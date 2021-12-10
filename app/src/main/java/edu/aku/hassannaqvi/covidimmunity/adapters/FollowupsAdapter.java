package edu.aku.hassannaqvi.covidimmunity.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.aku.hassannaqvi.covidimmunity.R;
import edu.aku.hassannaqvi.covidimmunity.core.MainApp;
import edu.aku.hassannaqvi.covidimmunity.models.FollowUpsSche;
import edu.aku.hassannaqvi.covidimmunity.models.Followup;
import edu.aku.hassannaqvi.covidimmunity.ui.sections.SectionFHAActivity;


public class FollowupsAdapter extends RecyclerView.Adapter<FollowupsAdapter.ViewHolder> {
    private static final String TAG = "MWRAAdapter";
    private final List<FollowUpsSche> fups;
    private final int mExpandedPosition = -1;
    private final int completeCount;
    private final boolean motherPresent = false;
    private Context mContext;

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param fups List<FemaleMembersModel> containing the data to populate views to be used by RecyclerView.
     */
    public FollowupsAdapter(Context mContext, List<FollowUpsSche> fups) {
        this.fups = fups;
        this.mContext = mContext;
        completeCount = 0;
        MainApp.followupComplete = false;

    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int positionu) {
        int position = holder.getAdapterPosition();
        Log.d("FollowupsAdapter", "onBindViewHolder: " + fups.get(position).getFpcode() + "/20");
        holder.fupWeek.setText("0" + fups.get(position).getFpcode());
        holder.chName.setText(fups.get(position).getPa01());
        holder.mName.setText(" [" + fups.get(position).getPa01a() + "]");
        holder.mrno.setText(fups.get(position).getMemberid());
        holder.fupdates.setText("SCHEDULED NO: " + fups.get(position).getFp_date() + " - DONE ON: " + (fups.get(position).getFupdonedt().equals("") ? "not-done" : fups.get(position).getFupdonedt()));
        if (!fups.get(position).getFupdonedt().equals("")) {
            holder.fupdates.setTextColor(ContextCompat.getColor(mContext, R.color.redDark));

        }
/*        holder.istatus.setText(iStatus);
        holder.istatus.setTextColor(iColor);*/
        //  holder.cluster.setText(form.get(position).getA08() + " (" + form.get(position).getRefno() + ")");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fups.get(position).getFupdonedt().equals("")) {
                    MainApp.position = position;
                    Intent intent = new Intent(mContext, SectionFHAActivity.class);
                    intent.putExtra("list", true);
                    MainApp.followupsSche = fups.get(position);
                    MainApp.followup = new Followup();
                    // MainApp.followup.setFha01(fups.get(position).getHa01());
                    MainApp.followup.setFha09(fups.get(position).getHa09());
                    MainApp.followup.setFha11(fups.get(position).getHa11());
                    MainApp.followup.setFha12(fups.get(position).getHa12());
                    MainApp.followup.setFha12a(fups.get(position).getHa12a());
                    MainApp.followup.setFpa01(fups.get(position).getPa01());
                    MainApp.followup.setFpa01a(fups.get(position).getPa01a());
                    MainApp.followup.setFha13(fups.get(position).getPa01b());
                    ((Activity) mContext).startActivityForResult(intent, 1002);
                } else {
                    Toast.makeText(mContext, " Followup-" + fups.get(position).getFpcode() + " of " + fups.get(position).getPa01() + " has already been done.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.followups_list_item, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return fups.size();
    }

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView rv;
        public TextView chName;
        public TextView mName;
        public TextView fupWeek;
        public TextView mrno;
        public TextView fupdates;
        public TextView istatus;


        public ViewHolder(View v) {
            super(v);
            fupWeek = v.findViewById(R.id.fupWeek);
            chName = v.findViewById(R.id.chname);
            mName = v.findViewById(R.id.mname);
            mrno = v.findViewById(R.id.mrno);
            fupdates = v.findViewById(R.id.fupDates);
            istatus = v.findViewById(R.id.istatus);
            mContext = v.getContext();

        }

  /*      public TextView getTextView() {
            return fName;
        }*/
    }


}
