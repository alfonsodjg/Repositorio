package com.example.repositorio.ui.modules.reset_password.email_detail.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.repositorio.components.TextInputComponent

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ResetPasswordViewPreView(){
    ResetPasswordView(
        email = "",
        updateEmailRequest = {_->},
        onSendResetEmail = {}
    )
}


@Composable
fun ResetPasswordView(
    email: String,
    updateEmailRequest:(String)->Unit,
    onSendResetEmail:()->Unit
){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TextInputComponent(
            modifier = Modifier,
            placeholder = "Ingresa tu correo",
            text = email,
            onChangeText = {email->
                updateEmailRequest(email)
            })
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {onSendResetEmail()}) {
                Text(text = "Enviar email")
            }
        }
    }
}