package com.example.avi

import android.content.Intent
import android.os.Bundle
import com.example.avi.menu.RecordingActivity
import com.example.lib_avi.databinding.ActivityAviMenuBinding
import com.yang.ktbase.base.BaseBindActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
class AviMenuActivity : BaseBindActivity<ActivityAviMenuBinding>(), CoroutineScope by MainScope()  {
    override fun initView(savedInstanceState: Bundle?) {
        binding.apply {
            tvRecording.setOnClickListener {
                startActivity(Intent(this@AviMenuActivity, RecordingActivity::class.java))
            }
        }
    }
}