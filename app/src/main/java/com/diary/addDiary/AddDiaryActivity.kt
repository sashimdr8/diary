package com.diary.addDiary

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.diary.R
import com.diary.databinding.ActivityAddDiaryBinding
import com.diary.main.BaseActivity

/**
 * Created by brain on 12/8/17.
 */
class AddDiaryActivity : BaseActivity(), AddDiaryContract.View {


    private lateinit var presenter: AddDiaryContract.Presenter
    private lateinit var binding: ActivityAddDiaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this ,
                R.layout.activity_add_diary)


    }
    override fun setPresenter(presenter: AddDiaryContract.Presenter) {
        this.presenter = presenter
    }
}