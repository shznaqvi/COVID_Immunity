package edu.aku.hassannaqvi.covidimmunity;

import static edu.aku.hassannaqvi.covidimmunity.core.MainApp.PROJECT_NAME;
import static edu.aku.hassannaqvi.covidimmunity.core.MainApp.versionApp;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.os.ResultReceiver;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import edu.aku.hassannaqvi.covidimmunity.core.MainApp;

/**
 * Created by ali.azaz on 9/26/2017.
 */

public class DownloadFileService extends IntentService {

    public static final int UPDATE_PROGRESS = 8344;

    public DownloadFileService() {
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String urlToDownload = intent.getStringExtra("url");
        ResultReceiver receiver = intent.getParcelableExtra("receiver");
        try {
            URL url = new URL(MainApp._UPDATE_URL + versionApp.getPathname());
            URLConnection connection = url.openConnection();
            connection.connect();
            // this will be useful so that you can show a typical 0-100% progress bar
            int fileLength = connection.getContentLength();

            String fileName = PROJECT_NAME;
            this.getExternalFilesDir(
                    Environment.DIRECTORY_DOWNLOADS);
            File file = new File(this.getExternalFilesDir(
                    Environment.DIRECTORY_DOWNLOADS) + File.separator + fileName, versionApp.getPathname());
            // download the file
            InputStream input = new BufferedInputStream(connection.getInputStream());
            OutputStream output;

            ContentResolver contentResolver = this.getContentResolver();

            ContentValues contentValues = new ContentValues();
            contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, versionApp.getPathname());
            contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "application/vnd.android.package-archive");
            contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS);
            Uri uri = contentResolver.insert(MediaStore.Files.getContentUri("external"), contentValues);
            output = contentResolver.openOutputStream(uri);

            byte[] data = new byte[1024];
            long total = 0;
            int count;
            while ((count = input.read(data)) != -1) {
                total += count;
                // publishing the progress....
                Bundle resultData = new Bundle();
                resultData.putInt("progress", (int) (total * 100 / fileLength));
                receiver.send(UPDATE_PROGRESS, resultData);
                output.write(data, 0, count);
            }

            output.flush();
            output.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Bundle resultData = new Bundle();
        resultData.putInt("progress", 100);
        receiver.send(UPDATE_PROGRESS, resultData);
    }
}
