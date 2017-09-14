package edu.aku.hassannaqvi.dss_census_monitor.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class HouseholdContract {

    private final String projectName = "DSS MONITOR APP";
    //private final String surveyType = "SN";
    private String _ID = "";
    private String _UID = "";
    private String householdID = "";
    private String formDate = ""; // Date
    private String user = ""; // Interviewer

    private String center = "";

    private String gpsLat = "";
    private String gpsLng = "";
    private String gpsTime = "";
    private String gpsAcc = "";
    private String deviceID = "";
    private String synced = "";
    private String synced_date = "";

    public HouseholdContract() {
    }



    public HouseholdContract Sync(JSONObject jsonObject) throws JSONException {
        this._ID= jsonObject.getString(householdForm.COLUMN_ID);
        this._UID= jsonObject.getString(householdForm.COLUMN_UID);
        this.householdID = jsonObject.getString(householdForm.COLUMN_HOUSEHOLDID);
        this.formDate= jsonObject.getString(householdForm.COLUMN_FORMDATE);
        this.user = jsonObject.getString(householdForm.COLUMN_USER);
        this.center = jsonObject.getString(householdForm.COLUMN_CENTER);
        this.gpsLat= jsonObject.getString(householdForm.COLUMN_GPSLAT);
        this.gpsLng= jsonObject.getString(householdForm.COLUMN_GPSLNG);
        this.gpsTime= jsonObject.getString(householdForm.COLUMN_GPSTIME);
        this.gpsAcc= jsonObject.getString(householdForm.COLUMN_GPSACC);
        this.deviceID= jsonObject.getString(householdForm.COLUMN_DEVICEID);
        this.synced= jsonObject.getString(householdForm.COLUMN_SYNCED);
        this.synced_date= jsonObject.getString(householdForm.COLUMN_SYNCED_DATE);

        return this;

    }

    public HouseholdContract Hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(householdForm.COLUMN_ID));
        this._UID = cursor.getString(cursor.getColumnIndex(householdForm.COLUMN_UID));
        this.householdID = cursor.getString(cursor.getColumnIndex(householdForm.COLUMN_HOUSEHOLDID));
        this.formDate = cursor.getString(cursor.getColumnIndex(householdForm.COLUMN_FORMDATE));
        this.user = cursor.getString(cursor.getColumnIndex(householdForm.COLUMN_USER));
        this.center = cursor.getString(cursor.getColumnIndex(householdForm.COLUMN_CENTER));
        this.gpsLat = cursor.getString(cursor.getColumnIndex(householdForm.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndex(householdForm.COLUMN_GPSLNG));
        this.gpsTime = cursor.getString(cursor.getColumnIndex(householdForm.COLUMN_GPSTIME));
        this.gpsAcc = cursor.getString(cursor.getColumnIndex(householdForm.COLUMN_GPSACC));
        this.deviceID = cursor.getString(cursor.getColumnIndex(householdForm.COLUMN_DEVICEID));
        this.synced = cursor.getString(cursor.getColumnIndex(householdForm.COLUMN_SYNCED));
        this.synced_date = cursor.getString(cursor.getColumnIndex(householdForm.COLUMN_SYNCED_DATE));

        // TODO:

        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(householdForm.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(householdForm.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(householdForm.COLUMN_HOUSEHOLDID, this.householdID == null ? JSONObject.NULL : this.householdID);
        json.put(householdForm.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(householdForm.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);
        json.put(householdForm.COLUMN_CENTER, this.center == null ? JSONObject.NULL : this.center);
        json.put(householdForm.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
        json.put(householdForm.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
        json.put(householdForm.COLUMN_GPSTIME, this.gpsTime == null ? JSONObject.NULL : this.gpsTime);
        json.put(householdForm.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
        json.put(householdForm.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(householdForm.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
        json.put(householdForm.COLUMN_SYNCED_DATE, this.synced_date == null ? JSONObject.NULL : this.synced_date);


        return json;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getUID() {
        return _UID;
    }

    public void setUID(String _UID) {
        this._UID = _UID;
    }

    public String getHouseholdID() {
        return householdID;
    }

    public void setHouseholdID(String householdID) {
        this.householdID = householdID;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    public String getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
    }

    public String getGpsTime() {
        return gpsTime;
    }

    public void setGpsTime(String gpsTime) {
        this.gpsTime = gpsTime;
    }

    public String getGpsAcc() {
        return gpsAcc;
    }

    public void setGpsAcc(String gpsAcc) {
        this.gpsAcc = gpsAcc;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;
    }

    public static abstract class householdForm implements BaseColumns {

        public static final String TABLE_NAME = "household";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "DSS Census";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_HOUSEHOLDID = "dssid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_CENTER = "center";
        public static final String COLUMN_GPSLAT = "gpslat";
        public static final String COLUMN_GPSLNG = "gpslng";
        public static final String COLUMN_GPSTIME = "gpstime";
        public static final String COLUMN_GPSACC = "gpsacc";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
    }
}
