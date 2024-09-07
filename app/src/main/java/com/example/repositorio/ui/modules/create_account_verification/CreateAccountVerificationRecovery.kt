package com.example.repositorio.ui.modules.create_account_verification

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.repositorio.ui.modules.create_account_verification.view.CreateAccountVerification
import com.example.repositorio.ui.modules.create_account_verification.viewmodel.CreateAccountVerificationViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CreateAccountVerificationRecovery(
    viewModel: CreateAccountVerificationViewModel = koinViewModel(),
    onTopBarChange:(String)->Unit
){
    LaunchedEffect(Unit){
        onTopBarChange("Codigo de verificacion")
    }
    val state = viewModel.viewState.collectAsStateWithLifecycle()
    CreateAccountVerification(
        code = state.value.code,
        updateCode = {code->
            viewModel.updateCode(code)
        },
        onSendCode = {
            viewModel.onSendCode(code = state.value.code)
        }
    )
}