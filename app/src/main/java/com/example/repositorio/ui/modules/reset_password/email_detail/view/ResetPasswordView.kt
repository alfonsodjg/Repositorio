package com.example.repositorio.ui.modules.reset_password.email_detail.view

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repositorio.R
import com.example.repositorio.components.ErrorComponent
import com.example.repositorio.components.ProgressComponent
import com.example.repositorio.components.TextInputComponent
import com.example.repositorio.ui.theme.AppTheme

@Preview(
    showBackground = true,
    showSystemUi = true,
    backgroundColor = 0xFFE6E6E6,
    device = Devices.PIXEL_2,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun ResetPasswordViewPreView(){
    AppTheme {
        ResetPasswordView(
            email = "",
            updateEmailRequest = {_->},
            onSendResetEmail = {},
            isEnabledButton = false
        )
    }
}


@Composable
fun ResetPasswordView(
    email: String,
    updateEmailRequest:(String)->Unit,
    onSendResetEmail:()->Unit,
    isEnabledButton: Boolean
){
    val isEmailValid = remember { mutableStateOf(true) }
    val hasInteracted = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.containerColor)
    ) {
        ProgressComponent()
        Box(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.largo),
                contentDescription = null)
        }
        Surface(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp),
            shape = RoundedCornerShape(10.dp),
            color = AppTheme.colors.cardColor
        ) {
            Column {
                Text(
                    text = "1 .Ingresa tu correo electronico para recuperar tu contraseña, es necesario tener un correo activo.",
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 20.dp),
                    color = AppTheme.colors.textColor
                )
                TextInputComponent(
                    modifier = Modifier
                        .padding(top = 20.dp),
                    placeholder = "Ingresa tu correo",
                    text = email,
                    onChangeText = {email->
                        updateEmailRequest(email)
                        hasInteracted.value = true
                    },
                    isEmailValid = { isValid ->
                        isEmailValid.value = isValid
                    }
                )
                if (hasInteracted.value && !isEmailValid.value) {
                    ErrorComponent(error = "Correo no valido")
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, bottom = 20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = {onSendResetEmail()},
                        enabled = isEnabledButton,
                        shape = RoundedCornerShape(7.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AppTheme.colors.colorLogin,
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Enviar email")
                    }
                }
            }
        }
    }
}