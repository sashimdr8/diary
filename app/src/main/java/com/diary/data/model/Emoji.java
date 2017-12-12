package com.diary.data.model;

import android.support.annotation.DrawableRes;

import io.realm.RealmObject;

/**
 * Created by brain on 12/12/17.
 */

public class Emoji extends RealmObject {

    @DrawableRes
    private int drawableRes;
    private String name;


    public Emoji setData(@DrawableRes int drawableRes, String name) {
        this.drawableRes = drawableRes;
        this.name = name;
        return this;
    }

    public int getDrawableRes() {
        return drawableRes;
    }

    public void setDrawableRes(int drawableRes) {
        this.drawableRes = drawableRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
