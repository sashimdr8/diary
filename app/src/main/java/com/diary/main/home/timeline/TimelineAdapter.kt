package com.diary.main.home.timeline

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.diary.R
import com.diary.data.model.Diary
import com.diary.databinding.LayoutAddOptionsBinding
import com.diary.databinding.ListItemTimelineBinding
import com.diary.main.home.HomeContract

/**
 * Created by brain on 12/13/17.
 */
class TimelineAdapter(private val diary: List<Diary>,
                      private val clickedCallBack: HomeContract.OnClickCallback)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        return if (viewType == 0) {
            val headerBinding: LayoutAddOptionsBinding = DataBindingUtil.inflate(inflater,
                    R.layout.layout_add_options, parent, false)
            OptionHolder(headerBinding)
        } else {
            val binding: ListItemTimelineBinding = DataBindingUtil.inflate(inflater,
                    R.layout.list_item_timeline, parent, false)
            Holder(binding)
        }

    }

    override fun onBindViewHolder(myHolder: RecyclerView.ViewHolder, position: Int) {
        if (position == 0) {
            bindOptionsView(myHolder as OptionHolder, position)
        } else {
            bindTimelineView(myHolder as Holder, position-1)
        }
    }

    private fun bindOptionsView(myHolder: TimelineAdapter.OptionHolder,
                                position: Int) {
        myHolder.binding.tvAddDiary.setOnClickListener(({
            clickedCallBack.onOptionClicked(0)
        }))


    }

    private fun bindTimelineView(myHolder: TimelineAdapter.Holder, position: Int) {
        myHolder.binding.icEmoji.setImageResource(diary[position].emoji.drawableRes)
        myHolder.binding.tvTitle.text = diary[position].title
        myHolder.binding.tvContent.text = diary[position].content
        myHolder.binding.tvTime.text = diary[position].time
        myHolder.binding.tvFeelings.text = """Feeling ${diary[position].emoji.name}"""
        myHolder.binding.root.setOnClickListener({
            clickedCallBack.onItemClicked(diary[myHolder.adapterPosition-1])
        })

    }

    override fun getItemCount(): Int {
        return diary.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class Holder(val binding: ListItemTimelineBinding)
        : RecyclerView.ViewHolder(binding.root)

    class OptionHolder(val binding: LayoutAddOptionsBinding)
        : RecyclerView.ViewHolder(binding.root)
}
