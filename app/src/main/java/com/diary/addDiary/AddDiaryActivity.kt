package com.diary.addDiary

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.diary.R
import com.diary.data.model.Emoji
import com.diary.databinding.ActivityAddDiaryBinding
import com.diary.main.BaseActivity

/**
 * Created by brain on 12/8/17.
 */
class AddDiaryActivity : BaseActivity(), AddDiaryContract.View {
    override fun onEmojiClicked(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private lateinit var presenter: AddDiaryContract.Presenter
    private lateinit var binding: ActivityAddDiaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this ,
                R.layout.activity_add_diary)

        setSupportActionBar(binding.toolBar)
        assert(supportActionBar != null)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val emojis = ArrayList<Emoji>()
        emojis.add(Emoji(R.drawable.emoji_bad, "Bad"))
        emojis.add(Emoji(R.drawable.emoji_cry, "Cry"))
        emojis.add(Emoji(R.drawable.emoji_happy, "happy"))
        emojis.add(Emoji(R.drawable.emoji_laugh, "So Happy"))
        emojis.add(Emoji(R.drawable.emoji_love, "Love"))

        binding.rvSentiments.adapter = EmojiAdapter(emojis, this)


    }
    override fun setPresenter(presenter: AddDiaryContract.Presenter) {
        this.presenter = presenter
    }
}