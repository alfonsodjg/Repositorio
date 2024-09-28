package com.example.repositorio.ui.modules.login

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.repositorio.components.AlertDialogComponent
import com.example.repositorio.components.BottomSheetComponent
import com.example.repositorio.navigation.main.DialogEvents
import com.example.repositorio.navigation.main.core.SingleActionUI
import com.example.repositorio.ui.modules.login.model.ErrorUi
import com.example.repositorio.ui.modules.login.view.LoginView
import com.example.repositorio.ui.modules.login.viewmodel.LoginViewModel
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun LoginRecovery(
    viewModel: LoginViewModel = koinViewModel(),
    onGoToCreateAccount: () -> Unit,
    onGoToHome: () -> Unit,
    onGoToResetPass: () -> Unit
) {
    val state = viewModel.viewState.collectAsStateWithLifecycle()
    val sharedFlow = viewModel.sharedFlow.collectAsStateWithLifecycle(initialValue = SingleActionUI.None)
    val showError = remember {
        mutableStateOf(false)
    }
    val showBottomSheet = remember {
        mutableStateOf(false)
    }
    val showAlertDialog = remember {
        mutableStateOf(false)
    }

    LoginView(
        onGoToCreateAccount = { onGoToCreateAccount() },
        onGoToHome = { onGoToHome() },
        onGoToResetPass = onGoToResetPass,
        token = state.value.token.token,
        email = state.value.email,
        password = state.value.password,
        updateCredentials = { email, password ->
            viewModel.updateCredentials(email, password)
        },
        onLogin = {
            viewModel.onLogin(state.value.email, state.value.password)
        },
        showError = showError,
        isEnabledButton = state.value.isEnabledButton
    )
    when (state.value.error) {
        ErrorUi.ErrorCredentials -> {
            showError.value = true
        }

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

        ErrorUi.ErrorRequest -> {
            showError.value = false
            showAlertDialog.value = true
            AlertDialogComponent(
                title = "Ocurrio un error",
                description = "El correo que ingresaste no esta registrado",
                onDismiss = {
                    showAlertDialog.value = false
                    viewModel.clearError()
                },
                showAlertDialog = showAlertDialog
            )
        }

        ErrorUi.None -> {}
    }
    DialogEvents(singleActionUI = sharedFlow.value)
}