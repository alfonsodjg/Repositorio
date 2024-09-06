package com.example.repositorio.ui.modules.reset_password.change_password.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.repositorio.components.TextInputComponent

@Preview
@Composable
fun MyScreen(){
    ChangePasswordView(
        password = "",
        updateRequest = {_->},
        onSendNewPassword = {}
        )
}
@Composable
fun ChangePasswordView(
    password: String,
    updateRequest:(String)->Unit,
    onSendNewPassword:()->Unit
) {
    val code = ""
    Column {
        //Para recuperar el code podemos hacer un singleton y guardarlo en el viewmodel como en el login
        TextInputComponent(
            modifier = Modifier,
            placeholder = "Ingresa la nueva contraseña",
            text = password,
            onChangeText = {
                updateRequest(it)
            })
        Button(onClick = { onSendNewPassword()}) {
            Text(text = "Guardar")
        }
    }
}