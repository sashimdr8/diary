package com.diary.main.home

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diary.BaseFragment
import com.diary.R
import com.diary.databinding.FragmentHomeBinding

/**
 * Created by brain on 12/6/17.
 */
class HomeFragment :BaseFragment(){

    private lateinit var  binding : FragmentHomeBinding;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,
                container, false)
        return binding.root
    }
}