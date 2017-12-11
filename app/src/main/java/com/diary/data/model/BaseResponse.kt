package com.diary.data.model

/**
 * Created by brain on 12/5/17.
 */

class BaseResponse<T> {
    private  var code: Int = 0
    private var message: String? = null
    private var data: T? = null

}
