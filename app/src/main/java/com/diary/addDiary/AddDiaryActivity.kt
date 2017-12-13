package com.diary.addDiary

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.diary.App
import com.diary.R
import com.diary.data.model.Emoji
import com.diary.databinding.ActivityAddDiaryBinding
import com.diary.main.BaseActivity
import com.diary.utils.Utils
import com.diary.utils.Utils.isKeyboardShown


/**
 * Created by brain on 12/8/17.
 */
class AddDiaryActivity : BaseActivity(), AddDiaryContract.View {


    private lateinit var presenter: AddDiaryContract.Presenter
    private lateinit var binding: ActivityAddDiaryBinding
    private lateinit var selectedEmoji: Emoji

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_add_diary)

        AddDiaryPresenter(App.component(this), this)
        setSupportActionBar(binding.toolBar)
        assert(supportActionBar != null)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        initViews()


    }

    private fun initViews() {
        val emojis = ArrayList<Emoji>()
        emojis.add(Emoji().setData(R.drawable.emoji_bad, "Bad"))
        emojis.add(Emoji().setData(R.drawable.emoji_cry, "Cry"))
        emojis.add(Emoji().setData(R.drawable.emoji_happy, "happy"))
        emojis.add(Emoji().setData(R.drawable.emoji_laugh, "So Happy"))
        emojis.add(Emoji().setData(R.drawable.emoji_love, "Love"))

        binding.rvSentiments.adapter = EmojiAdapter(emojis, this)

        binding.etDiary.viewTreeObserver
                .addOnGlobalLayoutListener({
                    when (isKeyboardShown(binding.etDiary.rootView)) {
                        false -> {
                            binding.vHow.visibility = View.VISIBLE
                            binding.v.visibility = View.VISIBLE
                            binding.rvSentiments.visibility = View.VISIBLE
                        }
                        true -> {
                            binding.vHow.visibility = View.GONE
                            binding.v.visibility = View.GONE
                            binding.rvSentiments.visibility = View.GONE
                        }
                    }
                })


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add_diary, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.save) {
            presenter.saveDiary(binding.etTitle.text.toString(),
                    binding.etDiary.text.toString(), selectedEmoji)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showDiarySaveSuccess() {
        Utils.showSnackbar(this, "Diary Saved")
    }

    override fun setPresenter(presenter: AddDiaryContract.Presenter) {
        this.presenter = presenter
    }

    override fun onEmojiClicked(position: Emoji) {
        this.selectedEmoji = position
    }

}