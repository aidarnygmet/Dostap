package com.example.dostapp.screens

data class OnBoardingData(
    val label: String,
    val body: String,
    val pic: Int,
    val button: String,
    val dot: Int,
    val buttonClicked: ()->Unit
)
