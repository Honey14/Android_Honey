package com.example.android.quakereport;

public class EarthquakeObject {
    private double mag;
    private String place;
    private long time;

    public EarthquakeObject(double mEarthQuakeSize, String mLocation, long mDate) {
        this.mag = mEarthQuakeSize;
        this.place = mLocation;
        this.time = mDate;
    }

    public double getmEarthQuakeSize() {
        return mag;
    }

    public String getmLocation() {
        return place;
    }

    public long getmDate() {
        return time;
    }

}
