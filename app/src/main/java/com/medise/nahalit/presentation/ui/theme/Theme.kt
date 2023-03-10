package com.medise.nahalit.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.medise.nahalit.R

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun NahalItTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    fontFamily: FontFamily = FontFamily(Font(R.font.maktab)),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    val uiController = rememberSystemUiController()
    if (darkTheme) {
        uiController.setStatusBarColor(
            color = colorPrimary
        )
        uiController.setNavigationBarColor(
            color = ghost_white
        )
    } else {
        uiController.setStatusBarColor(
            color = colorPrimary
        )
        uiController.setNavigationBarColor(
            color = ghost_white
        )
    }

    val typography = getTypography(fontFamily)

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = Shapes,
        content = content
    )
}

fun getTypography(fontFamily: FontFamily) = androidx.compose.material.Typography(
    defaultFontFamily = fontFamily
)