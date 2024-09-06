package com.example.repositorio.ui.modules.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.repositorio.ui.modules.login.view.LoginView
import com.example.repositorio.ui.modules.login.viewmodel.LoginViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginRecovery(
    viewModel: LoginViewModel = koinViewModel(),
    onGoToCreateAccount: () -> Unit,
    onGoToHome: () -> Unit,
    onGoToResetPass:()->Unit
) {
    val state = viewModel.viewState.collectAsStateWithLifecycle()

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
        }
    )
}