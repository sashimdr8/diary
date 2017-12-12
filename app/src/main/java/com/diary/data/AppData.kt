package com.diary.data

import com.diary.data.local.LocalRepo
import com.diary.data.model.Diary
import com.diary.data.model.Emoji
import com.diary.data.remote.RemoteRepo
import javax.inject.Inject

/**
 * Created by brain on 12/5/17.
 */
class AppData @Inject
internal constructor(private val localRepo: LocalRepo,
                     private val remoteRepo: RemoteRepo) {


    fun saveDiary(title: String, diary: String, selectedEmoji: Emoji) {

        this.localRepo.saveDiary(title, diary, selectedEmoji)
    }

    fun getAllDiary(): List<Diary> {
        return this.localRepo.getAllDiary()
    }


}