package com.example.repositorio.components.bottomsheet

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.example.repositorio.components.BottomSheetComponent

@Composable
fun BottomSheetRecovery(
    goToLogin: () -> Unit,
    showBottomSheet: MutableState<Boolean>,
    title: String,
    textSecondButton: String,
    description:String,
    textButton:String
) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        BottomSheetComponent(
            title = title,
            description = description,
            textButton = textButton,
            textSecondButton = textSecondButton,
            isVisibleButtonGoHome = true,
            onGoInitHome = { goToLogin() },
            onDismiss = {
                showBottomSheet.value = false
            },
            showErrorBottomSheet = showBottomSheet
        )
    }
}