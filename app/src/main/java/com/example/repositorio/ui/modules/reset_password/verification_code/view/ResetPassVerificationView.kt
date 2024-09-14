package com.example.repositorio.ui.modules.reset_password.verification_code.view

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
    showSystemUi = true,
    showBackground = true,
    device = Devices.PIXEL_2
)
@Composable
fun ResetVerificationPreView() {
    AppTheme {
        ResetPassVerificationView(
            code = "",
            updateCodeRequest = { _ -> },
            onSendCode = {}
        )
    }
}

@Composable
fun ResetPassVerificationView(
    code: String,
    updateCodeRequest: (String) -> Unit,
    onSendCode: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.containerColor)
    ) {
        ProgressComponent(
            step1 = Color.Red,
            step2 = Color.Red
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
                    text = "2. Ingresa el codigo que se envio a tu correo electronico.",
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 20.dp)
                )
                TextInputComponent(
                    modifier = Modifier
                        .padding(top = 20.dp),
                    placeholder = "Ingresa el codigo de verificacion",
                    text = code,
                    onChangeText = {
                        updateCodeRequest(it)
                    })
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, bottom = 20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = { onSendCode() },
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