package edu.aku.hassannaqvi.covidimmunity.ui.sections;


import static edu.aku.hassannaqvi.covidimmunity.core.MainApp.fp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import edu.aku.hassannaqvi.covidimmunity.R;
import edu.aku.hassannaqvi.covidimmunity.core.MainApp;
import edu.aku.hassannaqvi.covidimmunity.database.DatabaseHelper;
import edu.aku.hassannaqvi.covidimmunity.databinding.ActivitySectionFhaBinding;
import edu.aku.hassannaqvi.covidimmunity.ui.FP_EndingActivity;

public class SectionFHAActivity extends AppCompatActivity {

    private static final String TAG = "SectionFHAActivity";
    ActivitySectionFhaBinding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_fha);
        bi.setFp(fp);
        setupSkips();
        setSupportActionBar(bi.toolbar);
        setTitle(R.string.sectionha_mainheading);
        db = MainApp.appInfo.dbHelper;

    }

    private void setupSkips() {

    }

    private boolean insertNewRecord() {
        /*if (!fp.getUid().equals("")) return true;
        long rowId = 0;
        try {
            rowId = db.addFollowup(fp);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.db_excp_error, Toast.LENGTH_SHORT).show();
            return false;
        }
        fp.setId(String.valueOf(rowId));
        if (rowId > 0) {
            fp.setUid(fp.getDeviceId() + fp.getId());
            db.updatesFollowupColumn(TableContracts.FollowupTable.COLUMN_UID, fp.getUid());
            return true;
        } else {
            Toast.makeText(this, R.string.upd_db_error, Toast.LENGTH_SHORT).show();
            return false;
        }*/

        return true;
    }


    private boolean updateDB() {
        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = 0;
        try {
            updcount = db.updatesFormColumn(TableContracts.FollowupTable.COLUMN_SFHA, fp.sFHAtoString());
        } catch (JSONException e) {
            Toast.makeText(this, R.string.upd_db + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, R.string.upd_db_error, Toast.LENGTH_SHORT).show();
            return false;
        }*/

        return true;
    }

    public void BtnContinue(View view) {
        if (!formValidation()) return;
        if (!insertNewRecord()) return;
        saveDraft();
        if (updateDB()) {
            finish();
            startActivity(new Intent(this, SectionFPAActivity.class).putExtra("complete", true));
        } else {
            Toast.makeText(this, R.string.fail_db_upd, Toast.LENGTH_SHORT).show();
        }
    }

    private void saveDraft() {
    }


    public void BtnEnd(View view) {
         if (!formValidation()) return;
        if (!insertNewRecord()) return;
        saveDraft();
        if (updateDB()) {
            finish();
            startActivity(new Intent(this, FP_EndingActivity.class).putExtra("complete", false));
        } else {
            Toast.makeText(this, R.string.fail_db_upd, Toast.LENGTH_SHORT).show();
        }
    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    @Override
    public void onBackPressed() {
        // Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
        setResult(RESULT_CANCELED);
    }



}