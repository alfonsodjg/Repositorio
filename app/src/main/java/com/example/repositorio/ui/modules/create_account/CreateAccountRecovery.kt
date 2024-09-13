package com.example.repositorio.ui.modules.create_account

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.repositorio.ui.modules.create_account.view.CreateAccountView
import com.example.repositorio.ui.modules.create_account.viewmodel.CreateAccountViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CreateAccountRecovery(
    viewModel: CreateAccountViewModel = koinViewModel(),
    goToVerification:()->Unit,
    onTopBarChange:(String)->Unit,
    showAlertBottomSheet: MutableState<Boolean>
) {
    val state = viewModel.viewState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit){
        onTopBarChange("Crear cuenta")
    }
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
    BackHandler(enabled = true) {
        showAlertBottomSheet.value = true
    }
}