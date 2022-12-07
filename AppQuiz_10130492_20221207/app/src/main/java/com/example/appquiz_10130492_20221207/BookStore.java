package com.example.appquiz_10130492_20221207;

public class BookStore {
    public BookStore(String name, String cityName, String openTime) {
        this.name = name;
        this.cityName = cityName;
        this.openTime = openTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    private String name;
    private String cityName;
    private String openTime;
}
