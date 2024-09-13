package com.example.repositorio.ui.theme.theme_colors

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class StyleColors (
    val textColor: Color = Color.Unspecified,
    val containerColor : Color = Color.Unspecified,
    val colorLogo:Color = Color.Unspecified,
    val colorLogin:Color = Color.Unspecified,
    val colorFooter:Color = Color.Unspecified,
    val colorRegisterAccount: Color = Color.Unspecified,
    val textBlackWhite: Color = Color.Unspecified
)