package edu.aku.hassannaqvi.dss_census_monitor.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class CensusContract {

    private final String projectName = "DSS MONITOR APP";
    private String _ID = "";
    private String REF_ID = "";
    private String _UID = "";
    private String _UUID = "";
    private String _DATE = "";
    private String formDate = "";
    private String deviceId = "";
    private String user = "";
    private String dss_id_hh = "";
    private String dss_id_f = "";
    private String dss_id_m = "";
    private String dss_id_h = "";
    private String dss_id_member = "";
    private String prevs_dss_id_member = "";
    private String site_code = "";
    private String name = "";
    private String dob = "";
    private String ageY = "";
    private String ageM = "";
    private String ageD = "";
    private String gender = "";
    private String is_head = "";
    private String relation_hh = "";
    private String current_status = "";
    private String current_statusX = "";
    private String current_date = "";
    private String dod = "";
    private String m_status = "";
    private String education = "";
    private String educationX = "";
    private String occupation = "";
    private String occupationX = "";
    private String member_type = "";
    private String rsvp = "";
    private String update_flag = "";
    private String update_dt = "";
    private String synced = "";
    private String syncedDate = "";
    private String remarks = "";
    private String istatus = "";
    private String serialNo = "";

    private String devicetagID = "";


    public CensusContract() {
    }

    public CensusContract(CensusContract cc){
        this.dss_id_hh = cc.dss_id_hh;
        this.dss_id_m = cc.dss_id_m;
        this.dss_id_member = cc.dss_id_member;
        this.name = cc.name;
        this.dob = cc.dob;
        this.ageY = cc.ageY;
        this.ageM = cc.ageM;
        this.ageD = cc.ageD;
        this.gender = cc.gender;
        this.member_type = cc.member_type;
        this.serialNo = cc.serialNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public String getREF_ID() {
        return REF_ID;
    }

    public void setREF_ID(String REF_ID) {
        this.REF_ID = REF_ID;
    }

    public String get_UID() {
        return _UID;
    }

    public void set_UID(String _UID) {
        this._UID = _UID;
    }

    public String get_UUID() {
        return _UUID;
    }

    public void set_UUID(String _UUID) {
        this._UUID = _UUID;
    }

    public String get_DATE() {
        return _DATE;
    }

    public void set_DATE(String _DATE) {
        this._DATE = _DATE;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    public String getAgeY() {
        return ageY;
    }

    public void setAgeY(String ageY) {
        this.ageY = ageY;
    }

    public String getAgeM() {
        return ageM;
    }

    public void setAgeM(String ageM) {
        this.ageM = ageM;
    }

    public String getAgeD() {
        return ageD;
    }

    public void setAgeD(String ageD) {
        this.ageD = ageD;
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

    public String getUpdate_flag() {
        return update_flag;
    }

    public void setUpdate_flag(String update_flag) {
        this.update_flag = update_flag;
    }

    public String getUpdate_dt() {
        return update_dt;
    }

    public void setUpdate_dt(String update_dt) {
        this.update_dt = update_dt;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSyncedDate() {
        return syncedDate;
    }

    public void setSyncedDate(String syncedDate) {
        this.syncedDate = syncedDate;
    }

    public String getCurrent_statusX() {
        return current_statusX;
    }

    public void setCurrent_statusX(String current_statusX) {
        this.current_statusX = current_statusX;
    }

    public String getEducationX() {
        return educationX;
    }

    public void setEducationX(String educationX) {
        this.educationX = educationX;
    }

    public String getOccupationX() {
        return occupationX;
    }

    public void setOccupationX(String occupationX) {
        this.occupationX = occupationX;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }

    public String getRsvp() {
        return rsvp;
    }

    public void setRsvp(String rsvp) {
        this.rsvp = rsvp;
    }

    public String getDevicetagID() {
        return devicetagID;
    }

    public void setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
    }

    public CensusContract Sync(JSONObject jsonObject) throws JSONException {

        this._ID= jsonObject.getString(censusMember.COLUMN_ID);
        this.REF_ID= jsonObject.getString(censusMember.COLUMN_REF_ID);
        this._UID= jsonObject.getString(censusMember.COLUMN_UID);
        this._UUID= jsonObject.getString(censusMember.COLUMN_UUID);
        this._DATE= jsonObject.getString(censusMember.COLUMN_DATE);
        this.formDate= jsonObject.getString(censusMember.COLUMN_FORMDATE);
        this.deviceId= jsonObject.getString(censusMember.COLUMN_DEVICEID);
        this.user= jsonObject.getString(censusMember.COLUMN_USER);
        this.dss_id_hh= jsonObject.getString(censusMember.COLUMN_DSS_ID_HH);
        this.dss_id_f= jsonObject.getString(censusMember.COLUMN_DSS_ID_F);
        this.dss_id_m= jsonObject.getString(censusMember.COLUMN_DSS_ID_M);
        this.dss_id_h= jsonObject.getString(censusMember.COLUMN_DSS_ID_H);
        this.dss_id_member= jsonObject.getString(censusMember.COLUMN_DSS_ID_MEMBER);
        this.prevs_dss_id_member= jsonObject.getString(censusMember.COLUMN_PREVS_DSS_ID_MEMBER);
        this.site_code= jsonObject.getString(censusMember.COLUMN_SITE_CODE);
        this.name= jsonObject.getString(censusMember.COLUMN_NAME);
        this.dob= jsonObject.getString(censusMember.COLUMN_DOB);
        this.ageY = jsonObject.getString(censusMember.COLUMN_AGEY);
        this.ageM = jsonObject.getString(censusMember.COLUMN_AGEM);
        this.ageD = jsonObject.getString(censusMember.COLUMN_AGED);
        this.gender= jsonObject.getString(censusMember.COLUMN_GENDER);
        this.is_head= jsonObject.getString(censusMember.COLUMN_IS_HEAD);
        this.relation_hh= jsonObject.getString(censusMember.COLUMN_RELATION_HH);
        this.current_status= jsonObject.getString(censusMember.COLUMN_CURRENT_STATUS);
        this.current_statusX= jsonObject.getString(censusMember.COLUMN_CURRENT_STATUSX);
        this.current_date= jsonObject.getString(censusMember.COLUMN_CURRENT_DATE);
        this.dod= jsonObject.getString(censusMember.COLUMN_DOD);
        this.m_status= jsonObject.getString(censusMember.COLUMN_M_STATUS);
        this.education= jsonObject.getString(censusMember.COLUMN_EDUCATION);
        this.educationX= jsonObject.getString(censusMember.COLUMN_EDUCATIONX);
        this.occupation= jsonObject.getString(censusMember.COLUMN_OCCUPATION);
        this.occupationX= jsonObject.getString(censusMember.COLUMN_OCCUPATIONX);
        this.member_type= jsonObject.getString(censusMember.COLUMN_MEMBER_TYPE);
        this.rsvp= jsonObject.getString(censusMember.COLUMN_RSVP);
        this.update_flag= jsonObject.getString(censusMember.COLUMN_UPDATE_FLAG);
        this.update_dt= jsonObject.getString(censusMember.COLUMN_UPDATE_DT);
        this.serialNo= jsonObject.getString(censusMember.COLUMN_SERIAL_NO);
        this.synced= jsonObject.getString(censusMember.COLUMN_SYNCED);
        this.syncedDate= jsonObject.getString(censusMember.COLUMN_SYNCED_DATE);
        this.remarks= jsonObject.getString(censusMember.COLUMN_REMARKS);
        this.istatus= jsonObject.getString(censusMember.COLUMN_ISTATUS);
        this.devicetagID= jsonObject.getString(censusMember.COLUMN_DEVICETAGID);

        return this;

    }

    public CensusContract Hydrate(Cursor cursor) {

        this._ID = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_ID));
        this.REF_ID = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_REF_ID));
        this._UID = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_UID));
        this._UUID = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_UUID));
        this._DATE = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_DATE));
        this.formDate = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_FORMDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_DEVICEID));
        this.user = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_USER));
        this.dss_id_hh = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_DSS_ID_HH));
        this.dss_id_f = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_DSS_ID_F));
        this.dss_id_m = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_DSS_ID_M));
        this.dss_id_h = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_DSS_ID_H));
        this.dss_id_member = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_DSS_ID_MEMBER));
        this.prevs_dss_id_member = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_PREVS_DSS_ID_MEMBER));
        this.site_code = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_SITE_CODE));
        this.name = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_NAME));
        this.dob = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_DOB));
        this.ageY = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_AGEY));
        this.ageM = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_AGEM));
        this.ageD = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_AGED));
        this.gender = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_GENDER));
        this.is_head = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_IS_HEAD));
        this.relation_hh = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_RELATION_HH));
        this.current_status = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_CURRENT_STATUS));
        this.current_statusX = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_CURRENT_STATUSX));
        this.current_date = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_CURRENT_DATE));
        this.dod = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_DOD));
        this.m_status = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_M_STATUS));
        this.education = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_EDUCATION));
        this.educationX = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_EDUCATIONX));
        this.occupation = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_OCCUPATION));
        this.occupationX = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_OCCUPATIONX));
        this.member_type = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_MEMBER_TYPE));
        this.rsvp = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_RSVP));
        this.update_flag = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_UPDATE_FLAG));
        this.update_dt = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_UPDATE_DT));
        this.serialNo = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_SERIAL_NO));
        this.remarks = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_REMARKS));
        this.istatus = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_ISTATUS));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(censusMember.COLUMN_DEVICETAGID));

        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(censusMember.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(censusMember.COLUMN_REF_ID, this.REF_ID == null ? JSONObject.NULL : this.REF_ID);
        json.put(censusMember.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(censusMember.COLUMN_UUID, this._UUID == null ? JSONObject.NULL : this._UUID);
        json.put(censusMember.COLUMN_DATE, this._DATE == null ? JSONObject.NULL : this._DATE);
        json.put(censusMember.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(censusMember.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
        json.put(censusMember.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);
        json.put(censusMember.COLUMN_DSS_ID_HH, this.dss_id_hh == null ? JSONObject.NULL : this.dss_id_hh);
        json.put(censusMember.COLUMN_DSS_ID_F, this.dss_id_f == null ? JSONObject.NULL : this.dss_id_f);
        json.put(censusMember.COLUMN_DSS_ID_M, this.dss_id_m == null ? JSONObject.NULL : this.dss_id_m);
        json.put(censusMember.COLUMN_DSS_ID_H, this.dss_id_h == null ? JSONObject.NULL : this.dss_id_h);
        json.put(censusMember.COLUMN_DSS_ID_MEMBER, this.dss_id_member == null ? JSONObject.NULL : this.dss_id_member);
        json.put(censusMember.COLUMN_PREVS_DSS_ID_MEMBER, this.prevs_dss_id_member == null ? JSONObject.NULL : this.prevs_dss_id_member);
        json.put(censusMember.COLUMN_SITE_CODE, this.site_code == null ? JSONObject.NULL : this.site_code);
        json.put(censusMember.COLUMN_NAME, this.name == null ? JSONObject.NULL : this.name);
        json.put(censusMember.COLUMN_DOB, this.dob == null ? JSONObject.NULL : this.dob);
        json.put(censusMember.COLUMN_AGEY, this.ageY == null ? JSONObject.NULL : this.ageY);
        json.put(censusMember.COLUMN_AGEM, this.ageM == null ? JSONObject.NULL : this.ageM);
        json.put(censusMember.COLUMN_AGED, this.ageD == null ? JSONObject.NULL : this.ageD);
        json.put(censusMember.COLUMN_GENDER, this.gender == null ? JSONObject.NULL : this.gender);
        json.put(censusMember.COLUMN_IS_HEAD, this.is_head == null ? JSONObject.NULL : this.is_head);
        json.put(censusMember.COLUMN_RELATION_HH, this.relation_hh == null ? JSONObject.NULL : this.relation_hh);
        json.put(censusMember.COLUMN_CURRENT_STATUS, this.current_status == null ? JSONObject.NULL : this.current_status);
        json.put(censusMember.COLUMN_CURRENT_STATUSX, this.current_statusX == null ? JSONObject.NULL : this.current_statusX);
        json.put(censusMember.COLUMN_CURRENT_DATE, this.current_date == null ? JSONObject.NULL : this.current_date);
        json.put(censusMember.COLUMN_DOD, this.dod == null ? JSONObject.NULL : this.dod);
        json.put(censusMember.COLUMN_M_STATUS, this.m_status == null ? JSONObject.NULL : this.m_status);
        json.put(censusMember.COLUMN_EDUCATION, this.education == null ? JSONObject.NULL : this.education);
        json.put(censusMember.COLUMN_EDUCATIONX, this.educationX == null ? JSONObject.NULL : this.educationX);
        json.put(censusMember.COLUMN_OCCUPATION, this.occupation == null ? JSONObject.NULL : this.occupation);
        json.put(censusMember.COLUMN_OCCUPATIONX, this.occupationX == null ? JSONObject.NULL : this.occupationX);
        json.put(censusMember.COLUMN_MEMBER_TYPE, this.member_type == null ? JSONObject.NULL : this.member_type);
        json.put(censusMember.COLUMN_RSVP, this.rsvp == null ? JSONObject.NULL : this.rsvp);
        json.put(censusMember.COLUMN_UPDATE_FLAG, this.update_flag == null ? JSONObject.NULL : this.update_flag);
        json.put(censusMember.COLUMN_UPDATE_DT, this.update_dt == null ? JSONObject.NULL : this.update_dt);
        json.put(censusMember.COLUMN_SERIAL_NO, this.serialNo == null ? JSONObject.NULL : this.serialNo);
        json.put(censusMember.COLUMN_REMARKS, this.remarks == null ? JSONObject.NULL : this.remarks);
        json.put(censusMember.COLUMN_PROJECT_NAME, this.projectName == null ? JSONObject.NULL : this.projectName);
        json.put(censusMember.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
        json.put(censusMember.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);


        return json;
    }

    public static abstract class censusMember implements BaseColumns {

        public static final String TABLE_NAME = "census";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";

        public static final String COLUMN_PROJECT_NAME = "project_name";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN_UUID = "uuid";
        public static final String COLUMN_DATE = "_date";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_DSS_ID_HH = "dss_id_hh";
        public static final String COLUMN_DSS_ID_F = "dss_id_f";
        public static final String COLUMN_DSS_ID_M = "dss_id_m";
        public static final String COLUMN_DSS_ID_H = "dss_id_h";
        public static final String COLUMN_DSS_ID_MEMBER = "dss_id_member";
        public static final String COLUMN_PREVS_DSS_ID_MEMBER = "prevs_dss_id_member";
        public static final String COLUMN_SITE_CODE = "site_code";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DOB = "dob";
        public static final String COLUMN_AGEY = "agey";
        public static final String COLUMN_AGEM = "agem";
        public static final String COLUMN_AGED = "aged";
        public static final String COLUMN_GENDER = "gender";
        public static final String COLUMN_IS_HEAD = "is_head";
        public static final String COLUMN_RELATION_HH = "relation_hh";
        public static final String COLUMN_CURRENT_STATUS = "current_status";
        public static final String COLUMN_CURRENT_STATUSX = "current_statusx";
        public static final String COLUMN_CURRENT_DATE = "status_date";
        public static final String COLUMN_DOD = "dod";
        public static final String COLUMN_M_STATUS = "m_status";
        public static final String COLUMN_EDUCATION = "education";
        public static final String COLUMN_EDUCATIONX = "educationx";
        public static final String COLUMN_OCCUPATION = "occupation";
        public static final String COLUMN_OCCUPATIONX = "occupationx";
        public static final String COLUMN_REMARKS = "remarks";
        public static final String COLUMN_MEMBER_TYPE = "member_type";
        public static final String COLUMN_UPDATE_FLAG = "updated_flag";
        public static final String COLUMN_UPDATE_DT = "update_date";
        public static final String COLUMN_RSVP = "isresp";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "sync_date";
        public static final String COLUMN_REF_ID = "refid";
        public static final String COLUMN_ISTATUS = "istatus";

        public static final String COLUMN_DEVICETAGID = "tagid";
        public static final String COLUMN_SERIAL_NO = "serial";

        public static String _URL = "census.php";
    }
}
