package com.jinqihang.traveler.javabean;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/10/20 0020.
 */

public class FlightModel implements Serializable{
    public String FlightDynamicID;
    public String FlightID;
    public String FlightCode;
    public String DepartDate;
    public String PlaneModel;
    public String FlightState;
    public String RealDepartTime;
    public String DepartTerminal;
    public String DepartCheckinCounter;
    public String DepartBoardingCounter;
    public String RealArriveTime;
    public String ArriveTerminal;
    public String RealDuration;
    public String TransferTerminals;
    public String TransferCheckinCounters;
    public String TransferBoardingCounters;
    public String RealDepartTransferTimes;
    public String RealArriveTransferTimes;
    public String UpdateTime;
    public String AirlineID;
    public String DepartCityID;
    public String DepartAirportID;
    public String DepartTime;
    public String ArriveCityID;
    public String ArriveAirportID;
    public String ArriveTime;
    public String TransferAirportIDs;
    public String TransferDepartTimes;
    public String TransferArriveTimes;
    public String Period;
    public String FoodPeriod;
    public String Duration;
    public String Accuracy;
    public String ArriveCity;
    public String DepartCity;
    public String AirlineFullName;
    public String AirlineShortName;
    public String DepartAirport;
    public String ArriveAirport;
    public String PlaneModelName;

    public FlightModel(JSONObject object){
        try {
            FlightDynamicID = object.getString("FlightDynamicID");
            FlightID = object.getString("FlightID");
            FlightCode = object.getString("FlightCode");
            DepartDate = object.getString("DepartDate");
            PlaneModel = object.getString("PlaneModel");
            FlightState = object.getString("FlightState");
            RealDepartTime = object.getString("RealDepartTime");
            DepartTerminal = object.getString("DepartTerminal");
            DepartCheckinCounter = object.getString("DepartCheckinCounter");
            DepartBoardingCounter = object.getString("DepartBoardingCounter");
            RealArriveTime = object.getString("RealArriveTime");
            ArriveTerminal = object.getString("ArriveTerminal");
            RealDuration = object.getString("RealDuration");
            TransferTerminals = object.getString("TransferTerminals");
            TransferCheckinCounters = object.getString("TransferCheckinCounters");
            TransferBoardingCounters = object.getString("TransferBoardingCounters");
            RealDepartTransferTimes = object.getString("RealDepartTransferTimes");
            RealArriveTransferTimes = object.getString("RealArriveTransferTimes");
            UpdateTime = object.getString("UpdateTime");
            AirlineID = object.getString("AirlineID");
            DepartCityID = object.getString("DepartCityID");
            DepartAirportID = object.getString("DepartAirportID");
            DepartTime = object.getString("DepartTime");
            ArriveCityID = object.getString("ArriveCityID");
            ArriveAirportID = object.getString("ArriveAirportID");
            ArriveTime = object.getString("ArriveTime");
            TransferAirportIDs = object.getString("TransferAirportIDs");
            TransferDepartTimes = object.getString("TransferDepartTimes");
            TransferArriveTimes = object.getString("TransferArriveTimes");
            Period = object.getString("Period");
            FoodPeriod = object.getString("FoodPeriod");
            Duration = object.getString("Duration");
            Accuracy = object.getString("Accuracy");
            ArriveCity = object.getString("ArriveCity");
            DepartCity = object.getString("DepartCity");
            AirlineFullName = object.getString("AirlineFullName");
            AirlineShortName = object.getString("AirlineShortName");
            DepartAirport = object.getString("DepartAirport");
            ArriveAirport = object.getString("ArriveAirport");
            PlaneModelName = object.getString("PlaneModelName");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getFlightDynamicID() {
        return FlightDynamicID;
    }

    public void setFlightDynamicID(String flightDynamicID) {
        FlightDynamicID = flightDynamicID;
    }

    public String getFlightID() {
        return FlightID;
    }

    public void setFlightID(String flightID) {
        FlightID = flightID;
    }

    public String getFlightCode() {
        return FlightCode;
    }

    public void setFlightCode(String flightCode) {
        FlightCode = flightCode;
    }

    public String getDepartDate() {
        return DepartDate;
    }

    public void setDepartDate(String departDate) {
        DepartDate = departDate;
    }

    public String getPlaneModel() {
        return PlaneModel;
    }

    public void setPlaneModel(String planeModel) {
        PlaneModel = planeModel;
    }

    public String getFlightState() {
        return FlightState;
    }

    public void setFlightState(String flightState) {
        FlightState = flightState;
    }

    public String getRealDepartTime() {
        return RealDepartTime;
    }

    public void setRealDepartTime(String realDepartTime) {
        RealDepartTime = realDepartTime;
    }

    public String getDepartTerminal() {
        return DepartTerminal;
    }

    public void setDepartTerminal(String departTerminal) {
        DepartTerminal = departTerminal;
    }

    public String getDepartChechinCounter() {
        return DepartCheckinCounter;
    }

    public void setDepartChechinCounter(String departChechinCounter) {
        DepartCheckinCounter = departChechinCounter;
    }

    public String getDepartBoardingCounter() {
        return DepartBoardingCounter;
    }

    public void setDepartBoardingCounter(String departBoardingCounter) {
        DepartBoardingCounter = departBoardingCounter;
    }

    public String getRealArriveTime() {
        return RealArriveTime;
    }

    public void setRealArriveTime(String realArriveTime) {
        RealArriveTime = realArriveTime;
    }

    public String getArriveTerminal() {
        return ArriveTerminal;
    }

    public void setArriveTerminal(String arriveTerminal) {
        ArriveTerminal = arriveTerminal;
    }

    public String getRealDuration() {
        return RealDuration;
    }

    public void setRealDuration(String realDuration) {
        RealDuration = realDuration;
    }

    public String getTransferTerminals() {
        return TransferTerminals;
    }

    public void setTransferTerminals(String transferTerminals) {
        TransferTerminals = transferTerminals;
    }

    public String getTransferCheckinCounters() {
        return TransferCheckinCounters;
    }

    public void setTransferCheckinCounters(String transferCheckinCounters) {
        TransferCheckinCounters = transferCheckinCounters;
    }

    public String getTransferBoardingCounters() {
        return TransferBoardingCounters;
    }

    public void setTransferBoardingCounters(String transferBoardingCounters) {
        TransferBoardingCounters = transferBoardingCounters;
    }

    public String getRealDepartTransferTimes() {
        return RealDepartTransferTimes;
    }

    public void setRealDepartTransferTimes(String realDepartTransferTimes) {
        RealDepartTransferTimes = realDepartTransferTimes;
    }

    public String getRealArriveTransferTimes() {
        return RealArriveTransferTimes;
    }

    public void setRealArriveTransferTimes(String realArriveTransferTimes) {
        RealArriveTransferTimes = realArriveTransferTimes;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String updateTime) {
        UpdateTime = updateTime;
    }

    public String getAirlineID() {
        return AirlineID;
    }

    public void setAirlineID(String airlineID) {
        AirlineID = airlineID;
    }

    public String getDepartCityID() {
        return DepartCityID;
    }

    public void setDepartCityID(String departCityID) {
        DepartCityID = departCityID;
    }

    public String getDepartAirportID() {
        return DepartAirportID;
    }

    public void setDepartAirportID(String departAirportID) {
        DepartAirportID = departAirportID;
    }

    public String getDepartTime() {
        return DepartTime;
    }

    public void setDepartTime(String departTime) {
        DepartTime = departTime;
    }

    public String getArriveCityID() {
        return ArriveCityID;
    }

    public void setArriveCityID(String arriveCityID) {
        ArriveCityID = arriveCityID;
    }

    public String getArriveAirportID() {
        return ArriveAirportID;
    }

    public void setArriveAirportID(String arriveAirportID) {
        ArriveAirportID = arriveAirportID;
    }

    public String getArriveTime() {
        return ArriveTime;
    }

    public void setArriveTime(String arriveTime) {
        ArriveTime = arriveTime;
    }

    public String getTransferAirportIDs() {
        return TransferAirportIDs;
    }

    public void setTransferAirportIDs(String transferAirportIDs) {
        TransferAirportIDs = transferAirportIDs;
    }

    public String getTransferDepartTimes() {
        return TransferDepartTimes;
    }

    public void setTransferDepartTimes(String transferDepartTimes) {
        TransferDepartTimes = transferDepartTimes;
    }

    public String getTransferArriveTimes() {
        return TransferArriveTimes;
    }

    public void setTransferArriveTimes(String transferArriveTimes) {
        TransferArriveTimes = transferArriveTimes;
    }

    public String getPeriod() {
        return Period;
    }

    public void setPeriod(String period) {
        Period = period;
    }

    public String getFoodPeriod() {
        return FoodPeriod;
    }

    public void setFoodPeriod(String foodPeriod) {
        FoodPeriod = foodPeriod;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getAccuracy() {
        return Accuracy;
    }

    public void setAccuracy(String accuracy) {
        Accuracy = accuracy;
    }

    public String getArriveCity() {
        return ArriveCity;
    }

    public void setArriveCity(String arriveCity) {
        ArriveCity = arriveCity;
    }

    public String getDepartCity() {
        return DepartCity;
    }

    public void setDepartCity(String departCity) {
        DepartCity = departCity;
    }

    public String getAirlineFullName() {
        return AirlineFullName;
    }

    public void setAirlineFullName(String airlineFullName) {
        AirlineFullName = airlineFullName;
    }

    public String getAirlineShortName() {
        return AirlineShortName;
    }

    public void setAirlineShortName(String airlineShortName) {
        AirlineShortName = airlineShortName;
    }

    public String getDepartAirport() {
        return DepartAirport;
    }

    public void setDepartAirport(String departAirport) {
        DepartAirport = departAirport;
    }

    public String getArriveAirport() {
        return ArriveAirport;
    }

    public void setArriveAirport(String arriveAirport) {
        ArriveAirport = arriveAirport;
    }

    public String getPlaneModelName() {
        return PlaneModelName;
    }

    public void setPlaneModelName(String planeModelName) {
        PlaneModelName = planeModelName;
    }
}
