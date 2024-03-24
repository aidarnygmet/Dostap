package com.example.dostap.home.domain

import android.util.Log
import com.example.dostap.home.data.model.DeleteResult
import com.example.dostap.home.data.repository.MainApi
import com.example.dostap.home.data.repository.MainApiRepo

class MainRepoImpl(private val mainApi: MainApi): MainApiRepo {
    override suspend fun deleteAccount(): DeleteResult<Unit> {
        return try {
            val res = mainApi.deleteAccount()
            DeleteResult.Success()
        } catch (e: Exception){
            Log.d("test", "delete error:"+e.message)
            DeleteResult.Failed()
        }
    }
}