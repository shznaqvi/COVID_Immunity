package edu.aku.hassannaqvi.covidimmunity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import edu.aku.hassannaqvi.covidimmunity.core.MainApp;
import edu.aku.hassannaqvi.covidimmunity.database.AndroidDatabaseManager;
import edu.aku.hassannaqvi.covidimmunity.databinding.ActivityMainBinding;
import edu.aku.hassannaqvi.covidimmunity.models.Form;
import edu.aku.hassannaqvi.covidimmunity.ui.SyncActivity;
import edu.aku.hassannaqvi.covidimmunity.ui.lists.FormsReportCluster;
import edu.aku.hassannaqvi.covidimmunity.ui.lists.FormsReportDate;
import edu.aku.hassannaqvi.covidimmunity.ui.lists.FormsReportPending;
import edu.aku.hassannaqvi.covidimmunity.ui.sections.SectionHAActivity;
import edu.aku.hassannaqvi.covidimmunity.ui.sections.SectionPAActivity;
import edu.aku.hassannaqvi.covidimmunity.ui.sections.SectionPBActivity;
import edu.aku.hassannaqvi.covidimmunity.ui.sections.SectionPCActivity;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding bi;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bi.setCallback(this);
        setSupportActionBar(bi.toolbar);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //getSupportActionBar().setIcon(R.drawable.app_icon);
        bi.adminView.setVisibility(MainApp.admin ? View.VISIBLE : View.GONE);
        bi.toolbar.setSubtitle("Welcome, " + MainApp.user.getFullname() + (MainApp.admin ? " (Admin)" : "") + "!");
    }

    public void sectionPress(View view) {

        switch (view.getId()) {
            case R.id.openForm:
                MainApp.idType = 1;
                break;
            default:
                MainApp.idType = 0;
        }


        switch (view.getId()) {

            case R.id.openForm:
                MainApp.idType = 1;
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionHAActivity.class));
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

}