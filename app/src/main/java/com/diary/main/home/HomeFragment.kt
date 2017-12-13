package com.diary.main.home

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diary.BaseFragment
import com.diary.R
import com.diary.databinding.FragmentHomeBinding
import com.diary.databinding.ListItemDateTabBinding
import com.yarolegovich.slidingrootnav.SlidingRootNav

/**
 * Created by brain on 12/6/17.
 */
class HomeFragment : HomeContract.View, BaseFragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var slidingRootNav: SlidingRootNav
    private lateinit var presenter: HomeContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,
                container, false)

        setUpTabsAndViewPager()

        binding.btMenu.setOnClickListener({ slidingRootNav.openMenu() })

        return binding.root
    }

    private fun setUpTabsAndViewPager() {
        var count = 0
        /* binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Timeline"))
         binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Notes"))
         binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Calendar"))*/
        binding.viewPager.adapter = PagerAdapter(activity!!, activity!!.supportFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        while (count < 3) {
            val inflater: LayoutInflater = LayoutInflater.from(activity)
            val dateBinding: ListItemDateTabBinding = DataBindingUtil
                    .inflate(inflater, R.layout.list_item_date_tab, null,
                            false)
            dateBinding.tv.text = binding.tabLayout.getTabAt(count)?.text
            val tab = binding.tabLayout.getTabAt(count)
            tab?.customView = dateBinding.root
            count++
        }

    }


    override fun setSlidingRootNav(slidingRootNav: SlidingRootNav) {
        this.slidingRootNav = slidingRootNav
    }

    override fun setPresenter(presenter: HomeContract.Presenter) {
        this.presenter = presenter
    }
}
