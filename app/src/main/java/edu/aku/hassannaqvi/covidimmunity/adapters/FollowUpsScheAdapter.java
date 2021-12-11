package edu.aku.hassannaqvi.covidimmunity.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import edu.aku.hassannaqvi.covidimmunity.R;
import edu.aku.hassannaqvi.covidimmunity.core.MainApp;
import edu.aku.hassannaqvi.covidimmunity.models.FollowUpsSche;
import edu.aku.hassannaqvi.covidimmunity.models.Followup;
import edu.aku.hassannaqvi.covidimmunity.ui.sections.SectionFHAActivity;


public class FollowUpsScheAdapter extends RecyclerView.Adapter<FollowUpsScheAdapter.ViewHolder> {
    private static final String TAG = "MWRAAdapter";
    private Context mContext;


    public FollowUpsScheAdapter(Context mContext) {
        this.mContext = mContext;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "Element " + position + " set.");
        FollowUpsSche fups = MainApp.fupsSche.get(position);        // Get element from your dataset at this position and replace the contents of the view
        // with that element

        TextView chName = holder.chName;
        TextView mName = holder.mName;
        TextView fupWeek = holder.fupWeek;
        TextView mrno = holder.mrno;
        TextView fupdates = holder.fupdates;
        ImageView istatus = holder.istatus;

        //String pregStatus = familyMember.getRb07().equals("1") ? "Pregnant" : "Not Pregnant";

        fupWeek.setText("0" + fups.getFpcode());
        chName.setText(fups.getPa01());
        mName.setText(fups.getPa01a());
        mrno.setText(fups.getMemberid());
        fupdates.setText(fups.getFupdonedt().equals("") ? "SCHEDULED NO: " + fups.getFp_date() : "DONE ON: " + fups.getFupdonedt());
        fupdates.setTextColor(fups.getFupdonedt().equals("") ? ContextCompat.getColor(mContext, R.color.colorPrimaryDark) : ContextCompat.getColor(mContext, R.color.redDark));
        istatus.setVisibility(fups.getFupdonedt().equals("") ? View.INVISIBLE : View.VISIBLE);

/*        if (!fups.getFupdonedt().equals("")) {
            fupdates.setText("DONE ON: " + fups.getFupdonedt());
            fupdates.setTextColor(ContextCompat.getColor(mContext, R.color.redDark));
            istatus.setVisibility(View.VISIBLE);
        }*/

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fups.getFupdonedt().equals("")) {
                    MainApp.position = position;
                    Intent intent = new Intent(mContext, SectionFHAActivity.class);
                    intent.putExtra("list", true);
                    MainApp.followupsSche = fups;
                    MainApp.followup = new Followup();
                    // MainApp.followup.setFha01(fups.get(position).getHa01());
                    MainApp.followup.setFha09(fups.getHa09());
                    MainApp.followup.setFha11(fups.getHa11());
                    MainApp.followup.setFha12(fups.getHa12());
                    MainApp.followup.setFha12a(fups.getHa12a());
                    MainApp.followup.setFpa01(fups.getPa01());
                    MainApp.followup.setFpa01a(fups.getPa01a());
                    MainApp.followup.setFha13(fups.getPa01b());
                    ((Activity) mContext).startActivityForResult(intent, 1002);
                } else {
                    Toast.makeText(mContext, " Followup-" + fups.getFpcode() + " of " + fups.getPa01() + " has already been done.", Toast.LENGTH_SHORT).show();
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
        return MainApp.fupsSche.size();
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
        public ImageView istatus;


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

    }


}
