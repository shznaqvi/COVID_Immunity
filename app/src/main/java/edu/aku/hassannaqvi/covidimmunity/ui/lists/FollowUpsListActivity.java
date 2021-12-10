package edu.aku.hassannaqvi.covidimmunity.ui.lists;

import static edu.aku.hassannaqvi.covidimmunity.core.MainApp.followup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.covidimmunity.R;
import edu.aku.hassannaqvi.covidimmunity.adapters.FollowupsAdapter;
import edu.aku.hassannaqvi.covidimmunity.contracts.TableContracts;
import edu.aku.hassannaqvi.covidimmunity.core.MainApp;
import edu.aku.hassannaqvi.covidimmunity.database.DatabaseHelper;
import edu.aku.hassannaqvi.covidimmunity.databinding.ActivityFollowupsListBinding;
import edu.aku.hassannaqvi.covidimmunity.models.FollowUpsSche;

public class FollowUpsListActivity extends AppCompatActivity {

    ActivityFollowupsListBinding bi;
    DatabaseHelper db;
    List<FollowUpsSche> fupsSche;
    String sysdateToday = new SimpleDateFormat("dd-MM-yy").format(new Date());
    private RecyclerView.Adapter followupsAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_followups_list);
        //recyclerView = findViewById(R.id.fc_recycler_view);
//        setSupportActionBar(bi.toolbar);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);


        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        //  bi.fcRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        bi.fcRecyclerView.setLayoutManager(layoutManager);
        bi.dtFilter.setVisibility(View.VISIBLE);
        db = MainApp.appInfo.dbHelper;
        try {
            fupsSche = db.getAllFollowUpsSche();
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "JSONException(FollowUpsSche)", Toast.LENGTH_SHORT).show();
        }

        // specify an adapter (see also next example)
        followupsAdapter = new FollowupsAdapter(this, (List<FollowUpsSche>) fupsSche);
        bi.fcRecyclerView.setAdapter(followupsAdapter);
    }

    public void filterFollowUps(View view) {
        Toast.makeText(this, "updated", Toast.LENGTH_SHORT).show();
        try {
            fupsSche = db.getFollowUpsScheByDistrict(bi.dtFilter.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "JSONException(FollowUpsSche)", Toast.LENGTH_SHORT).show();
        }
        followupsAdapter = new FollowupsAdapter(this, (List<FollowUpsSche>) fupsSche);
        followupsAdapter.notifyDataSetChanged();
        bi.fcRecyclerView.setAdapter(followupsAdapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1002) {
            if (followup.getiStatus().equals("1")) {
                db.updatesFollowupsScheColumn(TableContracts.FollowupsScheTable.COLUMN_FP_DONE, followup.getSysDate());
                fupsSche.get(MainApp.position).setFupdonedt(followup.getSysDate());
                followupsAdapter.notifyItemChanged(MainApp.position);
            } else {
                Toast.makeText(this, "Followup was not recorded.", Toast.LENGTH_SHORT).show();
            }
        }

    }
}