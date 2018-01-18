package com.diary.main.home.calendar

import com.diary.BasePresenter
import com.diary.BaseView

/**
 * Created by root on 1/17/18.
 */
interface CalendarContract {

    interface Presenter : BasePresenter {
        fun stop()
    }

    interface View : BaseView<Presenter> {

    }
}