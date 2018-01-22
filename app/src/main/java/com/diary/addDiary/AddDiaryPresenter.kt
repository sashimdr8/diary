package com.diary.addDiary

import android.app.Activity
import com.diary.AppComponent
import com.diary.data.model.Attachment
import com.diary.data.model.Diary
import com.diary.data.model.Emoji
import com.esafirm.imagepicker.features.ImagePicker
import io.realm.RealmList

/**
 * Created by brain on 12/8/17.
 */
class AddDiaryPresenter : AddDiaryContract.Presenter {
    private val activity: Activity

    companion object {
        val REQUEST_CODE_PICKER: Int = 123
    }


    private var component: AppComponent
    private var view: AddDiaryContract.View

    constructor(activity: Activity, component: AppComponent, view: AddDiaryContract.View) {
        this.activity = activity
        this.component = component
        this.view = view
        this.view.setPresenter(this)
    }


    override fun stop() {
    }

    override fun start() {
    }

    override fun startImagePicker() {
        ImagePicker.create(activity)
                .folderMode(true) // folder mode (false by default)
                .folderTitle("Folder") // folder selection title
                .imageTitle("Tap to select") // image selection title
                .single() // single mode
                .multi() // multi mode (default mode)
                .limit(1) // max images can be selected (999 by default)
                .showCamera(true) // show camera or not (true by default)
                .imageDirectory("Camera") // directory name for captured image  ("Camera" folder by default)
                .start(REQUEST_CODE_PICKER)
    }

    override fun saveDiary(title: String, diary: String,
                           selectedEmoji: Emoji, attachments: List<Attachment>) {
        component.data().saveDiary(title, diary, selectedEmoji ,attachments)
        view.showDiarySaveSuccess()

    }

    override fun saveDiary(id: Long, title: String, diary: String
                           , selectedEmoji: Emoji, attachments: List<Attachment>) {
        component.data().saveDiary(id, title, diary, selectedEmoji , attachments)
        view.showDiarySaveSuccess()
    }


    override fun getDiary(diaryId: Long) {
        val diary: Diary = component.data().getDiary(diaryId)
        view.showDiaryDetails(diary)
    }
}