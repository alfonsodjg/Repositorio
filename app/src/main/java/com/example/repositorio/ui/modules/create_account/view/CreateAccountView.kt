package com.example.repositorio.ui.modules.create_account.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.repositorio.R
import com.example.repositorio.components.TextInputComponent
import com.example.repositorio.components.TextInputPassComponent
import com.example.repositorio.ui.theme.AppTheme

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_2
)
@Composable
fun CreateAccountPreView() {
    AppTheme {
        CreateAccountView(
            email = "",
            password = "",
            firstName = "",
            lastName = "",
            matricula = "",
            apellidoMaterno = "",
            onCreateAccount = {},
            updateRequest = { _, _, _, _, _, _, -> },
            isCreatedAccount = false,
            goToVerification = {}
        )
    }
}

@Composable
fun CreateAccountView(
    email: String,
    password: String,
    firstName: String,
    lastName: String,
    matricula: String,
    apellidoMaterno: String,
    onCreateAccount: () -> Unit,
    updateRequest: (String, String, String, String, String, String) -> Unit,
    isCreatedAccount: Boolean,
    goToVerification:()->Unit
) {
    LaunchedEffect(isCreatedAccount) {
        println("Estado fuera del if $isCreatedAccount")
        if (isCreatedAccount) {
            println("Estado dentro del if $isCreatedAccount")
            goToVerification()
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            .background(AppTheme.colors.containerColor)
    ) {
        Surface(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp),
            color = AppTheme.colors.cardColor,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column {
                Text(
                    text = "Crea una cuenta con un correo activo, llena todos los campos.",
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp),
                    color = AppTheme.colors.textColor
                )
                Box(
                    modifier = Modifier.fillMaxWidth()
                        .padding(vertical = 20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.newlogo),
                        contentDescription = null,
                        modifier = Modifier.width(250.dp)
                    )
                }
            }
        }
        Surface(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp),
            color = AppTheme.colors.cardColor,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column {
                Text(
                    text = "Nombre:",
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp),
                    fontSize = 14.sp,
                    color = AppTheme.colors.textColor,
                    fontWeight = FontWeight.W600
                )
                TextInputComponent(
                    modifier = Modifier,
                    placeholder = "Nombre",
                    text = firstName,
                    onChangeText = {
                        updateRequest(email, password, it,lastName,matricula,apellidoMaterno)
                    }
                )
                Text(
                    text = "Apellido paterno:",
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp),
                    fontSize = 14.sp,
                    color = AppTheme.colors.textColor,
                    fontWeight = FontWeight.W600
                )
                TextInputComponent(
                    modifier = Modifier,
                    placeholder = "Apellido paterno",
                    text = lastName,
                    onChangeText = {
                        updateRequest(email, password, firstName,it,matricula,apellidoMaterno)
                    }
                )
                Text(
                    text = "Apellido materno:",
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp),
                    fontSize = 14.sp,
                    color = AppTheme.colors.textColor,
                    fontWeight = FontWeight.W600
                )
                TextInputComponent(
                    modifier = Modifier,
                    placeholder = "Apellido materno",
                    text = apellidoMaterno,
                    onChangeText = {
                        updateRequest(email, password, firstName,lastName,matricula,it)
                    }
                )
                Text(
                    text = "Matricula:",
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp),
                    fontSize = 14.sp,
                    color = AppTheme.colors.textColor,
                    fontWeight = FontWeight.W600
                )
                TextInputComponent(
                    modifier = Modifier,
                    placeholder = "Matricula",
                    text = matricula,
                    onChangeText = {
                        updateRequest(email, password,firstName,lastName,it,apellidoMaterno)
                    }
                )
                Text(
                    text = "Email:",
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp),
                    fontSize = 14.sp,
                    color = AppTheme.colors.textColor,
                    fontWeight = FontWeight.W600
                )
                TextInputComponent(
                    modifier = Modifier,
                    placeholder = "email",
                    text = email,
                    onChangeText = {
                        updateRequest(it, password,firstName,lastName,matricula,apellidoMaterno)
                    }
                )
                Text(
                    text = "Contraseña:",
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp),
                    fontSize = 14.sp,
                    color = AppTheme.colors.textColor,
                    fontWeight = FontWeight.W600
                )
                TextInputPassComponent(
                    modifier = Modifier,
                    placeholder = "contraseña",
                    password = password,
                    onChangeText = {
                        updateRequest(email, it, firstName,lastName,matricula,apellidoMaterno)
                    }
                )
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = { onCreateAccount()},
                        modifier = Modifier.padding(vertical = 20.dp)
                            .widthIn(min = 150.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AppTheme.colors.colorLogin,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(7.dp)
                    ) {
                        Text(text = "Crear cuenta")
                    }
                }
            }
        }
    }
}