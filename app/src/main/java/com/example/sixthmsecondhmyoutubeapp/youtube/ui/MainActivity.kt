package com.example.sixthmsecondhmyoutubeapp.youtube.ui

import android.view.LayoutInflater
import com.example.sixthmsecondhmyoutubeapp.databinding.ActivityMainBinding
import com.example.sixthmsecondhmyoutubeapp.youtube.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun inflateViewBinding(layoutInflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
supportActionBar?.hide()
    }

    override fun initListener() {

    }


}