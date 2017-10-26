package com.jinqihang.traveler.javabean;

/**
 * Created by Administrator on 2017/10/13 0013.
 */

public class FlightBean {
    private String startTime;
    private String endTime;
    private String startAirport;
    private String endAirport;
    private String airlineCompany;
    private String plane;
    private String price;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartAirport() {
        return startAirport;
    }

    public void setStartAirport(String startAirport) {
        this.startAirport = startAirport;
    }

    public String getEndAirport() {
        return endAirport;
    }

    public void setEndAirport(String endAirport) {
        this.endAirport = endAirport;
    }

    public String getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(String startPlane) {
        this.airlineCompany = startPlane;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String endPlane) {
        this.plane = endPlane;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
