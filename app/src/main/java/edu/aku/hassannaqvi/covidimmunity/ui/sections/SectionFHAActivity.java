package edu.aku.hassannaqvi.covidimmunity.ui.sections;


import static edu.aku.hassannaqvi.covidimmunity.core.MainApp.followup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.hassannaqvi.covidimmunity.R;
import edu.aku.hassannaqvi.covidimmunity.contracts.TableContracts;
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
        bi.setFollowup(followup);
        setSupportActionBar(bi.toolbar);
        setTitle(R.string.sectionha_mainheading);
        db = MainApp.appInfo.dbHelper;

    }


    private boolean insertNewRecord() {
        if (!followup.getUid().equals("")) return true;
        followup.populateMeta();
        long rowId = 0;
        try {
            rowId = db.addFollowup(followup);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.db_excp_error, Toast.LENGTH_SHORT).show();
            return false;
        }
        followup.setId(String.valueOf(rowId));
        if (rowId > 0) {
            followup.setUid(followup.getDeviceId() + followup.getId());
            db.updatesFollowupColumn(TableContracts.FollowupTable.COLUMN_UID, followup.getUid());
            return true;
        } else {
            Toast.makeText(this, R.string.upd_db_error, Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private boolean updateDB() {
        int updcount = 0;
        try {
            updcount = db.updatesFollowupColumn(TableContracts.FollowupTable.COLUMN_SFHA, followup.sFHAtoString());
        } catch (JSONException e) {
            Toast.makeText(this, R.string.upd_db + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, R.string.upd_db_error, Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    public void BtnContinue(View view) {
        if (!formValidation()) return;
        if (!insertNewRecord()) return;
        if (updateDB()) {
            finish();
            startActivity(new Intent(this, SectionFPAActivity.class).putExtra("complete", true));
        } else {
            Toast.makeText(this, R.string.fail_db_upd, Toast.LENGTH_SHORT).show();
        }
    }



    public void BtnEnd(View view) {
        if (!insertNewRecord()) return;
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
        finish();
    }



}