package com.jinqihang.traveler.javabean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/19 0019.
 */

public class BaseModle {
    String message;
    String code;
    String data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<DataBean> getList() {
        return list;
    }

    public void setList(List<DataBean> list) {
        this.list = list;
    }

    List<DataBean> list;
    public class DataBean{
        int ZoneID;
        int ZoneType;
        String ZoneName;
        int ZoneCode;
        int ParentID;
        int PopularLevel;
        String CreateTime;

        public int getZoneID() {
            return ZoneID;
        }

        public void setZoneID(int zoneID) {
            ZoneID = zoneID;
        }

        public int getZoneType() {
            return ZoneType;
        }

        public void setZoneType(int zoneType) {
            ZoneType = zoneType;
        }

        public String getZoneName() {
            return ZoneName;
        }

        public void setZoneName(String zoneName) {
            ZoneName = zoneName;
        }

        public int getZoneCode() {
            return ZoneCode;
        }

        public void setZoneCode(int zoneCode) {
            ZoneCode = zoneCode;
        }

        public int getParentID() {
            return ParentID;
        }

        public void setParentID(int parentID) {
            ParentID = parentID;
        }

        public int getPopularLevel() {
            return PopularLevel;
        }

        public void setPopularLevel(int popularLevel) {
            PopularLevel = popularLevel;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String createTime) {
            CreateTime = createTime;
        }
    }

}
