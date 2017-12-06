package com.kotlinsampleproject.data.remote

import com.google.gson.Gson
import javax.inject.Inject

/**
 * Created by brain on 12/5/17.
 */

@SuppressWarnings("unchecked")
class RemoteRepo @Inject constructor(private val api:Api,private val gson: Gson) {
}