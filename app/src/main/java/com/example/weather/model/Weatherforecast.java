package com.example.weather.model;

import java.util.List;

public class Weatherforecast {
    private Coord coord;
    private List<Weather> weather;
    private  String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private Sys sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getName() {
        return name;
    }

    public Sys getSys() {
        return sys;
    }

    public String getBase() {
        return base;
    }

    public Main getMain() {
        return main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public int getVisibility() {
        return visibility;
    }

    public int getTimezone() {
        return timezone;
    }

    public Coord getCoord() {
        return coord;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

}


