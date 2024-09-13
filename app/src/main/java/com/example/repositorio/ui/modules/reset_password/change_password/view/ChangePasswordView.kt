package com.example.repositorio.ui.modules.reset_password.change_password.view

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
fun MyScreen() {
    ChangePasswordView(
        password = "",
        updateRequest = { _ -> },
        onSendNewPassword = {}
    )
}

@Composable
fun ChangePasswordView(
    password: String,
    updateRequest: (String) -> Unit,
    onSendNewPassword: () -> Unit
) {
    val code = ""
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.containerColor)
    ) {
        //Para recuperar el code podemos hacer un singleton y guardarlo en el viewmodel como en el login
        ProgressComponent(
            step1 = Color.Red,
            step2 = Color.Red,
            step3 = Color.Red
        )
        Text(
            text = "3 .Ingresa la nueva contraseña",
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 20.dp)
        )
        TextInputComponent(
            modifier = Modifier,
            placeholder = "Ingresa la nueva contraseña",
            text = password,
            onChangeText = {
                updateRequest(it)
            })
        Button(onClick = { onSendNewPassword() }) {
            Text(text = "Guardar")
        }
    }
}