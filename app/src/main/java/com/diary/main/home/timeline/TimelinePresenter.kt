package com.diary.main.home.timeline

import com.diary.AppComponent
import com.diary.data.model.Diary
import com.diary.utils.Utils

/**
 * Created by brain on 12/8/17.
 */
class TimelinePresenter : TimelineContract.Presenter {
    private var component: AppComponent
    private var view: TimelineContract.View

    constructor(component: AppComponent, view: TimelineContract.View) {
        this.component = component
        this.view = view
        this.view.setPresenter(this)
    }


    override fun stop() {
    }

    override fun start() {

        var diary: List<Diary> = component.data().getAllDiary()
        if (Utils.isEmpty(diary)) {
//            view.showOptions()
        } else {
            view.showAllDiary(diary)
        }

    }
}