package edu.aku.hassannaqvi.covidimmunity.ui.sections;

import static edu.aku.hassannaqvi.covidimmunity.core.MainApp.form;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import edu.aku.hassannaqvi.covidimmunity.R;
import edu.aku.hassannaqvi.covidimmunity.core.MainApp;
import edu.aku.hassannaqvi.covidimmunity.database.DatabaseHelper;
import edu.aku.hassannaqvi.covidimmunity.databinding.ActivitySectionC1Binding;
import edu.aku.hassannaqvi.covidimmunity.ui.EndingActivity;


public class SectionC1Activity extends AppCompatActivity {
    private static final String TAG = "SectionC1Activity";
    ActivitySectionC1Binding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c1);
        bi.setCallback(this);
        bi.setForm(form);
       /* form.setC100Name(MainApp.child.getH229());
        form.setCuid(MainApp.child.getUid());*/
        setupSkips();

        bi.c102.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                bi.c102x.setMaxvalue(form.getC102().equals("2") ? 23f : 99f);
            }
        });

    }


    private void setupSkips() {
    /*    rgLsnr(bi.c101, bi.c101b, new ViewGroup[]{bi.fldGrpCVc102});
        rgLsnr(bi.c106b, bi.c106bb, bi.c106b98, new ViewGroup[]{bi.fldGrpCVc106c});
        rgLsnr(bi.c106d, bi.c106db, bi.c106d98, new ViewGroup[]{bi.fldGrpCVc106e, bi.fldGrpCVc106f});
        rgLsnr(bi.c106g, bi.c106gb, bi.c106g98, new ViewGroup[]{bi.fldGrpCVc106h, bi.fldGrpCVc106i});
        rgLsnr(bi.c106m, bi.c106mb, bi.c106m98, new ViewGroup[]{bi.fldGrpCVc106n});
        rgLsnr(bi.c106p, bi.c106pb, bi.c106p98, new ViewGroup[]{bi.fldGrpCVc106q});
        rgLsnr(bi.c107a, bi.c107ab, bi.c107a98, new ViewGroup[]{bi.fldGrpCVc107bt});*/
        /*rgrps(bi.c107a);
        rgrps(bi.c107c);
        rgrps(bi.c107d);
        rgrps(bi.c107e);
        rgrps(bi.c107f);
        rgrps(bi.c107g);
        rgrps(bi.c107h);
        rgrps(bi.c107i);
        rgrps(bi.c107j);
        rgrps(bi.c107k);
        rgrps(bi.c107l);
        rgrps(bi.c107m);
        rgrps(bi.c107n);
        rgrps(bi.c107o);
        rgrps(bi.c107p);
        rgrps(bi.c107q);
        rgrps(bi.c107r);*/
    }

    private void rgrps(RadioGroup rg) {
        rg.setOnCheckedChangeListener((radioGroup, i) -> {
            if (bi.c107aa.isChecked()
                    || bi.c107ca.isChecked()
                    || bi.c107da.isChecked()
                    || bi.c107ea.isChecked()
                    || bi.c107fa.isChecked()
                    || bi.c107ga.isChecked()
                    || bi.c107ha.isChecked()
                    || bi.c107ia.isChecked()
                    || bi.c107ja.isChecked()
                    || bi.c107ka.isChecked()
                    || bi.c107la.isChecked()
                    || bi.c107ma.isChecked()
                    || bi.c107na.isChecked()
                    || bi.c107oa.isChecked()
                    || bi.c107pa.isChecked()
                    || bi.c107qa.isChecked()
                    || bi.c107ra.isChecked()) {
                form.setC107s("");
                bi.fldGrpCVc107st.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVc107st.setVisibility(View.VISIBLE);
            }
        });
    }


    private boolean updateDB() {
        db = MainApp.appInfo.getDbHelper();
        long updcount = 0;
      /*  try {
            updcount = db.updatesFormColumn(TableContracts.FormsTable.COLUMN_SC1, form.sC1toString());
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, R.string.upd_db_form + e.getMessage());
            Toast.makeText(this, R.string.upd_db_form + e.getMessage(), Toast.LENGTH_SHORT).show();
        }*/
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

        form.setC101(bi.c101a.isChecked() ? "1"
                : bi.c101b.isChecked() ? "2"
                : "-1");

        form.setC102(bi.c102h.isChecked() ? "1"
                : bi.c102d.isChecked() ? "2"
                : bi.c102a.isChecked() ? "000"
                : "-1");

        form.setC103(bi.c103a.isChecked() ? "1"
                : bi.c103b.isChecked() ? "2"
                : "-1");

        form.setC104(bi.c104a.isChecked() ? "1"
                : bi.c104b.isChecked() ? "2"
                : bi.c10498.isChecked() ? "98"
                : "-1");

        form.setC105(bi.c105a.isChecked() ? "1"
                : bi.c105b.isChecked() ? "2"
                : bi.c10598.isChecked() ? "98"
                : "-1");

        form.setC106a(bi.c106aa.isChecked() ? "1"
                : bi.c106ab.isChecked() ? "2"
                : bi.c106a98.isChecked() ? "98"
                : "-1");

        form.setC106b(bi.c106ba.isChecked() ? "1"
                : bi.c106bb.isChecked() ? "2"
                : bi.c106b98.isChecked() ? "98"
                : "-1");

        form.setC106ca(bi.c106ca.getText().toString());
        form.setC106d(bi.c106da.isChecked() ? "1"
                : bi.c106db.isChecked() ? "2"
                : bi.c106d98.isChecked() ? "98"
                : "-1");

        form.setC106ea(bi.c106ea.getText().toString());
        form.setC106f(bi.c106fa.isChecked() ? "1"
                : bi.c106fb.isChecked() ? "2"
                : bi.c106f98.isChecked() ? "98"
                : "-1");

        form.setC106g(bi.c106ga.isChecked() ? "1"
                : bi.c106gb.isChecked() ? "2"
                : bi.c106g98.isChecked() ? "98"
                : "-1");

        form.setC106ha(bi.c106ha.getText().toString());
        form.setC106i(bi.c106ia.isChecked() ? "1"
                : bi.c106ib.isChecked() ? "2"
                : bi.c106i98.isChecked() ? "98"
                : "-1");

        form.setC106j(bi.c106ja.isChecked() ? "1"
                : bi.c106jb.isChecked() ? "2"
                : bi.c106j98.isChecked() ? "98"
                : "-1");

        form.setC106k(bi.c106ka.isChecked() ? "1"
                : bi.c106kb.isChecked() ? "2"
                : bi.c106k98.isChecked() ? "98"
                : "-1");

        form.setC106l(bi.c106la.isChecked() ? "1"
                : bi.c106lb.isChecked() ? "2"
                : bi.c106l98.isChecked() ? "98"
                : "-1");

        form.setC106m(bi.c106ma.isChecked() ? "1"
                : bi.c106mb.isChecked() ? "2"
                : bi.c106m98.isChecked() ? "98"
                : "-1");

        form.setC106n(bi.c106na.isChecked() ? "1"
                : bi.c106nb.isChecked() ? "2"
                : bi.c106n98.isChecked() ? "98"
                : "-1");

        form.setC106o(bi.c106oa.isChecked() ? "1"
                : bi.c106ob.isChecked() ? "2"
                : bi.c106o98.isChecked() ? "98"
                : "-1");

        form.setC106p(bi.c106pa.isChecked() ? "1"
                : bi.c106pb.isChecked() ? "2"
                : bi.c106p98.isChecked() ? "98"
                : "-1");

        form.setC106q(bi.c106qa.isChecked() ? "1"
                : bi.c106qb.isChecked() ? "2"
                : bi.c106q98.isChecked() ? "98"
                : "-1");

        form.setC107a(bi.c107aa.isChecked() ? "1"
                : bi.c107ab.isChecked() ? "2"
                : bi.c107a98.isChecked() ? "98"
                : "-1");

        form.setC107b(bi.c107b.getText().toString());
        form.setC107c(bi.c107ca.isChecked() ? "1"
                : bi.c107cb.isChecked() ? "2"
                : bi.c107c98.isChecked() ? "98"
                : "-1");

        form.setC107d(bi.c107da.isChecked() ? "1"
                : bi.c107db.isChecked() ? "2"
                : bi.c107d98.isChecked() ? "98"
                : "-1");

        form.setC107e(bi.c107ea.isChecked() ? "1"
                : bi.c107eb.isChecked() ? "2"
                : bi.c107e98.isChecked() ? "98"
                : "-1");

        form.setC107f(bi.c107fa.isChecked() ? "1"
                : bi.c107fb.isChecked() ? "2"
                : bi.c107f98.isChecked() ? "98"
                : "-1");

        form.setC107g(bi.c107ga.isChecked() ? "1"
                : bi.c107gb.isChecked() ? "2"
                : bi.c107g98.isChecked() ? "98"
                : "-1");

        form.setC107h(bi.c107ha.isChecked() ? "1"
                : bi.c107hb.isChecked() ? "2"
                : bi.c107h98.isChecked() ? "98"
                : "-1");

        form.setC107j(bi.c107ja.isChecked() ? "1"
                : bi.c107jb.isChecked() ? "2"
                : bi.c107j98.isChecked() ? "98"
                : "-1");

        form.setC107i(bi.c107ia.isChecked() ? "1"
                : bi.c107ib.isChecked() ? "2"
                : bi.c107i98.isChecked() ? "98"
                : "-1");

        form.setC107k(bi.c107ka.isChecked() ? "1"
                : bi.c107kb.isChecked() ? "2"
                : bi.c107k98.isChecked() ? "98"
                : "-1");

        form.setC107l(bi.c107la.isChecked() ? "1"
                : bi.c107lb.isChecked() ? "2"
                : bi.c107l98.isChecked() ? "98"
                : "-1");

        form.setC107m(bi.c107ma.isChecked() ? "1"
                : bi.c107mb.isChecked() ? "2"
                : bi.c107m98.isChecked() ? "98"
                : "-1");

        form.setC107n(bi.c107na.isChecked() ? "1"
                : bi.c107nb.isChecked() ? "2"
                : bi.c107n98.isChecked() ? "98"
                : "-1");

        form.setC107o(bi.c107oa.isChecked() ? "1"
                : bi.c107ob.isChecked() ? "2"
                : bi.c107o98.isChecked() ? "98"
                : "-1");

        form.setC107p(bi.c107pa.isChecked() ? "1"
                : bi.c107pb.isChecked() ? "2"
                : bi.c107p98.isChecked() ? "98"
                : "-1");

        form.setC107q(bi.c107qa.isChecked() ? "1"
                : bi.c107qb.isChecked() ? "2"
                : bi.c107q98.isChecked() ? "98"
                : "-1");

        form.setC107r(bi.c107ra.isChecked() ? "1"
                : bi.c107rb.isChecked() ? "2"
                : bi.c107r98.isChecked() ? "98"
                : "-1");

        form.setC107s(bi.c107s.getText().toString());
        form.setC108(bi.c108a.isChecked() ? "1"
                : bi.c108b.isChecked() ? "2"
                : "-1");

        form.setC108t1(bi.c108t1.getText().toString());

        form.setC109(bi.c109.getText().toString());
*/

    }


    public void btnEnd(View view) {
        finish();
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }


    private boolean formValidation() {
        if (!Validator.emptyCheckingContainer(this, bi.GrpName))
            return false;

        if (bi.c108a.isChecked() && (
                !bi.c107aa.isChecked()
                        || !bi.c107ca.isChecked()
                        || !bi.c107da.isChecked()
                        || !bi.c107ea.isChecked()
                        || !bi.c107fa.isChecked()
                        || !bi.c107ga.isChecked()
                        || !bi.c107ha.isChecked()
                        || !bi.c107ia.isChecked()
                        || !bi.c107ja.isChecked()
                        || !bi.c107ka.isChecked()
                        || !bi.c107la.isChecked()
                        || !bi.c107ma.isChecked()
                        || !bi.c107na.isChecked()
                        || !bi.c107oa.isChecked()
                        || !bi.c107pa.isChecked()
                        || !bi.c107qa.isChecked()
                        || !bi.c107ra.isChecked()
        )) {
            bi.fldGrpCVc107a.setFocusable(true);
            bi.fldGrpCVc107r.setFocusable(true);
            Toast.makeText(this, R.string.invalid_response, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
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