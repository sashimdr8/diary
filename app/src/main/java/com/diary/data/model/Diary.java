package com.diary.data.model;

import android.support.annotation.ColorInt;

import io.realm.RealmObject;

/**
 * Created by brain on 12/12/17.
 */

public class Diary extends RealmObject {

    private int id;
    private String content;
    private String font;
    private @ColorInt
    int color;
    private String date;
    private String time;
    private Emoji feelings;

    public Emoji getFeelings() {
        return feelings;
    }

    public void setFeelings(Emoji feelings) {
        this.feelings = feelings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
