package com.example.repositorio.navigation.main

import androidx.compose.runtime.Composable
import com.example.repositorio.components.TopBarScaffoldComponent
import com.example.repositorio.navigation.model.TopBarUI

object TopBarListener {
    var onClickBackListener: () -> Unit = {}
    var overWriteBackListener: Boolean = false
    var onClickAction: () -> Unit = {}
    var overWriteAction: Boolean = false
}

@Composable
fun TopBarRecovery(
    topBarUI: TopBarUI,
    onBack: () -> Unit,
    onAction: () -> Unit
){
    when (topBarUI) {
        is TopBarUI.NavigateBar -> {
            val title: String = topBarUI.title
            val enableActionButton = topBarUI.enabledIcon
            TopBarScaffoldComponent(
                title = title,
                enableAction = enableActionButton,
                onBackClick = {
                    if (TopBarListener.overWriteBackListener) TopBarListener.onClickBackListener()
                    else onBack()
                },
                onActionClick = {
                    if (TopBarListener.overWriteAction) TopBarListener.onClickAction()
                    else onAction()
                }
            )
        }
        is TopBarUI.NoActionBar -> { }
    }
}