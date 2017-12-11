package com.diary.data.model

import android.support.annotation.DrawableRes


/**
 * Created by brain on 12/11/17.
 */
class Emoji {

    constructor(@DrawableRes drawableRes: Int, name: String) {
        this.drawableRes = drawableRes
        this.name = name
    }

    @DrawableRes
    var drawableRes: Int = 0
    var name: String? = null

}