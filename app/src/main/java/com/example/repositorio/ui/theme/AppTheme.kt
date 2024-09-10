package com.example.repositorio.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import com.example.repositorio.ui.theme.theme_colors.StyleColors
import com.example.repositorio.ui.theme.theme_colors.getDarkColors
import com.example.repositorio.ui.theme.theme_colors.getLightColor
import com.example.repositorio.ui.theme.theme_colors.materialDarkSchema
import com.example.repositorio.ui.theme.theme_colors.materialLightSchema

//File to custom colors
object AppTheme{
    val colors: StyleColors
    @Composable
    @ReadOnlyComposable
    get() = LocalExtendColors.current

    @Composable
    fun isDarkTheme(): Boolean{
        return isSystemInDarkTheme()
    }

}
@Composable
fun AppTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable ()-> Unit
){
    val styleColors = if (useDarkTheme) getDarkColors() else getLightColor()
    CompositionLocalProvider(
        LocalExtendColors provides styleColors
    ) {
       MaterialTheme (
           colorScheme = if (useDarkTheme) materialDarkSchema() else materialLightSchema(),
           content = content
       )
    }
}
private val LocalExtendColors = staticCompositionLocalOf {
    StyleColors()
}