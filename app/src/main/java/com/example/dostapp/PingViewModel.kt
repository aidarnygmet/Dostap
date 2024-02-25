package com.example.dostapp

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonElement
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Response
import kotlin.coroutines.resume

class PingViewModel: ViewModel() {
    private val _ping = mutableStateOf<String?>("")
    val ping: State<String?> = _ping
    fun ping(){
        try {
            val apiService: ApiService = ApiClient.getInstance().create(ApiService::class.java)
            val res = parse(apiService.ping().execute())
            _ping.value = res
        } catch (e: Exception){
            Log.d("test", "error happened: "+e.message.toString())
        }
//        var response = ""
//        suspendCancellableCoroutine<Unit> { continuation->
//            viewModelScope.launch {
//                val apiService: ApiService = ApiClient.getInstance().create(ApiService::class.java)
//                val res = parse(apiService.ping().execute())
//                if(res!=null){
//                    response = res
//                    continuation.resume(Unit)
//                }
//            }
//        }
//
//        return response
    }
    fun parse(res: Response<JsonElement>): String?{
        return res.body()?.asString
    }
}