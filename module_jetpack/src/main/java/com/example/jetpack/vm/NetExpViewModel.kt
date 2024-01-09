package com.example.jetpack.vm

import com.yang.ktbase.network.entity.ApiResponse
import com.google.gson.JsonArray
import com.yang.ktbase.network.RetrofitApi
import com.yang.ktbase.vm.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * 示例代码
 */
class NetExpViewModel: BaseViewModel() {


    private val _titleData = MutableStateFlow<ApiResponse<JsonArray>>(ApiResponse())
    val titleData: StateFlow<ApiResponse<JsonArray>> = _titleData.asStateFlow()

    suspend fun getBanner1() {
        _titleData.value = executeHttp { RetrofitApi.getApi.getBanner() }
    }

    suspend fun getPage(pageIndex:Int): ApiResponse<JsonArray> {
        return executeHttp { RetrofitApi.getApi.getData(pageIndex) }
    };
}