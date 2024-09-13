package com.example.repositorio.components.bottomsheet

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.example.repositorio.components.BottomSheetComponent

@Composable
fun BottomSheetRecovery(
    goToLogin: () -> Unit,
    showBottomSheet: MutableState<Boolean>
) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        BottomSheetComponent(
            title = "Cancelar proceso",
            description = "Si cancelas el proceso es posible que pierdas todo el progreso para recuperar tu cuenta, tendras que volver a empezar la solicitud",
            textButton = "Permanecer",
            isVisibleButtonGoHome = true,
            onGoInitHome = { goToLogin() },
            onDismiss = {
                showBottomSheet.value = false
            },
            showErrorBottomSheet = showBottomSheet
        )
    }
}