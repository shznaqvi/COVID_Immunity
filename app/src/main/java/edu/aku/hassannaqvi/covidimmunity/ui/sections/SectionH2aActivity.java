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
import edu.aku.hassannaqvi.covidimmunity.databinding.ActivitySectionH2aBinding;
import edu.aku.hassannaqvi.covidimmunity.ui.EndingActivity;


public class SectionH2aActivity extends AppCompatActivity {
    private static final String TAG = "SectionH2aActivity";
    ActivitySectionH2aBinding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h2a);
        bi.setCallback(this);
    }


    private boolean updateDB() {
        db = MainApp.appInfo.getDbHelper();
        long updcount = 0;
        try {
            updcount = db.updatesFormColumn(TableContracts.FormsTable.COLUMN_SH2B, form.sH2btoString());
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, R.string.upd_db + e.getMessage());
            Toast.makeText(this, R.string.upd_db + e.getMessage(), Toast.LENGTH_SHORT).show();
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
            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
        } else Toast.makeText(this, R.string.fail_db_upd, Toast.LENGTH_SHORT).show();
    }


    private void saveDraft() {
/*

        form.setH201(bi.h201.getText().toString().isEmpty() ? "-1" : bi.h201.getText().toString());

        form.setH202(bi.h202a.isChecked() ? "1"
                : bi.h202b.isChecked() ? "2"
                : "-1");

        form.setH203d(bi.h203d.getText().toString().isEmpty() ? "-1" : bi.h203d.getText().toString());
        form.setH203m(bi.h203m.getText().toString().isEmpty() ? "-1" : bi.h203m.getText().toString());
        form.setH203y(bi.h203y.getText().toString().isEmpty() ? "-1" : bi.h203y.getText().toString());

        form.setH204(bi.h204.getText().toString().isEmpty() ? "-1" : bi.h204.getText().toString());

        form.setH205(bi.h205a.isChecked() ? "1"
                : bi.h205b.isChecked() ? "2"
                : bi.h205c.isChecked() ? "3"
                : bi.h205d.isChecked() ? "4"
                : bi.h205e.isChecked() ? "5"
                : "-1");

        form.setH206(bi.h206a.isChecked() ? "1"
                : bi.h206b.isChecked() ? "2"
                : bi.h206c.isChecked() ? "3"
                : bi.h206d.isChecked() ? "4"
                : bi.h206e.isChecked() ? "5"
                : bi.h206f.isChecked() ? "6"
                : bi.h206g.isChecked() ? "7"
                : bi.h206h.isChecked() ? "8"
                : bi.h206i.isChecked() ? "9"
                : bi.h206j.isChecked() ? "10"
                : bi.h20698.isChecked() ? "98"
                : "-1");

        form.setH207(bi.h207a.isChecked() ? "1"
                : bi.h207b.isChecked() ? "2"
                : bi.h207c.isChecked() ? "3"
                : bi.h207d.isChecked() ? "4"
                : bi.h207e.isChecked() ? "5"
                : bi.h207f.isChecked() ? "6"
                : bi.h207g.isChecked() ? "7"
                : bi.h207h.isChecked() ? "8"
                : bi.h207i.isChecked() ? "9"
                : bi.h20798.isChecked() ? "98"
                : "-1");

        form.setH208(bi.h208a.isChecked() ? "1"
                : bi.h208b.isChecked() ? "2"
                : "-1");
*/

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

/*

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }
*/


}