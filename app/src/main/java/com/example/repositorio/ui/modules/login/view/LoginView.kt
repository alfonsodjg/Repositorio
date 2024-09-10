package com.example.repositorio.ui.modules.login.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.repositorio.R
import com.example.repositorio.components.ErrorComponent
import com.example.repositorio.components.TextInputComponent
import com.example.repositorio.components.TextInputPassComponent

@Composable
fun LoginView(
    onGoToCreateAccount: () -> Unit,
    onGoToHome: () -> Unit,
    onGoToResetPass: () -> Unit,
    token: String,
    email: String,
    password: String,
    updateCredentials: (String, String) -> Unit,
    onLogin: () -> Unit,
    showError: MutableState<Boolean>
) {
    val context = LocalContext.current

    LaunchedEffect(token) {
        token.let {
            if (token.isNotEmpty()) {
                onGoToHome()
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.newlogo),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
        }
        Text(
            text = "BIENVENIDO",
            modifier = Modifier
                .fillMaxWidth(),
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
        Text(
            text = "Al repositorio del Instituto Tecnologico Superior de Zongolica",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.Black
        )

        TextInputComponent(
            modifier = Modifier,
            placeholder = "Ingresa tu contraseña",
            text = email,
            onChangeText = { updateCredentials(it, password) }
        )
        TextInputPassComponent(
            modifier = Modifier,
            placeholder = "Ingresa tu contraseña",
            password = password,
            onChangeText = { updateCredentials(email, it) }
        )
        if (showError.value){
            ErrorComponent(error = "Verifica tus credenciales e intentalo de nuevo")
        }
        Button(
            onClick = { onLogin() },
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp, top = 20.dp)
                .fillMaxWidth()
                .height(45.dp)
        ) {
            Text(text = "Iniciar sesion")
        }
        Button(
            onClick = { onGoToCreateAccount() },
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp, top = 20.dp)
                .fillMaxWidth()
                .height(45.dp)
        ) {
            Text(text = "Registrarse")
        }
        Text(
            text = "¿Haz olvidado tu contraseña?",
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .clickable { onGoToResetPass() },
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun LoginViewPreview() {
    val navController = rememberNavController()
    LoginView(
        onGoToCreateAccount = {},
        onGoToHome = {},
        onGoToResetPass = {},
        token = "",
        email = "",
        password = "",
        updateCredentials = { _, _ ->

        },
        onLogin = {},
        showError = remember {
            mutableStateOf(false)
        }
    )
}