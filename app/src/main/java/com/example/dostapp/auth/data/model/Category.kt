package com.example.dostapp.auth.data.model

import com.example.dostapp.R

sealed class Category(
    val image: Int,
    val text: Int
){
    object Skates: Category(R.drawable.skates, R.string.skates)
    object Box: Category(R.drawable.box, R.string.box)
    object Golf: Category(R.drawable.chess, R.string.skates)
    object Hockey: Category(R.drawable.skates, R.string.skates)
    object Skiing: Category(R.drawable.skates, R.string.skates)
    object Swimming: Category(R.drawable.skates, R.string.skates)
    object Weight: Category(R.drawable.skates, R.string.skates)
    object Volleyball: Category(R.drawable.skates, R.string.skates)
    object Tennis: Category(R.drawable.skates, R.string.skates)
    object Chess: Category(R.drawable.chess, R.string.chess)
    object Theater: Category(R.drawable.skates, R.string.skates)
    object Concert: Category(R.drawable.skates, R.string.skates)
    object Yoga: Category(R.drawable.skates, R.string.skates)
    object Cycling: Category(R.drawable.skates, R.string.skates)

}
