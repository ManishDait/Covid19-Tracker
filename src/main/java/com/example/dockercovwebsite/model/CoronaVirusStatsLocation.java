package com.example.dockercovwebsite.model;

public class CoronaVirusStatsLocation {
    private String Country;
    private String State;
    private int Cases;
    private int TotalCases;
    private String rising;
    private int difference;
    
    public String getCountry() {
        return Country;
    }
    public void setCountry(String country) {
        Country = country;
    }
    public String getState() {
        return State;
    }
   
    public String getRising() {
        return rising;
    }
    public void setRising(String rising) {
        this.rising = rising;
    }
    public int getDifference() {
        return difference;
    }
    public void setDifference(int difference) {
        this.difference = difference;
    }
    public void setState(String state) {
        State = state;
    }
    public int getCases() {
        return Cases;
    }
    public void setCases(int cases) {
        Cases = cases;
    }
    public int getTotalCases() {
        return TotalCases;
    }
    public void setTotalCases(int totalCases) {
        TotalCases = totalCases;
    }
    @Override
    public String toString() {
        return "CoronaVirusStatsLocation [Cases=" + Cases + ", Country=" + Country + ", State=" + State
                + ", TotalCases=" + TotalCases + ", difference=" + difference + ", rising=" + rising + "]";
    }

    
}
