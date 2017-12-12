package com.diary.data.local

import com.diary.data.local.dao.DiaryDao
import javax.inject.Inject

/**
 * Created by brain on 12/5/17.
 */
class LocalRepo {

    private val realmDbManager: RealmDbManager
    private val diaryDao: DiaryDao

    @Inject constructor(realmDbManager: RealmDbManager) {

        this.realmDbManager = realmDbManager
        realmDbManager.open()
        diaryDao = this.realmDbManager.createDao()

    }

}