package com.diary.data.model;

import io.realm.RealmObject;

/**
 * Created by root on 1/19/18.
 */

public class Attachment extends RealmObject {

    private int type; // 0 for image , 1 for audio
    private String filePath;

    public void setData(int type, String filePath) {
        this.type = type;
        this.filePath = filePath;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
