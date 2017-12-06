package com.kotlinsampleproject.data.model

/**
 * Created by brain on 12/5/17.
 */

class BaseResponse<T> {
    private  var code: Int = 0
    private var message: String? = null
    private var data: T? = null

    fun getCode(): Int {
        return code
    }

    fun setCode(code: Int) {
        this.code = code
    }

    fun getMessage(): String? {
        return message
    }

    fun setMessage(message: String) {
        this.message = message
    }

    fun getData(): T? {
        return data
    }

    fun setData(data: T) {
        this.data = data
    }
}
