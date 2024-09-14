package com.example.repositorio.ui.modules.home

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.platform.LocalContext
import com.example.repositorio.ui.modules.home.view.HomeView

@Composable
fun HomeRecovery(
    onGoToHome:()->Unit,
    onGoToProfile:()->Unit,
    onGoToAbout:()->Unit,
    onGoToAdmin:()->Unit,
    showBottomSheetLogOut: MutableState<Boolean>
){
    val context = LocalContext.current
    HomeView(
        onGoToHome = onGoToHome,
        onGoToProfile = onGoToProfile,
        onGoToAbout = onGoToAbout,
        onGoToAdmin = onGoToAdmin
    )
    BackHandler {
      showBottomSheetLogOut.value = true
    }
}