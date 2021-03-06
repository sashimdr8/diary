package com.diary.main.home.timeline

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Parcel
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diary.BaseFragment
import com.diary.R
import com.diary.addDiary.AddDiaryActivity
import com.diary.data.model.Diary
import com.diary.databinding.FragmentTimelineBinding
import com.diary.utils.RecyclerViewMargin
import org.parceler.Parcels
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
        initView()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        presenter.start()

    }

    private fun initView() {
        binding.rvOptions.layoutManager = GridLayoutManager(activity, 2)
        binding.rvOptions.addItemDecoration(RecyclerViewMargin(40, 2))
        binding.rvTimeline.layoutManager = GridLayoutManager(activity, 2)
        binding.rvTimeline.addItemDecoration(RecyclerViewMargin(20, 2))
    }


    override fun showOptions() {
        binding.rvOptions.visibility = View.VISIBLE
        val options = ArrayList<String>()
        options.add(getString(R.string.add_a_diary))
        options.add(getString(R.string.add_a_note))
        options.add(getString(R.string.add_a_to_do_list))
        binding.rvOptions.adapter = OptionsAdapter(options, this)
    }

    override fun setPresenter(presenter: TimelineContract.Presenter) {
        this.presenter = presenter
    }

    override fun showAllDiary(diary: List<Diary>) {
        binding.rvTimeline.visibility = View.VISIBLE
        binding.rvOptions.visibility = View.GONE
        binding.rvTimeline.adapter = TimelineAdapter(diary, this)
    }


    override fun onOptionClicked(position: Int) {
        when (position) {
            0 -> startActivity(Intent(activity, AddDiaryActivity::class.java))
        }

    }

    override fun onItemClicked(diary: Diary) {
        startActivity(Intent(activity, AddDiaryActivity::class.java)
                .putExtra("DiaryId",diary.id))
    }


}