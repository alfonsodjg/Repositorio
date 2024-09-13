package com.example.repositorio.ui.modules.reset_password.verification_code.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repositorio.components.ProgressComponent
import com.example.repositorio.components.TextInputComponent
import com.example.repositorio.ui.theme.AppTheme

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
            .background(AppTheme.colors.containerColor)
    ) {
        ProgressComponent(
            step1 = Color.Red,
            step2 = Color.Red
        )
        Text(
            text = "2. Ingresa el codigo que se envio a tu correo electronico.",
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 20.dp)
        )
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