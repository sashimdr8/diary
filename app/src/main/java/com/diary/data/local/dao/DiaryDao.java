package com.diary.data.local.dao;

import android.support.annotation.NonNull;

import com.diary.data.model.Diary;


import org.jetbrains.annotations.NotNull;

import java.util.List;

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

    public void saveDiary(final Diary diary) {

        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(diary);
            }
        });

    }

    public List<Diary> getAllDiary() {
        return mRealm.where(Diary.class)
                .findAll();
    }


    public Diary getDiary(long diaryId) {
        return mRealm.where(Diary.class)
                .equalTo("id",diaryId)
                .findFirst();
    }

}