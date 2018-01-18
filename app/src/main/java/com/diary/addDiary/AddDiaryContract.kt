package com.diary.addDiary

import com.diary.BasePresenter
import com.diary.BaseView
import com.diary.data.model.Diary
import com.diary.data.model.Emoji

/**
 * Created by brain on 12/8/17.
 */
interface AddDiaryContract {

    interface Presenter : BasePresenter {
        fun stop()
        fun saveDiary(id: Long, text: String, text1: String, selectedEmoji: Emoji)
        fun saveDiary(text: String, text1: String, selectedEmoji: Emoji)
        fun getDiary(diaryId: Long)
    }

    interface View : BaseView<Presenter>, OnClickCallback {
        fun showDiarySaveSuccess()
        fun showDiaryDetails(diary: Diary)

    }


    interface OnClickCallback {
        fun onEmojiClicked(position: Emoji)
    }

}
