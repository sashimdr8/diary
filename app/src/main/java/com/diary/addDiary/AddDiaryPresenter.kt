package com.diary.addDiary

import com.diary.AppComponent
import com.diary.data.model.Emoji

/**
 * Created by brain on 12/8/17.
 */
class AddDiaryPresenter : AddDiaryContract.Presenter {

    private var component: AppComponent
    private var view: AddDiaryContract.View

    constructor(component: AppComponent, view: AddDiaryContract.View) {
        this.component = component
        this.view = view
        this.view.setPresenter(this)
    }


    override fun stop() {
    }

    override fun start() {
    }

    override fun saveDiary(title: String, diary: String, selectedEmoji: Emoji) {
        component.data().saveDiary(title, diary, selectedEmoji)
        view.showDiarySaveSuccess()

    }
}