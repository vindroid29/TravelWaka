package com.globant.travelwaka.features.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import travelwaka.composeapp.generated.resources.Res
import travelwaka.composeapp.generated.resources.abeezee_regular
import travelwaka.composeapp.generated.resources.gilroy_semi_bold
import travelwaka.composeapp.generated.resources.montserrat_extra_bold


val ABeeZee
    @Composable get() = FontFamily(
        Font(
            resource = Res.font.abeezee_regular,
            weight = FontWeight.Normal
        )
    )
val Gilroy
    @Composable get() = FontFamily(
        Font(
            resource = Res.font.gilroy_semi_bold,
            weight = FontWeight.SemiBold
        )
    )

val MontserratExtraBold
    @Composable get() = FontFamily(
        Font(
            resource = Res.font.montserrat_extra_bold
        )
    )

val Typography @Composable get() = Typography(
    titleLarge = TextStyle(
        fontFamily = MontserratExtraBold,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = ABeeZee,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 24.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = ABeeZee,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 20.sp
    ),
    labelMedium = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),
    labelLarge = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)