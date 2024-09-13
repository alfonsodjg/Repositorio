package com.example.repositorio.ui.modules.reset_password.verification_code

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.repositorio.ui.modules.reset_password.verification_code.view.ResetPassVerificationView
import com.example.repositorio.ui.modules.reset_password.verification_code.viewmodel.VerificationCodeViewModel
import com.example.repositorio.ui.modules.reset_password.verification_code.viewstate.SuccessVerified
import org.koin.androidx.compose.koinViewModel

@Composable
fun ResetPasswordVerificationRecovery(
    viewModel: VerificationCodeViewModel = koinViewModel(),
    goToChangePass:()->Unit,
    onTopBarChange:(String)->Unit,
    showAlertBottomSheet: MutableState<Boolean>
) {
    val state = viewModel.viewState.collectAsStateWithLifecycle()
    LaunchedEffect(state.value.isSuccess){
        println("Veamos el succes fuera del if ${state.value.response}")
        onTopBarChange("Recuperar contraseña")
        if (state.value.isSuccess){
            println("Veamos el succes fuera dentro del if ${state.value.response}")
            goToChangePass()
        }
    }
    ResetPassVerificationView(
        code = state.value.code,
        updateCodeRequest = {
            viewModel.updateCodeRequest(it)
        },
        onSendCode = {
            viewModel.onSendCode(state.value.code)
        }
    )
    BackHandler(enabled = true) {
        showAlertBottomSheet.value = true
    }
}