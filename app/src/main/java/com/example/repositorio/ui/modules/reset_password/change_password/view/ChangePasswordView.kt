package com.example.repositorio.ui.modules.reset_password.change_password.view

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repositorio.R
import com.example.repositorio.components.ProgressComponent
import com.example.repositorio.components.TextInputComponent
import com.example.repositorio.ui.theme.AppTheme

@Preview(
    device = Devices.PIXEL_2,
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MyScreen() {
    AppTheme {
        ChangePasswordView(
            password = "",
            updateRequest = { _ -> },
            onSendNewPassword = {}
        )
    }
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
        Box(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.largo),
                contentDescription = null
            )
        }
        Surface(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp),
            shape = RoundedCornerShape(10.dp),
            color = AppTheme.colors.cardColor
        ) {
            Column {
                Text(
                    text = "3 .Ingresa la nueva contraseña",
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 20.dp)
                )
                TextInputComponent(
                    modifier = Modifier
                        .padding(top = 20.dp),
                    placeholder = "Ingresa la nueva contraseña",
                    text = password,
                    onChangeText = {
                        updateRequest(it)
                    })
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, bottom = 20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = { onSendNewPassword() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AppTheme.colors.colorLogin,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(7.dp)
                    ) {
                        Text(text = "Guardar")
                    }
                }
            }
        }
    }
}