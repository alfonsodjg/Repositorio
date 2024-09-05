package com.example.repositorio.ui.modules.create_account

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.repositorio.ui.modules.create_account.view.CreateAccountView
import com.example.repositorio.ui.modules.create_account.viewmodel.CreateAccountViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CreateAccountRecovery(
    viewModel: CreateAccountViewModel = koinViewModel(),
    goToVerification:()->Unit
) {
    val state = viewModel.viewState.collectAsStateWithLifecycle()

    CreateAccountView(
        email = state.value.email,
        password = state.value.password,
        firstName = state.value.firstName,
        lastName = state.value.lastName,
        matricula = state.value.matricula,
        apellidoMaterno = state.value.apellidoMaterno,
        updateRequest = { email, password, firstName, lastName, matricula, apellidoMaterno ->
            viewModel.updateRequest(
                email,
                password,
                firstName,
                lastName,
                matricula,
                apellidoMaterno
            )
        },
        onCreateAccount = {
            viewModel.onCreateAccount(
                state.value.email,
                state.value.password,
                state.value.firstName,
                state.value.lastName,
                state.value.matricula,
                state.value.apellidoMaterno
            )
        },
        isCreatedAccount = state.value.isCreatedAccount,
        goToVerification = goToVerification
    )
}