package com.example.repositorio.ui.modules.reset_password.verification_code.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.repositorio.components.TextInputComponent

@Preview
@Composable
fun ResetVerificationPreView() {
    ResetPassVerificationView(
        code = "",
        updateCodeRequest = { _ -> },
        onSendCode = {}
    )
}

@Composable
fun ResetPassVerificationView(
    code: String,
    updateCodeRequest: (String) -> Unit,
    onSendCode: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TextInputComponent(
            modifier = Modifier,
            placeholder = "Ingresa el codigo de verificacion",
            text = code,
            onChangeText = {
                updateCodeRequest(it)
            })
        Button(onClick = { onSendCode() }) {
            Text(text = "Enviar codigo")
        }
    }
}