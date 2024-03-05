package com.example.dostapp.home.data.model

import com.example.dostapp.auth.data.model.Category

data class ProfileData(
    val username: String,
    val profilePic: Int,
    val friendsCount: Int,
    val firstName: String,
    val age: Int,
    val city: String,
    val aboutUser: List<String>,
    val interests: List<Category>
)
