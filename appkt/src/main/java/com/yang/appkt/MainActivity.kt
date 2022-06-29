package com.yang.appkt

import android.content.Intent
import android.os.Bundle
import com.blankj.utilcode.util.ToastUtils
import com.yang.appkt.databinding.ActivityMainBinding
import com.yang.appkt.menu.*
import com.yang.ktbase.LiveDataBus
import com.yang.ktbase.base.BaseBindActivity
import kotlinx.coroutines.*


const val busTag:String="launch"

class MainActivity : BaseBindActivity<ActivityMainBinding>(), CoroutineScope by MainScope() {

    override fun initView(savedInstanceState: Bundle?) {
        LiveDataBus.with<String>(busTag).observer(this){
            ToastUtils.showLong(it)
        }

        binding.run {
            tvLaunch.setOnClickListener {
                startActivity(Intent(this@MainActivity, LaunchActivity::class.java))
            }

            tvHandler.setOnClickListener {
                startActivity(Intent(this@MainActivity, HandlerActivity::class.java))
            }

            tvWebView.setOnClickListener {
                startActivity(Intent(this@MainActivity, WebViewActivity::class.java))
            }

            tvRoom.setOnClickListener {
                startActivity(Intent(this@MainActivity, RoomActivity::class.java))
            }

            tvLifecycle.setOnClickListener {
                startActivity(Intent(this@MainActivity, LifecycleActivity::class.java))
            }

            tvLiveData.setOnClickListener {
                LiveDataBus.with<String>(busTag).postData("1212")
            }

            tvFrame.setOnClickListener {
                startActivity(Intent(this@MainActivity, RecyclerActivity::class.java))
            }

            tvCoroutines.setOnClickListener {
                startActivity(Intent(this@MainActivity, CoroutinesActivity::class.java))
            }
        }


    }
}