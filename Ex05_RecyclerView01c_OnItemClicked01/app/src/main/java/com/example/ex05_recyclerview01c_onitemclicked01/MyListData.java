package com.example.ex05_recyclerview01c_onitemclicked01;

public class MyListData {
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public MyListData(String desc, int imgId){
        description=desc;
        this.imgId = imgId;
    }

    private String description;
    private int imgId;

}
