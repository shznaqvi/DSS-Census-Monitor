package edu.aku.hassannaqvi.dss_census_monitor.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.dss_census_monitor.contracts.CensusContract;
import edu.aku.hassannaqvi.dss_census_monitor.contracts.CensusContract.censusMember;
import edu.aku.hassannaqvi.dss_census_monitor.contracts.FormsContract;
import edu.aku.hassannaqvi.dss_census_monitor.contracts.FormsContract.FormsTable;
import edu.aku.hassannaqvi.dss_census_monitor.contracts.HouseholdContract;
import edu.aku.hassannaqvi.dss_census_monitor.contracts.HouseholdContract.householdForm;
import edu.aku.hassannaqvi.dss_census_monitor.contracts.MembersContract;
import edu.aku.hassannaqvi.dss_census_monitor.contracts.MembersContract.singleMember;
import edu.aku.hassannaqvi.dss_census_monitor.contracts.MotherContract;
import edu.aku.hassannaqvi.dss_census_monitor.contracts.MotherContract.MotherTB;
import edu.aku.hassannaqvi.dss_census_monitor.contracts.SectionKIMContract;
import edu.aku.hassannaqvi.dss_census_monitor.contracts.UsersContract;
import edu.aku.hassannaqvi.dss_census_monitor.contracts.UsersContract.singleUser;
import edu.aku.hassannaqvi.dss_census_monitor.otherClasses.MothersLst;

import static edu.aku.hassannaqvi.dss_census_monitor.contracts.SectionKIMContract.singleIm;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String SQL_CREATE_USERS = "CREATE TABLE " + singleUser.TABLE_NAME + "("
            + singleUser._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleUser.ROW_USERNAME + " TEXT,"
            + singleUser.ROW_PASSWORD + " TEXT,"
            + singleUser.FULL_NAME + " TEXT,"
            + singleUser.REGION_DSS + " TEXT );";
    public static final String DATABASE_NAME = "dss-census.db";
    public static final String DB_NAME = "dss-census_copy.db";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_FORMS = "CREATE TABLE "
            + FormsTable.TABLE_NAME + "("
            + FormsTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FormsTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FormsTable.COLUMN_UID + " TEXT," +
            FormsTable.COLUMN_IS_NEW + " TEXT," +
            FormsTable.COLUMN_DSSID + " TEXT," +
            FormsTable.COLUMN_FORMDATE + " TEXT," +
            FormsTable.COLUMN_USER + " TEXT," +
            FormsTable.COLUMN_SA + " TEXT," +
            FormsTable.COLUMN_SD + " TEXT," +
            FormsTable.COLUMN_SE + " TEXT," +
            FormsTable.COLUMN_SF + " TEXT," +
            FormsTable.COLUMN_SG + " TEXT," +
            FormsTable.COLUMN_SH + " TEXT," +
            FormsTable.COLUMN_SI + " TEXT," +
            FormsTable.COLUMN_SJ + " TEXT," +
            FormsTable.COLUMN_SK + " TEXT," +
            FormsTable.COLUMN_SL + " TEXT," +
            FormsTable.COLUMN_SM + " TEXT," +
            FormsTable.COLUMN_ISTATUS + " TEXT," +
            FormsTable.COLUMN_GPSLAT + " TEXT," +
            FormsTable.COLUMN_GPSLNG + " TEXT," +
            FormsTable.COLUMN_GPSDATE + " TEXT," +
            FormsTable.COLUMN_GPSACC + " TEXT," +
            FormsTable.COLUMN_DEVICEID + " TEXT," +
            FormsTable.COLUMN_DEVICETAGID + " TEXT," +
            FormsTable.COLUMN_SYNCED + " TEXT," +
            FormsTable.COLUMN_SYNCED_DATE + " TEXT"
            + " );";
    private static final String SQL_CREATE_HOUSEHOLD = "CREATE TABLE "
            + householdForm.TABLE_NAME + "("
            + householdForm.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + householdForm.COLUMN_PROJECT_NAME + " TEXT,"
            + householdForm.COLUMN_UID + " TEXT," +
            householdForm.COLUMN_HOUSEHOLDID + " TEXT," +
            householdForm.COLUMN_FORMDATE + " TEXT," +
            householdForm.COLUMN_USER + " TEXT," +
            householdForm.COLUMN_CENTER + " TEXT," +
            householdForm.COLUMN_GPSLAT + " TEXT," +
            householdForm.COLUMN_GPSLNG + " TEXT," +
            householdForm.COLUMN_GPSTIME + " TEXT," +
            householdForm.COLUMN_GPSACC + " TEXT," +
            householdForm.COLUMN_DEVICEID + " TEXT," +
            householdForm.COLUMN_SYNCED + " TEXT," +
            householdForm.COLUMN_SYNCED_DATE + " TEXT"
            + " );";
    private static final String SQL_CREATE_CENSUS = "CREATE TABLE "
            + censusMember.TABLE_NAME + "("
            + censusMember.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + censusMember.COLUMN_PROJECT_NAME + " TEXT," +
            censusMember.COLUMN_DEVICETAGID + " TEXT," +
            censusMember.COLUMN_REF_ID + " TEXT," +
            censusMember.COLUMN_UID + " TEXT," +
            censusMember.COLUMN_UUID + " TEXT," +
            censusMember.COLUMN_DATE + " TEXT," +
            censusMember.COLUMN_FORMDATE + " TEXT," +
            censusMember.COLUMN_DEVICEID + " TEXT," +
            censusMember.COLUMN_USER + " TEXT," +
            censusMember.COLUMN_DSS_ID_HH + " TEXT," +
            censusMember.COLUMN_DSS_ID_F + " TEXT," +
            censusMember.COLUMN_DSS_ID_M + " TEXT," +
            censusMember.COLUMN_DSS_ID_H + " TEXT," +
            censusMember.COLUMN_DSS_ID_MEMBER + " TEXT," +
            censusMember.COLUMN_PREVS_DSS_ID_MEMBER + " TEXT," +
            censusMember.COLUMN_SITE_CODE + " TEXT," +
            censusMember.COLUMN_NAME + " TEXT," +
            censusMember.COLUMN_DOB + " TEXT," +
            censusMember.COLUMN_AGEY + " TEXT," +
            censusMember.COLUMN_AGEM + " TEXT," +
            censusMember.COLUMN_AGED + " TEXT," +
            censusMember.COLUMN_GENDER + " TEXT," +
            censusMember.COLUMN_IS_HEAD + " TEXT," +
            censusMember.COLUMN_RELATION_HH + " TEXT," +
            censusMember.COLUMN_CURRENT_STATUS + " TEXT," +
            censusMember.COLUMN_CURRENT_STATUSX + " TEXT," +
            censusMember.COLUMN_CURRENT_DATE + " TEXT," +
            censusMember.COLUMN_DOD + " TEXT," +
            censusMember.COLUMN_M_STATUS + " TEXT," +
            censusMember.COLUMN_EDUCATION + " TEXT," +
            censusMember.COLUMN_EDUCATIONX + " TEXT," +
            censusMember.COLUMN_OCCUPATION + " TEXT," +
            censusMember.COLUMN_OCCUPATIONX + " TEXT," +
            censusMember.COLUMN_MEMBER_TYPE + " TEXT," +
            censusMember.COLUMN_RSVP + " TEXT," +
            censusMember.COLUMN_ISTATUS + " TEXT," +
            censusMember.COLUMN_REMARKS + " TEXT," +
            censusMember.COLUMN_UPDATE_FLAG + " TEXT," +
            censusMember.COLUMN_UPDATE_DT + " TEXT," +
            censusMember.COLUMN_SERIAL_NO + " TEXT," +
            censusMember.COLUMN_SYNCED + " TEXT," +
            censusMember.COLUMN_SYNCED_DATE + " TEXT"
            + " );";
    private static final String SQL_CREATE_MEMBERS = "CREATE TABLE "
            + singleMember.TABLE_NAME + "("
            + singleMember.COLUMN_ID + " TEXT," +
            singleMember.COLUMN_DATE + " TEXT," +
            singleMember.COLUMN_DSS_ID_HH + " TEXT," +
            singleMember.COLUMN_DSS_ID_F + " TEXT," +
            singleMember.COLUMN_DSS_ID_M + " TEXT," +
            singleMember.COLUMN_DSS_ID_H + " TEXT," +
            singleMember.COLUMN_DSS_ID_MEMBER + " TEXT," +
            singleMember.COLUMN_PREVS_DSS_ID_MEMBER + " TEXT," +
            singleMember.COLUMN_SITE_CODE + " TEXT," +
            singleMember.COLUMN_NAME + " TEXT," +
            singleMember.COLUMN_DOB + " TEXT," +
            singleMember.COLUMN_AGE + " TEXT," +
            singleMember.COLUMN_GENDER + " TEXT," +
            singleMember.COLUMN_IS_HEAD + " TEXT," +
            singleMember.COLUMN_RELATION_HH + " TEXT," +
            singleMember.COLUMN_CURRENT_STATUS + " TEXT," +
            singleMember.COLUMN_CURRENT_DATE + " TEXT," +
            singleMember.COLUMN_DOD + " TEXT," +
            singleMember.COLUMN_M_STATUS + " TEXT," +
            singleMember.COLUMN_EDUCATION + " TEXT," +
            singleMember.COLUMN_OCCUPATION + " TEXT," +
            singleMember.COLUMN_MEMBER_TYPE + " TEXT" +
            " );";

    private static final String SQL_CREATE_MOTHER = "CREATE TABLE "
            + MotherTB.TABLE_NAME + "("
            + MotherTB.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            MotherTB.COLUMN_PROJECT_NAME + " TEXT," +
            MotherTB.COLUMN_UUID + " TEXT," +
            MotherTB.COLUMN_UID + " TEXT," +
            MotherTB.COLUMN_FORMDATE + " TEXT," +
            MotherTB.COLUMN_USER + " TEXT," +
            MotherTB.COLUMN_CHILDID + " TEXT,"+
            MotherTB.COLUMN_DSSID + " TEXT,"+
            MotherTB.COLUMN_MOTHERID + " TEXT,"+
            MotherTB.COLUMN_ISTATUS + " TEXT,"+
            MotherTB.COLUMN_SF + " TEXT," +
            MotherTB.COLUMN_SG + " TEXT," +
            MotherTB.COLUMN_SH + " TEXT," +
            MotherTB.COLUMN_SI + " TEXT," +
            MotherTB.COLUMN_SJ + " TEXT," +
//            MotherTB.COLUMN_SK + " TEXT," +
            MotherTB.COLUMN_DEVICEID + " TEXT," +
            MotherTB.COLUMN_SYNCED + " TEXT," +
            MotherTB.COLUMN_SYNCED_DATE + " TEXT" +

            " );";

    private static final String SQL_CREATE_SEC_K_IM = "CREATE TABLE "
            + singleIm.TABLE_NAME + "("
            + singleIm.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            singleIm.COLUMN_PROJECT_NAME + " TEXT," +
            singleIm.COLUMN_DEVICETAGID + " TEXT," +
            singleIm.COLUMN_UUID + " TEXT," +
            singleIm.COLUMN_UID + " TEXT," +
            singleIm.COLUMN_SK + " TEXT," +
            singleIm.COLUMN_FORMDATE + " TEXT," +
            singleIm.COLUMN_USER + " TEXT," +
            singleIm.COLUMN_CHILDID + " TEXT," +
            singleIm.COLUMN_MM + " TEXT," +
            singleIm.COLUMN_DSSID + " TEXT," +
            singleIm.COLUMN_DEVICEID + " TEXT," +
            singleIm.COLUMN_ISTATUS + " TEXT," +
            singleIm.COLUMN_SYNCED + " TEXT," +
            singleIm.COLUMN_SYNCED_DATE + " TEXT" +

            " );";


    private static final String SQL_DELETE_USERS =
            "DROP TABLE IF EXISTS " + singleUser.TABLE_NAME;
    private static final String SQL_DELETE_FORMS =
            "DROP TABLE IF EXISTS " + FormsTable.TABLE_NAME;
    private static final String SQL_DELETE_HOUSEHOLD =
            "DROP TABLE IF EXISTS " + householdForm.TABLE_NAME;
    private static final String SQL_DELETE_MEMBERS =
            "DROP TABLE IF EXISTS " + singleMember.TABLE_NAME;
    private static final String SQL_DELETE_CENSUS =
            "DROP TABLE IF EXISTS " + censusMember.TABLE_NAME;
    private static final String SQL_DELETE_MOTHER =
            "DROP TABLE IF EXISTS " + MotherTB.TABLE_NAME;
    private static final String SQL_DELETE_SEC_K_IM =
            "DROP TABLE IF EXISTS " + singleIm.TABLE_NAME;

    private static final String SQL_SELECT_MOTHER_BY_CHILD =
            "SELECT c.agem cm, c.agey cy, c.aged cd, c.gender, c.serial serial, m.serial serialm, c.name child_name, c.dss_id_member child_id, m.name mother_name, c.dss_id_member mother_id, c.dob date_of_birth FROM census C join census m on c.dss_id_m = m.dss_id_member where c.member_type =? and c.uuid = m.uuid and c.current_status IN ('1', '2') and c.uuid = ? group by mother_id order by substr(c.dob, 7) desc, substr(c.dob, 4,2) desc, substr(c.dob, 1,2) desc;";
    private static final String SQL_SELECT_CHILD =
            "SELECT * from census where member_type =? and dss_id_hh =? and uuid =? and current_status IN ('1', '2')";


    private final String TAG = "DatabaseHelper";


    public String spDateT = new SimpleDateFormat("dd-MM-yy").format(new Date().getTime());


    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_FORMS);
        db.execSQL(SQL_CREATE_HOUSEHOLD);
        db.execSQL(SQL_CREATE_MEMBERS);
        db.execSQL(SQL_CREATE_CENSUS);
        db.execSQL(SQL_CREATE_MOTHER);
        db.execSQL(SQL_CREATE_SEC_K_IM);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_USERS);
        db.execSQL(SQL_DELETE_FORMS);
        db.execSQL(SQL_DELETE_HOUSEHOLD);
        db.execSQL(SQL_DELETE_MEMBERS);
        db.execSQL(SQL_DELETE_CENSUS);
        db.execSQL(SQL_DELETE_MOTHER);
        db.execSQL(SQL_DELETE_SEC_K_IM);
    }

    public void syncUser(JSONArray userlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UsersContract.singleUser.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = userlist;
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);

                UsersContract user = new UsersContract();
                user.Sync(jsonObjectUser);
                ContentValues values = new ContentValues();

                values.put(singleUser.ROW_USERNAME, user.getUserName());
                values.put(singleUser.ROW_PASSWORD, user.getPassword());
                values.put(singleUser.FULL_NAME, user.getFULL_NAME());
                values.put(singleUser.REGION_DSS, user.getREGION_DSS());
                db.insert(singleUser.TABLE_NAME, null, values);
            }


        } catch (Exception e) {
            Log.d(TAG, "syncUser(e): " + e);
        } finally {
            db.close();
        }
    }

    public void syncMembers(JSONArray memberlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(MembersContract.singleMember.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = memberlist;
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObjectMember = jsonArray.getJSONObject(i);

                MembersContract member = new MembersContract();
                member.Sync(jsonObjectMember);
                ContentValues values = new ContentValues();

/*                values.put(singleMember.COLUMN_ID, member.get_ID());
                values.put(singleMember.COLUMN_DSS_ID_MEMBER, member.getDss_id_member());
                values.put(singleMember.COLUMN_DATE, member.get_DATE());*/
                values.put(singleMember.COLUMN_DSS_ID_HH, member.getDss_id_hh());
                /*values.put(singleMember.COLUMN_DSS_ID_F, member.getDss_id_f());
                values.put(singleMember.COLUMN_DSS_ID_M, member.getDss_id_m());
                values.put(singleMember.COLUMN_DSS_ID_H, member.getDss_id_h());
                values.put(singleMember.COLUMN_PREVS_DSS_ID_MEMBER, member.getPrevs_dss_id_member());
                values.put(singleMember.COLUMN_SITE_CODE, member.getSite_code());
                values.put(singleMember.COLUMN_NAME, member.getName());
                values.put(singleMember.COLUMN_DOB, member.getDob());
                values.put(singleMember.COLUMN_AGE, member.getAge());
                values.put(singleMember.COLUMN_GENDER, member.getGender());
                values.put(singleMember.COLUMN_IS_HEAD, member.getIs_head());
                values.put(singleMember.COLUMN_RELATION_HH, member.getRelation_hh());
                values.put(singleMember.COLUMN_CURRENT_STATUS, member.getCurrent_status());
                values.put(singleMember.COLUMN_CURRENT_DATE, member.getCurrent_date());
                values.put(singleMember.COLUMN_DOD, member.getDod());
                values.put(singleMember.COLUMN_M_STATUS, member.getM_status());
                values.put(singleMember.COLUMN_EDUCATION, member.getEducation());
                values.put(singleMember.COLUMN_OCCUPATION, member.getOccupation());
                values.put(singleMember.COLUMN_MEMBER_TYPE, member.getMember_type());*/

                db.insert(singleMember.TABLE_NAME, null, values);
            }


        } catch (Exception e) {
            Log.d(TAG, "syncMember(e): " + e);
        } finally {
            db.close();
        }
    }

//    public ArrayList<UsersContract> getAllUsers() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        ArrayList<UsersContract> userList = null;
//        try {
//            userList = new ArrayList<UsersContract>();
//            String QUERY = "SELECT * FROM " + singleUser.TABLE_NAME;
//            Cursor cursor = db.rawQuery(QUERY, null);
//            int num = cursor.getCount();
//            if (!cursor.isLast()) {
//                while (cursor.moveToNext()) {
//                    UsersContract user = new UsersContract();
//                    user.setId(cursor.getInt(0));
//                    user.setUserName(cursor.getString(1));
//                    user.setPassword(cursor.getString(2));
//                    user.setFULL_NAME(cursor.getString(3));
//                    user.setREGION_DSS(cursor.getString(4));
//                    userList.add(user);
//                }
//            }
//            db.close();
//        } catch (Exception e) {
//        }
//        return userList;
//    }

    public boolean Login(String username, String password) throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor mCursor = db.rawQuery("SELECT * FROM " + singleUser.TABLE_NAME + " WHERE " + singleUser.ROW_USERNAME + "=? AND " + singleUser.ROW_PASSWORD + "=?", new String[]{username, password});
        if (mCursor != null) {
            if (mCursor.getCount() > 0) {

                if (mCursor.moveToFirst()) {
                    MainApp.regionDss = mCursor.getString(mCursor.getColumnIndex("region_dss"));
                }
                return true;
            }
        }
        return false;
    }

    public Collection<MembersContract> getMembersByDSS(String dssID) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
//                singleMember.COLUMN_ID,
//                singleMember.COLUMN_DATE,
                singleMember.COLUMN_DSS_ID_HH,
/*                singleMember.COLUMN_DSS_ID_F,
                singleMember.COLUMN_DSS_ID_M,
                singleMember.COLUMN_DSS_ID_H,
                singleMember.COLUMN_DSS_ID_MEMBER,
                singleMember.COLUMN_PREVS_DSS_ID_MEMBER,
                singleMember.COLUMN_SITE_CODE,
                singleMember.COLUMN_NAME,
                singleMember.COLUMN_DOB,
                singleMember.COLUMN_AGE,
                singleMember.COLUMN_GENDER,
                singleMember.COLUMN_IS_HEAD,
                singleMember.COLUMN_RELATION_HH,
                singleMember.COLUMN_CURRENT_STATUS,
                singleMember.COLUMN_CURRENT_DATE,
                singleMember.COLUMN_DOD,
                singleMember.COLUMN_M_STATUS,
                singleMember.COLUMN_EDUCATION,
                singleMember.COLUMN_OCCUPATION,
                singleMember.COLUMN_MEMBER_TYPE,*/
        };

        String whereClause = singleMember.COLUMN_DSS_ID_HH + " = ?";
        String[] whereArgs = new String[]{dssID};
        String groupBy = null;
        String having = null;

        String orderBy =
                singleMember.COLUMN_DSS_ID_MEMBER + " ASC";

        Collection<MembersContract> memList = new ArrayList<MembersContract>();
        try {
            c = db.query(
                    singleMember.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                MembersContract mc = new MembersContract();
                memList.add(mc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return memList;
    }

    public List<FormsContract> getFormsByDSS(String dssID) {
        List<FormsContract> formList = new ArrayList<FormsContract>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + FormsTable.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                FormsContract fc = new FormsContract();
                formList.add(fc.Hydrate(c));
            } while (c.moveToNext());
        }

        // return contact list
        return formList;
    }

    public Collection<MothersLst> getMotherByUUID(String uuid) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        // COLUMNS RETURNED: child_name, child_id, mother_name, mother_id, date_of_birth, serial
        Collection<MothersLst> memList = new ArrayList<>();
        try {

//            c = db.rawQuery(SQL_SELECT_MOTHER_BY_CHILD, new String[]{"c", "('1', '2')", uuid});
            c = db.rawQuery(SQL_SELECT_MOTHER_BY_CHILD, new String[]{"c", uuid});

            while (c.moveToNext()) {

                MothersLst mc = new MothersLst();
                memList.add(mc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return memList;
    }

    public Collection<CensusContract> getChildFromMember(String dssID,String uuid) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        // COLUMNS RETURNED: child_name, child_id, mother_name, mother_id, date_of_birth, serial
        Collection<CensusContract> memList = new ArrayList<>();
        try {

//            c = db.rawQuery(SQL_SELECT_CHILD, new String[]{"c", dssID, uuid, "('1', '2')"});
            c = db.rawQuery(SQL_SELECT_CHILD, new String[]{"c", dssID, uuid});

            while (c.moveToNext()) {
                CensusContract mc = new CensusContract();
                memList.add(mc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return memList;
    }

    public Long addForm(FormsContract fc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_PROJECT_NAME, fc.getProjectName());
        values.put(FormsTable.COLUMN_UID, fc.getUID());
        values.put(FormsTable.COLUMN_IS_NEW, fc.getISNEW());
        values.put(FormsTable.COLUMN_DSSID, fc.getDSSID());
        values.put(FormsTable.COLUMN_FORMDATE, fc.getFormDate());
        values.put(FormsTable.COLUMN_USER, fc.getUser());
        values.put(FormsTable.COLUMN_ISTATUS, fc.getIstatus());
        values.put(FormsTable.COLUMN_SA, fc.getsA());
        values.put(FormsTable.COLUMN_SD, fc.getsD());
        values.put(FormsTable.COLUMN_SE, fc.getsE());
        values.put(FormsTable.COLUMN_SF, fc.getsF());
        values.put(FormsTable.COLUMN_SG, fc.getsG());
        values.put(FormsTable.COLUMN_SH, fc.getsH());
        values.put(FormsTable.COLUMN_SI, fc.getsI());
        values.put(FormsTable.COLUMN_SJ, fc.getsJ());
        values.put(FormsTable.COLUMN_SK, fc.getsK());
        values.put(FormsTable.COLUMN_SL, fc.getsL());
        values.put(FormsTable.COLUMN_SM, fc.getsM());
        values.put(FormsTable.COLUMN_GPSLAT, fc.getGpsLat());
        values.put(FormsTable.COLUMN_GPSLNG, fc.getGpsLng());
        values.put(FormsTable.COLUMN_GPSDATE, fc.getGpsDT());
        values.put(FormsTable.COLUMN_GPSACC, fc.getGpsAcc());
        values.put(FormsTable.COLUMN_DEVICETAGID, fc.getDevicetagID());
        values.put(FormsTable.COLUMN_DEVICEID, fc.getDeviceID());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormsTable.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addMother(MotherContract mc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(MotherTB.COLUMN_PROJECT_NAME, mc.getProjectName());
        values.put(MotherTB.COLUMN_UID, mc.getUID());
        values.put(MotherTB.COLUMN_UUID, mc.get_UUID());
        values.put(MotherTB.COLUMN_FORMDATE, mc.getFormDate());
        values.put(MotherTB.COLUMN_USER, mc.getUser());
        values.put(MotherTB.COLUMN_SF, mc.getsF());
        values.put(MotherTB.COLUMN_SG, mc.getsG());
        values.put(MotherTB.COLUMN_SH, mc.getsH());
        values.put(MotherTB.COLUMN_SI, mc.getsI());
        values.put(MotherTB.COLUMN_SJ, mc.getsJ());
//        values.put(MotherTB.COLUMN_SK, mc.getsK());
        values.put(MotherTB.COLUMN_DEVICEID, mc.getDeviceId());

        // SYNCED INFORMATION IS NEVER INSERTED WITH NEW RECORD.
     /*   values.put(MotherTB.COLUMN_SYNCED, mc.getSynced());
        values.put(MotherTB.COLUMN_SYNCED_DATE, mc.getSynced_date());*/

        values.put(MotherTB.COLUMN_CHILDID, mc.getChildID());
        values.put(MotherTB.COLUMN_DSSID, mc.getDssID());
        values.put(MotherTB.COLUMN_MOTHERID, mc.getMotherID());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                MotherTB.TABLE_NAME,
                MotherTB.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addChild(SectionKIMContract ims) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();

        values.put(singleIm.COLUMN_PROJECT_NAME, ims.getProjectName());
        values.put(singleIm.COLUMN_UUID, ims.get_UUID());
        values.put(singleIm.COLUMN_UID, ims.getUID());
        values.put(singleIm.COLUMN_SK, ims.getsK());
        values.put(singleIm.COLUMN_FORMDATE, ims.getFormDate());
        values.put(singleIm.COLUMN_USER, ims.getUser());
        values.put(singleIm.COLUMN_MM, ims.getMm());
        //values.put(singleIm.COLUMN_CHILDID, ims.getChildID());
        values.put(singleIm.COLUMN_DSSID, ims.getDssID());
        values.put(singleIm.COLUMN_DEVICEID, ims.getDeviceId());
        values.put(singleIm.COLUMN_DEVICETAGID, ims.getDevicetagID());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                singleIm.TABLE_NAME,
                singleIm.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    public Long addHousehold(HouseholdContract hc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(householdForm.COLUMN_PROJECT_NAME, hc.getProjectName());
        values.put(householdForm.COLUMN_UID, hc.getUID());
        values.put(householdForm.COLUMN_HOUSEHOLDID, hc.getHouseholdID());
        values.put(householdForm.COLUMN_FORMDATE, hc.getFormDate());
        values.put(householdForm.COLUMN_USER, hc.getUser());
        values.put(householdForm.COLUMN_GPSLAT, hc.getGpsLat());
        values.put(householdForm.COLUMN_GPSLNG, hc.getGpsLng());
        values.put(householdForm.COLUMN_GPSTIME, hc.getGpsTime());
        values.put(householdForm.COLUMN_GPSACC, hc.getGpsAcc());
        values.put(householdForm.COLUMN_DEVICEID, hc.getDeviceID());

        long newRowId;
        newRowId = db.insert(
                householdForm.TABLE_NAME,
                householdForm.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addCensusMembers(CensusContract mc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(censusMember.COLUMN_PROJECT_NAME, mc.getProjectName());
        values.put(censusMember.COLUMN_REF_ID, mc.getREF_ID());
        values.put(censusMember.COLUMN_UID, mc.get_UID());
        values.put(censusMember.COLUMN_UUID, mc.get_UUID());
        values.put(censusMember.COLUMN_DATE, mc.get_DATE());
        values.put(censusMember.COLUMN_FORMDATE, mc.getFormDate());
        values.put(censusMember.COLUMN_DEVICEID, mc.getDeviceId());
        values.put(censusMember.COLUMN_USER, mc.getUser());
        values.put(censusMember.COLUMN_DSS_ID_HH, mc.getDss_id_hh());
        values.put(censusMember.COLUMN_DSS_ID_F, mc.getDss_id_f());
        values.put(censusMember.COLUMN_DSS_ID_M, mc.getDss_id_m());
        values.put(censusMember.COLUMN_DSS_ID_H, mc.getDss_id_h());
        values.put(censusMember.COLUMN_DSS_ID_MEMBER, mc.getDss_id_member());
        values.put(censusMember.COLUMN_PREVS_DSS_ID_MEMBER, mc.getPrevs_dss_id_member());
        values.put(censusMember.COLUMN_SITE_CODE, mc.getSite_code());
        values.put(censusMember.COLUMN_NAME, mc.getName());
        values.put(censusMember.COLUMN_DOB, mc.getDob());
        values.put(censusMember.COLUMN_AGEY, mc.getAgeY());
        values.put(censusMember.COLUMN_AGEM, mc.getAgeM());
        values.put(censusMember.COLUMN_AGED, mc.getAgeD());
        values.put(censusMember.COLUMN_GENDER, mc.getGender());
        values.put(censusMember.COLUMN_IS_HEAD, mc.getIs_head());
        values.put(censusMember.COLUMN_RELATION_HH, mc.getRelation_hh());
        values.put(censusMember.COLUMN_CURRENT_STATUS, mc.getCurrent_status());
        values.put(censusMember.COLUMN_CURRENT_STATUSX, mc.getCurrent_statusX());
        values.put(censusMember.COLUMN_CURRENT_DATE, mc.getCurrent_date());
        values.put(censusMember.COLUMN_DOD, mc.getDod());
        values.put(censusMember.COLUMN_M_STATUS, mc.getM_status());
        values.put(censusMember.COLUMN_EDUCATION, mc.getEducation());
        values.put(censusMember.COLUMN_EDUCATIONX, mc.getEducationX());
        values.put(censusMember.COLUMN_OCCUPATION, mc.getOccupation());
        values.put(censusMember.COLUMN_OCCUPATIONX, mc.getOccupationX());
        values.put(censusMember.COLUMN_MEMBER_TYPE, mc.getMember_type());
        values.put(censusMember.COLUMN_REMARKS, mc.getRemarks());
        values.put(censusMember.COLUMN_UPDATE_FLAG, mc.getUpdate_flag());
        values.put(censusMember.COLUMN_UPDATE_DT, mc.getUpdate_dt());
        values.put(censusMember.COLUMN_RSVP, mc.getRsvp());
        values.put(censusMember.COLUMN_SERIAL_NO, mc.getSerialNo());
        values.put(censusMember.COLUMN_DEVICETAGID, mc.getDevicetagID());


        long newRowId;
        newRowId = db.insert(
                censusMember.TABLE_NAME,
                censusMember.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public void updateSyncedForms(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SYNCED, true);
        values.put(FormsTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = FormsTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FormsTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateMotherCount(String memCount,String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SF, memCount);

// Which row to update, based on the title
        String where = FormsTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FormsTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateMothers(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(MotherTB.COLUMN_SYNCED, true);
        values.put(MotherTB.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = MotherTB.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                MotherTB.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateChild(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(singleIm.COLUMN_SYNCED, true);
        values.put(singleIm.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = singleIm.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                singleIm.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateCensus(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(censusMember.COLUMN_SYNCED, true);
        values.put(censusMember.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = censusMember.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                censusMember.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateMother(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(MotherTB.COLUMN_SYNCED, true);
        values.put(MotherTB.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = MotherTB.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                MotherTB.TABLE_NAME,
                values,
                where,
                whereArgs);
    }
    public void updateIM(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(singleIm.COLUMN_SYNCED, true);
        values.put(singleIm.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = singleIm.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                singleIm.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public int updateFormID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_UID, MainApp.fc.getUID());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }


    public int updateCensusID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(censusMember.COLUMN_UID, MainApp.cc.get_UID());

// Which row to update, based on the ID
        String selection = censusMember.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.cc.get_ID())};

        int count = db.update(censusMember.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateMotherID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(MotherTB.COLUMN_UID, MainApp.mc.getUID());

// Which row to update, based on the ID
        String selection = MotherTB.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.mc.get_ID())};

        int count = db.update(MotherTB.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateChildID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(singleIm.COLUMN_UID, MainApp.ims.getUID());

// Which row to update, based on the ID
        String selection = singleIm.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.ims.get_ID())};

        int count = db.update(singleIm.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public Collection<FormsContract> getAllForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_IS_NEW,
                FormsTable.COLUMN_DSSID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_USER,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SA,
                FormsTable.COLUMN_SD,
                FormsTable.COLUMN_SE,
                FormsTable.COLUMN_SF,
                FormsTable.COLUMN_SG,
                FormsTable.COLUMN_SH,
                FormsTable.COLUMN_SI,
                FormsTable.COLUMN_SJ,
                FormsTable.COLUMN_SK,
                FormsTable.COLUMN_SL,
                FormsTable.COLUMN_SM,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDATE,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_DEVICEID,

        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }


    public Collection<MotherContract> getUnsyncedMother() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                MotherTB.COLUMN_ID,
                MotherTB.COLUMN_UID,
                MotherTB.COLUMN_UUID,
                MotherTB.COLUMN_FORMDATE,
                MotherTB.COLUMN_USER,
                MotherTB.COLUMN_SF,
                MotherTB.COLUMN_SG,
                MotherTB.COLUMN_SH,
                MotherTB.COLUMN_SI,
                MotherTB.COLUMN_SJ,
//                MotherTB.COLUMN_SK,
                MotherTB.COLUMN_DEVICEID,
                MotherTB.COLUMN_CHILDID,
                MotherTB.COLUMN_DSSID,
                MotherTB.COLUMN_ISTATUS,
                MotherTB.COLUMN_MOTHERID
        };
        String whereClause = MotherTB.COLUMN_SYNCED + " is null";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                MotherTB.COLUMN_ID + " ASC";

        Collection<MotherContract> allMC = new ArrayList<MotherContract>();
        try {
            c = db.query(
                    MotherTB.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                MotherContract mc = new MotherContract();
                allMC.add(mc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allMC;
    }


    public Collection<SectionKIMContract> getUnsyncedIM() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                singleIm.COLUMN_ID,
                singleIm.COLUMN_UUID,
                singleIm.COLUMN_UID,
                singleIm.COLUMN_SK,
                singleIm.COLUMN_FORMDATE,
                singleIm.COLUMN_USER,
//                singleIm.COLUMN_CHILDID,
                singleIm.COLUMN_MM,
                singleIm.COLUMN_DSSID,
                singleIm.COLUMN_DEVICETAGID,
                singleIm.COLUMN_DEVICEID,
                singleIm.COLUMN_ISTATUS

        };
        String whereClause = singleIm.COLUMN_SYNCED + " is null";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                singleIm.COLUMN_ID + " ASC";

        Collection<SectionKIMContract> allIM = new ArrayList<SectionKIMContract>();
        try {
            c = db.query(
                    singleIm.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                SectionKIMContract kIm = new SectionKIMContract();
                allIM.add(kIm.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allIM;
    }

    public Collection<CensusContract> getUnsyncedCensus() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                censusMember.COLUMN_ID,
                censusMember.COLUMN_REF_ID,
                censusMember.COLUMN_ISTATUS,
                censusMember.COLUMN_UID,
                censusMember.COLUMN_UUID,
                censusMember.COLUMN_DATE,
                censusMember.COLUMN_FORMDATE,
                censusMember.COLUMN_DEVICEID,
                censusMember.COLUMN_USER,
                censusMember.COLUMN_DSS_ID_HH,
                censusMember.COLUMN_DSS_ID_F,
                censusMember.COLUMN_DSS_ID_M,
                censusMember.COLUMN_DSS_ID_H,
                censusMember.COLUMN_DSS_ID_MEMBER,
                censusMember.COLUMN_PREVS_DSS_ID_MEMBER,
                censusMember.COLUMN_SITE_CODE,
                censusMember.COLUMN_NAME,
                censusMember.COLUMN_DOB,
                censusMember.COLUMN_AGEY,
                censusMember.COLUMN_AGEM,
                censusMember.COLUMN_AGED,
                censusMember.COLUMN_GENDER,
                censusMember.COLUMN_IS_HEAD,
                censusMember.COLUMN_RELATION_HH,
                censusMember.COLUMN_CURRENT_STATUS,
                censusMember.COLUMN_CURRENT_STATUSX,
                censusMember.COLUMN_CURRENT_DATE,
                censusMember.COLUMN_DOD,
                censusMember.COLUMN_M_STATUS,
                censusMember.COLUMN_EDUCATION,
                censusMember.COLUMN_EDUCATIONX,
                censusMember.COLUMN_OCCUPATION,
                censusMember.COLUMN_OCCUPATIONX,
                censusMember.COLUMN_MEMBER_TYPE,
                censusMember.COLUMN_UPDATE_FLAG,
                censusMember.COLUMN_UPDATE_DT,
                censusMember.COLUMN_RSVP,
                censusMember.COLUMN_SERIAL_NO,
                censusMember.COLUMN_DEVICETAGID,
                censusMember.COLUMN_REMARKS
        };
        String whereClause = censusMember.COLUMN_SYNCED + " is null";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                censusMember.COLUMN_ID + " ASC";

        Collection<CensusContract> allCC = new ArrayList<CensusContract>();
        try {
            c = db.query(
                    censusMember.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                CensusContract cc = new CensusContract();
                allCC.add(cc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allCC;
    }

    public Collection<FormsContract> getUnsyncedForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_IS_NEW,
                FormsTable.COLUMN_DSSID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_USER,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SA,
                FormsTable.COLUMN_SD,
                FormsTable.COLUMN_SE,
                FormsTable.COLUMN_SF,
                FormsTable.COLUMN_SG,
                FormsTable.COLUMN_SH,
                FormsTable.COLUMN_SI,
                FormsTable.COLUMN_SJ,
                FormsTable.COLUMN_SK,
                FormsTable.COLUMN_SL,
                FormsTable.COLUMN_SM,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDATE,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_DEVICEID
        };
        String whereClause = FormsTable.COLUMN_SYNCED + " is null";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public Collection<FormsContract> getTodayForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_DSSID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SYNCED,

        };
        String whereClause = FormsTable.COLUMN_FORMDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                fc.set_ID(c.getString(c.getColumnIndex(FormsTable.COLUMN_ID)));
                fc.setDSSID(c.getString(c.getColumnIndex(FormsTable.COLUMN_DSSID)));
                fc.setFormDate(c.getString(c.getColumnIndex(FormsTable.COLUMN_FORMDATE)));
                fc.setIstatus(c.getString(c.getColumnIndex(FormsTable.COLUMN_ISTATUS)));
                fc.setSynced(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYNCED)));
                allFC.add(fc);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    // ANDROID DATABASE MANAGER
    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }


    public int updateSA() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SG, MainApp.fc.getsG());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSD() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SD, MainApp.fc.getsD());
        values.put(FormsTable.COLUMN_UID, MainApp.fc.getUID());


// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSE() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SE, MainApp.fc.getsE());
        values.put(FormsTable.COLUMN_UID, MainApp.fc.getUID());


// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSF() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(MotherTB.COLUMN_SF, MainApp.mc.getsF());
        values.put(MotherTB.COLUMN_UID, MainApp.mc.getUID());


// Which row to update, based on the ID
        String selection = MotherTB.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.mc.get_ID())};

        int count = db.update(MotherTB.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSG() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(MotherTB.COLUMN_SG, MainApp.mc.getsG());

// Which row to update, based on the ID
        String selection = MotherTB.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.mc.get_ID())};

        int count = db.update(MotherTB.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSH() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(MotherTB.COLUMN_SH, MainApp.mc.getsH());

// Which row to update, based on the ID
        String selection = MotherTB.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.mc.get_ID())};

        int count = db.update(MotherTB.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSI() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(MotherTB.COLUMN_SI, MainApp.mc.getsI());

// Which row to update, based on the ID
        String selection = MotherTB.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.mc.get_ID())};

        int count = db.update(MotherTB.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSJ() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(MotherTB.COLUMN_SJ, MainApp.mc.getsJ());

// Which row to update, based on the ID
        String selection = MotherTB.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.mc.get_ID())};

        int count = db.update(MotherTB.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSK() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(singleIm.COLUMN_SK, MainApp.ims.getsK());
        values.put(singleIm.COLUMN_UID, MainApp.ims.getUID());


// Which row to update, based on the ID
        String selection = singleIm._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.ims.get_ID())};

        int count = db.update(singleIm.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSL() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SL, MainApp.fc.getsL());

// Which row to update, based on the ID
        String selection = FormsTable.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSM() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SM, MainApp.fc.getsM());

// Which row to update, based on the ID
        String selection = FormsTable.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateEnding() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_ISTATUS, MainApp.fc.getIstatus());

// Which row to update, based on the ID
        String selection = " _ID = " + MainApp.fc.get_ID();
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                null);
        return count;
    }

    public int updateCensus() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(censusMember.COLUMN_ISTATUS, MainApp.fc.getIstatus());

// Which row to update, based on the ID
        String selection = " uuid=?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.getUID())};

        int count = db.update(censusMember.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateMother() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(MotherTB.COLUMN_ISTATUS, MainApp.fc.getIstatus());

// Which row to update, based on the ID
        String selection = " uuid=?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.getUID())};

        int count = db.update(MotherTB.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }
    public int updateIM() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(singleIm.COLUMN_ISTATUS, MainApp.fc.getIstatus());

// Which row to update, based on the ID
        String selection = " uuid=?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.getUID())};

        int count = db.update(singleIm.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }



}