package com.diary.main.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.diary.main.home.timeline.TimelineFragment;

/**
 * Created by brain on 6/16/17.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    private static int NUM_ITEMS = 3;

    public PagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return new TimelineFragment();
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return new TimelineFragment();
            case 2: // Fragment # 1 - This will show SecondFragment
                return new TimelineFragment();
            default:
                return new TimelineFragment();
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Timeline";
            case 1:
                return "Notes";
            case 2:
                return "Calendar";
            default:
                return "";
        }
    }

}

