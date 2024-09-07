package com.example.repositorio.ui.modules.create_account.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repositorio.R
import com.example.repositorio.components.TextInputComponent
import com.example.repositorio.components.TextInputPassComponent

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CreateAccountPreView() {
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
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.newlogo),
                contentDescription = null,
                modifier = Modifier.width(250.dp)
            )
        }
        TextInputComponent(
            modifier = Modifier,
            placeholder = "Nombre",
            text = firstName,
            onChangeText = {
                updateRequest(email, password, it,lastName,matricula,apellidoMaterno)
            }
        )
        TextInputComponent(
            modifier = Modifier,
            placeholder = "Apellido paterno",
            text = lastName,
            onChangeText = {
                updateRequest(email, password, firstName,it,matricula,apellidoMaterno)
            }
        )
        TextInputComponent(
            modifier = Modifier,
            placeholder = "Apellido materno",
            text = apellidoMaterno,
            onChangeText = {
                updateRequest(email, password, firstName,lastName,matricula,it)
            }
        )
        TextInputComponent(
            modifier = Modifier,
            placeholder = "Matricula",
            text = matricula,
            onChangeText = {
                updateRequest(email, password,firstName,lastName,it,apellidoMaterno)
            }
        )
        TextInputComponent(
            modifier = Modifier,
            placeholder = "email",
            text = email,
            onChangeText = {
                updateRequest(it, password,firstName,lastName,matricula,apellidoMaterno)
            }
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
            Button(onClick = { onCreateAccount()}) {
                Text(text = "Crear cuenta")
            }
        }
    }
}