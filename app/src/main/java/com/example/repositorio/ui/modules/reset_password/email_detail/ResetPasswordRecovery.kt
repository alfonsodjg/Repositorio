package com.example.repositorio.ui.modules.reset_password.email_detail

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.repositorio.navigation.main.DialogEvents
import com.example.repositorio.navigation.main.core.SingleActionUI
import com.example.repositorio.ui.modules.reset_password.email_detail.view.ResetPasswordView
import com.example.repositorio.ui.modules.reset_password.email_detail.viewmodel.ResetPassViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ResetPasswordRecovery(
    viewModel: ResetPassViewModel = koinViewModel(),
    goToVerification: () -> Unit,
    onTopBarChange: (String) -> Unit,
    showAlertBottomSheet: MutableState<Boolean>
) {
    val state = viewModel.viewState.collectAsStateWithLifecycle()
    val sharedFlow = viewModel.sharedFlow.collectAsState(initial = SingleActionUI.None)
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
        }
    )
    DialogEvents(singleActionUI = sharedFlow.value)

    BackHandler(enabled = true) {
        showAlertBottomSheet.value = true
    }
}