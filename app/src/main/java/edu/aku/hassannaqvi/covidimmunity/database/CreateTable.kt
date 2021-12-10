package edu.aku.hassannaqvi.covidimmunity.database

import edu.aku.hassannaqvi.covidimmunity.contracts.TableContracts.*
import edu.aku.hassannaqvi.covidimmunity.core.MainApp.PROJECT_NAME

object CreateTable {

    const val DATABASE_NAME = "$PROJECT_NAME.db"
    const val DATABASE_COPY = "${PROJECT_NAME}_copy.db"
    const val DATABASE_VERSION = 1

    const val SQL_CREATE_FORMS = ("CREATE TABLE "
            + FormsTable.TABLE_NAME + "("
            + FormsTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FormsTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FormsTable.COLUMN_UID + " TEXT,"
            + FormsTable.COLUMN_USERNAME + " TEXT,"
            + FormsTable.COLUMN_SYSDATE + " TEXT,"
            + FormsTable.COLUMN_ISTATUS + " TEXT,"
            + FormsTable.COLUMN_DEVICEID + " TEXT,"
            + FormsTable.COLUMN_DEVICETAGID + " TEXT,"
            + FormsTable.COLUMN_SYNCED + " TEXT,"
            + FormsTable.COLUMN_SYNCED_DATE + " TEXT,"
            + FormsTable.COLUMN_APPVERSION + " TEXT,"
            + FormsTable.COLUMN_SHA + " TEXT,"
            + FormsTable.COLUMN_SPA + " TEXT,"
            + FormsTable.COLUMN_SPB + " TEXT,"
            + FormsTable.COLUMN_SPC + " TEXT"
            + " );"
            )

    const val SQL_CREATE_USERS = ("CREATE TABLE "
            + UsersTable.TABLE_NAME + "("
            + UsersTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsersTable.COLUMN_USERNAME + " TEXT,"
            + UsersTable.COLUMN_PASSWORD + " TEXT,"
            + UsersTable.COLUMN_FULLNAME + " TEXT"
            + " );"
            )

    const val SQL_CREATE_VERSIONAPP = ("CREATE TABLE "
            + VersionTable.TABLE_NAME + " ("
            + VersionTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + VersionTable.COLUMN_VERSION_CODE + " TEXT, "
            + VersionTable.COLUMN_VERSION_NAME + " TEXT, "
            + VersionTable.COLUMN_PATH_NAME + " TEXT "
            + ");"
            )

    const val SQL_CREATE_FOLLOWUPS = ("CREATE TABLE "
            + FollowupTable.TABLE_NAME + "("
            + FollowupTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FollowupTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FollowupTable.COLUMN_UID + " TEXT,"
            + FollowupTable.COLUMN_UUID + " TEXT,"
            + FollowupTable.COLUMN_USERNAME + " TEXT,"
            + FollowupTable.COLUMN_SYSDATE + " TEXT,"
            + FollowupTable.COLUMN_ISTATUS + " TEXT,"
            + FollowupTable.COLUMN_DEVICEID + " TEXT,"
            + FollowupTable.COLUMN_DEVICETAGID + " TEXT,"
            + FollowupTable.COLUMN_SYNCED + " TEXT,"
            + FollowupTable.COLUMN_SYNCED_DATE + " TEXT,"
            + FollowupTable.COLUMN_APPVERSION + " TEXT,"
            + FollowupTable.COLUMN_SFHA + " TEXT,"
            + FollowupTable.COLUMN_SFPA + " TEXT,"
            + FollowupTable.COLUMN_SFPC + " TEXT"
            + " );"
            )

    const val SQL_CREATE_FOLLOWUPS_SCHE = ("CREATE TABLE "
            + FollowupsScheTable.TABLE_NAME + "("
            + FollowupsScheTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FollowupsScheTable.COLUMN_FORM_COLID + " TEXT,"
            + FollowupsScheTable.COLUMN_MEMBER_ID + " TEXT,"
            + FollowupsScheTable.COLUMN_FP_CODE + " TEXT,"
            + FollowupsScheTable.COLUMN_FP_ID + " TEXT,"
            + FollowupsScheTable.COLUMN_HA01 + " TEXT,"
            + FollowupsScheTable.COLUMN_HA09 + " TEXT,"
            + FollowupsScheTable.COLUMN_HA11 + " TEXT,"
            + FollowupsScheTable.COLUMN_HA12 + " TEXT,"
            + FollowupsScheTable.COLUMN_HA12A + " TEXT,"
            + FollowupsScheTable.COLUMN_PA01 + " TEXT,"
            + FollowupsScheTable.COLUMN_PA01A + " TEXT,"
            + FollowupsScheTable.COLUMN_PA01B + " TEXT,"
            + FollowupsScheTable.COLUMN_FP_DATE + " TEXT"
            + " );"
            )
}