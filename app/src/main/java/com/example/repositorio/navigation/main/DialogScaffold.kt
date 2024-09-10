package com.example.repositorio.navigation.main

import androidx.compose.runtime.Composable
import com.example.repositorio.components.LoaderComponent
import com.example.repositorio.navigation.main.core.SingleActionUI

@Composable
fun DialogEvents(
    singleActionUI: SingleActionUI,
    onDismissDialog:(SingleActionUI)->Unit = {}
){
    when(singleActionUI){
        SingleActionUI.HideLoader -> {}
        SingleActionUI.NavigateTo -> {}
        SingleActionUI.None -> {}
        SingleActionUI.ShowLoader -> {LoaderComponent()}
    }
}