package com.example.repositorio.ui.modules.reset_password.change_password

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.repositorio.ui.core.utils.SaveCodeToChangePassword
import com.example.repositorio.ui.modules.reset_password.change_password.view.ChangePasswordView
import com.example.repositorio.ui.modules.reset_password.change_password.viewmodel.ChangePasswordViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ChangePassRecovery(
    viewModel: ChangePasswordViewModel = koinViewModel(),
    onTopBarChange:(String)->Unit
) {
    val state = viewModel.viewState.collectAsStateWithLifecycle()
    println("Codigo que se envio al correo ${SaveCodeToChangePassword.code}")
    LaunchedEffect(Unit){
        onTopBarChange("Recuperar contraseña")
    }
    ChangePasswordView(
        password = state.value.password,
        updateRequest = { password ->
            viewModel.updateRequest(
                code = SaveCodeToChangePassword.code ?: "",
                password = password
            )
        },
        onSendNewPassword = {
            viewModel.onSendNewPassword(code = state.value.code, password = state.value.password)
        }
    )
}