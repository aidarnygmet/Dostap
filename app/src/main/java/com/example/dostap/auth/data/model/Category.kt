package com.example.dostap.auth.data.model

import androidx.compose.ui.graphics.Color
import com.example.dostap.R


sealed class Category(
    val id: Int,
    val image: Int,
    val text: Int,
    val color: Color
){
    object Bike :Category(20,R.drawable.bike, R.string.bike,Color(0xFFF2EBFF))
    object Football :Category(1,R.drawable.football, R.string.football,Color(0xFFF2EBFF))
    object Tennis :Category(2,R.drawable.tennis, R.string.tennis,Color(0xFFF2EBFF))
    object Hiking :Category(3,R.drawable.hiking, R.string.hiking,Color(0xFFF2EBFF))
    object Swimming :Category(4,R.drawable.swimming, R.string.swimming,Color(0xFFF2EBFF))
    object Hockey :Category(5,R.drawable.hockey, R.string.hockey,Color(0xFFF2EBFF))
    object Weights :Category(6,R.drawable.weights, R.string.weights,Color(0xFFF2EBFF))
    object Volleyball :Category(7,R.drawable.volleyball, R.string.volleyball, Color(0xFFF2EBFF))
    object Yoga :Category(8,R.drawable.yoga, R.string.yoga,Color(0xFFF2EBFF))
    object Running :Category(9,R.drawable.walk, R.string.running,Color(0xFFF2EBFF))
    object Walking :Category(10,R.drawable.walk, R.string.walk, Color(0xFFF2EBFF))
    object Bowling :Category(11,R.drawable.ball_bowling, R.string.ball_bowling,Color(0xFFF2EBFF))
    object IceSkating :Category(12,R.drawable.ice_skating, R.string.ice_skating,Color(0xFFF2EBFF))
    object Skiing :Category(13,R.drawable.skiing, R.string.skiing,Color(0xFFF2EBFF))
    object Chess :Category(14,R.drawable.chess, R.string.chess,Color(0xFFF2EBFF))
    object Dancing :Category(15,R.drawable.dancing, R.string.dancing,Color(0xFFF2EBFF))
    object Concerts :Category(16,R.drawable.concert, R.string.concert,Color(0xFFF2EBFF))
    object Music :Category(17,R.drawable.music, R.string.music,Color(0xFFF2EBFF))
    object Movies :Category(18,R.drawable.movie, R.string.movie,Color(0xFFF2EBFF))
    object Art :Category(19,R.drawable.painting, R.string.art,Color(0xFFF2EBFF))

}
