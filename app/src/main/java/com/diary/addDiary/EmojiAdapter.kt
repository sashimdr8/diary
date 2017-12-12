package com.diary.addDiary

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.diary.R
import com.diary.data.model.Emoji
import com.diary.databinding.ListItemEmojiBinding

/**
 * Created by brain on 12/11/17.
 */
class EmojiAdapter(private val emojis: List<Emoji>,
                   private val clickedCallBack: AddDiaryContract.OnClickCallback)
    : RecyclerView.Adapter<EmojiAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            Holder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemEmojiBinding = DataBindingUtil.inflate(inflater,
                R.layout.list_item_emoji, parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(myHolder: Holder, position: Int) {
        myHolder.binding.icEmoticon
                .setImageResource(emojis[position].drawableRes)
        myHolder.binding.root.setOnClickListener({
            clickedCallBack.onEmojiClicked(emojis[myHolder.adapterPosition])
        })
    }

    override fun getItemCount(): Int {
        return emojis.size
    }


    class Holder(val binding: ListItemEmojiBinding)
        : RecyclerView.ViewHolder(binding.root)


}
