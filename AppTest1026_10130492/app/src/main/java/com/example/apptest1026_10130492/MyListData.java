package com.example.apptest1026_10130492;

public class MyListData {
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

     String description;

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

     int ImageId;
    public MyListData(String desc, int img){
        description = desc;
        ImageId = img;
    }
}
