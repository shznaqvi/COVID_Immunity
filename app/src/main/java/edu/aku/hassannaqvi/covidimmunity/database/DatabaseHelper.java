package edu.aku.hassannaqvi.covidimmunity.database;

import static edu.aku.hassannaqvi.covidimmunity.core.MainApp.IBAHC;
import static edu.aku.hassannaqvi.covidimmunity.database.CreateTable.DATABASE_NAME;
import static edu.aku.hassannaqvi.covidimmunity.database.CreateTable.DATABASE_VERSION;
import static edu.aku.hassannaqvi.covidimmunity.database.CreateTable.SQL_CREATE_ENTRYLOGS;
import static edu.aku.hassannaqvi.covidimmunity.database.CreateTable.SQL_CREATE_FOLLOWUPS;
import static edu.aku.hassannaqvi.covidimmunity.database.CreateTable.SQL_CREATE_FOLLOWUPS_SCHE;
import static edu.aku.hassannaqvi.covidimmunity.database.CreateTable.SQL_CREATE_FORMS;
import static edu.aku.hassannaqvi.covidimmunity.database.CreateTable.SQL_CREATE_USERS;
import static edu.aku.hassannaqvi.covidimmunity.database.CreateTable.SQL_CREATE_VERSIONAPP;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.util.Log;

import net.sqlcipher.SQLException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteException;
import net.sqlcipher.database.SQLiteOpenHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.covidimmunity.contracts.TableContracts.EntryLogTable;
import edu.aku.hassannaqvi.covidimmunity.contracts.TableContracts.FollowupTable;
import edu.aku.hassannaqvi.covidimmunity.contracts.TableContracts.FollowupsScheTable;
import edu.aku.hassannaqvi.covidimmunity.contracts.TableContracts.FormsTable;
import edu.aku.hassannaqvi.covidimmunity.contracts.TableContracts.UsersTable;
import edu.aku.hassannaqvi.covidimmunity.contracts.TableContracts.VersionTable;
import edu.aku.hassannaqvi.covidimmunity.core.MainApp;
import edu.aku.hassannaqvi.covidimmunity.models.EntryLog;
import edu.aku.hassannaqvi.covidimmunity.models.FollowUpsSche;
import edu.aku.hassannaqvi.covidimmunity.models.Followup;
import edu.aku.hassannaqvi.covidimmunity.models.Form;
import edu.aku.hassannaqvi.covidimmunity.models.Users;
import edu.aku.hassannaqvi.covidimmunity.models.VersionApp;



/*import edu.aku.hassannaqvi.naunehal.models.Immunization;*/

/**
 * @author hassan.naqvi on 11/30/2016.
 * @update ali azaz on 01/07/21
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private final String TAG = "DatabaseHelper";
    public static final String DATABASE_PASSWORD = IBAHC;
    private final Context mContext;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_FORMS);
        db.execSQL(SQL_CREATE_FOLLOWUPS);
        db.execSQL(SQL_CREATE_FOLLOWUPS_SCHE);
        db.execSQL(SQL_CREATE_VERSIONAPP);
        db.execSQL(SQL_CREATE_ENTRYLOGS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
                db.execSQL(SQL_CREATE_FOLLOWUPS);
                db.execSQL(SQL_CREATE_FOLLOWUPS_SCHE);
        }
    }


    //ADDITION in DB
    public Long addForm(Form form) throws JSONException {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_PROJECT_NAME, form.getProjectName());
        values.put(FormsTable.COLUMN_UID, form.getUid());
        values.put(FormsTable.COLUMN_USERNAME, form.getUserName());
        values.put(FormsTable.COLUMN_SYSDATE, form.getSysDate());
        values.put(FormsTable.COLUMN_SHA, form.sHAtoString());
        values.put(FormsTable.COLUMN_SPA, form.sPAtoString());
        values.put(FormsTable.COLUMN_SPB, form.sPBtoString());
        values.put(FormsTable.COLUMN_SPC, form.sPCtoString());


        values.put(FormsTable.COLUMN_ISTATUS, form.getiStatus());

        values.put(FormsTable.COLUMN_DEVICETAGID, form.getDeviceTag());
        values.put(FormsTable.COLUMN_DEVICEID, form.getDeviceId());
        values.put(FormsTable.COLUMN_APPVERSION, form.getAppver());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormsTable.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addEntryLog(EntryLog entryLog) throws SQLiteException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(EntryLogTable.COLUMN_PROJECT_NAME, entryLog.getProjectName());
        values.put(EntryLogTable.COLUMN_UUID, entryLog.getUuid());
        values.put(EntryLogTable.COLUMN_PSU_CODE, entryLog.getPsuCode());
        values.put(EntryLogTable.COLUMN_HHID, entryLog.getHhid());
        values.put(EntryLogTable.COLUMN_USERNAME, entryLog.getUserName());
        values.put(EntryLogTable.COLUMN_SYSDATE, entryLog.getSysDate());
        values.put(EntryLogTable.COLUMN_ISTATUS, entryLog.getiStatus());
        values.put(EntryLogTable.COLUMN_ISTATUS96x, entryLog.getiStatus96x());
        values.put(EntryLogTable.COLUMN_ENTRY_TYPE, entryLog.getEntryType());
        values.put(EntryLogTable.COLUMN_ENTRY_DATE, entryLog.getEntryDate());
        values.put(EntryLogTable.COLUMN_DEVICEID, entryLog.getDeviceId());
        values.put(EntryLogTable.COLUMN_SYNCED, entryLog.getSynced());
        values.put(EntryLogTable.COLUMN_SYNC_DATE, entryLog.getSyncDate());
        values.put(EntryLogTable.COLUMN_APPVERSION, entryLog.getAppver());

        long newRowId;
        newRowId = db.insertOrThrow(
                EntryLogTable.TABLE_NAME,
                EntryLogTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    //ADDITION in DB
    public Long addFollowup(Followup followup) throws JSONException {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FollowupTable.COLUMN_PROJECT_NAME, followup.getProjectName());
        values.put(FollowupTable.COLUMN_UID, followup.getUid());
        values.put(FollowupTable.COLUMN_USERNAME, followup.getUserName());
        values.put(FollowupTable.COLUMN_SYSDATE, followup.getSysDate());
        values.put(FollowupTable.COLUMN_SFHA, followup.sFHAtoString());

        values.put(FollowupTable.COLUMN_ISTATUS, followup.getiStatus());

        values.put(FollowupTable.COLUMN_DEVICETAGID, followup.getDeviceTag());
        values.put(FollowupTable.COLUMN_DEVICEID, followup.getDeviceId());
        values.put(FollowupTable.COLUMN_APPVERSION, followup.getAppver());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FollowupTable.TABLE_NAME,
                FollowupTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    //UPDATE in DB
    public int updatesFormColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.form.getId())};

        return db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    //UPDATE in DB
    public int updatesFollowupColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = FollowupTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.followup.getId())};

        return db.update(FollowupTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesFollowupsScheColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = FollowupsScheTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.followupsSche.getId())};

        return db.update(FollowupsScheTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }


    public int updatesEntryLogColumn(String column, String value, String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = EntryLogTable._ID + " =? ";
        String[] selectionArgs = {id};

        return db.update(EntryLogTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updateEnding() {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_ISTATUS, MainApp.form.getiStatus());

        // Which row to update, based on the ID
        String selection = FormsTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.form.getId())};

        return db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }


    /*
     * Functions that dealing with table data
     * */
    public boolean doLogin(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = {
                UsersTable.COLUMN_ID,
                UsersTable.COLUMN_USERNAME,
                UsersTable.COLUMN_PASSWORD,
                UsersTable.COLUMN_FULLNAME,
        };
        String whereClause = UsersTable.COLUMN_USERNAME + "=? AND " + UsersTable.COLUMN_PASSWORD + "=?";
        String[] whereArgs = {username, password};
        String groupBy = null;
        String having = null;
        String orderBy = UsersTable.COLUMN_ID + " ASC";

        Users loggedInUser = null;
            c = db.query(
                    UsersTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                loggedInUser = new Users().hydrate(c);
            }

                c.close();

                db.close();

        MainApp.user = loggedInUser;
        return c.getCount() > 0;
    }


    public ArrayList<Form> getFormsByDate(String sysdate) {

        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_SYSDATE,
                FormsTable.COLUMN_USERNAME,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SYNCED,

        };
        String whereClause = FormsTable.COLUMN_SYSDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + sysdate + " %"};
        String groupBy = null;
        String having = null;
        String orderBy = FormsTable.COLUMN_ID + " ASC";
        ArrayList<Form> allForms = new ArrayList<>();
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
                Form forms = new Form();
                forms.setId(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_ID)));
                forms.setUid(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_UID)));
                forms.setSysDate(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SYSDATE)));
                forms.setUserName(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_USERNAME)));
                allForms.add(forms);
            }

                c.close();

                db.close();

        return allForms;
    }


    // istatus examples: (1) or (1,9) or (1,3,5)
    public Form getFormByAssessNo(String uid, String istatus) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = FormsTable.COLUMN_UID + "=? AND " +
                FormsTable.COLUMN_ISTATUS + " in " + istatus;

        String[] whereArgs = {uid};

        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " ASC";

        Form allFC = null;
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
                allFC = new Form().Hydrate(c);
            }

        c.close();

        db.close();

        return allFC;
    }

    public ArrayList<Cursor> getDatabaseManagerData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase(DATABASE_PASSWORD);
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(Query, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (Exception sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }

    /*public int updateTemp(String assessNo, String temp) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_TSF305, temp);
        values.put(FormsTable.COLUMN_SYSDATE, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()) + "-Updated");
        values.put(FormsTable.COLUMN_ISTATUS, "1");
        values.put(FormsTable.COLUMN_SYNCED, (byte[]) null);

        String selection = FormsTable.COLUMN_ASSESMENT_NO + " =? AND " + FormsTable.COLUMN_ISTATUS + " =? ";
        // String selection = FormsTable.COLUMN_ASSESMENT_NO + " =? ";
        String[] selectionArgs = {assessNo, "9"};
        // String[] selectionArgs = {assessNo};

        return db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }*/


    public int syncversionApp(JSONArray VersionList) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        long count = 0;

        JSONObject jsonObjectVersion = ((JSONArray) VersionList.getJSONObject(0).get("elements")).getJSONObject(0);

        String appPath = jsonObjectVersion.getString("outputFile");
        String versionCode = jsonObjectVersion.getString("versionCode");

        MainApp.editor.putString("outputFile", jsonObjectVersion.getString("outputFile"));
        MainApp.editor.putString("versionCode", jsonObjectVersion.getString("versionCode"));
        MainApp.editor.putString("versionName", jsonObjectVersion.getString("versionName") + ".");
        MainApp.editor.apply();
        count++;
          /*  VersionApp Vc = new VersionApp();
            Vc.sync(jsonObjectVersion);

            ContentValues values = new ContentValues();

            values.put(VersionTable.COLUMN_PATH_NAME, Vc.getPathname());
            values.put(VersionTable.COLUMN_VERSION_CODE, Vc.getVersioncode());
            values.put(VersionTable.COLUMN_VERSION_NAME, Vc.getVersionname());

            count = db.insert(VersionTable.TABLE_NAME, null, values);
            if (count > 0) count = 1;

        } catch (Exception ignored) {
        } finally {
            db.close();
        }*/

        return (int) count;
    }


    public VersionApp getVersionApp() {

        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy = null;

        VersionApp versionApp = new VersionApp();
            c = db.query(
                    VersionTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                versionApp.hydrate(c);
            }

        c.close();

        db.close();

        return versionApp;
    }


    public int syncusers(JSONArray userList) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        db.delete(UsersTable.TABLE_NAME, null, null);
        int insertCount = 0;
        for (int i = 0; i < userList.length(); i++) {

            JSONObject jsonObjectUser = userList.getJSONObject(i);

            Users user = new Users();
            user.sync(jsonObjectUser);
            ContentValues values = new ContentValues();

                values.put(UsersTable.COLUMN_USERNAME, user.getUserName());
                values.put(UsersTable.COLUMN_PASSWORD, user.getPassword());
                values.put(UsersTable.COLUMN_FULLNAME, user.getFullname());
                long rowID = db.insert(UsersTable.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }


        db.close();

        db.close();

        return insertCount;
    }


    //get UnSyncedTables
    public JSONArray getUnsyncedForms() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        //whereClause = null;
        whereClause = FormsTable.COLUMN_SYNCED + " is null AND " +
                FormsTable.COLUMN_ISTATUS + "!= ''";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " ASC";

        JSONArray allForms = new JSONArray();
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
                /** WorkManager Upload
                 /*Form fc = new Form();
                 allFC.add(fc.Hydrate(c));*/
                Log.d(TAG, "getUnsyncedForms: " + c.getCount());
                Form form = new Form();
                allForms.put(form.Hydrate(c).toJSONObject());


            }


        c.close();

        db.close();


        Log.d(TAG, "getUnsyncedForms: " + allForms.toString().length());
        Log.d(TAG, "getUnsyncedForms: " + allForms);
        return allForms;
    }


    public JSONArray getUnsyncedFollowups() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        //whereClause = null;
        whereClause = FollowupTable.COLUMN_SYNCED + " is null AND " +
                FollowupTable.COLUMN_ISTATUS + "!= ''";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = FollowupTable.COLUMN_ID + " ASC";

        JSONArray allFollowups = new JSONArray();
        c = db.query(
                FollowupTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            /** WorkManager Upload
             /*Form fc = new Form();
             allFC.add(fc.Hydrate(c));*/
            Log.d(TAG, "getUnsyncedFollowups: " + c.getCount());
            Followup fp = new Followup();
            allFollowups.put(fp.Hydrate(c).toJSONObject());


        }

        c.close();

        db.close();

        return allFollowups;
    }


    public JSONArray getUnsyncedEntryLog() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause;
        whereClause = EntryLogTable.COLUMN_SYNCED + " = '' ";

        String[] whereArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = EntryLogTable.COLUMN_ID + " ASC";

        JSONArray all = new JSONArray();
        c = db.query(
                EntryLogTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            Log.d(TAG, "getUnsyncedEntryLog: " + c.getCount());
            EntryLog entryLog = new EntryLog();
            all.put(entryLog.Hydrate(c).toJSONObject());
        }
        Log.d(TAG, "getUnsyncedEntryLog: " + all.toString().length());
        Log.d(TAG, "getUnsyncedEntryLog: " + all);
        return all;
    }


    //update SyncedTables
    public void updateSyncedforms(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

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


    public void updateSyncedfollowup(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FollowupTable.COLUMN_SYNCED, true);
        values.put(FollowupTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = FollowupTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FollowupTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase(DATABASE_PASSWORD);
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


/*    public Form getFormByClusterHHNo(String cluster_no, String hh_no) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = FormsTable.COLUMN_CLUSTER + "=? AND " +
                FormsTable.COLUMN_HHID + " =? ";

        String[] whereArgs = {cluster_no, hh_no};

        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " ASC";

        Form form = null;
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
                form = new Form().Hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return form;
    }*/


    public Collection<Form> getTodayForms(String sysdate) {

        // String sysdate =  spDateT.substring(0, 8).trim()
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause = FormsTable.COLUMN_SYSDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + sysdate + " %"};
//        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " DESC";

        Collection<Form> allFC = new ArrayList<>();
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
                Form fc = new Form();
                fc.setId(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_ID)));
                fc.setUid(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_UID)));
                fc.setSysDate(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SYSDATE)));
                fc.setiStatus(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_ISTATUS)));
                fc.setSynced(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SYNCED)));
                allFC.add(fc);
            }

        c.close();

        db.close();

        return allFC;
    }


    public Collection<Form> getPendingForms() {

        // String sysdate =  spDateT.substring(0, 8).trim()
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause = FormsTable.COLUMN_ISTATUS + " = ?";
        String[] whereArgs = new String[]{""};
//        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " DESC";

        Collection<Form> allFC = new ArrayList<>();
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
                Form fc = new Form();
                fc.setId(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_ID)));
                fc.setUid(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_UID)));
                fc.setSysDate(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SYSDATE)));
                fc.setiStatus(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_ISTATUS)));
                fc.setSynced(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SYNCED)));
                allFC.add(fc);
            }

        c.close();

        db.close();

        return allFC;
    }

    /*public String getWraName(String uid) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = {FormsTable.COLUMN_SW1A};

        String whereClause;
        whereClause = FormsTable.COLUMN_UID + "=?  ";

        String[] whereArgs = {uid};

        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " ASC";

        Form form = null;
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
                form = new Form();
                form.sW1aHydrate(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SW1A)));


            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return form.getW100Name();
    }*/

    /*public String getChildName(String uid) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = {FormsTable.COLUMN_SC1};

        String whereClause;
        whereClause = FormsTable.COLUMN_UID + "=?  ";

        String[] whereArgs = {uid};

        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " ASC";

        Form form = null;
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
                form = new Form();
                form.sC1Hydrate(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SC1)));


            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return form.getC100Name();
    }*/


    public int syncfollowups_sche(JSONArray followupsList) throws JSONException {

        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);

        db.delete(FollowupsScheTable.TABLE_NAME, null, null);

        int insertCount = 0;

        for (int i = 0; i < followupsList.length(); i++) {

            JSONObject jsonObjectFollowup = followupsList.getJSONObject(i);

            FollowUpsSche followupsSche = new FollowUpsSche();
            followupsSche.Sync(jsonObjectFollowup);

            ContentValues values = new ContentValues();
            values.put(FollowupsScheTable.COLUMN_FORM_COLID, followupsSche.getForm_colid().trim());
            values.put(FollowupsScheTable.COLUMN_MEMBER_ID, followupsSche.getMemberid().trim());
            values.put(FollowupsScheTable.COLUMN_FP_CODE, followupsSche.getFpcode().trim());
            values.put(FollowupsScheTable.COLUMN_FP_ID, followupsSche.getFpid().trim());
            values.put(FollowupsScheTable.COLUMN_HA01, followupsSche.getHa01().trim());
            values.put(FollowupsScheTable.COLUMN_HA09, followupsSche.getHa09().trim());
            values.put(FollowupsScheTable.COLUMN_HA11, followupsSche.getHa11().trim());
            values.put(FollowupsScheTable.COLUMN_HA12, followupsSche.getHa12().trim());
            values.put(FollowupsScheTable.COLUMN_HA12A, followupsSche.getHa12a().trim());
            values.put(FollowupsScheTable.COLUMN_PA01, followupsSche.getPa01().trim());
            values.put(FollowupsScheTable.COLUMN_PA01A, followupsSche.getPa01a().trim());
            values.put(FollowupsScheTable.COLUMN_PA01B, followupsSche.getPa01b().trim());
            values.put(FollowupsScheTable.COLUMN_FP_DATE, followupsSche.getFp_date().trim());
            values.put(FollowupsScheTable.COLUMN_FP_DONE, "");

            long rowID = db.insertOrThrow(FollowupsScheTable.TABLE_NAME, null, values);

            if (rowID != -1) insertCount++;
        }

        db.close();

        return insertCount;
    }


    public List<FollowUpsSche> getAllFollowUpsSche() throws JSONException {

        // String sysdate =  spDateT.substring(0, 8).trim()
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause = null;
        String[] whereArgs = null;
//        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy = FollowupsScheTable.COLUMN_FP_DATE + " ASC";

        List<FollowUpsSche> allFollowupsSche = new ArrayList<>();
        c = db.query(
                FollowupsScheTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            allFollowupsSche.add(new FollowUpsSche().Hydrate(c));
        }

        c.close();

        db.close();

        return allFollowupsSche;
    }

    public List<FollowUpsSche> getFollowUpsScheByDistrict(String district) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause = FollowupsScheTable.COLUMN_HA09 + " =? ";
        String[] whereArgs = {district};
        String groupBy = null;
        String having = null;

        String orderBy = FollowupsScheTable.COLUMN_FP_DATE + " ASC";

        List<FollowUpsSche> allFollowupsSche = new ArrayList<>();
        c = db.query(
                FollowupsScheTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            allFollowupsSche.add(new FollowUpsSche().Hydrate(c));
        }

        c.close();

        db.close();

        return allFollowupsSche;
    }


    public List<FollowUpsSche> getFollowUpsScheByMemberID(String memberid) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause = FollowupsScheTable.COLUMN_MEMBER_ID + " like ? ";
        String[] whereArgs = {"%" + memberid + "%"};
        String groupBy = null;
        String having = null;

        String orderBy = FollowupsScheTable.COLUMN_ID + " DESC";

        List<FollowUpsSche> allFollowupsSche = new ArrayList<>();
        c = db.query(
                FollowupsScheTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            allFollowupsSche.add(new FollowUpsSche().Hydrate(c));
        }

        c.close();

        db.close();

        return allFollowupsSche;
    }

    public List<FollowUpsSche> getFollowUpsScheByRound(int round) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause = FollowupsScheTable.COLUMN_FP_CODE + " = ? ";
        String[] whereArgs = {String.valueOf(round)};
        String groupBy = null;
        String having = null;

        String orderBy = FollowupsScheTable.COLUMN_FP_DATE + " ASC";

        List<FollowUpsSche> allFollowupsSche = new ArrayList<>();
        c = db.query(
                FollowupsScheTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            allFollowupsSche.add(new FollowUpsSche().Hydrate(c));
        }

        c.close();

        db.close();

        return allFollowupsSche;
    }


}