package com.diary.main.home.timeline

import com.diary.BasePresenter
import com.diary.BaseView
import com.diary.main.home.HomeContract

/**
 * Created by brain on 12/8/17.
 */
interface TimelineContract {
    interface Presenter : BasePresenter {
        fun stop()
    }

    interface View : BaseView<Presenter>, HomeContract.OnClickCallback {

    }
}