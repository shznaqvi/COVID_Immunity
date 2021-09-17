package edu.aku.hassannaqvi.covidimmunity.models;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;
import androidx.databinding.library.baseAdapters.BR;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.covidimmunity.contracts.TableContracts.FormsTable;
import edu.aku.hassannaqvi.covidimmunity.core.MainApp;


public class Form extends BaseObservable implements Observable {

    private final String TAG = "Form";
    private final transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();
    // APP VARIABLES
    private String projectName = MainApp.PROJECT_NAME;
    // APP VARIABLES
    private String id = StringUtils.EMPTY;
    private String uid = StringUtils.EMPTY;
    private String wuid = StringUtils.EMPTY;
    private String cuid = StringUtils.EMPTY;
    private String userName = StringUtils.EMPTY;
    private String sysDate = StringUtils.EMPTY;
    private String cluster = StringUtils.EMPTY;
    private String hhid = StringUtils.EMPTY;
    private String deviceId = StringUtils.EMPTY;
    private String deviceTag = StringUtils.EMPTY;
    private String appver = StringUtils.EMPTY;
    private String endTime = StringUtils.EMPTY;
    private String iStatus = StringUtils.EMPTY;
    private String iStatus96x = StringUtils.EMPTY;
    private String synced = StringUtils.EMPTY;
    private String syncDate = StringUtils.EMPTY;

    // SECTION VARIABLES
    private String sHA = StringUtils.EMPTY;
    private String sPA = StringUtils.EMPTY;
    private String sPB = StringUtils.EMPTY;
    private String sPC = StringUtils.EMPTY;


    private String h107 = StringUtils.EMPTY;
    private String h108 = StringUtils.EMPTY;
    private String h109 = StringUtils.EMPTY;
    private String h110 = StringUtils.EMPTY;
    private String h111 = StringUtils.EMPTY;
    private String h112 = StringUtils.EMPTY;
    private String h11296x = StringUtils.EMPTY;


    public Form() {

    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Bindable
    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
        notifyPropertyChanged(BR.cluster);
    }

    @Bindable
    public String getHhid() {
        return hhid;
    }

    public void setHhid(String hhid) {
        this.hhid = hhid;
        notifyPropertyChanged(BR.hhid);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSysDate() {
        return sysDate;
    }

    public void setSysDate(String sysDate) {
        this.sysDate = sysDate;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceTag() {
        return deviceTag;
    }

    public void setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
    }

    public String getAppver() {
        return appver;
    }

    public void setAppver(String appver) {
        this.appver = appver;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getiStatus() {
        return iStatus;
    }

    public void setiStatus(String iStatus) {
        this.iStatus = iStatus;
    }

    public String getiStatus96x() {
        return iStatus96x;
    }

    public void setiStatus96x(String iStatus96x) {
        this.iStatus96x = iStatus96x;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(String syncDate) {
        this.syncDate = syncDate;
    }

   /* public String getsH2a() {
        return sH2a;
    }

    public void setsH2a(String sH2a) {
        this.sH2a = sH2a;
    }*/

    public String getsHA() {
        return sHA;
    }

    public void setsHA(String sHA) {
        this.sHA = sHA;
    }

    public String getsPA() {
        return sPA;
    }

    public void setsPA(String sPA) {
        this.sPA = sPA;
    }

    public String getsPB() {
        return sPB;
    }

    public void setsPB(String sPB) {
        this.sPB = sPB;
    }

    public String getsPC() {
        return sPC;
    }

    public void setsPC(String sPC) {
        this.sPC = sPC;
    }


    @Bindable
    public String getH107() {
        return h107;
    }

    public void setH107(String h107) {
        this.h107 = h107;
        notifyPropertyChanged(BR.h107);
    }

    @Bindable
    public String getH108() {
        return h108;
    }

    public void setH108(String h108) {
        this.h108 = h108;
        notifyPropertyChanged(BR.h108);
    }

    @Bindable
    public String getH109() {
        return h109;
    }

    public void setH109(String h109) {
        this.h109 = h109;
        notifyPropertyChanged(BR.h109);
    }

    @Bindable
    public String getH110() {
        return h110;
    }

    public void setH110(String h110) {
        this.h110 = h110;
        notifyPropertyChanged(BR.h110);
    }

    @Bindable
    public String getH111() {
        return h111;
    }

    public void setH111(String h111) {
        this.h111 = h111;
        notifyPropertyChanged(BR.h111);
    }

    @Bindable
    public String getH112() {
        return h112;
    }

    public void setH112(String h112) {
        this.h112 = h112;
        notifyPropertyChanged(BR.h112);
    }

    @Bindable
    public String getH11296x() {
        return h11296x;
    }

    public void setH11296x(String h11296x) {
        this.h11296x = h11296x;
        notifyPropertyChanged(BR.h11296x);
    }


    @Bindable
    public String getWuid() {
        return wuid;
    }

    public void setWuid(String wuid) {
        this.wuid = wuid;
        notifyPropertyChanged(BR.wuid);
    }

    @Bindable
    public String getCuid() {
        return cuid;
    }

    public void setCuid(String cuid) {
        this.cuid = cuid;
        notifyPropertyChanged(BR.cuid);
    }


    public Form Hydrate(Cursor cursor) throws JSONException {
        this.id = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_UID));
        this.cluster = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_CLUSTER));
        this.hhid = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_HHID));
        this.userName = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYSDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_APPVERSION));
        this.iStatus = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS));
        this.synced = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYNCED_DATE));

        sHAHydrate(cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SHA)));
        sPAHydrate(cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SPA)));
        sPBHydrate(cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SPB)));
        sPCHydrate(cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SPC)));

        return this;
    }

    public void sHAHydrate(String string) throws JSONException {
        Log.d(TAG, "sH1Hydrate: " + string);
        if (string != null) {

            JSONObject json = null;
            json = new JSONObject(string);
             /*   this.h106m = json.getString("h106m");
                this.h106y = json.getString("h106y");*/
            this.h107 = json.getString("h107");
            /*  this.h107m = json.getString("h107m");*/
            this.h108 = json.getString("h108");
            this.h109 = json.getString("h109");
            this.h110 = json.getString("h110");
            this.h111 = json.getString("h111");
            this.h112 = json.getString("h112");
            this.h11296x = json.getString("h11296x");

        }
    }

    public void sPAHydrate(String string) throws JSONException {
        Log.d(TAG, "sH2bHydrate: " + string);
        if (string != null) {

            JSONObject json = null;
            json = new JSONObject(string);
/*            this.h209t = json.getString("h209t");
            this.h209m = json.getString("h209m");*/

        }
    }

    public void sPBHydrate(String string) throws JSONException {
        Log.d(TAG, "sH3aHydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);

        }
    }

    public void sPCHydrate(String string) throws JSONException {
        Log.d(TAG, "sH3bHydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);

        }
    }


    public String sHAtoString() throws JSONException {
        Log.d(TAG, "sHAtoString: ");
        JSONObject json = new JSONObject();

        json.put("h108", h108)
                .put("h109", h109)
                .put("h110", h110)
                .put("h111", h111)
                .put("h112", h112)
                .put("h11296x", h11296x);

        return json.toString();
    }

    public String sPAtoString() throws JSONException {
        Log.d(TAG, "sPAtoString: ");
        JSONObject json = new JSONObject();
//        json.put();

        return json.toString();
    }

    public String sH3atoString() throws JSONException {
        Log.d(TAG, "sH3atoString: ");
        JSONObject json = new JSONObject();
//        json.put();

        return json.toString();
    }

    public String sPBtoString() throws JSONException {
        Log.d(TAG, "sPBtoString: ");
        JSONObject json = new JSONObject();
//        json.put();

        return json.toString();
    }

    public String sPCtoString() throws JSONException {
        Log.d(TAG, "sPCtoString: ");
        JSONObject json = new JSONObject();
//        json.put();

        return json.toString();
    }


    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();

        json.put(FormsTable.COLUMN_ID, this.id);
        json.put(FormsTable.COLUMN_UID, this.uid);
        json.put(FormsTable.COLUMN_CLUSTER, this.cluster);
        json.put(FormsTable.COLUMN_HHID, this.hhid);
        json.put(FormsTable.COLUMN_USERNAME, this.userName);
        json.put(FormsTable.COLUMN_SYSDATE, this.sysDate);
        json.put(FormsTable.COLUMN_DEVICEID, this.deviceId);
        json.put(FormsTable.COLUMN_DEVICETAGID, this.deviceTag);
        json.put(FormsTable.COLUMN_ISTATUS, this.iStatus);
        //  json.put(FormsTable.COLUMN_SYNCED, this.synced);
        //  json.put(FormsTable.COLUMN_SYNCED_DATE, this.syncDate);

        // Form
        json.put(FormsTable.COLUMN_SHA, new JSONObject(sHAtoString()));
        json.put(FormsTable.COLUMN_SPA, new JSONObject(sPAtoString()));
        json.put(FormsTable.COLUMN_SPB, new JSONObject(sPBtoString()));
        json.put(FormsTable.COLUMN_SPC, new JSONObject(sPCtoString()));

        return json;
    }
}
