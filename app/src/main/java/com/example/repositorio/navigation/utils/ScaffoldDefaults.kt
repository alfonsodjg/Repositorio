package com.example.repositorio.navigation.utils

import com.example.repositorio.navigation.model.ScaffoldMainModel
import com.example.repositorio.navigation.model.TopBarUI

object ScaffoldDefaults {

    private val default = ScaffoldMainModel(
        topBar = TopBarUI.NavigateBar()
    )

    fun navigateBar(
        title: String,
        enableActionIcon: Boolean,
        imgLightSrc: String,
        imgDarkSrc: String,
        showExitDialog: Boolean = false
    ) =
        default.copy(
            topBar = TopBarUI.NavigateBar(
                title = title,
                enabledIcon = enableActionIcon,
                imgLight = imgLightSrc,
                imgDark = imgDarkSrc,
                showExitDialog = showExitDialog
            )
        )

    fun none(): ScaffoldMainModel = default.copy(
        topBar = TopBarUI.NoActionBar
    )

    fun default(): ScaffoldMainModel = default
}