package com.example.appquiz_10130492_2022114;

public class BookStore {
    public BookStore(String name, String cityName, String closeDay) {
        this.name = name;
        this.cityName = cityName;
        this.closeDay = closeDay;
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

    public String getCloseDay() {
        return closeDay;
    }

    public void setCloseDay(String closeDay) {
        this.closeDay = closeDay;
    }

    private String name;
    private String cityName;
    private String closeDay;
}
