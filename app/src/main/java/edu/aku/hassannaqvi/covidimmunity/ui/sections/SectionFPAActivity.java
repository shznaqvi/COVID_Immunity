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
import edu.aku.hassannaqvi.covidimmunity.databinding.ActivitySectionFpaBinding;
import edu.aku.hassannaqvi.covidimmunity.ui.FP_EndingActivity;

public class SectionFPAActivity extends AppCompatActivity {

    private static final String TAG = "SectionFPAActivity";
    ActivitySectionFpaBinding bi;
    private DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_fpa);
        bi.setFollowup(followup);
        setSupportActionBar(bi.toolbar);
        setTitle(R.string.sectionpa_mainheading);
        db = MainApp.appInfo.dbHelper;

    }



    private boolean updateDB() {
        int updcount = 0;
        try {
            updcount = db.updatesFollowupColumn(TableContracts.FollowupTable.COLUMN_SFPA, MainApp.followup.sFPAtoString());
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
        if (!updateDB()) return;
        if (updateDB()) {
            finish();
            startActivity(new Intent(this, SectionFPCActivity.class).putExtra("complete", true));
        } else {
            Toast.makeText(this, R.string.fail_db_upd, Toast.LENGTH_SHORT).show();
        }
    }


    public void BtnEnd(View view) {
        finish();
        startActivity(new Intent(this, FP_EndingActivity.class).putExtra("complete", false));
    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
        //setResult(RESULT_CANCELED);
    }


}