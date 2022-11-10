package com.example.ex05_recyclerview01a_10130492;

public class MyListData {
    public String getDescription() {
        return description;
    }

    public int getImgID() {
        return imgID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    private String description;
    private int imgID;

    public MyListData(String desc, int id) {
        description = desc;
        imgID = id;
    }
}
