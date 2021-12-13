package edu.aku.hassannaqvi.covidimmunity.ui;

import static edu.aku.hassannaqvi.covidimmunity.core.MainApp.followup;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import edu.aku.hassannaqvi.covidimmunity.R;
import edu.aku.hassannaqvi.covidimmunity.contracts.TableContracts;
import edu.aku.hassannaqvi.covidimmunity.core.MainApp;
import edu.aku.hassannaqvi.covidimmunity.database.DatabaseHelper;
import edu.aku.hassannaqvi.covidimmunity.databinding.ActivityFpEndingBinding;

public class FP_EndingActivity extends AppCompatActivity {

    private static final String TAG = "SectionFPEndingActivity";
    ActivityFpEndingBinding bi;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_fp_ending);
        bi.setFollowup(followup);
        //setupSkips();
        setSupportActionBar(bi.toolbar);
        db = MainApp.appInfo.dbHelper;

        boolean check = getIntent().getBooleanExtra("complete", false);


        bi.fpa0501.setEnabled(check);
        bi.fpa0502.setEnabled(!check);
        bi.fpa0503.setEnabled(!check);
        bi.fpa0504.setEnabled(!check);
        bi.fpa0505.setEnabled(!check);
        bi.fpa0506.setEnabled(!check);
        bi.fpa0596.setEnabled(!check);
    }

    private void saveDraft() {
        followup.setiStatus(bi.fpa0501.isChecked() ? "1"
                : bi.fpa0502.isChecked() ? "2"
                : bi.fpa0503.isChecked() ? "3"
                : bi.fpa0504.isChecked() ? "4"
                : bi.fpa0505.isChecked() ? "5"
                : bi.fpa0506.isChecked() ? "6"
                : bi.fpa0596.isChecked() ? "96"
                : "-1");
        followup.setiStatus96x(bi.fpa0596x.getText().toString());
    }

    public void BtnEnd(View view) {
        if (!formValidation()) return;
        saveDraft();
        if (UpdateDB()) {


            finish();
            setResult(RESULT_OK);
            Toast.makeText(this, "Data has been updated.", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Error in updating Database.", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean UpdateDB() {
        int updcount = db.updatesFollowupColumn(TableContracts.FollowupTable.COLUMN_ISTATUS, followup.getiStatus());
        return updcount > 0;
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpFpEnd);
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back Press Not Allowed", Toast.LENGTH_LONG).show();
    }


}