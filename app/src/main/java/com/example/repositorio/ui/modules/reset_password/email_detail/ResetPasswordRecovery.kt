package com.example.repositorio.ui.modules.reset_password.email_detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.repositorio.ui.modules.reset_password.email_detail.view.ResetPasswordView
import com.example.repositorio.ui.modules.reset_password.email_detail.viewmodel.ResetPassViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ResetPasswordRecovery(
    viewModel: ResetPassViewModel = koinViewModel(),
    goToVerification:()->Unit,
    onTopBarChange:(String)->Unit
) {
    val state = viewModel.viewState.collectAsStateWithLifecycle()
    LaunchedEffect(state.value.success){
        onTopBarChange("Recuperar contraseña")
        if (state.value.success){
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
}