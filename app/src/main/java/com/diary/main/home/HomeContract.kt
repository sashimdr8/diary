package com.diary.main.home

import com.diary.BasePresenter
import com.diary.BaseView
import com.diary.data.model.Diary
import com.yarolegovich.slidingrootnav.SlidingRootNav

/**
 * Created by brain on 12/6/17.
 */
interface HomeContract {

    interface Presenter : BasePresenter {
        fun stop()
    }

    interface View : BaseView<Presenter> {

        fun setSlidingRootNav(slidingRootNav: SlidingRootNav)
    }

    interface OnClickCallback {
        fun onOptionClicked(position: Int)

        fun onItemClicked(diary : Diary)
    }
}