package edu.aku.hassannaqvi.covidimmunity.ui.sections;

import static edu.aku.hassannaqvi.covidimmunity.core.MainApp.followup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.hassannaqvi.covidimmunity.R;
import edu.aku.hassannaqvi.covidimmunity.contracts.TableContracts;
import edu.aku.hassannaqvi.covidimmunity.core.MainApp;
import edu.aku.hassannaqvi.covidimmunity.database.DatabaseHelper;
import edu.aku.hassannaqvi.covidimmunity.databinding.ActivitySectionFpcBinding;
import edu.aku.hassannaqvi.covidimmunity.ui.FP_EndingActivity;

public class SectionFPCActivity extends AppCompatActivity {

    private static final String TAG = "SectionFPCActivity";
    ActivitySectionFpcBinding bi;
    private DatabaseHelper db;
    private int pressedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_fpc);
        bi.setFollowup(followup);
        setSupportActionBar(bi.toolbar);
        setTitle(R.string.sectionpc_mainheading);
        db = MainApp.appInfo.dbHelper;


    }



    private boolean updateDB() {
        int updcount = 0;
        try {
            updcount = db.updatesFollowupColumn(TableContracts.FollowupTable.COLUMN_SFPC, MainApp.followup.sFPCtoString());
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
        if (updateDB()) {
            finish();
            startActivity(new Intent(this, FP_EndingActivity.class).putExtra("complete", true));
        } else {
            Toast.makeText(this, R.string.fail_db_upd, Toast.LENGTH_SHORT).show();
        }
    }



    public void BtnEnd(View view) {
        finish();
        startActivity(new Intent(this, FP_EndingActivity.class).putExtra("complete", false));
    }

    private boolean formValidation() {

        if (!Validator.emptyCheckingContainer(this, bi.GrpName))
            return false;

        if (bi.fpc05q1.isChecked() && bi.fpc07.getText().toString().equals("")) {
            return Validator.emptyCustomTextBox(this, bi.fpc07, "Scan QR");
        }
        return true;

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
        // setResult(RESULT_CANCELED);
    }

    // Barcode Scanner
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (pressedButton == bi.scanQrFPC07.getId()) {
                if (result.getContents() == null) {
                    Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
                } else {
                    String strResult = result.getContents();
                    bi.fpc07.setText(strResult);
                }
            } else {
                if (result.getContents() == null) {
                    Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
                } else {
                    String strResult = result.getContents();
                    bi.fpc07.setText(strResult);
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