package edu.aku.hassannaqvi.dss_census_monitor.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FormsContract {

    private final String projectName = "DSS Census";
    //private final String surveyType = "SN";
    private String _ID = "";
    private String _UID = "";
    private String ISNEW = "";
    private String DSSID = "";
    private String formDate = ""; // Date
    private String user = ""; // Interviewer


    private String istatus = ""; // Interview Status
    private String sA = "";
    //private String sB = ""; // commented out for Members
    //private String sC = ""; // Commented out for Deceased
    private String sD = "";
    private String sE = "";
    private String sF = "";
    private String sG = "";
    private String sH = "";
    private String sI = "";
    private String sJ = "";
    private String sK = "";
    private String sL = "";
    private String sM = "";


    private String gpsLat = "";
    private String gpsLng = "";
    private String gpsDT = "";
    private String gpsAcc = "";
    private String deviceID = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";

    public FormsContract() {
    }



    public FormsContract Sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getString(FormsTable.COLUMN_ID);
        this._UID = jsonObject.getString(FormsTable.COLUMN_UID);
        this.ISNEW = jsonObject.getString(FormsTable.COLUMN_IS_NEW);
        this.DSSID = jsonObject.getString(FormsTable.COLUMN_DSSID);
        this.formDate = jsonObject.getString(FormsTable.COLUMN_FORMDATE);
        this.user = jsonObject.getString(FormsTable.COLUMN_USER);
        this.istatus = jsonObject.getString(FormsTable.COLUMN_ISTATUS);
        this.sA = jsonObject.getString(FormsTable.COLUMN_SA);
        this.sD = jsonObject.getString(FormsTable.COLUMN_SD);
        this.sE = jsonObject.getString(FormsTable.COLUMN_SE);
        this.sF = jsonObject.getString(FormsTable.COLUMN_SF);
        this.sG = jsonObject.getString(FormsTable.COLUMN_SG);
        this.sH = jsonObject.getString(FormsTable.COLUMN_SH);
        this.sI = jsonObject.getString(FormsTable.COLUMN_SI);
        this.sJ = jsonObject.getString(FormsTable.COLUMN_SJ);
        this.sK = jsonObject.getString(FormsTable.COLUMN_SK);
        this.sL = jsonObject.getString(FormsTable.COLUMN_SL);
        this.sM = jsonObject.getString(FormsTable.COLUMN_SM);
        this.gpsLat = jsonObject.getString(FormsTable.COLUMN_GPSLAT);
        this.gpsLng = jsonObject.getString(FormsTable.COLUMN_GPSLNG);
        this.gpsDT = jsonObject.getString(FormsTable.COLUMN_GPSDATE);
        this.gpsAcc = jsonObject.getString(FormsTable.COLUMN_GPSACC);
        this.deviceID = jsonObject.getString(FormsTable.COLUMN_DEVICEID);
        this.devicetagID = jsonObject.getString(FormsTable.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(FormsTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(FormsTable.COLUMN_SYNCED_DATE);

        return this;

    }

    public FormsContract Hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ID));
        this._UID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_UID));
        this.ISNEW = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_IS_NEW));
        this.DSSID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DSSID));
        this.formDate = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_FORMDATE));
        this.user = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_USER));
        this.istatus = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS));
        this.sA = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SA));
        this.sD = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SD));
        this.sE = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SE));
        this.sF = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SF));
        this.sG = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SG));
        this.sH = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SH));
        this.sI = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SI));
        this.sJ = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SJ));
        this.sK = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SK));
        this.sL = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SL));
        this.sM = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SM));
        this.gpsLat = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLNG));
        this.gpsDT = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSDATE));
        this.gpsAcc = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSACC));
        this.deviceID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICEID));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICETAGID));

        // TODO:

        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(FormsTable.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(FormsTable.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(FormsTable.COLUMN_IS_NEW, this.ISNEW == null ? JSONObject.NULL : this.ISNEW);
        json.put(FormsTable.COLUMN_DSSID, this.DSSID == null ? JSONObject.NULL : this.DSSID);
        json.put(FormsTable.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(FormsTable.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);
        json.put(FormsTable.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
        json.put(FormsTable.COLUMN_SA, this.sA.equals("") ? JSONObject.NULL : new JSONObject(this.sA));
        json.put(FormsTable.COLUMN_SD, this.sD.equals("") ? JSONObject.NULL : new JSONObject(this.sD));
        json.put(FormsTable.COLUMN_SE, this.sE.equals("") ? JSONObject.NULL : new JSONObject(this.sE));
//        json.put(FormsTable.COLUMN_SF, this.sF.equals("") ? JSONObject.NULL : new JSONObject(this.sF));
//        json.put(FormsTable.COLUMN_SG, this.sG.equals("") ? JSONObject.NULL : new JSONObject(this.sG));
//        json.put(FormsTable.COLUMN_SH, this.sH.equals("") ? JSONObject.NULL : new JSONObject(this.sH));
//        json.put(FormsTable.COLUMN_SI, this.sI.equals("") ? JSONObject.NULL : new JSONObject(this.sI));
//        json.put(FormsTable.COLUMN_SJ, this.sJ.equals("") ? JSONObject.NULL : new JSONObject(this.sJ));
//        json.put(FormsTable.COLUMN_SK, this.sK.equals("") ? JSONObject.NULL : new JSONObject(this.sK));
        json.put(FormsTable.COLUMN_SL, this.sL.equals("") ? JSONObject.NULL : new JSONObject(this.sL));
        json.put(FormsTable.COLUMN_SM, this.sM.equals("") ? JSONObject.NULL : new JSONObject(this.sM));
        json.put(FormsTable.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
        json.put(FormsTable.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
        json.put(FormsTable.COLUMN_GPSDATE, this.gpsDT == null ? JSONObject.NULL : this.gpsDT);
        json.put(FormsTable.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
        json.put(FormsTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(FormsTable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);


        return json;
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

    public String getUID() {
        return _UID;
    }

    public void setUID(String _UID) {
        this._UID = _UID;
    }

    public String getISNEW() {
        return ISNEW;
    }

    public void setISNEW(String ISNEW) {
        this.ISNEW = ISNEW;
    }

    public String getDSSID() {
        return DSSID;
    }

    public void setDSSID(String DSSID) {
        this.DSSID = DSSID;
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

    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }

    public String getsA() {
        return sA;
    }

    public void setsA(String sA) {
        this.sA = sA;
    }

    public String getsD() {
        return sD;
    }

    public void setsD(String sD) {
        this.sD = sD;
    }

    public String getsE() {
        return sE;
    }

    public void setsE(String sE) {
        this.sE = sE;
    }

    public String getsF() {
        return sF;
    }

    public void setsF(String sF) {
        this.sF = sF;
    }

    public String getsG() {
        return sG;
    }

    public void setsG(String sG) {
        this.sG = sG;
    }

    public String getsH() {
        return sH;
    }

    public void setsH(String sH) {
        this.sH = sH;
    }

    public String getsI() {
        return sI;
    }

    public void setsI(String sI) {
        this.sI = sI;
    }

    public String getsJ() {
        return sJ;
    }

    public void setsJ(String sJ) {
        this.sJ = sJ;
    }

    public String getsK() {
        return sK;
    }

    public void setsK(String sK) {
        this.sK = sK;
    }

    public String getsL() {
        return sL;
    }

    public void setsL(String sL) {
        this.sL = sL;
    }

    public String getsM() {
        return sM;
    }

    public void setsM(String sM) {
        this.sM = sM;
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

    public String getGpsDT() {
        return gpsDT;
    }

    public void setGpsDT(String gpsDT) {
        this.gpsDT = gpsDT;
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

    public String getDevicetagID() {
        return devicetagID;
    }

    public void setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
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

    public static abstract class FormsTable implements BaseColumns {

        public static final String TABLE_NAME = "forms";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "projectname";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_IS_NEW = "isnew";
        public static final String COLUMN_DSSID = "dssid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_ISTATUS = "istatus";
        public static final String COLUMN_SA = "sa";
        public static final String COLUMN_SD = "sd";
        public static final String COLUMN_SE = "se";
        public static final String COLUMN_SF = "sf";
        public static final String COLUMN_SG = "sg";
        public static final String COLUMN_SH = "sh";
        public static final String COLUMN_SI = "si";
        public static final String COLUMN_SJ = "sj";
        public static final String COLUMN_SK = "sk";
        public static final String COLUMN_SL = "sl";
        public static final String COLUMN_SM = "sm";
        public static final String COLUMN_GPSLAT = "gpslat";
        public static final String COLUMN_GPSLNG = "gpslng";
        public static final String COLUMN_GPSDATE = "gpsdate";
        public static final String COLUMN_GPSACC = "gpsacc";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "tagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";

        public static String _URL = "forms.php";
    }
}
