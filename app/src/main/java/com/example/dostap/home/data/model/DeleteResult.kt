package com.example.dostap.home.data.model

sealed class DeleteResult<T>{
    class Success<T>: DeleteResult<T>()
    class Failed<T>: DeleteResult<T>()
}