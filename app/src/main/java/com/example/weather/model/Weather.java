package com.example.weather.model;

public class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;

    public void setMain(String main) {
        this.main = main;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMain() {
        return main;
    }

    public String getIcon() {
        return icon;
    }

    public String getDescription() {
        return description;
    }

}
