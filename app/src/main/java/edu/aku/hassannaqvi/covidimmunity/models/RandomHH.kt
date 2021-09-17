package edu.aku.hassannaqvi.covidimmunity.models

import android.database.Cursor
import edu.aku.hassannaqvi.covidimmunity.contracts.TableContracts.RandomTable
import org.apache.commons.lang3.StringUtils
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by hassan.naqvi on 11/30/2016.
 */
class RandomHH {
    var ID: Long = 0
    var sno: String = StringUtils.EMPTY
    var clusterNo: String = StringUtils.EMPTY
    var hhno: String = StringUtils.EMPTY
    var headhh: String = StringUtils.EMPTY

    constructor() {
        // Default Constructor
    }

    @Throws(JSONException::class)
    fun sync(jsonObject: JSONObject): RandomHH {
        ID = jsonObject.getLong(RandomTable.COLUMN_ID)
        sno = jsonObject.getString(RandomTable.COLUMN_SNO)
        clusterNo = jsonObject.getString(RandomTable.COLUMN_CLUSTER_NO)
        hhno = jsonObject.getString(RandomTable.COLUMN_HH_NO)
        headhh = jsonObject.getString(RandomTable.COLUMN_HEAD_HH)
        return this
    }

    fun hydrate(cursor: Cursor): RandomHH {
        ID = cursor.getLong(cursor.getColumnIndex(RandomTable.COLUMN_ID))
        sno = cursor.getString(cursor.getColumnIndex(RandomTable.COLUMN_SNO))
        clusterNo = cursor.getString(cursor.getColumnIndex(RandomTable.COLUMN_CLUSTER_NO))
        hhno = cursor.getString(cursor.getColumnIndex(RandomTable.COLUMN_HH_NO))
        headhh = cursor.getString(cursor.getColumnIndex(RandomTable.COLUMN_HEAD_HH))
        return this
    }


}