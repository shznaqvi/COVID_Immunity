package edu.aku.hassannaqvi.covidimmunity.models

import android.database.Cursor
import edu.aku.hassannaqvi.covidimmunity.contracts.TableContracts.ClustersTable
import org.apache.commons.lang3.StringUtils
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by hassan.naqvi on 11/30/2016.
 */
class Clusters {
    var ID: Long = 0
    var districtName: String = StringUtils.EMPTY
    var districtCode: String = StringUtils.EMPTY
    var cityName: String = StringUtils.EMPTY
    var cityCode: String = StringUtils.EMPTY
    var clusterNo: String = StringUtils.EMPTY

    constructor() {
        // Default Constructor
    }

    @Throws(JSONException::class)
    fun sync(jsonObject: JSONObject): Clusters {
        districtName = jsonObject.getString(ClustersTable.COLUMN_DISTRICT_NAME)
        districtCode = jsonObject.getString(ClustersTable.COLUMN_DISTRICT_CODE)
        cityName = jsonObject.getString(ClustersTable.COLUMN_CITY_NAME)
        cityCode = jsonObject.getString(ClustersTable.COLUMN_CITY_CODE)
        clusterNo = jsonObject.getString(ClustersTable.COLUMN_CLUSTER_NO)
        return this
    }

    fun hydrate(cursor: Cursor): Clusters {
        ID = cursor.getLong(cursor.getColumnIndex(ClustersTable.COLUMN_ID))
        districtName = cursor.getString(cursor.getColumnIndex(ClustersTable.COLUMN_DISTRICT_NAME))
        districtCode = cursor.getString(cursor.getColumnIndex(ClustersTable.COLUMN_DISTRICT_CODE))
        cityName = cursor.getString(cursor.getColumnIndex(ClustersTable.COLUMN_CITY_NAME))
        cityCode = cursor.getString(cursor.getColumnIndex(ClustersTable.COLUMN_CITY_CODE))
        clusterNo = cursor.getString(cursor.getColumnIndex(ClustersTable.COLUMN_CLUSTER_NO))
        return this
    }


}