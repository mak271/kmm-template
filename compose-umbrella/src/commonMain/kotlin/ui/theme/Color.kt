package ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val diamantRed = Color(0xffE21100)
val diamantRedLight = Color(0xffF15B4F)
val diamantRedDark = Color(0xffCE1000)

val diamantBlue = Color(0xff177ec3)
val diamantBlueLight = Color(0xff5fadf6)
val diamantBlueDark = Color(0xff005292)

val diamantErrorLight = Color(0xFFFF0000)
val diamantErrorDark = Color(0xFFCF6679)

val diamantBackgroundLight = Color.White
val diamantBackgroundDark = Color(0xFF121212)

val diamantSurfaceDark5 = Color(0xff1f1f1f).copy(alpha = 0.2F)
val diamantSurfaceDark10 = Color(0xFF2b2b2b)

val goodColor = Color(0xff26AA3C)
val badColor = Color(0xffFF0000)

val LightColors = lightColorScheme(
    primary = diamantRed,
    primaryContainer = diamantRedDark,
    secondary = diamantBlue,
    secondaryContainer = diamantBlueDark,
    background = diamantBackgroundLight,
    surface = diamantBackgroundLight,
    error = diamantErrorLight,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.White
)

val DarkColors = darkColorScheme(
    primary = diamantRedLight,
    primaryContainer = diamantRedDark,
    secondary = diamantBlue,
    secondaryContainer = diamantBlueLight,
    background = diamantBackgroundDark,
    surface = diamantBackgroundDark,
    error = diamantErrorDark,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White,
    onError = Color.Black
)
