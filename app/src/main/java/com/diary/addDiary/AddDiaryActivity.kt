package com.diary.addDiary

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.bumptech.glide.Glide
import com.diary.App
import com.diary.R
import com.diary.addDiary.AddDiaryPresenter.Companion.REQUEST_CODE_PICKER
import com.diary.data.model.Attachment
import com.diary.data.model.Diary
import com.diary.data.model.Emoji
import com.diary.databinding.ActivityAddDiaryBinding
import com.diary.main.BaseActivity
import com.diary.utils.Utils
import com.diary.utils.Utils.isKeyboardShown
import com.esafirm.imagepicker.features.ImagePicker
import com.esafirm.imagepicker.model.Image
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File


/**
 * Created by brain on 12/8/17.
 */
class AddDiaryActivity : BaseActivity(), AddDiaryContract.View {


    private lateinit var presenter: AddDiaryContract.Presenter
    private lateinit var binding: ActivityAddDiaryBinding
    private var selectedEmoji: Emoji = Emoji()
    private lateinit var emojiAdapter: EmojiAdapter

    var diaryId: Long = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_add_diary)

        AddDiaryPresenter(this, App.component(this), this)
        setSupportActionBar(binding.toolBar)
        assert(supportActionBar != null)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        initViews()

        if (intent != null) {
            if (intent.extras != null) {
                diaryId = intent.getLongExtra("DiaryId", -1)
                presenter.getDiary(diaryId)
            }
        }

        binding.btAddPhoto.setOnClickListener({

            presenter.startImagePicker()

        })

    }

    private fun initViews() {
        val emojis = ArrayList<Emoji>()
        emojis.add(Emoji().setData(R.drawable.emoji_bad, "Bad", 0))
        emojis.add(Emoji().setData(R.drawable.emoji_cry, "Cry", 1))
        emojis.add(Emoji().setData(R.drawable.emoji_happy, "happy", 2))
        emojis.add(Emoji().setData(R.drawable.emoji_laugh, "So Happy", 3))
        emojis.add(Emoji().setData(R.drawable.emoji_love, "Love", 4))
        emojiAdapter = EmojiAdapter(emojis, this)
        binding.rvSentiments.adapter = emojiAdapter

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE_PICKER && resultCode == RESULT_OK && data != null) {
            val images = data.getParcelableArrayListExtra<Image>("selectedImages")
            val img = images[0].path
            Glide.with(this).load(images[0].path).into(binding.image)
            val file = File(img)
            val reqFile = RequestBody.create(MediaType.parse("image/*"), file)
            binding.image.visibility = View.VISIBLE
//            imageBody = MultipartBody.Part.createFormData("ProfilePic", file.name, reqFile)
        }
    }


    override fun onAttachmentDeleted(attachment: Attachment) {
    }

    override fun onAttachmentClicked(attachment: Attachment) {
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add_diary, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.save) {
            return if (diaryId.compareTo(-1) == 0) {
                presenter.saveDiary(binding.etTitle.text.toString(),
                        binding.etDiary.text.toString(), selectedEmoji)
                true
            } else {
                presenter.saveDiary(diaryId, binding.etTitle.text.toString(),
                        binding.etDiary.text.toString(), selectedEmoji)
                true
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun showDiarySaveSuccess() {
        Utils.showSnackbar(this, "Diary Saved")
        finish()
    }

    override fun showDiaryDetails(diary: Diary) {
        binding.etDiary.setText(diary.content)
        binding.etTitle.setText(diary.title)
        selectedEmoji = emojiAdapter.emojiClicked(diary.emoji.id)
    }


    override fun setPresenter(presenter: AddDiaryContract.Presenter) {
        this.presenter = presenter
    }

    override fun onEmojiClicked(position: Emoji) {
        this.selectedEmoji = position
    }

}