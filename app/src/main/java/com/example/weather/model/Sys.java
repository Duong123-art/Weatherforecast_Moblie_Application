package com.example.weather.model;

public class Sys {
    private float type;
    private int id;
    private String country;
    private  int sunset;
    private  int sunrise;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setType(float type) {
        this.type = type;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSunset() {
        return sunset;
    }

    public int getSunrise() {
        return sunrise;
    }

    public float getType() {
        return type;
    }

}
