package edu.aku.hassannaqvi.covidimmunity.ui.sections;

import static edu.aku.hassannaqvi.covidimmunity.core.MainApp.form;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import edu.aku.hassannaqvi.covidimmunity.databinding.ActivitySectionPbBinding;
import edu.aku.hassannaqvi.covidimmunity.ui.EndingActivity;


public class SectionPBActivity extends AppCompatActivity {
    private static final String TAG = "SectionPBActivity";
    ActivitySectionPbBinding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_pb);
        // bi.setCallback(this);
        bi.setForm(form);
        setupSkips();
        setSupportActionBar(bi.toolbar);
        db = MainApp.appInfo.getDbHelper();
        //form.getPa02();
    }

    private void setupSkips() {

/*        if (form.getPa02().equals("1")) {
            bi.fldGrpCVpb05.setVisibility(View.GONE);
            bi.fldGrpCVpb06.setVisibility(View.GONE);
            bi.fldGrpCVpb05sub.setVisibility(View.GONE);
        } else {
            bi.fldGrpCVpb05.setVisibility(View.VISIBLE);
            bi.fldGrpCVpb06.setVisibility(View.VISIBLE);
            bi.fldGrpCVpb05sub.setVisibility(View.VISIBLE);
        }*/
    }


    private boolean updateDB() {

        long updcount = 0;
        try {
            updcount = db.updatesFormColumn(TableContracts.FormsTable.COLUMN_SPB, form.sPBtoString());
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, R.string.upd_db_form + e.getMessage());
            Toast.makeText(this, R.string.upd_db_form + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if (updcount > 0) return true;
        else {
            Toast.makeText(this, R.string.upd_db_error, Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    public void btnContinue(View view) {
        if (!formValidation()) return;
        saveDraft();
        if (updateDB()) {
            finish();
            startActivity(new Intent(this, SectionPCActivity.class).putExtra("complete", true));
        } else Toast.makeText(this, R.string.fail_db_upd, Toast.LENGTH_SHORT).show();
    }


    private void saveDraft() {
    }


    public void btnEnd(View view) {
        finish();
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
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