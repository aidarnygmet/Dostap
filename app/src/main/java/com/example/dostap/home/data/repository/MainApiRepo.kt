package com.example.dostap.home.data.repository

import com.example.dostap.home.data.model.DeleteResult

interface MainApiRepo {
    suspend fun deleteAccount(): DeleteResult<Unit>
}