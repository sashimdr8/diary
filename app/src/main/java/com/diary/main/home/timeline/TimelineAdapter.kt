package com.diary.main.home.timeline

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.diary.R
import com.diary.data.model.Diary
import com.diary.databinding.ListItemTimelineBinding
import com.diary.main.home.HomeContract

/**
 * Created by brain on 12/13/17.
 */
class TimelineAdapter(private val diary: List<Diary>,
                     private val clickedCallBack: HomeContract.OnClickCallback)
    : RecyclerView.Adapter<TimelineAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            Holder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemTimelineBinding = DataBindingUtil.inflate(inflater,
                R.layout.list_item_timeline, parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(myHolder: Holder, position: Int) {
        myHolder.binding.icEmoji.setImageResource(diary[position].emoji.drawableRes)
        myHolder.binding.tvTitle.text = diary[position].title
        myHolder.binding.tvContent.text = diary[position].content
        myHolder.binding.tvTime.text = diary[position].time
        myHolder.binding.tvFeelings.text = """Feeling ${diary[position].emoji.name}"""
        myHolder.binding.root.setOnClickListener({
            clickedCallBack.onItemClicked(diary[myHolder.adapterPosition])
        })
    }

    override fun getItemCount(): Int {
        return diary.size
    }


    class Holder(val binding: ListItemTimelineBinding)
        : RecyclerView.ViewHolder(binding.root)


}
