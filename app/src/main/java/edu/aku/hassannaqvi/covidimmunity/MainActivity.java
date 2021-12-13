package edu.aku.hassannaqvi.covidimmunity;

import static edu.aku.hassannaqvi.covidimmunity.core.MainApp.PROJECT_NAME;
import static edu.aku.hassannaqvi.covidimmunity.core.MainApp.editor;
import static edu.aku.hassannaqvi.covidimmunity.core.MainApp.sharedPref;

import android.app.ActivityManager;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import java.io.File;
import java.util.List;

import edu.aku.hassannaqvi.covidimmunity.core.MainApp;
import edu.aku.hassannaqvi.covidimmunity.database.AndroidDatabaseManager;
import edu.aku.hassannaqvi.covidimmunity.database.DatabaseHelper;
import edu.aku.hassannaqvi.covidimmunity.databinding.ActivityMainBinding;
import edu.aku.hassannaqvi.covidimmunity.models.Followup;
import edu.aku.hassannaqvi.covidimmunity.models.Form;
import edu.aku.hassannaqvi.covidimmunity.models.VersionApp;
import edu.aku.hassannaqvi.covidimmunity.ui.SyncActivity;
import edu.aku.hassannaqvi.covidimmunity.ui.lists.FollowUpsListActivity;
import edu.aku.hassannaqvi.covidimmunity.ui.lists.FormsReportCluster;
import edu.aku.hassannaqvi.covidimmunity.ui.lists.FormsReportDate;
import edu.aku.hassannaqvi.covidimmunity.ui.lists.FormsReportPending;
import edu.aku.hassannaqvi.covidimmunity.ui.sections.SectionFHAActivity;
import edu.aku.hassannaqvi.covidimmunity.ui.sections.SectionHAActivity;
import edu.aku.hassannaqvi.covidimmunity.ui.sections.SectionPAActivity;
import edu.aku.hassannaqvi.covidimmunity.ui.sections.SectionPBActivity;
import edu.aku.hassannaqvi.covidimmunity.ui.sections.SectionPCActivity;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    ActivityMainBinding bi;
    SharedPreferences sp;
    String currentVersion = "", newVersion = "";
    private DatabaseHelper db;
    private VersionApp versionApp;
    private DownloadManager downloadManager;
    private long refID;
    private File file;
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(intent.getAction())) {

                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterById(sharedPref.getLong("refID", 0));

                downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                Cursor cursor = downloadManager.query(query);
                if (cursor.moveToFirst()) {
                    int colIndex = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS);
                    if (DownloadManager.STATUS_SUCCESSFUL == cursor.getInt(colIndex)) {

                        editor.putBoolean("flag", true);
                        editor.commit();

                        Toast.makeText(context, "Newer version of the app downloaded!", Toast.LENGTH_SHORT).show();
                        bi.lblAppVersion.setText("A newer version " + newVersion + " of " + PROJECT_NAME + " application downloaded.");

                        ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                        List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);

                        if (taskInfo.get(0).topActivity.getClassName().equals(MainActivity.class.getName())) {
//                                InstallNewApp(newVer, preVer);
                            new AlertDialog.Builder(MainActivity.this)
                                    .setTitle("Update Available!")
                                    .setMessage("A newer version of this application is available.\n\n Please install the update now.")

                                    // Specifying a listener allows you to take an action before dismissing the dialog.
                                    // The dialog is automatically dismissed when a dialog button is clicked.
                                    .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intent = new Intent(Intent.ACTION_VIEW);
                                            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                            startActivity(intent);
                                        }
                                    })

                                    // A null listener allows the button to dismiss the dialog and take no further action.
                                    .setNegativeButton(android.R.string.no, null)
                                    .setIcon(android.R.drawable.ic_dialog_alert)
                                    .show();
                        }
                    }
                }
            }
        }
    };
    private File folder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bi.setCallback(this);

        db = MainApp.appInfo.dbHelper;

        setSupportActionBar(bi.toolbar);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //getSupportActionBar().setIcon(R.drawable.app_icon);
        bi.adminView.setVisibility(MainApp.admin ? View.VISIBLE : View.GONE);
        bi.toolbar.setSubtitle("Welcome, " + MainApp.user.getFullname() + (MainApp.admin ? " (Admin)" : "") + "!");


        //    processAPKDownload();

    }

    private void processAPKDownload() {
        versionApp = db.getVersionApp();
        Log.d(TAG, "processAPKDownload (versionApp): " + versionApp);
        if (versionApp.getVersioncode() != null) {

            currentVersion = MainApp.versionName + "." + MainApp.versionCode;
            newVersion = versionApp.getVersionname() + "." + versionApp.getVersioncode();
            Log.d(TAG, "processAPKDownload: Cur: " + currentVersion + " New: " + newVersion);

            if (Integer.valueOf(versionApp.getVersioncode()) > MainApp.versionCode) {
                bi.lblAppVersion.setVisibility(View.VISIBLE);


                //File file = new File(this.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + fileName, versionApp.getPathname());
                //File downloadFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
                //File downloadFolder = this.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);

                ContentResolver contentResolver = this.getContentResolver();

                ContentValues contentValues = new ContentValues();
                contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, versionApp.getPathname());
                contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "application/vnd.android.package-archive");
                contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS);
                //Uri uri = contentResolver.insert(MediaStore.Files.getContentUri("external"), contentValues);
                Uri uri = MediaStore.Files.getContentUri("external");
                Cursor cursor = getContentResolver().query(uri, null, null, null, null, null);

                if (cursor != null) {
                    bi.lblAppVersion.setText("A newer version " + newVersion + " of " + PROJECT_NAME + " application downloaded.");
//                    InstallNewApp(newVer, preVer);
                    new AlertDialog.Builder(this)
                            .setTitle("Update Available!")
                            .setMessage("A newer version of this application is available.\n\nPlease install the update now.")

                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {


                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, versionApp.getPathname());
                                    contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "application/vnd.android.package-archive");
                                    contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS);
                                    int docIndex = cursor.getColumnIndexOrThrow(MediaStore.DownloadColumns._ID);
                                    Uri uriFile = null;
                                    if (cursor.moveToNext() == true) {
                                        uriFile = ContentUris.withAppendedId(MediaStore.Downloads.EXTERNAL_CONTENT_URI, cursor.getInt(docIndex));
                                    }
                                    if (uriFile != null) {
                                        try {
                                            Intent intent = new Intent(Intent.ACTION_VIEW);
                                            intent.setDataAndType(uriFile, "application/vnd.android.package-archive");
                                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                            startActivity(intent);

                                        } catch (Exception e) {
                                            Log.d("application", "error starting download file: " + e.toString());
                                        }
                                    } else {
                                        Toast.makeText(MainActivity.this, "File does not Exists", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            .setNegativeButton(android.R.string.no, null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                } else {
                    NetworkInfo networkInfo = ((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
                    if (networkInfo != null && networkInfo.isConnected()) {

                        bi.lblAppVersion.setText("A newer version " + newVersion + " of " + PROJECT_NAME + " application downloading...");
                        downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                        uri = Uri.parse(MainApp._UPDATE_URL + versionApp.getPathname());
                        DownloadManager.Request request = new DownloadManager.Request(uri);
                        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS + File.separator + PROJECT_NAME, versionApp.getPathname())
                                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                                .setTitle("Downloading " + PROJECT_NAME + " app ver." + newVersion);
                        refID = downloadManager.enqueue(request);

                        editor.putLong("refID", refID);
                        editor.putBoolean("flag", false);
                        editor.commit();

                    } else {
                        bi.lblAppVersion.setText("A newer version " + newVersion + " of " + PROJECT_NAME + " application can't be downloaded. Waiting for Internet...");
                    }
                }

            } else {
                bi.lblAppVersion.setVisibility(View.GONE);
                bi.lblAppVersion.setText(null);
            }
        }
        registerReceiver(broadcastReceiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

    }

    public void sectionPress(View view) {

/*        switch (view.getId()) {
            case R.id.openForm:
                break;
            case R.id.openFollowupList:
                break;
            default:
                MainApp.idType = 0;
        }*/


        switch (view.getId()) {

            case R.id.openForm:
                MainApp.idType = 1;
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionHAActivity.class));
                break;

            case R.id.openFollowupList:
                MainApp.followup = new Followup();
                startActivity(new Intent(this, FollowUpsListActivity.class));
                break;

            case R.id.secha:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionHAActivity.class));
                break;

            case R.id.secpa:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionPAActivity.class));
                break;

            case R.id.secpb:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionPBActivity.class));
                break;

            case R.id.secpc:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionPCActivity.class));
                break;


            case R.id.secfha:
                MainApp.followup = new Followup();
                startActivity(new Intent(this, SectionFHAActivity.class));
                break;

            /*case R.id.secfpa:
                MainApp.followup = new Followup();
                startActivity(new Intent(this, SectionFPAActivity.class));
                break;

            case R.id.secfpc:
                MainApp.followup = new Followup();
                startActivity(new Intent(this, SectionFPCActivity.class));
                break;
*/
            case R.id.dbManager:
                startActivity(new Intent(this, AndroidDatabaseManager.class));
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.action_database:
                intent = new Intent(MainActivity.this, AndroidDatabaseManager.class);
                startActivity(intent);
                break;
            case R.id.onSync:
                intent = new Intent(MainActivity.this, SyncActivity.class);
                startActivity(intent);
                break;
            case R.id.checkPendingForms:
                intent = new Intent(MainActivity.this, FormsReportPending.class);
                startActivity(intent);
                break;
            case R.id.formsReportDate:
                intent = new Intent(MainActivity.this, FormsReportDate.class);
                startActivity(intent);
                break;
            case R.id.formsReportCluster:
                intent = new Intent(MainActivity.this, FormsReportCluster.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }

}