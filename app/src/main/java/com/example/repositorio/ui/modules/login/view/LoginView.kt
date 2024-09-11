package com.example.repositorio.ui.modules.login.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.ui.graphics.ColorFilter
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
import com.example.repositorio.ui.theme.AppTheme

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
    showError: MutableState<Boolean>,
    isEnabledButton: Boolean
) {
    val context = LocalContext.current
    val isEmailValid = remember { mutableStateOf(true) }
    val hasInteracted = remember { mutableStateOf(false) }

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
            .background(AppTheme.colors.containerColor)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.itsz_logo),
                contentDescription = null,
                modifier = Modifier.size(200.dp),
                colorFilter = ColorFilter.tint(AppTheme.colors.colorLogo)
            )
        }
        Text(
            text = "BIENVENIDO",
            modifier = Modifier
                .fillMaxWidth(),
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = AppTheme.colors.textColor
        )
        Text(
            text = "Al repositorio del Instituto Tecnologico Superior de Zongolica",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = AppTheme.colors.textColor
        )

        TextInputComponent(
            modifier = Modifier,
            placeholder = "Ingresa tu email",
            text = email,
            onChangeText = {
                updateCredentials(it, password)
                hasInteracted.value = true
            },
            isEmailValid = { isValid ->
                isEmailValid.value = isValid
            }
        )
        if (hasInteracted.value && !isEmailValid.value){
            ErrorComponent(error = "Correo no valido")
        }
        TextInputPassComponent(
            modifier = Modifier,
            placeholder = "Ingresa tu contraseña",
            password = password,
            onChangeText = { updateCredentials(email, it) }
        )
        if (showError.value && email.isNotEmpty() && password.isNotEmpty()){
            ErrorComponent(error = "Verifica tus credenciales e intentalo de nuevo")
        }
        Button(
            onClick = { onLogin() },
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp, top = 20.dp)
                .fillMaxWidth()
                .height(45.dp),
            enabled = isEnabledButton
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
            textAlign = TextAlign.Center,
            color = AppTheme.colors.textColor
        )
    }
}

@Preview
@Composable
fun LoginViewPreview() {
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
        },
        isEnabledButton = false
    )
}