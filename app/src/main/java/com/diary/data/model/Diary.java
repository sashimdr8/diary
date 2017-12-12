package com.diary.data.model;

import android.support.annotation.ColorInt;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by brain on 12/12/17.
 */

public class Diary extends RealmObject {

    @PrimaryKey
    private long id;
    private String title;
    private String content;
    private String font;
    private @ColorInt
    int color;
    private String date;
    private String time;
    private Emoji emoji;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Emoji getEmoji() {
        return emoji;
    }

    public void setEmoji(Emoji emoji) {
        this.emoji = emoji;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Diary setData(long id, String title,
                         String content, String font, @ColorInt int color,
                         String date, String time, Emoji selectedEmoji) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.font = font;
        this.color = color;
        this.date = date;
        this.time = time;
        this.emoji = selectedEmoji;

        return this;
    }
}
