package com.example.dostap.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.dostap.R

val poppinsFontFamily = FontFamily(
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_light, FontWeight.Light),

    )
val fontFamily = FontFamily.Default
// Set of Material typography styles to start with
//val Typography = Typography(
//    displayLarge = TextStyle(
//        fontFamily = poppinsFontFamily,
//        fontWeight = FontWeight.Bold,
//        fontSize = 32.sp,
//    )
//    ,
//    displayMedium = TextStyle(//on boarding label, reg label, login label
//        fontFamily = poppinsFontFamily,
//        fontWeight = FontWeight.Bold,
//        fontSize = 32.sp,
//    )
//    ,
//    displaySmall = TextStyle(// on boarding body
//        fontFamily = poppinsFontFamily,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp,
//    )
//    ,
//    headlineLarge = TextStyle(
//        fontFamily = poppinsFontFamily,
//        fontWeight = FontWeight.Bold,
//        fontSize = 32.sp,
//        lineHeight = 28.sp,
//        letterSpacing = 0.sp
//    )
//    ,
//    headlineMedium = TextStyle(//create acc, login
//        fontFamily = poppinsFontFamily,
//        fontWeight = FontWeight.Normal,
//        fontSize = 14.sp,
//    )
//    ,
//    headlineSmall = TextStyle(
//        fontFamily = poppinsFontFamily,
//        fontWeight = FontWeight.Bold,
//        fontSize = 32.sp,
//        lineHeight = 28.sp,
//        letterSpacing = 0.sp
//    ),
//
//    titleLarge = TextStyle(
//        fontFamily = poppinsFontFamily,
//        fontWeight = FontWeight.Medium,
//        fontSize = 11.sp,
//        lineHeight = 16.sp,
//        letterSpacing = 0.5.sp
//    ),
//    titleMedium = TextStyle(
//        fontFamily = poppinsFontFamily,
//        fontWeight = FontWeight.Medium,
//        fontSize = 11.sp,
//        lineHeight = 16.sp,
//        letterSpacing = 0.5.sp
//    ),
//    titleSmall = TextStyle(
//        fontFamily = poppinsFontFamily,
//        fontWeight = FontWeight.Medium,
//        fontSize = 11.sp,
//        lineHeight = 16.sp,
//        letterSpacing = 0.5.sp
//    ),
//    bodyLarge = TextStyle(
//        fontFamily = poppinsFontFamily,
//        fontWeight = FontWeight.Medium,
//        fontSize = 16.sp,
//    ),
//    bodyMedium = TextStyle(
//        fontFamily = poppinsFontFamily,
//        fontWeight = FontWeight.Medium,
//        fontSize = 11.sp,
//        lineHeight = 16.sp,
//        letterSpacing = 0.5.sp
//    ),
//    bodySmall = TextStyle(
//        fontFamily = poppinsFontFamily,
//        fontWeight = FontWeight.Medium,
//        fontSize = 11.sp,
//        lineHeight = 16.sp,
//        letterSpacing = 0.5.sp
//    ),
//    labelLarge = TextStyle(
//        fontFamily = poppinsFontFamily,
//        fontWeight = FontWeight.Medium,
//        fontSize = 11.sp,
//        lineHeight = 16.sp,
//        letterSpacing = 0.5.sp
//    ),
//    labelMedium = TextStyle(
//        fontFamily = poppinsFontFamily,
//        fontWeight = FontWeight.Medium,
//        fontSize = 11.sp,
//        lineHeight = 16.sp,
//        letterSpacing = 0.5.sp
//    ),
//    labelSmall = TextStyle(
//        fontFamily = poppinsFontFamily,
//        fontWeight = FontWeight.Medium,
//        fontSize = 11.sp,
//        lineHeight = 16.sp,
//        letterSpacing = 0.5.sp
//    )
//)
val defTypography = Typography(
    displayLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
    ),
    displayMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
    ),
    headlineLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
    ),
    headlineMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 25.6.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    bodySmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 20.sp
    ),
    labelSmall = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 10.sp,
    ),
    labelMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp,
    ),
    labelLarge = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 14.sp
    )

)
