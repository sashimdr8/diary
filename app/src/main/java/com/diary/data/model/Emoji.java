package com.diary.data.model;

import android.support.annotation.DrawableRes;

import org.parceler.Parcel;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by brain on 12/12/17.
 */


public class Emoji extends RealmObject {

    @DrawableRes
    private int drawableRes;
    private String name;
    @PrimaryKey
    private int id;


    public Emoji setData(@DrawableRes int drawableRes, String name, int id) {
        this.drawableRes = drawableRes;
        this.name = name;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
