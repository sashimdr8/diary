package com.diary.main.home.calendar

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diary.BaseFragment
import com.diary.R
import com.diary.databinding.FragmentCalendarBinding
import com.yarolegovich.slidingrootnav.SlidingRootNav

/**
 * Created by brain on 12/8/17.
 */
class CalendarFragment : CalendarContract.View, BaseFragment() {

    private lateinit var binding: FragmentCalendarBinding
    private lateinit var presenter: CalendarContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_calendar,
                container, false)
        return binding.root
    }

    override fun setPresenter(presenter: CalendarContract.Presenter) {
        this.presenter = presenter
    }


}