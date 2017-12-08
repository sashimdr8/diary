package com.diary.main.home.timeline

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.diary.R
import com.diary.databinding.ListItemOptionsBinding
import com.diary.main.home.HomeContract

/**
 * Created by brain on 12/8/17.
 */
class OptionsAdapter(private val movies: List<String>,
                     private val clickedCallBack: HomeContract.OnClickCallback)
    : RecyclerView.Adapter<OptionsAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            Holder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemOptionsBinding = DataBindingUtil.inflate(inflater,
                R.layout.list_item_options, parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(myHolder: Holder, position: Int) {
        myHolder.binding.tv.text = movies[position]
        myHolder.binding.root.setOnClickListener({
            clickedCallBack.onOptionClicked(myHolder.adapterPosition)
        })
    }

    override fun getItemCount(): Int {
        return movies.size
    }


    class Holder(val binding: ListItemOptionsBinding)
        : RecyclerView.ViewHolder(binding.root)


}
