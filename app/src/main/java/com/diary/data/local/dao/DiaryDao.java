package com.diary.data.local.dao;

import android.support.annotation.NonNull;

import com.diary.data.model.Diary;

import io.realm.Realm;

/**
 * Created by brain on 12/12/17.
 */

public class DiaryDao {

    private Realm mRealm;
    Diary diary;

    public DiaryDao(@NonNull Realm realm) {
        mRealm = realm;
    }

}