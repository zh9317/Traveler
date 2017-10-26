package com.jinqihang.traveler.javabean;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/10/18 0018.
 */

public class CityData implements Serializable{

    public String ZoneID;
    public String ZoneType;
    public String ZoneName;
    public String ParentID;
    public String PopularLevel;

    public CityData(JSONObject obj) {
        try {
            ZoneID = obj.getString("ZoneID");
            ZoneType = obj.getString("ZoneType");
            ZoneName = obj.getString("ZoneName");
            ParentID = obj.getString("ParentID");
            PopularLevel = obj.getString("PopularLevel");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getZoneID() {
        return ZoneID;
    }

    public void setZoneID(String zoneID) {
        ZoneID = zoneID;
    }

    public String getZoneType() {
        return ZoneType;
    }

    public void setZoneType(String zoneType) {
        ZoneType = zoneType;
    }

    public String getZoneName() {
        return ZoneName;
    }

    public void setZoneName(String zoneName) {
        ZoneName = zoneName;
    }

    public String getParentID() {
        return ParentID;
    }

    public void setParentID(String parentID) {
        ParentID = parentID;
    }

    public String getPopularLevel() {
        return PopularLevel;
    }

    public void setPopularLevel(String popularLevel) {
        PopularLevel = popularLevel;
    }

}
