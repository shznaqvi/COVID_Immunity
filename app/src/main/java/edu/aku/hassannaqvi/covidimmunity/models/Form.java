package edu.aku.hassannaqvi.covidimmunity.models;

import android.database.Cursor;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.covidimmunity.BR;
import edu.aku.hassannaqvi.covidimmunity.contracts.TableContracts.FormsTable;
import edu.aku.hassannaqvi.covidimmunity.core.MainApp;


public class Form extends BaseObservable implements Observable {

    private final String TAG = "Form";
    private transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();
    // APP VARIABLES
    private String projectName = MainApp.PROJECT_NAME;
    // APP VARIABLES
    private String id = StringUtils.EMPTY;
    private String uid = StringUtils.EMPTY;
    private final String wuid = StringUtils.EMPTY;
    private final String cuid = StringUtils.EMPTY;
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


    private String ha01 = StringUtils.EMPTY;
    private String ha02 = StringUtils.EMPTY;
    private String ha08 = StringUtils.EMPTY;
    private String ha09 = StringUtils.EMPTY;
    private String ha10 = StringUtils.EMPTY;
    private String ha11 = StringUtils.EMPTY;
    private String ha12 = StringUtils.EMPTY;
    private String ha12a = StringUtils.EMPTY;
    private String ha13 = StringUtils.EMPTY;
    private String pa01 = StringUtils.EMPTY;
    private String pa01a = StringUtils.EMPTY;
    private String pa01b = StringUtils.EMPTY;
    private String pa01c = StringUtils.EMPTY;
    private String pa02 = StringUtils.EMPTY;
    private String pa03a = StringUtils.EMPTY;
    private String pa03b = StringUtils.EMPTY;
    private String pa04 = StringUtils.EMPTY;
    private String pa05 = StringUtils.EMPTY;
    private String pa05a = StringUtils.EMPTY;
    private String pa06a = StringUtils.EMPTY;
    private String pa06b = StringUtils.EMPTY;
    private String pa07 = StringUtils.EMPTY;
    private String pa08 = StringUtils.EMPTY;
    private String pb01a = StringUtils.EMPTY;
    private String pb01b = StringUtils.EMPTY;
    private String pb01c = StringUtils.EMPTY;
    private String pb01d = StringUtils.EMPTY;
    private String pb01e = StringUtils.EMPTY;
    private String pb01f = StringUtils.EMPTY;
    private String pb01g = StringUtils.EMPTY;
    private String pb01h = StringUtils.EMPTY;
    private String pb01j = StringUtils.EMPTY;
    private String pb01k = StringUtils.EMPTY;
    private String pb01m = StringUtils.EMPTY;
    private String pb01n = StringUtils.EMPTY;
    private String pb01p = StringUtils.EMPTY;
    private String pb01q = StringUtils.EMPTY;
    private String pb02a = StringUtils.EMPTY;
    private String pb02b = StringUtils.EMPTY;
    private String pb02c = StringUtils.EMPTY;
    private String pb02d = StringUtils.EMPTY;
    private String pb02e = StringUtils.EMPTY;
    private String pb02f = StringUtils.EMPTY;
    private String pb02g = StringUtils.EMPTY;
    private String pb02h = StringUtils.EMPTY;
    private String pb02j = StringUtils.EMPTY;
    private String pb02j96 = StringUtils.EMPTY;
    private String pb03 = StringUtils.EMPTY;
    private String pb05 = StringUtils.EMPTY;
    private String pb06 = StringUtils.EMPTY;
    private String pb07 = StringUtils.EMPTY;
    private String pb08 = StringUtils.EMPTY;
    private String pc01 = StringUtils.EMPTY;
    private String pc0196x = StringUtils.EMPTY;
    private String pc02 = StringUtils.EMPTY;
    private String pc03 = StringUtils.EMPTY;
    private String pc04 = StringUtils.EMPTY;
    private String pc05 = StringUtils.EMPTY;
    private String pc06 = StringUtils.EMPTY;
    private String pc07 = StringUtils.EMPTY;
    private String pc08 = StringUtils.EMPTY;


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
    }

    @Bindable
    public String getHhid() {
        return hhid;
    }

    public void setHhid(String hhid) {
        this.hhid = hhid;
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

    @Bindable
    public String getHa01() {
        return ha01;
    }

    public void setHa01(String ha01) {
        this.ha01 = ha01;
        notifyPropertyChanged(BR.ha01);
    }

    @Bindable
    public String getHa02() {
        return ha02;
    }

    public void setHa02(String ha02) {
        this.ha02 = ha02;
        notifyChange(BR.ha02);
    }

    @Bindable
    public String getHa08() {
        return ha08;
    }

    public void setHa08(String ha08) {
        this.ha08 = ha08;
        notifyChange(BR.ha08);
    }

    @Bindable
    public String getHa09() {
        return ha09;
    }

    public void setHa09(String ha09) {
        this.ha09 = ha09;
        notifyChange(BR.ha09);
    }

    @Bindable
    public String getHa10() {
        return ha10;
    }

    public void setHa10(String ha10) {
        this.ha10 = ha10;
        notifyChange(BR.ha10);
    }

    @Bindable
    public String getHa11() {
        return ha11;
    }

    public void setHa11(String ha11) {
        this.ha11 = ha11;
        notifyChange(BR.ha11);
    }

    @Bindable
    public String getHa12() {
        return ha12;
    }

    public void setHa12(String ha12) {
        this.ha12 = ha12;
        notifyChange(BR.ha12);
    }

    @Bindable
    public String getHa12a() {
        return ha12a;
    }

    public void setHa12a(String ha12a) {
        this.ha12a = ha12a;
        notifyChange(BR.ha12a);
    }

    @Bindable
    public String getHa13() {
        return ha13;
    }

    public void setHa13(String ha13) {
        this.ha13 = ha13;
        notifyChange(BR.ha13);
    }

    @Bindable
    public String getPa01() {
        return pa01;
    }

    public void setPa01(String pa01) {
        this.pa01 = pa01;
        notifyChange(BR.pa01);
    }

    @Bindable
    public String getPa01a() {
        return pa01a;
    }

    public void setPa01a(String pa01a) {
        this.pa01a = pa01a;
        notifyChange(BR.pa01a);
    }

    @Bindable
    public String getPa01b() {
        return pa01b;
    }

    public void setPa01b(String pa01b) {
        this.pa01b = pa01b;
        notifyChange(BR.pa01b);
    }

    @Bindable
    public String getPa01c() {
        return pa01c;
    }

    public void setPa01c(String pa01c) {
        this.pa01c = pa01c;
        notifyChange(BR.pa01c);
    }

    @Bindable
    public String getPa02() {
        return pa02;
    }

    public void setPa02(String pa02) {
        this.pa02 = pa02;
        notifyChange(BR.pa02);
    }

    @Bindable
    public String getPa03a() {
        return pa03a;
    }

    public void setPa03a(String pa03a) {
        this.pa03a = pa03a;
        notifyChange(BR.pa03a);
    }

    @Bindable
    public String getPa03b() {
        return pa03b;
    }

    public void setPa03b(String pa03b) {
        this.pa03b = pa03b;
        notifyChange(BR.pa03b);
    }

    @Bindable
    public String getPa04() {
        return pa04;
    }

    public void setPa04(String pa04) {
        this.pa04 = pa04;
        setPa05(pa04.equals("1") ? this.pa05 : "");
        setPa05a(pa04.equals("1") ? this.pa05a : "");
        setPa06a(pa04.equals("1") ? this.pa06a : "");
        setPa07(pa04.equals("1") ? this.pa07 : "");
        setPa08(pa04.equals("1") ? this.pa08 : "");
        notifyChange(BR.pa04);
    }

    @Bindable
    public String getPa05() {
        return pa05;
    }

    public void setPa05(String pa05) {
        this.pa05 = pa05;
        setPa05a(pa05.equals("2") ? this.pa05a : "");
        setPa06a(pa05.equals("2") ? this.pa06a : "");
        setPa07(pa05.equals("2") ? this.pa07 : "");
        setPa08(pa05.equals("2") ? this.pa08 : "");
        notifyChange(BR.pa05);
    }

    @Bindable
    public String getPa05a() {
        return pa05a;
    }

    public void setPa05a(String pa05a) {
        this.pa05a = pa05a;
        notifyChange(BR.pa05a);
    }

    @Bindable
    public String getPa06a() {
        return pa06a;
    }

    public void setPa06a(String pa06a) {
        this.pa06a = pa06a;
        notifyChange(BR.pa06a);
    }

    @Bindable
    public String getPa06b() {
        return pa06b;
    }

    public void setPa06b(String pa06b) {
        this.pa06b = pa06b;
        notifyChange(BR.pa06b);
    }

    @Bindable
    public String getPa07() {
        return pa07;
    }

    public void setPa07(String pa07) {
        this.pa07 = pa07;
        notifyChange(BR.pa07);
    }

    @Bindable
    public String getPa08() {
        return pa08;
    }

    public void setPa08(String pa08) {
        this.pa08 = pa08;
        notifyChange(BR.pa08);
    }

    @Bindable
    public String getPb01a() {
        return pb01a;
    }

    public void setPb01a(String pb01a) {
        this.pb01a = pb01a;
        notifyChange(BR.pb01a);
    }

    @Bindable
    public String getPb01b() {
        return pb01b;
    }

    public void setPb01b(String pb01b) {
        this.pb01b = pb01b;
        notifyChange(BR.pb01b);
    }

    @Bindable
    public String getPb01c() {
        return pb01c;
    }

    public void setPb01c(String pb01c) {
        this.pb01c = pb01c;
        notifyChange(BR.pb01c);
    }

    @Bindable
    public String getPb01d() {
        return pb01d;
    }

    public void setPb01d(String pb01d) {
        this.pb01d = pb01d;
        notifyChange(BR.pb01d);
    }

    @Bindable
    public String getPb01e() {
        return pb01e;
    }

    public void setPb01e(String pb01e) {
        this.pb01e = pb01e;
        notifyChange(BR.pb01e);
    }

    @Bindable
    public String getPb01f() {
        return pb01f;
    }

    public void setPb01f(String pb01f) {
        this.pb01f = pb01f;
        notifyChange(BR.pb01f);
    }

    @Bindable
    public String getPb01g() {
        return pb01g;
    }

    public void setPb01g(String pb01g) {
        this.pb01g = pb01g;
        notifyChange(BR.pb01g);
    }

    @Bindable
    public String getPb01h() {
        return pb01h;
    }

    public void setPb01h(String pb01h) {
        this.pb01h = pb01h;
        notifyChange(BR.pb01h);
    }

    @Bindable
    public String getPb01j() {
        return pb01j;
    }

    public void setPb01j(String pb01j) {
        this.pb01j = pb01j;
        notifyChange(BR.pb01j);
    }

    @Bindable
    public String getPb01k() {
        return pb01k;
    }

    public void setPb01k(String pb01k) {
        this.pb01k = pb01k;
        notifyChange(BR.pb01k);
    }

    @Bindable
    public String getPb01m() {
        return pb01m;
    }

    public void setPb01m(String pb01m) {
        this.pb01m = pb01m;
        notifyChange(BR.pb01m);
    }

    @Bindable
    public String getPb01n() {
        return pb01n;
    }

    public void setPb01n(String pb01n) {
        this.pb01n = pb01n;
        notifyChange(BR.pb01n);
    }

    @Bindable
    public String getPb01p() {
        return pb01p;
    }

    public void setPb01p(String pb01p) {
        this.pb01p = pb01p;
        notifyChange(BR.pb01p);
    }

    @Bindable
    public String getPb01q() {
        return pb01q;
    }

    public void setPb01q(String pb01q) {
        this.pb01q = pb01q;
        notifyChange(BR.pb01q);
    }

    @Bindable
    public String getPb02a() {
        return pb02a;
    }

    public void setPb02a(String pb02a) {
        this.pb02a = pb02a;
        notifyChange(BR.pb02a);
    }

    @Bindable
    public String getPb02b() {
        return pb02b;
    }

    public void setPb02b(String pb02b) {
        this.pb02b = pb02b;
        notifyChange(BR.pb02b);
    }

    @Bindable
    public String getPb02c() {
        return pb02c;
    }

    public void setPb02c(String pb02c) {
        this.pb02c = pb02c;
        notifyChange(BR.pb02c);
    }

    @Bindable
    public String getPb02d() {
        return pb02d;
    }

    public void setPb02d(String pb02d) {
        this.pb02d = pb02d;
        notifyChange(BR.pb02d);
    }

    @Bindable
    public String getPb02e() {
        return pb02e;
    }

    public void setPb02e(String pb02e) {
        this.pb02e = pb02e;
        notifyChange(BR.pb02e);
    }

    @Bindable
    public String getPb02f() {
        return pb02f;
    }

    public void setPb02f(String pb02f) {
        this.pb02f = pb02f;
        notifyChange(BR.pb02f);
    }

    @Bindable
    public String getPb02g() {
        return pb02g;
    }

    public void setPb02g(String pb02g) {
        this.pb02g = pb02g;
        notifyChange(BR.pb02g);
    }

    @Bindable
    public String getPb02h() {
        return pb02h;
    }

    public void setPb02h(String pb02h) {
        this.pb02h = pb02h;
        notifyChange(BR.pb02h);
    }

    @Bindable
    public String getPb02j() {
        return pb02j;
    }

    public void setPb02j(String pb02j) {
        this.pb02j = pb02j;
        setPb02j96(pb02j.equals("1") ? this.pb02j96 : ""); // for all skips, mention all skipped questions
        notifyChange(BR.pb02j);
    }

    @Bindable
    public String getPb02j96() {
        return pb02j96;
    }

    public void setPb02j96(String pb02j96) {
        this.pb02j96 = pb02j96;
        notifyChange(BR.pb02j96);
    }

    @Bindable
    public String getPb03() {
        return pb03;
    }

    public void setPb03(String pb03) {
        this.pb03 = pb03;
        notifyChange(BR.pb03);
    }

    @Bindable
    public String getPb05() {
        return pb05;
    }

    public void setPb05(String pb05) {
        this.pb05 = pb05;
        setPb06(pb05.equals("1") ? this.pb06 : "");
        notifyChange(BR.pb05);
    }

    @Bindable
    public String getPb06() {
        return pb06;
    }

    public void setPb06(String pb06) {
        this.pb06 = pb06;
        notifyChange(BR.pb06);
    }

    @Bindable
    public String getPb07() {
        return pb07;
    }

    public void setPb07(String pb07) {
        this.pb07 = pb07;
        setPb08(pb07.equals("1") ? this.pb08 : "");
        notifyChange(BR.pb07);
    }

    @Bindable
    public String getPb08() {
        return pb08;
    }

    public void setPb08(String pb08) {
        this.pb08 = pb08;
        notifyChange(BR.pb08);
    }

    @Bindable
    public String getPc01() {
        return pc01;
    }

    public void setPc01(String pc01) {
        this.pc01 = pc01;
        setPc0196x(pc01.equals("96") ? this.pc0196x : "");
        notifyChange(BR.pc01);
    }

    @Bindable
    public String getPc0196x() {
        return pc0196x;
    }

    public void setPc0196x(String pc0196x) {
        this.pc0196x = pc0196x;
        notifyChange(BR.pc0196x);
    }

    @Bindable
    public String getPc02() {
        return pc02;
    }

    public void setPc02(String pc02) {
        this.pc02 = pc02;
        notifyChange(BR.pc02);
    }

    @Bindable
    public String getPc03() {
        return pc03;
    }

    public void setPc03(String pc03) {
        this.pc03 = pc03;
        notifyChange(BR.pc03);
    }

    @Bindable
    public String getPc04() {
        return pc04;
    }

    public void setPc04(String pc04) {
        this.pc04 = pc04;
        notifyChange(BR.pc04);
    }

    @Bindable
    public String getPc05() {
        return pc05;
    }

    public void setPc05(String pc05) {
        this.pc05 = pc05;
        notifyChange(BR.pc05);
    }

    @Bindable
    public String getPc06() {
        return pc06;
    }

    public void setPc06(String pc06) {
        this.pc06 = pc06;
        setPc07(pc06.equals("1") ? this.pc07 : "");
        setPc08(pc06.equals("1") ? this.pc08 : "");
        notifyChange(BR.pc06);
    }

    @Bindable
    public String getPc07() {
        return pc07;
    }

    public void setPc07(String pc07) {
        this.pc07 = pc07;
        notifyChange(BR.pc07);
    }

    @Bindable
    public String getPc08() {
        return pc08;
    }

    public void setPc08(String pc08) {
        this.pc08 = pc08;
        notifyChange(BR.pc08);
    }

    @Bindable
    public String getH107() {
        return h107;
    }

    public void setH107(String h107) {
        this.h107 = h107;
        notifyChange(BR.h107);
    }

    @Bindable
    public String getH108() {
        return h108;
    }

    public void setH108(String h108) {
        this.h108 = h108;
        notifyChange(BR.h108);
    }

    @Bindable
    public String getH109() {
        return h109;
    }

    public void setH109(String h109) {
        this.h109 = h109;
        notifyChange(BR.h109);
    }

    @Bindable
    public String getH110() {
        return h110;
    }

    public void setH110(String h110) {
        this.h110 = h110;
        notifyChange(BR.h110);
    }

    @Bindable
    public String getH111() {
        return h111;
    }

    public void setH111(String h111) {
        this.h111 = h111;
        notifyChange(BR.h111);
    }

    @Bindable
    public String getH112() {
        return h112;
    }

    public void setH112(String h112) {
        this.h112 = h112;
        notifyChange(BR.h112);
    }

    @Bindable
    public String getH11296x() {
        return h11296x;
    }

    public void setH11296x(String h11296x) {
        this.h11296x = h11296x;
        notifyChange(BR.h11296x);
    }

    private synchronized void notifyChange(int propertyId) {
        if (propertyChangeRegistry == null) {
            propertyChangeRegistry = new PropertyChangeRegistry();
        }
        propertyChangeRegistry.notifyChange(this, propertyId);
    }

    @Override
    public synchronized void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (propertyChangeRegistry == null) {
            propertyChangeRegistry = new PropertyChangeRegistry();
        }
        propertyChangeRegistry.add(callback);

    }

    @Override
    public synchronized void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (propertyChangeRegistry != null) {
            propertyChangeRegistry.remove(callback);
        }
    }
}
