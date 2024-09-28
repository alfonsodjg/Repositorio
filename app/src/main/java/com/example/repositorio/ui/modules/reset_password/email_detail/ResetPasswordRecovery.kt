package com.example.repositorio.ui.modules.reset_password.email_detail

import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.repositorio.components.BottomSheetComponent
import com.example.repositorio.navigation.main.DialogEvents
import com.example.repositorio.navigation.main.core.SingleActionUI
import com.example.repositorio.ui.modules.login.model.ErrorUi
import com.example.repositorio.ui.modules.reset_password.email_detail.view.ResetPasswordView
import com.example.repositorio.ui.modules.reset_password.email_detail.viewmodel.ResetPassViewModel
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun ResetPasswordRecovery(
    viewModel: ResetPassViewModel = koinViewModel(),
    goToVerification: () -> Unit,
    onTopBarChange: (String) -> Unit,
    showAlertBottomSheet: MutableState<Boolean>
) {
    val state = viewModel.viewState.collectAsStateWithLifecycle()
    val sharedFlow = viewModel.sharedFlow.collectAsState(initial = SingleActionUI.None)
    val showBottomSheet = remember {
        mutableStateOf(false)
    }
    LaunchedEffect(state.value.success) {
        onTopBarChange("Recuperar contraseña")
        if (state.value.success) {
            goToVerification()
        }
    }
    ResetPasswordView(
        email = state.value.email,
        updateEmailRequest = { email ->
            viewModel.updateEmailRequest(email)
        },
        onSendResetEmail = {
            viewModel.onSendEmail(email = state.value.email)
        },
        isEnabledButton = state.value.isEnabledButton
    )
    DialogEvents(singleActionUI = sharedFlow.value)

    BackHandler(enabled = true) {
        showAlertBottomSheet.value = true
    }

    when(state.value.error){
        ErrorUi.ErrorCredentials -> {}
        ErrorUi.ErrorRequest -> {}
        ErrorUi.ErrorServer -> {
            showBottomSheet.value = true
            BottomSheetComponent(
                title = "Servicio no disponible",
                description = "Lo sentimos por el momento el servicio no esta disponible, contacta a tu administrador para mas informacion.",
                textButton = "Cerrar",
                textSecondButton = "Cancelar",
                onDismiss = {
                    showBottomSheet.value = false
                    viewModel.clearError()
                },
                onGoInitHome = {},
                showErrorBottomSheet = showBottomSheet
            )
        }
        ErrorUi.None -> {}
    }
}