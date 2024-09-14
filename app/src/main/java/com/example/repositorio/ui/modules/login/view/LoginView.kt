package com.example.repositorio.ui.modules.login.view

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.compose.rememberNavController
import com.example.repositorio.R
import com.example.repositorio.components.ErrorComponent
import com.example.repositorio.components.FooterComponent
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
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    LaunchedEffect(token) {
        token.let {
            if (token.isNotEmpty()) {
                onGoToHome()
            }
        }
    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    keyboardController?.hide()
                    focusManager.clearFocus()
                })
            }
            .background(AppTheme.colors.colorLogin)
            .windowInsetsPadding(WindowInsets.ime)
    ) {
        val (headerContainer, bodyContainer, footerContainer) = createRefs()

        Column(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
                .constrainAs(headerContainer) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(bodyContainer.top)
                    height = Dimension.fillToConstraints
                }
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.itsz_logo),
                    contentDescription = null,
                    modifier = Modifier.size(190.dp),
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }
            Text(
                text = "BIENVENIDO",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Text(
                text = "Al repositorio del Instituto Tecnologico Superior de Zongolica",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp),
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 14.sp
            )
        }
        Surface(
            modifier = Modifier
                .constrainAs(bodyContainer) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(footerContainer.top)
                },
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            color = AppTheme.colors.colorFooter
        ) {
            Column(
                modifier = Modifier.padding(top =10.dp)
            ) {
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
                if (hasInteracted.value && !isEmailValid.value) {
                    ErrorComponent(error = "Correo no valido")
                }
                TextInputPassComponent(
                    modifier = Modifier,
                    placeholder = "Ingresa tu contraseña",
                    password = password,
                    onChangeText = { updateCredentials(email, it) }
                )
                if (showError.value && email.isNotEmpty() && password.isNotEmpty()) {
                    ErrorComponent(error = "Verifica tus credenciales e intentalo de nuevo")
                }

                Button(
                    onClick = { onLogin() },
                    modifier = Modifier
                        .padding(start = 30.dp, end = 30.dp, top = 15.dp)
                        .fillMaxWidth()
                        .height(45.dp),
                    enabled = isEnabledButton,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppTheme.colors.colorLogin,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Iniciar sesion")
                }
                Text(
                    text = "¿Haz olvidado tu contraseña?",
                    modifier = Modifier
                        .padding(top = 10.dp, bottom = 20.dp)
                        .fillMaxWidth()
                        .clickable { onGoToResetPass() },
                    textAlign = TextAlign.Center,
                    color = AppTheme.colors.textColor,
                    fontSize = 13.sp
                )
            }
        }
        Box(
            modifier = Modifier
                .constrainAs(footerContainer) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            FooterComponent(
                onGoToAccount = onGoToCreateAccount
            )
        }
    }
}

@Preview(
    backgroundColor = 0xFFB3B0B0,
    showBackground = true,
    device = Devices.PIXEL_2,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun LoginViewPreview() {
    AppTheme {
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
}