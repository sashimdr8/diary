package com.diary.main.home

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.diary.App
import com.diary.main.home.calendar.CalendarFragment
import com.diary.main.home.calendar.CalendarPresenter
import com.diary.main.home.timeline.TimelineFragment
import com.diary.main.home.timeline.TimelinePresenter

/**
 * Created by brain on 12/12/17.
 */
class PagerAdapter(private val context: FragmentActivity,
                   fragmentManager: FragmentManager)
    : FragmentStatePagerAdapter(fragmentManager) {

    // Returns total number of pages
    override fun getCount(): Int {
        return NUM_ITEMS
    }

    // Returns the fragment to display for that page
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 // Fragment # 0 - This will show FirstFragment
            -> {
                val timelineFragment = TimelineFragment()
                TimelinePresenter(App.component(context),
                        timelineFragment)
                return timelineFragment
            }
            1 // Fragment # 0 - This will show FirstFragment different title
            -> {
                val timelineFragment = TimelineFragment()
                TimelinePresenter(App.component(context),
                        timelineFragment)
                return timelineFragment
            }
            2 // Fragment # 1 - This will show SecondFragment
            -> {
                val calendarFragment = CalendarFragment()
                CalendarPresenter(App.component(context),
                        calendarFragment)
                return calendarFragment
            }
            else -> {
                val timelineFragment = TimelineFragment()
                TimelinePresenter(App.component(context),
                        timelineFragment)
                return timelineFragment
            }
        }
    }

    // Returns the page title for the top indicator
    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Timeline"
            1 -> return "Notes"
            2 -> return "Calendar"
            else -> return ""
        }
    }

    companion object {
        private val NUM_ITEMS = 3
    }

}
