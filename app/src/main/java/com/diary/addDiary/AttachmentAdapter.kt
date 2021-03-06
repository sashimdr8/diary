package com.diary.addDiary

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.diary.R
import com.diary.data.model.Attachment
import com.diary.databinding.ListItemAttachmentBinding
import io.realm.RealmList

/**
 * Created by root on 1/19/18.
 */
class AttachmentAdapter
    : RecyclerView.Adapter<AttachmentAdapter.Holder> {


    private val context: Context
    private val clickedCallBack: AddDiaryContract.OnClickCallback
    private val attachments: ArrayList<Attachment>

    constructor(context: Context, clickedCallBack: AddDiaryContract.OnClickCallback) : super() {
        this.context = context
        this.clickedCallBack = clickedCallBack
        this.attachments = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            Holder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemAttachmentBinding = DataBindingUtil.inflate(inflater,
                R.layout.list_item_attachment, parent, false)
        return Holder(binding)
    }

    fun add(attachment: Attachment) {
        attachments.add(attachment)
        notifyDataSetChanged()
    }

    fun add(attachments: List<Attachment>) {
        this.attachments.addAll(attachments)
        notifyDataSetChanged()
    }


    fun getAttachments(): List<Attachment> {
        return attachments
    }

    override fun onBindViewHolder(myHolder: Holder, position: Int) {

        Glide.with(context).load(attachments[position].filePath)
                .into(myHolder.binding.image)

        myHolder.binding.btDelete.setOnClickListener({
            clickedCallBack.onAttachmentDeleted(attachments[myHolder.adapterPosition])
            attachments.remove(attachments[myHolder.adapterPosition])
            notifyDataSetChanged()
        })
        myHolder.binding.root.setOnClickListener({
            clickedCallBack.onAttachmentClicked(attachments[myHolder.adapterPosition])
        })
//        myHolder.binding.icEmoticon
//                .setBackgroundResource([position].drawableRes)


    }

    override fun getItemCount(): Int {
        return attachments.size
    }


    inner class Holder(val binding: ListItemAttachmentBinding)
        : RecyclerView.ViewHolder(binding.root)



}
