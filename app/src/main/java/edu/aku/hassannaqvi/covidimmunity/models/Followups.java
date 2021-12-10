package edu.aku.hassannaqvi.covidimmunity.models;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.covidimmunity.contracts.TableContracts;

public class Followups {

    String id;
    String form_colid;
    String memberid;
    String  fpcode;
    String fpid;
    String ha01;
    String ha09;
    String ha11;
    String ha12;
    String ha12a;
    String pa01;
    String pa01a;
    String pa01b;
    String fp_date;
    String fp_lock;


    public Followups()
    {
        // Default Constructor
    }

    public String getId() {
        return id;
    }

    public String getForm_colid() {
        return form_colid;
    }

    public String getMemberid() {
        return memberid;
    }

    public String getFpcode() {
        return fpcode;
    }

    public String getFpid() {
        return fpid;
    }

    public String getHa01() {
        return ha01;
    }

    public String getHa09() {
        return ha09;
    }

    public String getHa11() {
        return ha11;
    }

    public String getHa12() {
        return ha12;
    }

    public String getHa12a() {
        return ha12a;
    }

    public String getPa01() {
        return pa01;
    }

    public String getPa01a() {
        return pa01a;
    }

    public String getPa01b() {
        return pa01b;
    }

    public String getFp_date() {
        return fp_date;
    }

    public String getFp_lock() {
        return fp_lock;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setForm_colid(String form_colid) {
        this.form_colid = form_colid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public void setFpcode(String fpcode) {
        this.fpcode = fpcode;
    }

    public void setFpid(String fpid) {
        this.fpid = fpid;
    }

    public void setHa01(String ha01) {
        this.ha01 = ha01;
    }

    public void setHa09(String ha09) {
        this.ha09 = ha09;
    }

    public void setHa11(String ha11) {
        this.ha11 = ha11;
    }

    public void setHa12(String ha12) {
        this.ha12 = ha12;
    }

    public void setHa12a(String ha12a) {
        this.ha12a = ha12a;
    }

    public void setPa01(String pa01) {
        this.pa01 = pa01;
    }

    public void setPa01a(String pa01a) {
        this.pa01a = pa01a;
    }

    public void setPa01b(String pa01b) {
        this.pa01b = pa01b;
    }

    public void setFp_date(String fp_date) {
        this.fp_date = fp_date;
    }

    public void setFp_lock(String fp_lock) {
        this.fp_lock = fp_lock;
    }

    public Followups Hydrate(JSONObject fup) throws JSONException {

        this.id = fup.getString("id");
        this.form_colid = fup.getString("form_colid");
        this.memberid = fup.getString("memberid");
        this.fpcode = fup.getString("fpcode");
        this.fpid = fup.getString("fpid");
        this.ha01 = fup.getString("ha01");
        this.ha09 = fup.getString("ha09");
        this.ha11 = fup.getString("ha11");
        this.ha12 = fup.getString("ha12");
        this.ha12a = fup.getString("ha12a");
        this.pa01 = fup.getString("pa01");
        this.pa01a = fup.getString("pa01a");
        this.pa01b = fup.getString("pa01b");
        this.fp_date = fup.getString("fp_date");
        this.fp_lock = fup.getString("fp_lock");

        return this;
    }

    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();
        try {
            json.put(TableContracts.Followups_sche.ID, this.id == null ? JSONObject.NULL : this.id);
            json.put(TableContracts.Followups_sche.FORM_COLID, this.form_colid == null ? JSONObject.NULL : this.form_colid);
            json.put(TableContracts.Followups_sche.MEMBER_ID, this.memberid == null ? JSONObject.NULL : this.memberid);
            json.put(TableContracts.Followups_sche.FP_CODE, this.fpcode == null ? JSONObject.NULL : this.fpcode);
            json.put(TableContracts.Followups_sche.FP_ID, this.fpid == null ? JSONObject.NULL : this.fpid);
            json.put(TableContracts.Followups_sche.HA01, this.ha01 == null ? JSONObject.NULL : this.ha01);
            json.put(TableContracts.Followups_sche.HA09, this.ha09 == null ? JSONObject.NULL : this.ha09);
            json.put(TableContracts.Followups_sche.HA11, this.ha11 == null ? JSONObject.NULL : this.ha11);
            json.put(TableContracts.Followups_sche.HA12, this.ha12 == null ? JSONObject.NULL : this.ha12);
            json.put(TableContracts.Followups_sche.HA12A, this.ha12a == null ? JSONObject.NULL : this.ha12a);
            json.put(TableContracts.Followups_sche.PA01, this.pa01 == null ? JSONObject.NULL : this.pa01);
            json.put(TableContracts.Followups_sche.PA01A, this.pa01a == null ? JSONObject.NULL : this.pa01a);
            json.put(TableContracts.Followups_sche.PA01B, this.pa01b == null ? JSONObject.NULL : this.pa01b);
            json.put(TableContracts.Followups_sche.FP_DATE, this.fp_date == null ? JSONObject.NULL : this.fp_date);
            json.put(TableContracts.Followups_sche.FP_LOCK, this.fp_lock == null ? JSONObject.NULL : this.fp_lock);

            return json;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Followups Sync(JSONObject jsonObject) throws JSONException {

        this.id = jsonObject.getString(TableContracts.Followups_sche.ID);
        this.form_colid = jsonObject.getString(TableContracts.Followups_sche.FORM_COLID);
        this.memberid = jsonObject.getString(TableContracts.Followups_sche.MEMBER_ID);
        this.fpcode = jsonObject.getString(TableContracts.Followups_sche.FP_CODE);
        this.fpid = jsonObject.getString(TableContracts.Followups_sche.FP_ID);
        this.ha01 = jsonObject.getString(TableContracts.Followups_sche.HA01);
        this.ha09 = jsonObject.getString(TableContracts.Followups_sche.HA09);
        this.ha11 = jsonObject.getString(TableContracts.Followups_sche.HA11);
        this.ha12 = jsonObject.getString(TableContracts.Followups_sche.HA12);
        this.ha12a = jsonObject.getString(TableContracts.Followups_sche.HA12A);
        this.pa01 = jsonObject.getString(TableContracts.Followups_sche.PA01);
        this.pa01a = jsonObject.getString(TableContracts.Followups_sche.PA01A);
        this.pa01b = jsonObject.getString(TableContracts.Followups_sche.PA01B);
        this.fp_date = jsonObject.getString(TableContracts.Followups_sche.FP_DATE);
        this.fp_lock = jsonObject.getString(TableContracts.Followups_sche.FP_LOCK);


        return this;
    }

}
