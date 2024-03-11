package com.example.dostap.auth.data.model

data class SignUpRequest(
    val first_name: String,
    val last_name: String,
    val password: String,
    val email: String,
    val avatar_link: String? = null,
    val gender: String? = null,
    val age: Int? = null,
    val phone_number: String? = null,
    val city_of_residence: String? = null,
    val description: String? = null

)