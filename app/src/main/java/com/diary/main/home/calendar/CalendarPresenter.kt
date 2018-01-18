package com.diary.main.home.calendar

import com.diary.AppComponent

/**
 * Created by root on 1/17/18.
 */
class CalendarPresenter : CalendarContract.Presenter {

    private var component: AppComponent
    private  var view: CalendarContract.View

    constructor(component: AppComponent, view: CalendarContract.View) {
        this.component = component
        this.view = view
        this.view.setPresenter(this)
    }


    override fun stop() {
    }

    override fun start() {
    }



}