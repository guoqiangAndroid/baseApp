package com.yang.ktbase.base

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.yang.ktbase.ext.getVmClazz

abstract class BaseFragment<M:BaseViewModel,B: ViewBinding> :BaseVmFragment<B>() {

    protected lateinit var viewModel: M

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=createViewModel()
        initView(savedInstanceState)
    }

    /**
     * 初始化布局
     */
    abstract fun initView(savedInstanceState: Bundle?)
    /**
     * 创建viewModel
     */
    private fun createViewModel(): M {
        return ViewModelProvider(this).get(getVmClazz(this))
    }
}