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
import edu.aku.hassannaqvi.covidimmunity.databinding.ActivitySectionC2Binding;
import edu.aku.hassannaqvi.covidimmunity.ui.EndingActivity;


public class SectionC2Activity extends AppCompatActivity {
    private static final String TAG = "SectionC2Activity";
    ActivitySectionC2Binding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c2);
        bi.setCallback(this);
        bi.setForm(form);
    }


    private boolean updateDB() {
        db = MainApp.appInfo.getDbHelper();
        long updcount = 0;
        try {
            updcount = db.updatesFormColumn(TableContracts.FormsTable.COLUMN_SC2, form.sC2toString());
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
            // startActivity(new Intent(this, SectionC3Activity.class).putExtra("complete", true));
        } else Toast.makeText(this, R.string.fail_db_upd, Toast.LENGTH_SHORT).show();
    }


    private void saveDraft() {
/*

        form.setC201(bi.c201.getText().toString().trim().isEmpty() ? "-1" : bi.c201.getText().toString());

        form.setC202(bi.c202a.isChecked() ? "1"
                : bi.c202b.isChecked() ? "2"
                : bi.c202c.isChecked() ? "3"
                : "-1");

        form.setC20301a(bi.c20301aa.isChecked() ? "1"
                : bi.c20301ab.isChecked() ? "2"
                : "-1");

        form.setC20301ba(bi.c20301ba.isChecked() ? "1" : "-1");
        form.setC20301bb(bi.c20301bb.isChecked() ? "2" : "-1");
        form.setC20301bc(bi.c20301bc.isChecked() ? "3" : "-1");
        form.setC20301bd(bi.c20301bd.isChecked() ? "4" : "-1");
        form.setC20301be(bi.c20301be.isChecked() ? "5" : "-1");
        form.setC20301bf(bi.c20301bf.isChecked() ? "6" : "-1");
        form.setC20301bg(bi.c20301bg.isChecked() ? "7" : "-1");

        form.setC20302a(bi.c20302aa.isChecked() ? "1"
                : bi.c20302ab.isChecked() ? "2"
                : "-1");

        form.setC20302ba(bi.c20302ba.isChecked() ? "1" : "-1");
        form.setC20302bb(bi.c20302bb.isChecked() ? "2" : "-1");
        form.setC20302bc(bi.c20302bc.isChecked() ? "3" : "-1");
        form.setC20302bd(bi.c20302bd.isChecked() ? "4" : "-1");
        form.setC20302be(bi.c20302be.isChecked() ? "5" : "-1");
        form.setC20302bf(bi.c20302bf.isChecked() ? "6" : "-1");
        form.setC20302bg(bi.c20302bg.isChecked() ? "7" : "-1");

        form.setC20303a(bi.c20303aa.isChecked() ? "1"
                : bi.c20303ab.isChecked() ? "2"
                : "-1");

        form.setC20303ba(bi.c20303ba.isChecked() ? "1" : "-1");
        form.setC20303bb(bi.c20303bb.isChecked() ? "2" : "-1");
        form.setC20303bc(bi.c20303bc.isChecked() ? "3" : "-1");
        form.setC20303bd(bi.c20303bd.isChecked() ? "4" : "-1");
        form.setC20303be(bi.c20303be.isChecked() ? "5" : "-1");
        form.setC20303bf(bi.c20303bf.isChecked() ? "6" : "-1");
        form.setC20303bg(bi.c20303bg.isChecked() ? "7" : "-1");

        form.setC20304a(bi.c20304aa.isChecked() ? "1"
                : bi.c20304ab.isChecked() ? "2"
                : "-1");

        form.setC20304ba(bi.c20304ba.isChecked() ? "1" : "-1");
        form.setC20304bb(bi.c20304bb.isChecked() ? "2" : "-1");
        form.setC20304bc(bi.c20304bc.isChecked() ? "3" : "-1");
        form.setC20304bd(bi.c20304bd.isChecked() ? "4" : "-1");
        form.setC20304be(bi.c20304be.isChecked() ? "5" : "-1");
        form.setC20304bf(bi.c20304bf.isChecked() ? "6" : "-1");
        form.setC20304bg(bi.c20304bg.isChecked() ? "7" : "-1");

        form.setC20305a(bi.c20305aa.isChecked() ? "1"
                : bi.c20305ab.isChecked() ? "2"
                : "-1");

        form.setC20305ba(bi.c20305ba.isChecked() ? "1" : "-1");
        form.setC20305bb(bi.c20305bb.isChecked() ? "2" : "-1");
        form.setC20305bc(bi.c20305bc.isChecked() ? "3" : "-1");
        form.setC20305bd(bi.c20305bd.isChecked() ? "4" : "-1");
        form.setC20305be(bi.c20305be.isChecked() ? "5" : "-1");
        form.setC20305bf(bi.c20305bf.isChecked() ? "6" : "-1");
        form.setC20305bg(bi.c20305bg.isChecked() ? "7" : "-1");

        form.setC20306a(bi.c20306aa.isChecked() ? "1"
                : bi.c20306ab.isChecked() ? "2"
                : "-1");

        form.setC20306ba(bi.c20306ba.isChecked() ? "1" : "-1");
        form.setC20306bb(bi.c20306bb.isChecked() ? "2" : "-1");
        form.setC20306bc(bi.c20306bc.isChecked() ? "3" : "-1");
        form.setC20306bd(bi.c20306bd.isChecked() ? "4" : "-1");
        form.setC20306be(bi.c20306be.isChecked() ? "5" : "-1");
        form.setC20306bf(bi.c20306bf.isChecked() ? "6" : "-1");
        form.setC20306bg(bi.c20306bg.isChecked() ? "7" : "-1");

        form.setC20307a(bi.c20307aa.isChecked() ? "1"
                : bi.c20307ab.isChecked() ? "2"
                : "-1");

        form.setC20307ba(bi.c20307ba.isChecked() ? "1" : "-1");
        form.setC20307bb(bi.c20307bb.isChecked() ? "2" : "-1");
        form.setC20307bc(bi.c20307bc.isChecked() ? "3" : "-1");
        form.setC20307bd(bi.c20307bd.isChecked() ? "4" : "-1");
        form.setC20307be(bi.c20307be.isChecked() ? "5" : "-1");
        form.setC20307bf(bi.c20307bf.isChecked() ? "6" : "-1");
        form.setC20307bg(bi.c20307bg.isChecked() ? "7" : "-1");

        form.setC20308a(bi.c20308aa.isChecked() ? "1"
                : bi.c20308ab.isChecked() ? "2"
                : "-1");

        form.setC20308ba(bi.c20308ba.isChecked() ? "1" : "-1");
        form.setC20308bb(bi.c20308bb.isChecked() ? "2" : "-1");
        form.setC20308bc(bi.c20308bc.isChecked() ? "3" : "-1");
        form.setC20308bd(bi.c20308bd.isChecked() ? "4" : "-1");
        form.setC20308be(bi.c20308be.isChecked() ? "5" : "-1");
        form.setC20308bf(bi.c20308bf.isChecked() ? "6" : "-1");
        form.setC20308bg(bi.c20308bg.isChecked() ? "7" : "-1");
        form.setC20309a(bi.c20309aa.isChecked() ? "1"
                : bi.c20309ab.isChecked() ? "2"
                : "-1");

        form.setC20309ba(bi.c20309ba.isChecked() ? "1" : "-1");
        form.setC20309bb(bi.c20309bb.isChecked() ? "2" : "-1");
        form.setC20309bc(bi.c20309bc.isChecked() ? "3" : "-1");
        form.setC20309bd(bi.c20309bd.isChecked() ? "4" : "-1");
        form.setC20309be(bi.c20309be.isChecked() ? "5" : "-1");
        form.setC20309bf(bi.c20309bf.isChecked() ? "6" : "-1");
        form.setC20309bg(bi.c20309bg.isChecked() ? "7" : "-1");

        form.setC20310a(bi.c20310aa.isChecked() ? "1"
                : bi.c20310ab.isChecked() ? "2"
                : "-1");

        form.setC20310ba(bi.c20310ba.isChecked() ? "1" : "-1");
        form.setC20310bb(bi.c20310bb.isChecked() ? "2" : "-1");
        form.setC20310bc(bi.c20310bc.isChecked() ? "3" : "-1");
        form.setC20310bd(bi.c20310bd.isChecked() ? "4" : "-1");
        form.setC20310be(bi.c20310be.isChecked() ? "5" : "-1");
        form.setC20310bf(bi.c20310bf.isChecked() ? "6" : "-1");
        form.setC20310bg(bi.c20310bg.isChecked() ? "7" : "-1");

        form.setC20311a(bi.c20311aa.isChecked() ? "1"
                : bi.c20311ab.isChecked() ? "2"
                : "-1");

        form.setC20311ba(bi.c20311ba.isChecked() ? "1" : "-1");
        form.setC20311bb(bi.c20311bb.isChecked() ? "2" : "-1");
        form.setC20311bc(bi.c20311bc.isChecked() ? "3" : "-1");
        form.setC20311bd(bi.c20311bd.isChecked() ? "4" : "-1");
        form.setC20311be(bi.c20311be.isChecked() ? "5" : "-1");
        form.setC20311bf(bi.c20311bf.isChecked() ? "6" : "-1");
        form.setC20311bg(bi.c20311bg.isChecked() ? "7" : "-1");

        form.setC20312a(bi.c20312aa.isChecked() ? "1"
                : bi.c20312ab.isChecked() ? "2"
                : "-1");

        form.setC20312ba(bi.c20312ba.isChecked() ? "1" : "-1");
        form.setC20312bb(bi.c20312bb.isChecked() ? "2" : "-1");
        form.setC20312bc(bi.c20312bc.isChecked() ? "3" : "-1");
        form.setC20312bd(bi.c20312bd.isChecked() ? "4" : "-1");
        form.setC20312be(bi.c20312be.isChecked() ? "5" : "-1");
        form.setC20312bf(bi.c20312bf.isChecked() ? "6" : "-1");
        form.setC20312bg(bi.c20312bg.isChecked() ? "7" : "-1");

        form.setC20313a(bi.c20313aa.isChecked() ? "1"
                : bi.c20313ab.isChecked() ? "2"
                : "-1");

        form.setC20313ba(bi.c20313ba.isChecked() ? "1" : "-1");
        form.setC20313bb(bi.c20313bb.isChecked() ? "2" : "-1");
        form.setC20313bc(bi.c20313bc.isChecked() ? "3" : "-1");
        form.setC20313bd(bi.c20313bd.isChecked() ? "4" : "-1");
        form.setC20313be(bi.c20313be.isChecked() ? "5" : "-1");
        form.setC20313bf(bi.c20313bf.isChecked() ? "6" : "-1");
        form.setC20313bg(bi.c20313bg.isChecked() ? "7" : "-1");

        form.setC20314a(bi.c20314aa.isChecked() ? "1"
                : bi.c20314ab.isChecked() ? "2"
                : "-1");

        form.setC20314ba(bi.c20314ba.isChecked() ? "1" : "-1");
        form.setC20314bb(bi.c20314bb.isChecked() ? "2" : "-1");
        form.setC20314bc(bi.c20314bc.isChecked() ? "3" : "-1");
        form.setC20314bd(bi.c20314bd.isChecked() ? "4" : "-1");
        form.setC20314be(bi.c20314be.isChecked() ? "5" : "-1");
        form.setC20314bf(bi.c20314bf.isChecked() ? "6" : "-1");
        form.setC20314bg(bi.c20314bg.isChecked() ? "7" : "-1");

        form.setC20315a(bi.c20315aa.isChecked() ? "1"
                : bi.c20315ab.isChecked() ? "2"
                : "-1");

        form.setC20315ba(bi.c20315ba.isChecked() ? "1" : "-1");
        form.setC20315bb(bi.c20315bb.isChecked() ? "2" : "-1");
        form.setC20315bc(bi.c20315bc.isChecked() ? "3" : "-1");
        form.setC20315bd(bi.c20315bd.isChecked() ? "4" : "-1");
        form.setC20315be(bi.c20315be.isChecked() ? "5" : "-1");
        form.setC20315bf(bi.c20315bf.isChecked() ? "6" : "-1");
        form.setC20315bg(bi.c20315bg.isChecked() ? "7" : "-1");

        form.setC20316a(bi.c20316aa.isChecked() ? "1"
                : bi.c20316ab.isChecked() ? "2"
                : "-1");

        form.setC20316ba(bi.c20316ba.isChecked() ? "1" : "-1");
        form.setC20316bb(bi.c20316bb.isChecked() ? "2" : "-1");
        form.setC20316bc(bi.c20316bc.isChecked() ? "3" : "-1");
        form.setC20316bd(bi.c20316bd.isChecked() ? "4" : "-1");
        form.setC20316be(bi.c20316be.isChecked() ? "5" : "-1");
        form.setC20316bf(bi.c20316bf.isChecked() ? "6" : "-1");
        form.setC20316bg(bi.c20316bg.isChecked() ? "7" : "-1");

        form.setC20317a(bi.c20317aa.isChecked() ? "1"
                : bi.c20317ab.isChecked() ? "2"
                : "-1");

        form.setC20317ba(bi.c20317ba.isChecked() ? "1" : "-1");
        form.setC20317bb(bi.c20317bb.isChecked() ? "2" : "-1");
        form.setC20317bc(bi.c20317bc.isChecked() ? "3" : "-1");
        form.setC20317bd(bi.c20317bd.isChecked() ? "4" : "-1");
        form.setC20317be(bi.c20317be.isChecked() ? "5" : "-1");
        form.setC20317bf(bi.c20317bf.isChecked() ? "6" : "-1");
        form.setC20317bg(bi.c20317bg.isChecked() ? "7" : "-1");

        form.setC204(bi.c204a.isChecked() ? "1"
                : bi.c204b.isChecked() ? "2"
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

   /* @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }*/


}