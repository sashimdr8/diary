package com.diary.addDiary

import com.diary.BasePresenter
import com.diary.BaseView

/**
 * Created by brain on 12/8/17.
 */
interface AddDiaryContract {

    interface Presenter : BasePresenter {
        fun stop()
    }

    interface View : BaseView<Presenter> , OnClickCallback {

    }


    interface OnClickCallback {
        fun onEmojiClicked(position: Int)
    }

}
