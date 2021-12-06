package edu.aku.hassannaqvi.covidimmunity.models;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.covidimmunity.BR;
import edu.aku.hassannaqvi.covidimmunity.contracts.TableContracts;
import edu.aku.hassannaqvi.covidimmunity.core.MainApp;

public class FP extends BaseObservable implements Observable {

    private final String TAG = "FP";
    private transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();
    // APP VARIABLES
    private String projectName = MainApp.PROJECT_NAME;
    // APP VARIABLES
    private String id = StringUtils.EMPTY;
    private String uid = StringUtils.EMPTY;
    private String uuid = StringUtils.EMPTY;
    private final String wuid = StringUtils.EMPTY;
    private final String cuid = StringUtils.EMPTY;
    private String userName = StringUtils.EMPTY;
    private String sysDate = StringUtils.EMPTY;
    private String deviceId = StringUtils.EMPTY;
    private String deviceTag = StringUtils.EMPTY;
    private String appver = StringUtils.EMPTY;
    private String endTime = StringUtils.EMPTY;
    private String iStatus = StringUtils.EMPTY;
    private String iStatus96x = StringUtils.EMPTY;
    private String synced = StringUtils.EMPTY;
    private String syncDate = StringUtils.EMPTY;

    // SECTION VARIABLES
    private String sFHA = StringUtils.EMPTY;
    private String sFPA = StringUtils.EMPTY;
    private String sFPC = StringUtils.EMPTY;


    // Field Variables

    private String fha01 = StringUtils.EMPTY;
    private String fha02 = StringUtils.EMPTY;
    private String fha09 = StringUtils.EMPTY;
    private String fha10 = StringUtils.EMPTY;
    private String fha11 = StringUtils.EMPTY;
    private String fha12 = StringUtils.EMPTY;
    private String fha12a = StringUtils.EMPTY;
    private String fha13 = StringUtils.EMPTY;
    private String fpa01a = StringUtils.EMPTY;
    private String fpa01 = StringUtils.EMPTY;
    private String fpa02 = StringUtils.EMPTY;
    private String fpa03y = StringUtils.EMPTY;
    private String fpa03m = StringUtils.EMPTY;
    private String fpa03a = StringUtils.EMPTY;
    private String fpa03c = StringUtils.EMPTY;
    private String fpa04 = StringUtils.EMPTY;
    private String fpc01 = StringUtils.EMPTY;
    private String fpc02 = StringUtils.EMPTY;
    private String fpc03 = StringUtils.EMPTY;
    private String fpc04a = StringUtils.EMPTY;
    private String fpc04b = StringUtils.EMPTY;
    private String fpc04c = StringUtils.EMPTY;
    private String fpc04d = StringUtils.EMPTY;
    private String fpc04e = StringUtils.EMPTY;
    private String fpc04f = StringUtils.EMPTY;
    private String fpc04g = StringUtils.EMPTY;
    private String fpc04h = StringUtils.EMPTY;
    private String fpc04j = StringUtils.EMPTY;
    private String fpc04k = StringUtils.EMPTY;
    private String fpc04m = StringUtils.EMPTY;
    private String fpc04n = StringUtils.EMPTY;
    private String fpc04p = StringUtils.EMPTY;
    private String fpc04q = StringUtils.EMPTY;
    private String fpc0496x = StringUtils.EMPTY;
    private String fpc05 = StringUtils.EMPTY;
    private String fpc06 = StringUtils.EMPTY;
    private String fpc07 = StringUtils.EMPTY;
    private String fpc08 = StringUtils.EMPTY;
    private String fpc0896x = StringUtils.EMPTY;
    private String fpa05 = StringUtils.EMPTY;
    private String fpa0596x = StringUtils.EMPTY;

    public FP() {

        userName = MainApp.user.getUserName();
        sysDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime());
        deviceId = MainApp.deviceid;
        appver = MainApp.versionName + "." + MainApp.versionCode;

    }

    public void populateMeta() {

        setSysDate(MainApp.fp.getSysDate());
        setUserName(MainApp.fp.getUserName());
        setDeviceId(MainApp.deviceid);
        setUuid(MainApp.form.getUid());  // not applicable in Form table
        setAppver(MainApp.appInfo.getAppVersion());

        setProjectName(MainApp.PROJECT_NAME);
        /*setpsuCode(MainApp.selectedPSU);
        setHhid(MainApp.selectedHHID);*/

    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setSysDate(String sysDate) {
        this.sysDate = sysDate;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
    }

    public void setAppver(String appver) {
        this.appver = appver;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setiStatus(String iStatus) {
        this.iStatus = iStatus;
    }

    public void setiStatus96x(String iStatus96x) {
        this.iStatus96x = iStatus96x;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public void setSyncDate(String syncDate) {
        this.syncDate = syncDate;
    }

    public void setsFHA(String sFHA) {
        this.sFHA = sFHA;
    }

    public void setsFPA(String sFPA) {
        this.sFPA = sFPA;
    }

    public void setsFPC(String sFPC) {
        this.sFPC = sFPC;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getId() {
        return id;
    }

    public String getUid() {
        return uid;
    }

    public String getWuid() {
        return wuid;
    }

    public String getCuid() {
        return cuid;
    }

    public String getUserName() {
        return userName;
    }

    public String getSysDate() {
        return sysDate;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceTag() {
        return deviceTag;
    }

    public String getAppver() {
        return appver;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getiStatus() {
        return iStatus;
    }

    public String getiStatus96x() {
        return iStatus96x;
    }

    public String getSynced() {
        return synced;
    }

    public String getSyncDate() {
        return syncDate;
    }

    public String getsFHA() {
        return sFHA;
    }

    public String getsFPA() {
        return sFPA;
    }

    public String getsFPC() {
        return sFPC;
    }


    @Bindable
    public String getFha01() {
        return fha01;
    }

    @Bindable
    public String getFha02() {
        return fha02;
    }

    @Bindable
    public String getFha09() {
        return fha09;
    }

    @Bindable
    public String getFha10() {
        return fha10;
    }

    @Bindable
    public String getFha11() {
        return fha11;
    }

    @Bindable
    public String getFha12() {
        return fha12;
    }

    @Bindable
    public String getFha12a() {
        return fha12a;
    }

    @Bindable
    public String getFha13() {
        return fha13;
    }

    @Bindable
    public String getFpa01a() {
        return fpa01a;
    }

    @Bindable
    public String getFpa01() {
        return fpa01;
    }

    @Bindable
    public String getFpa02() {
        return fpa02;
    }

    @Bindable
    public String getFpa03y() {
        return fpa03y;
    }

    @Bindable
    public String getFpa03m() {
        return fpa03m;
    }

    @Bindable
    public String getFpa03a() {
        return fpa03a;
    }

    @Bindable
    public String getFpa03c() {
        return fpa03c;
    }

    @Bindable
    public String getFpa04() {
        return fpa04;
    }

    @Bindable
    public String getFpc01() {
        return fpc01;
    }

    @Bindable
    public String getFpc02() {
        return fpc02;
    }

    @Bindable
    public String getFpc03() {
        return fpc03;
    }

    @Bindable
    public String getFpc04a() {
        return fpc04a;
    }

    @Bindable
    public String getFpc04b() {
        return fpc04b;
    }

    @Bindable
    public String getFpc04c() {
        return fpc04c;
    }

    @Bindable
    public String getFpc04d() {
        return fpc04d;
    }

    @Bindable
    public String getFpc04e() {
        return fpc04e;
    }

    @Bindable
    public String getFpc04f() {
        return fpc04f;
    }

    @Bindable
    public String getFpc04g() {
        return fpc04g;
    }

    @Bindable
    public String getFpc04h() {
        return fpc04h;
    }

    @Bindable
    public String getFpc04j() {
        return fpc04j;
    }

    @Bindable
    public String getFpc04k() {
        return fpc04k;
    }

    @Bindable
    public String getFpc04m() {
        return fpc04m;
    }

    @Bindable
    public String getFpc04n() {
        return fpc04n;
    }

    @Bindable
    public String getFpc04p() {
        return fpc04p;
    }

    @Bindable
    public String getFpc04q() {
        return fpc04q;
    }

    @Bindable
    public String getFpc0496x() {
        return fpc0496x;
    }

    @Bindable
    public String getFpc05() {
        return fpc05;
    }

    @Bindable
    public String getFpc06() {
        return fpc06;
    }

    @Bindable
    public String getFpc07() {
        return fpc07;
    }

    @Bindable
    public String getFpc08() {
        return fpc08;
    }

    @Bindable
    public String getFpc0896x() {
        return fpc0896x;
    }

    @Bindable
    public String getFpa05() {
        return fpa05;
    }

    @Bindable
    public String getFpa0596x() {
        return fpa0596x;
    }

    public void setFha01(String fha01) {
        this.fha01 = fha01;
        notifyChange(BR.fha01);
    }

    public void setFha02(String fha02) {
        this.fha02 = fha02;
        notifyChange(BR.fha02);
    }

    public void setFha09(String fha09) {
        this.fha09 = fha09;
        notifyChange(BR.fha09);
    }

    public void setFha10(String fha10) {
        this.fha10 = fha10;
        notifyChange(BR.fha10);
    }

    public void setFha11(String fha11) {
        this.fha11 = fha11;
        notifyChange(BR.fha11);
    }

    public void setFha12(String fha12) {
        this.fha12 = fha12;
        notifyChange(BR.fha12);
    }

    public void setFha12a(String fha12a) {
        this.fha12a = fha12a;
        notifyChange(BR.fha12a);
    }

    public void setFha13(String fha13) {
        this.fha13 = fha13;
        notifyChange(BR.fha13);
    }

    public void setFpa01a(String fpa01a) {
        this.fpa01a = fpa01a;
        notifyChange(BR.fpa01a);
    }

    public void setFpa01(String fpa01) {
        this.fpa01 = fpa01;
        notifyChange(BR.fpa01);
    }

    public void setFpa02(String fpa02) {
        this.fpa02 = fpa02;
        notifyChange(BR.fpa02);
    }

    public void setFpa03y(String fpa03y) {
        this.fpa03y = fpa03y;
        notifyChange(BR.fpa03y);
    }

    public void setFpa03m(String fpa03m) {
        this.fpa03m = fpa03m;
        notifyChange(BR.fpa03m);
    }

    public void setFpa03a(String fpa03a) {
        this.fpa03a = fpa03a;
        setFpa03c(fpa03a.equals("1") ? "" : this.fpa03c);
        notifyChange(BR.fpa03a);
    }

    public void setFpa03c(String fpa03c) {
        this.fpa03c = fpa03c;
        notifyChange(BR.fpa03c);
    }

    public void setFpa04(String fpa04) {
        this.fpa04 = fpa04;
        notifyChange(BR.fpa04);
    }

    public void setFpc01(String fpc01) {
        this.fpc01 = fpc01;
        setFpc02(fpc01.equals("1") ? this.fpc02 : "");
        notifyChange(BR.fpc01);
    }

    public void setFpc02(String fpc02) {
        this.fpc02 = fpc02;
        notifyChange(BR.fpc02);
    }

    public void setFpc03(String fpc03) {
        this.fpc03 = fpc03;
        setFpc04a(fpc03.equals("1") ? this.fpc04a : "");
        setFpc04b(fpc03.equals("1") ? this.fpc04b : "");
        setFpc04c(fpc03.equals("1") ? this.fpc04c : "");
        setFpc04d(fpc03.equals("1") ? this.fpc04d : "");
        setFpc04e(fpc03.equals("1") ? this.fpc04e : "");
        setFpc04f(fpc03.equals("1") ? this.fpc04f : "");
        setFpc04g(fpc03.equals("1") ? this.fpc04g : "");
        setFpc04h(fpc03.equals("1") ? this.fpc04h : "");
        setFpc04j(fpc03.equals("1") ? this.fpc04j : "");
        setFpc04k(fpc03.equals("1") ? this.fpc04k : "");
        setFpc04m(fpc03.equals("1") ? this.fpc04m : "");
        setFpc04n(fpc03.equals("1") ? this.fpc04n : "");
        setFpc04p(fpc03.equals("1") ? this.fpc04p : "");
        setFpc04q(fpc03.equals("1") ? this.fpc04q : "");
        setFpc0496x(fpc03.equals("1") ? this.fpc0496x : "");
        notifyChange(BR.fpc03);
    }

    public void setFpc04a(String fpc04a) {
        this.fpc04a = fpc04a;
        notifyChange(BR.fpc04a);
    }

    public void setFpc04b(String fpc04b) {
        this.fpc04b = fpc04b;
        notifyChange(BR.fpc04b);
    }

    public void setFpc04c(String fpc04c) {
        this.fpc04c = fpc04c;
        notifyChange(BR.fpc04c);
    }

    public void setFpc04d(String fpc04d) {
        this.fpc04d = fpc04d;
        notifyChange(BR.fpc04d);
    }

    public void setFpc04e(String fpc04e) {
        this.fpc04e = fpc04e;
        notifyChange(BR.fpc04e);
    }

    public void setFpc04f(String fpc04f) {
        this.fpc04f = fpc04f;
        notifyChange(BR.fpc04f);
    }

    public void setFpc04g(String fpc04g) {
        this.fpc04g = fpc04g;
        notifyChange(BR.fpc04g);
    }

    public void setFpc04h(String fpc04h) {
        this.fpc04h = fpc04h;
        notifyChange(BR.fpc04h);
    }

    public void setFpc04j(String fpc04j) {
        this.fpc04j = fpc04j;
        notifyChange(BR.fpc04j);
    }

    public void setFpc04k(String fpc04k) {
        this.fpc04k = fpc04k;
        notifyChange(BR.fpc04k);
    }

    public void setFpc04m(String fpc04m) {
        this.fpc04m = fpc04m;
        notifyChange(BR.fpc04m);
    }

    public void setFpc04n(String fpc04n) {
        this.fpc04n = fpc04n;
        notifyChange(BR.fpc04n);
    }

    public void setFpc04p(String fpc04p) {
        this.fpc04p = fpc04p;
        notifyChange(BR.fpc04p);
    }

    public void setFpc04q(String fpc04q) {
        this.fpc04q = fpc04q;
        setFpc0496x(fpc04q.equals("96") ? this.fpc0496x : "");
        notifyChange(BR.fpc04q);
    }

    public void setFpc0496x(String fpc0496x) {
        this.fpc0496x = fpc0496x;
        notifyChange(BR.fpc0496x);
    }

    public void setFpc05(String fpc05) {
        this.fpc05 = fpc05;
        setFpc06(fpc05.equals("1") ?  this.fpc06 : "");
        setFpc07(fpc05.equals("1") ?  this.fpc07 : "");
        setFpc08(fpc05.equals("2") ? this.fpc08 : "");
        notifyChange(BR.fpc05);
    }

    public void setFpc06(String fpc06) {
        this.fpc06 = fpc06;
        notifyChange(BR.fpc06);
    }

    public void setFpc07(String fpc07) {
        this.fpc07 = fpc07;
        notifyChange(BR.fpc07);
    }

    public void setFpc08(String fpc08) {
        this.fpc08 = fpc08;
        setFpc0896x(fpc08.equals("96") ? this.fpc0896x : "");
        notifyChange(BR.fpc08);
    }

    public void setFpc0896x(String fpc0896x) {
        this.fpc0896x = fpc0896x;
        notifyChange(BR.fpc0896x);
    }

    public void setFpa05(String fpa05) {
        this.fpa05 = fpa05;
        setFpa0596x(fpa05.equals("96") ? this.fpa0596x : "");
        notifyChange(BR.fpa05);
    }

    public void setFpa0596x(String fpa0596x) {
        this.fpa0596x = fpa0596x;
        notifyChange(BR.fpa0596x);
    }

    @SuppressLint("Range")
    public FP Hydrate(Cursor cursor) throws JSONException {
        this.id = cursor.getString(cursor.getColumnIndex(TableContracts.FollowupTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndex(TableContracts.FollowupTable.COLUMN_UID));
        this.uuid = cursor.getString(cursor.getColumnIndex(TableContracts.FollowupTable.COLUMN_UID));
        this.userName = cursor.getString(cursor.getColumnIndex(TableContracts.FollowupTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndex(TableContracts.FollowupTable.COLUMN_SYSDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndex(TableContracts.FollowupTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndex(TableContracts.FollowupTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndex(TableContracts.FollowupTable.COLUMN_APPVERSION));
        this.iStatus = cursor.getString(cursor.getColumnIndex(TableContracts.FollowupTable.COLUMN_ISTATUS));
        this.synced = cursor.getString(cursor.getColumnIndex(TableContracts.FollowupTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndex(TableContracts.FollowupTable.COLUMN_SYNCED_DATE));

        sFHAHydrate(cursor.getString(cursor.getColumnIndex(TableContracts.FollowupTable.COLUMN_SFHA)));
        sFPAHydrate(cursor.getString(cursor.getColumnIndex(TableContracts.FollowupTable.COLUMN_SFPA)));
        sFPCHydrate(cursor.getString(cursor.getColumnIndex(TableContracts.FollowupTable.COLUMN_SFPC)));

        return this;
    }

    public void sFHAHydrate(String string) throws JSONException {
        Log.d(TAG, "sFHAHydrate: " + string);
        if (string != null) {

            JSONObject json = null;
            json = new JSONObject(string);
            this.fha01 = json.getString("fha01");
            this.fha02 = json.getString("fha02");
            this.fha09 = json.getString("fha09");
            this.fha10 = json.getString("fha10");
            this.fha11 = json.getString("fha11");
            this.fha12 = json.getString("fha12");
            this.fha12a = json.getString("fha12a");
            this.fha13 = json.getString("fha13");


        }
    }

    public void sFPAHydrate(String string) throws JSONException {
        Log.d(TAG, "sFPAHydrate: " + string);
        if (string != null) {

            JSONObject json = null;
            json = new JSONObject(string);
            this.fpa01a = json.getString("fpa01a");
            this.fpa01 = json.getString("fpa01");
            this.fpa02 = json.getString("fpa02");
            this.fpa03y = json.getString("fpa03y");
            this.fpa03m = json.getString("fpa03m");
            this.fpa03a = json.getString("fpa03a");
            this.fpa03c = json.getString("fpa03c");
            this.fpa04 = json.getString("fpa04");

        }
    }

    public void sFPCHydrate(String string) throws JSONException {
        Log.d(TAG, "sPCHydrate: " + string);
        if (string != null) {

            JSONObject json = null;
            json = new JSONObject(string);
            this.fpc01 = json.getString("fpc01");
            this.fpc02 = json.getString("fpc02");
            this.fpc03 = json.getString("fpc03");
            this.fpc04a = json.getString("fpc04a");
            this.fpc04b = json.getString("fpc04b");
            this.fpc04c = json.getString("fpc04c");
            this.fpc04d = json.getString("fpc04d");
            this.fpc04e = json.getString("fpc04e");
            this.fpc04f = json.getString("fpc04f");
            this.fpc04g = json.getString("fpc04g");
            this.fpc04h = json.getString("fpc04h");
            this.fpc04j = json.getString("fpc04j");
            this.fpc04k = json.getString("fpc04k");
            this.fpc04m = json.getString("fpc04m");
            this.fpc04n = json.getString("fpc04n");
            this.fpc04p = json.getString("fpc04p");
            this.fpc04q = json.getString("fpc04q");
            this.fpc0496x = json.getString("fpc0496x");
            this.fpc05 = json.getString("fpc05");
            this.fpc06 = json.getString("fpc06");
            this.fpc07 = json.getString("fpc07");
            this.fpc08 = json.getString("fpc08");
            this.fpc0896x = json.getString("fpc0896x");


        }
    }

    public String sFHAtoString() throws JSONException {
        Log.d(TAG, "sFHAtoString: ");
        JSONObject json = new JSONObject();

        json.put("fha01", fha01)
                .put("fha02", fha02)
                .put("fha09", fha09)
                .put("fha10", fha10)
                .put("fha11", fha11)
                .put("fha12", fha12)
                .put("fha12a", fha12a)
                .put("fha13", fha13);

        return json.toString();
    }


    public String sFPAtoString() throws JSONException {
        Log.d(TAG, "sFPAtoString: ");
        JSONObject json = new JSONObject();

        json.put("fpa01a", fpa01a)
                .put("fpa01", fpa01)
                .put("fpa02", fpa02)
                .put("fpa03y", fpa03y)
                .put("fpa03m", fpa03m)
                .put("fpa03a", fpa03a)
                .put("fpa03c", fpa03c)
                .put("fpa04", fpa04);

        return json.toString();
    }



    public String sFPCtoString() throws JSONException {
        Log.d(TAG, "sFPCtoString: ");
        JSONObject json = new JSONObject();

        json.put("fpc01", fpc01)
                .put("fpc02", fpc02)
                .put("fpc03", fpc03)
                .put("fpc04a", fpc04a)
                .put("fpc04b", fpc04b)
                .put("fpc04c", fpc04c)
                .put("fpc04d", fpc04d)
                .put("fpc04e", fpc04e)
                .put("fpc04f", fpc04f)
                .put("fpc04g", fpc04g)
                .put("fpc04h", fpc04h)
                .put("fpc04j", fpc04j)
                .put("fpc04k", fpc04k)
                .put("fpc04m", fpc04m)
                .put("fpc04n", fpc04n)
                .put("fpc04p", fpc04p)
                .put("fpc04q", fpc04q)
                .put("fpc0496x", fpc0496x)
                .put("fpc05", fpc05)
                .put("fpc06", fpc06)
                .put("fpc07", fpc07)
                .put("fpc08", fpc08)
                .put("fpc0896x", fpc0896x);

        return json.toString();
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();

        json.put(TableContracts.FollowupTable.COLUMN_ID, this.id);
        json.put(TableContracts.FollowupTable.COLUMN_UID, this.uid);
        json.put(TableContracts.FollowupTable.COLUMN_UUID, this.uuid);
        json.put(TableContracts.FollowupTable.COLUMN_USERNAME, this.userName);
        json.put(TableContracts.FollowupTable.COLUMN_SYSDATE, this.sysDate);
        json.put(TableContracts.FollowupTable.COLUMN_DEVICEID, this.deviceId);
        json.put(TableContracts.FollowupTable.COLUMN_DEVICETAGID, this.deviceTag);
        json.put(TableContracts.FollowupTable.COLUMN_ISTATUS, this.iStatus);
        json.put(TableContracts.FollowupTable.COLUMN_SYNCED, this.synced);
        json.put(TableContracts.FollowupTable.COLUMN_SYNCED_DATE, this.syncDate);

        // FP
        json.put(TableContracts.FollowupTable.COLUMN_SFHA, new JSONObject(sFHAtoString()));
        json.put(TableContracts.FollowupTable.COLUMN_SFPA, new JSONObject(sFPAtoString()));
        json.put(TableContracts.FollowupTable.COLUMN_SFPC, new JSONObject(sFPCtoString()));

        return json;
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


