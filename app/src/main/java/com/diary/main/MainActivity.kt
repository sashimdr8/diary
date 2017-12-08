package com.diary.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.design.widget.FloatingActionButton
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.diary.App
import com.diary.R
import com.diary.databinding.ActivityMainBinding
import com.diary.main.DrawerAdapter.*
import com.diary.main.home.HomeFragment
import com.diary.main.home.HomePresenter
import com.yarolegovich.slidingrootnav.SlidingRootNav
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder
import java.util.*

/**
 * Created by brain on 12/5/17.
 */
class MainActivity : BaseActivity(), DrawerAdapter.OnItemSelectedListener {


    private lateinit var slidingRootNav: SlidingRootNav
    private lateinit var binding: ActivityMainBinding
    private lateinit var screenTitles: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main)

        slidingRootNav = SlidingRootNavBuilder(this)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.drawer_content)
                .withRootViewScale(.75f) //Content view's scale will be interpolated between 1f and 0.7f. Default == 0.65f;
                .withRootViewElevation(10) //Content view's elevation will be interpolated between 0 and 10dp. Default == 8.
                .withRootViewYTranslation(3)
                .inject()

        setUpDrawer()
        startHomeFragment()
    }

    private fun startHomeFragment() {
        val homeFragment = HomeFragment()
        HomePresenter(App.component(this),
                homeFragment, slidingRootNav)
        supportFragmentManager.beginTransaction()
                .replace(R.id.contentFrame, homeFragment)
                .commit()

    }


    private fun setUpDrawer() {
        screenTitles = loadScreenTitles()
        val adapter = DrawerAdapter(Arrays.asList(
                createItemFor(TYPE_HOME).setChecked(true),
                createItemFor(TYPE_DIARY),
                createItemFor(TYPE_TAGS),
                createItemFor(TYPE_TRASH),
                createItemFor(TYPE_MOOD_STATISTICS),
                createItemFor(TYPE_SETTINGS),
                createItemFor(TYPE_SHARE)))
        adapter.setListener(this)


        val list: RecyclerView = findViewById(R.id.rvMenu)
        list.isNestedScrollingEnabled = false
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter


        val floatingBtn: FloatingActionButton = findViewById(R.id.floatBtnMenu)
        floatingBtn.setOnClickListener({ slidingRootNav.closeMenu() })
    }

    private fun createItemFor(position: Int): SimpleItem {
        return SimpleItem(screenTitles[position])
                .withIconTint(color(R.color.textColorBlack))
                .withTextTint(color(R.color.textColorBlack))
                .withSelectedIconTint(color(R.color.colorPrimary))
                .withSelectedTextTint(color(R.color.colorPrimary))
    }

    @ColorInt
    private fun color(@ColorRes res: Int): Int {
        return ContextCompat.getColor(this, res)
    }

    private fun loadScreenTitles(): Array<String> {
        return resources.getStringArray(R.array.ld_activityScreenTitles)
    }

    override fun onItemSelected(position: Int) {
        slidingRootNav.closeMenu()
    }
}