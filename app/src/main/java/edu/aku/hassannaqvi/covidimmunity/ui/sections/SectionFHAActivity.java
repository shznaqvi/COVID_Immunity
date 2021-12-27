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
import edu.aku.hassannaqvi.covidimmunity.databinding.ActivitySectionFhaBinding;
import edu.aku.hassannaqvi.covidimmunity.ui.FP_EndingActivity;

public class SectionFHAActivity extends AppCompatActivity {

    private static final String TAG = "SectionFHAActivity";
    ActivitySectionFhaBinding bi;
    private DatabaseHelper db;
    private int pressedButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_fha);
        bi.setFollowup(followup);
        setSupportActionBar(bi.toolbar);
        setTitle(R.string.sectionfha_mainheading);
        db = MainApp.appInfo.dbHelper;

        switch (followup.getFha09()) {
            case "1":
                bi.fha09.setText("Hala");
                break;
            case "2":
                bi.fha09.setText("Mariari");
                break;
            case "3":
                bi.fha09.setText("Saeedabad");
                break;
        }



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
            if(bi.fpa041.isChecked()) {
                startActivity(new Intent(this, FP_EndingActivity.class).putExtra("complete", true));
            }else{
                startActivity(new Intent(this, FP_EndingActivity.class).putExtra("complete", false));
            }
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
        if (!Validator.emptyCheckingContainer(this, bi.GrpName))
            return false;

        if (bi.fpc05q1.isChecked() && bi.fpc07.getText().toString().equals("")) {
            return Validator.emptyCustomTextBox(this, bi.fpc07, "Scan QR");
        }

        if (bi.fpc05a01.isChecked() && bi.fpc05c.getText().toString().equals("")) {
            return Validator.emptyCustomTextBox(this, bi.fpc05c, "Scan QR");
        }
        return true;
    }


    @Override
    public void onBackPressed() {
        // Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
        setResult(RESULT_CANCELED);
        finish();
    }


    // Barcode Scanner
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (pressedButton == bi.scanQrFPC07.getId() && result.getContents() != null) {
                String strResult = result.getContents();
                bi.fpc07.setText(strResult);
            } else if (pressedButton == bi.scanQrFPC05C.getId() && result.getContents() != null) {
                String strResult = result.getContents();
                bi.fpc05c.setText(strResult);
            } else {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            }

        } else {
            super.onActivityResult(requestCode, resultCode, data);
            Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
        }
    }



    public void scanQR(View view) {
        pressedButton = view.getId();
        new IntentIntegrator(this).initiateScan();
    }



}