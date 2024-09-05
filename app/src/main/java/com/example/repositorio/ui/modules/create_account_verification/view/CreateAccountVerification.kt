package com.example.repositorio.ui.modules.create_account_verification.view

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
    showSystemUi = true,
    showBackground = true
)
@Composable
fun CreateAccountVerificationPreview(){
    CreateAccountVerification(
        code = "",
        updateCode = {_->},
        onSendCode = {}
    )
}
@Composable
fun CreateAccountVerification(
    code: String,
    updateCode:(String)->Unit,
    onSendCode:()->Unit
    ){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TextInputComponent(
            modifier = Modifier ,
            placeholder = "Ingresa el codigo de validacion" ,
            text = code,
            onChangeText = {
                updateCode(it)
            })
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = { onSendCode() }) {
                Text(text = "Enviar codigo")
            }
        }
    }
}