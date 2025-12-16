package dev.andyalv.profile.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.andyalv.profile.R

val Pixelifysans = FontFamily(
    Font(R.font.pixelifysans_regular, FontWeight.Normal),
    Font(R.font.pixelifysans_medium, FontWeight.Medium),
    Font(R.font.pixelifysans_bold, FontWeight.Bold),
    Font(R.font.pixelifysans_semibold, FontWeight.SemiBold)
)

val RainyHearts = FontFamily(
    Font(R.font.rainyhearts, FontWeight.Normal)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = Typography().bodyLarge.copy(
        fontFamily = RainyHearts,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        letterSpacing = 1.sp
    ),
    titleLarge = Typography().titleLarge.copy(
        fontFamily = Pixelifysans,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    ),
    headlineSmall = Typography().headlineSmall.copy(
        fontFamily = Pixelifysans,
        fontWeight = FontWeight.Bold
    ),
    titleMedium = Typography().titleMedium.copy(
        fontFamily = RainyHearts,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold
    )
)