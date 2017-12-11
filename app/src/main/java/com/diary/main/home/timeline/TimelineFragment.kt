package com.diary.main.home.timeline

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diary.BaseFragment
import com.diary.R
import com.diary.addDiary.AddDiaryActivity
import com.diary.databinding.FragmentTimelineBinding
import com.diary.utils.RecyclerViewMargin
import java.util.ArrayList

/**
 * Created by brain on 12/8/17.
 */
class TimelineFragment : BaseFragment(), TimelineContract.View {


    private lateinit var binding: FragmentTimelineBinding
    private lateinit var presenter: TimelineContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?
                              , savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_timeline,
                container, false)

        showOptions()
        return binding.root
    }

    private fun showOptions() {
        val options = ArrayList<String>()
        options.add(getString(R.string.add_a_diary))
        options.add(getString(R.string.add_a_note))
        options.add(getString(R.string.add_a_to_do_list))
        binding.rvOptions.layoutManager = GridLayoutManager(activity, 2)
        binding.rvOptions.addItemDecoration(RecyclerViewMargin(40, 2))
        binding.rvOptions.adapter = OptionsAdapter(options, this)
    }

    override fun setPresenter(presenter: TimelineContract.Presenter) {
        this.presenter = presenter
    }

    override fun onOptionClicked(position: Int) {
        when (position) {
            0 -> startActivity(Intent(activity, AddDiaryActivity::class.java))
        }

    }


}