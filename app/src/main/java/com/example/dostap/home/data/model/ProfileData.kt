package com.example.dostap.home.data.model

import com.example.dostap.auth.data.model.Category

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
