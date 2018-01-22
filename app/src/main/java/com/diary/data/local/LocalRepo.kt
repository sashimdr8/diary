package com.diary.data.local

import android.graphics.Color
import com.diary.data.local.dao.DiaryDao
import com.diary.data.model.Attachment
import com.diary.data.model.Diary
import com.diary.data.model.Emoji
import io.realm.Case
import io.realm.RealmList
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

    fun saveDiary(title: String, diary: String, selectedEmoji: Emoji ,
                  attachments: List<Attachment>) {
        val attachmentsRealmList =  RealmList<Attachment>()
        attachmentsRealmList.addAll(attachments)
        diaryDao.saveDiary(Diary().setData(
                System.currentTimeMillis(),
                title,
                diary,
                "san-serif",
                Color.parseColor("#ededed"),
                "Jan 24",
                "5:00pm",
                selectedEmoji,
                attachmentsRealmList
        ))
    }

    fun saveDiary(id: Long, title: String, diary: String, selectedEmoji: Emoji,
                  attachments: List<Attachment>) {
        val attachmentsRealmList =  RealmList<Attachment>()
        attachmentsRealmList.addAll(attachments)
        diaryDao.saveDiary(Diary().setData(id,
                title, diary, "san-serif", Color.parseColor("#ededed"),
                "Jan 24", "5:00pm", selectedEmoji, attachmentsRealmList))
    }

    fun getAllDiary(): List<Diary> {
        return diaryDao.allDiary
    }

    fun getDiary(diaryId: Long): Diary {
        return diaryDao.getDiary(diaryId)

    }


}