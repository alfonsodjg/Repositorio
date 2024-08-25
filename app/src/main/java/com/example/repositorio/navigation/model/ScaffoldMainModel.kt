package com.example.repositorio.navigation.model

data class BottomBarUI(
    val show: Boolean = false
)
sealed class TopBarUI{
    class NavigateBar(
        val title: String,
        val enabledIcon: Boolean = true,
        val imgLight: String = "",
        val imgDark: String = ""
    ): TopBarUI()
    data object NoActionBar: TopBarUI()
}
data class ScaffoldMainModel(
    val topBar: TopBarUI,
    val bottomBar: BottomBarUI
)
