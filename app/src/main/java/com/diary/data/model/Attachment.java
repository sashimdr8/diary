package com.diary.data.model;

/**
 * Created by root on 1/19/18.
 */

public class Attachment {

    private int type; // 0 for image , 1 for audio
    private String image;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
