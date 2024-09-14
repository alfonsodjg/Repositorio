package com.example.repositorio.ui.modules.create_account_verification.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repositorio.components.TextInputComponent
import com.example.repositorio.ui.theme.AppTheme

@Preview(
    showSystemUi = true,
    showBackground = true,
    device = Devices.PIXEL_2
)
@Composable
fun CreateAccountVerificationPreview(){
    AppTheme {
        CreateAccountVerification(
            code = "",
            updateCode = {_->},
            onSendCode = {}
        )
    }
}
@Composable
fun CreateAccountVerification(
    code: String,
    updateCode:(String)->Unit,
    onSendCode:()->Unit
    ){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.containerColor)
    ) {
        Surface(
            modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 10.dp),
            shape = RoundedCornerShape(10.dp),
            color = AppTheme.colors.cardColor
        ) {
            Column {
                Text(
                    text = "Verifica tu correo e ingresa el codigo",
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
                    color = AppTheme.colors.textColor,
                    fontWeight = FontWeight.W500
                )
                TextInputComponent(
                    modifier = Modifier ,
                    placeholder = "Ingresa el codigo de validacion" ,
                    text = code,
                    onChangeText = {
                        updateCode(it)
                    })
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = { onSendCode() },
                        modifier = Modifier.widthIn(min = 150.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AppTheme.colors.colorLogin,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(7.dp)
                    ) {
                        Text(text = "Enviar codigo")
                    }
                }
            }
        }
    }
}