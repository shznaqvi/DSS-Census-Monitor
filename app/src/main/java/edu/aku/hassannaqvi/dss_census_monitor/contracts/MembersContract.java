package edu.aku.hassannaqvi.dss_census_monitor.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class MembersContract {

    private final String projectName = "DSS Census";
    private String _ID = "";
    private String _DATE = "";
    private String dss_id_hh = "";
    private String dss_id_f = "";
    private String dss_id_m = "";
    private String dss_id_h = "";
    private String dss_id_member = "";
    private String prevs_dss_id_member = "";
    private String site_code = "";
    private String name = "";
    private String dob = "";
    private String age = "";
    private String gender = "";
    private String is_head = "";
    private String relation_hh = "";
    private String current_status = "";
    private String current_date = "";
    private String dod = "";
    private String m_status = "";
    private String education = "";
    private String occupation = "";
    private String member_type = "";


    public MembersContract() {
    }

    public MembersContract(MembersContract mc) {
        this._ID =  mc.get_ID();
        this._DATE =  mc.get_DATE();
        this.dss_id_hh =  mc.getDss_id_hh();
        this.dss_id_f =  mc.getDss_id_f();
        this.dss_id_m =  mc.getDss_id_m();
        this.dss_id_h =  mc.getDss_id_h();
        this.dss_id_member =  mc.getDss_id_member();
        this.prevs_dss_id_member =  mc.getPrevs_dss_id_member();
        this.site_code =  mc.getSite_code();
        this.name =  mc.getName();
        this.dob =  mc.getDob();
        this.age =  mc.getAge();
        this.gender =  mc.getGender();
        this.is_head =  mc.getIs_head();
        this.relation_hh =  mc.getRelation_hh();
        this.current_status =  mc.getCurrent_status();
        this.current_date =  mc.getCurrent_date();
        this.dod =  mc.getDod();
        this.m_status =  mc.getM_status();
        this.education =  mc.getEducation();
        this.occupation =  mc.getOccupation();
        this.member_type =  mc.getMember_type();
    }

    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public String getProjectName() {
        return projectName;
    }

    public String get_DATE() {
        return _DATE;
    }

    public void set_DATE(String _DATE) {
        this._DATE = _DATE;
    }

    public String getDss_id_hh() {
        return dss_id_hh;
    }

    public void setDss_id_hh(String dss_id_hh) {
        this.dss_id_hh = dss_id_hh;
    }

    public String getDss_id_f() {
        return dss_id_f;
    }

    public void setDss_id_f(String dss_id_f) {
        this.dss_id_f = dss_id_f;
    }

    public String getDss_id_m() {
        return dss_id_m;
    }

    public void setDss_id_m(String dss_id_m) {
        this.dss_id_m = dss_id_m;
    }

    public String getDss_id_h() {
        return dss_id_h;
    }

    public void setDss_id_h(String dss_id_h) {
        this.dss_id_h = dss_id_h;
    }

    public String getDss_id_member() {
        return dss_id_member;
    }

    public void setDss_id_member(String dss_id_member) {
        this.dss_id_member = dss_id_member;
    }

    public String getPrevs_dss_id_member() {
        return prevs_dss_id_member;
    }

    public void setPrevs_dss_id_member(String prevs_dss_id_member) {
        this.prevs_dss_id_member = prevs_dss_id_member;
    }

    public String getSite_code() {
        return site_code;
    }

    public void setSite_code(String site_code) {
        this.site_code = site_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIs_head() {
        return is_head;
    }

    public void setIs_head(String is_head) {
        this.is_head = is_head;
    }

    public String getRelation_hh() {
        return relation_hh;
    }

    public void setRelation_hh(String relation_hh) {
        this.relation_hh = relation_hh;
    }

    public String getCurrent_status() {

        return current_status;
    }

    public void setCurrent_status(String current_status) {

        this.current_status = current_status;
    }

    public String getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(String current_date) {
        this.current_date = current_date;
    }

    public String getDod() {
        return dod;
    }

    public void setDod(String dod) {
        this.dod = dod;
    }

    public String getM_status() {
        return m_status;
    }

    public void setM_status(String m_status) {
        this.m_status = m_status;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getMember_type() {
        return member_type;
    }

    public void setMember_type(String member_type) {
        this.member_type = member_type;
    }

    public MembersContract Sync(JSONObject jsonObject) throws JSONException {

/*        this._ID= jsonObject.getString(singleMember.COLUMN_ID);
        this._DATE = jsonObject.getString(singleMember.COLUMN_DATE);*/
        this.dss_id_hh= jsonObject.getString(singleMember.COLUMN_DSS_ID_HH);
/*        this.dss_id_f= jsonObject.getString(singleMember.COLUMN_DSS_ID_F);
        this.dss_id_m= jsonObject.getString(singleMember.COLUMN_DSS_ID_M);
        this.dss_id_h= jsonObject.getString(singleMember.COLUMN_DSS_ID_H);
        this.dss_id_member= jsonObject.getString(singleMember.COLUMN_DSS_ID_MEMBER);
        this.prevs_dss_id_member= jsonObject.getString(singleMember.COLUMN_PREVS_DSS_ID_MEMBER);
        this.site_code= jsonObject.getString(singleMember.COLUMN_SITE_CODE);
        this.name= jsonObject.getString(singleMember.COLUMN_NAME);
        this.dob= jsonObject.getString(singleMember.COLUMN_DOB);
        this.age= jsonObject.getString(singleMember.COLUMN_AGE);
        this.gender= jsonObject.getString(singleMember.COLUMN_GENDER);
        this.is_head= jsonObject.getString(singleMember.COLUMN_IS_HEAD);
        this.relation_hh= jsonObject.getString(singleMember.COLUMN_RELATION_HH);
        this.current_status= jsonObject.getString(singleMember.COLUMN_CURRENT_STATUS);
        this.current_date= jsonObject.getString(singleMember.COLUMN_CURRENT_DATE);
        this.dod= jsonObject.getString(singleMember.COLUMN_DOD);
        this.m_status= jsonObject.getString(singleMember.COLUMN_M_STATUS);
        this.education= jsonObject.getString(singleMember.COLUMN_EDUCATION);
        this.occupation= jsonObject.getString(singleMember.COLUMN_OCCUPATION);
        this.member_type= jsonObject.getString(singleMember.COLUMN_MEMBER_TYPE);*/

        return this;

    }

    public MembersContract Hydrate(Cursor cursor) {

        /*this._ID = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_ID));
        this._DATE = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_DATE));*/
        this.dss_id_hh = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_DSS_ID_HH));
/*        this.dss_id_f = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_DSS_ID_F));
        this.dss_id_m = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_DSS_ID_M));
        this.dss_id_h = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_DSS_ID_H));
        this.dss_id_member = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_DSS_ID_MEMBER));
        this.prevs_dss_id_member = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_PREVS_DSS_ID_MEMBER));
        this.site_code = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_SITE_CODE));
        this.name = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_NAME));
        this.dob = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_DOB));
        this.age = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_AGE));
        this.gender = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_GENDER));
        this.is_head = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_IS_HEAD));
        this.relation_hh = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_RELATION_HH));
        this.current_status = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_CURRENT_STATUS));
        this.current_date = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_CURRENT_DATE));
        this.dod = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_DOD));
        this.m_status = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_M_STATUS));
        this.education = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_EDUCATION));
        this.occupation = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_OCCUPATION));
        this.member_type = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_MEMBER_TYPE));*/

        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(singleMember.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(singleMember.COLUMN_DATE, this._DATE == null ? JSONObject.NULL : this._DATE);
        json.put(singleMember.COLUMN_DSS_ID_HH, this.dss_id_hh == null ? JSONObject.NULL : this.dss_id_hh);
        json.put(singleMember.COLUMN_DSS_ID_F, this.dss_id_f == null ? JSONObject.NULL : this.dss_id_f);
        json.put(singleMember.COLUMN_DSS_ID_M, this.dss_id_m == null ? JSONObject.NULL : this.dss_id_m);
        json.put(singleMember.COLUMN_DSS_ID_H, this.dss_id_h == null ? JSONObject.NULL : this.dss_id_h);
        json.put(singleMember.COLUMN_DSS_ID_MEMBER, this.dss_id_member == null ? JSONObject.NULL : this.dss_id_member);
        json.put(singleMember.COLUMN_PREVS_DSS_ID_MEMBER, this.prevs_dss_id_member == null ? JSONObject.NULL : this.prevs_dss_id_member);
        json.put(singleMember.COLUMN_SITE_CODE, this.site_code == null ? JSONObject.NULL : this.site_code);
        json.put(singleMember.COLUMN_NAME, this.name == null ? JSONObject.NULL : this.name);
        json.put(singleMember.COLUMN_DOB, this.dob == null ? JSONObject.NULL : this.dob);
        json.put(singleMember.COLUMN_AGE, this.age == null ? JSONObject.NULL : this.age);
        json.put(singleMember.COLUMN_GENDER, this.gender == null ? JSONObject.NULL : this.gender);
        json.put(singleMember.COLUMN_IS_HEAD, this.is_head == null ? JSONObject.NULL : this.is_head);
        json.put(singleMember.COLUMN_RELATION_HH, this.relation_hh == null ? JSONObject.NULL : this.relation_hh);
        json.put(singleMember.COLUMN_CURRENT_STATUS, this.current_status == null ? JSONObject.NULL : this.current_status);
        json.put(singleMember.COLUMN_CURRENT_DATE, this.current_date == null ? JSONObject.NULL : this.current_date);
        json.put(singleMember.COLUMN_DOD, this.dod == null ? JSONObject.NULL : this.dod);
        json.put(singleMember.COLUMN_M_STATUS, this.m_status == null ? JSONObject.NULL : this.m_status);
        json.put(singleMember.COLUMN_EDUCATION, this.education == null ? JSONObject.NULL : this.education);
        json.put(singleMember.COLUMN_OCCUPATION, this.occupation == null ? JSONObject.NULL : this.occupation);
        json.put(singleMember.COLUMN_MEMBER_TYPE, this.member_type == null ? JSONObject.NULL : this.member_type);


        return json;
    }

    public static abstract class singleMember implements BaseColumns {

        public static final String TABLE_NAME = "members";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";

        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_DATE = "_date";
        public static final String COLUMN_DSS_ID_HH = "dss_id_hh";
        public static final String COLUMN_DSS_ID_F = "dss_id_f";
        public static final String COLUMN_DSS_ID_M = "dss_id_m";
        public static final String COLUMN_DSS_ID_H = "dss_id_h";
        public static final String COLUMN_DSS_ID_MEMBER = "dss_id_member";
        public static final String COLUMN_PREVS_DSS_ID_MEMBER = "prevs_dss_id_member";
        public static final String COLUMN_SITE_CODE = "site_code";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DOB = "dob";
        public static final String COLUMN_AGE = "age";
        public static final String COLUMN_GENDER = "gender";
        public static final String COLUMN_IS_HEAD = "is_head";
        public static final String COLUMN_RELATION_HH = "relation_hh";
        public static final String COLUMN_CURRENT_STATUS = "current_status";
        public static final String COLUMN_CURRENT_DATE = "current_date";
        public static final String COLUMN_DOD = "dod";
        public static final String COLUMN_M_STATUS = "m_status";
        public static final String COLUMN_EDUCATION = "education";
        public static final String COLUMN_OCCUPATION = "occupation";
        public static final String COLUMN_MEMBER_TYPE = "member_type";

        public static final String _URI = "gethouseholds.php";

    }
}
