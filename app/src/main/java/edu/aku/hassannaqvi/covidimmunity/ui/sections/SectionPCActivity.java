package edu.aku.hassannaqvi.covidimmunity.ui.sections;

import static edu.aku.hassannaqvi.covidimmunity.core.MainApp.form;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import edu.aku.hassannaqvi.covidimmunity.R;
import edu.aku.hassannaqvi.covidimmunity.contracts.TableContracts;
import edu.aku.hassannaqvi.covidimmunity.core.DateUtilsKt;
import edu.aku.hassannaqvi.covidimmunity.core.MainApp;
import edu.aku.hassannaqvi.covidimmunity.database.DatabaseHelper;
import edu.aku.hassannaqvi.covidimmunity.databinding.ActivitySectionPcBinding;
import edu.aku.hassannaqvi.covidimmunity.models.Form;
import edu.aku.hassannaqvi.covidimmunity.ui.EndingActivity;


public class SectionPCActivity extends AppCompatActivity {
    private static final String TAG = "SectionPCActivity";
    private DatabaseHelper db;
    ActivitySectionPcBinding bi;
    private int pressedButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_pc);
        // bi.setCallback(this);
        if (form == null) form = new Form();
        bi.setForm(form);
        setupSkips();
        setSupportActionBar(bi.toolbar);
        db = MainApp.appInfo.dbHelper;

        //pc05 setMaxDate
        bi.pc05.setMaxDate(DateUtilsKt.getDaysBack("dd/MM/yyyy", 60));
    }


    private void setupSkips() {

        bi.pc02.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (editable.toString().isEmpty()) return;

              /*  bi.pc05.setText(null);

                String convertDate = DateUtilsKt.convertDateFormat("yyyy-MM-dd", "dd/MM/yyyy", editable.toString());

                bi.pc05.setMinDate(convertDate);*/
                Calendar cal = Calendar.getInstance();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                try {
                    cal.setTime(sdf.parse(form.getPc02()));// all done

                    sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

                    // Set MinDob date to 50 years back from DOV
                    cal.add(Calendar.DAY_OF_MONTH, +1);
                    String minDob = sdf.format(cal.getTime());

                    // Set minDate for 2nd Dose
                    bi.pc05.setMinDate(minDob);


                } catch (ParseException e) {
                    e.printStackTrace();
                    Toast.makeText(SectionPCActivity.this, "PC02: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        bi.pc09.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.pc0901.getId()) {
                bi.fldGrpCVpc10.setVisibility(View.VISIBLE);
            } else bi.fldGrpCVpc10.setVisibility(View.GONE);
        }));
    }


    private boolean updateDB() {
        db = MainApp.appInfo.getDbHelper();
        long updcount = 0;
        try {
            updcount = db.updatesFormColumn(TableContracts.FormsTable.COLUMN_SPC, form.sPCtoString());
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
            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
        } else Toast.makeText(this, R.string.fail_db_upd, Toast.LENGTH_SHORT).show();
    }


    private void saveDraft() {
    }


    public void btnEnd(View view) {
        finish();
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }


    private boolean formValidation() {
        if (!Validator.emptyCheckingContainer(this, bi.GrpName))
            return false;

        if (bi.pc061.isChecked() && bi.pc08.getText().toString().equals("")) {
            return Validator.emptyCustomTextBox(this, bi.pc08, "Scan QR");
        }
        if (bi.pc0901.isChecked() && bi.pc10.getText().toString().equals("")) {
            return Validator.emptyCustomTextBox(this, bi.pc10, "Scan QR");
        }
        return true;
    }


    @Override
    public void onBackPressed() {
        // Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
        setResult(RESULT_CANCELED);
    }

    // Barcode Scanner
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (pressedButton == bi.scanQrPC09.getId()) {
                if (result.getContents() == null) {
                    Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
                } else {
                    String strResult = result.getContents();
                    bi.pc08.setText(strResult);
                }
            } else {
                if (result.getContents() == null) {
                    Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
                } else {
                    String strResult = result.getContents();
                    bi.pc10.setText(strResult);
                }
            }

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void scanQR(View view) {
        pressedButton = view.getId();
        new IntentIntegrator(this).initiateScan();
    }

}