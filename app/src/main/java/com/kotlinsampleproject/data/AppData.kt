package com.kotlinsampleproject.data

import com.kotlinsampleproject.data.local.LocalRepo
import com.kotlinsampleproject.data.remote.RemoteRepo
import javax.inject.Inject

/**
 * Created by brain on 12/5/17.
 */
class AppData @Inject
        internal  constructor(private val localRepo: LocalRepo,
                              private val remoteRepo: RemoteRepo){


}