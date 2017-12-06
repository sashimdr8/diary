package com.diary.main.home

import com.diary.AppComponent
import com.yarolegovich.slidingrootnav.SlidingRootNav

/**
 * Created by brain on 12/6/17.
 */
class HomePresenter : HomeContract.Presenter {

    private lateinit var component: AppComponent
    private lateinit var view: HomeContract.View
    private lateinit var slidingRootNav: SlidingRootNav

    constructor(component: AppComponent, view: HomeContract.View,
                slidingRootNav: SlidingRootNav) {
        this.component = component
        this.view = view
        this.slidingRootNav = slidingRootNav
        this.view.setPresenter(this)
        this.view.setSlidingRootNav(slidingRootNav)
    }


    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



}