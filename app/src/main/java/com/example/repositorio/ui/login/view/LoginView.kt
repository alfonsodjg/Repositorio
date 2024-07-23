package com.example.repositorio.ui.login.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.repositorio.R
import com.example.repositorio.components.TextInputComponent
import com.example.repositorio.components.TextInputPassComponent
import com.example.repositorio.data.login.model.LoginResponse
import com.example.repositorio.ui.login.viewmodel.LoginViewModel

@Composable
fun LoginView(
    viewModel: LoginViewModel,
    navController: NavController
) {
    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loginResponse: LoginResponse? by viewModel.loginResponse.observeAsState()
    val showErrorMessage: Boolean by viewModel.showErrorMessage.observeAsState(initial = false)
    val context = LocalContext.current

    LaunchedEffect(loginResponse){
        loginResponse?.let {
            if (it.token.isNotEmpty()){
                navController.navigate("MainView")
            }
        }
    }

    if (showErrorMessage){
        LaunchedEffect(Unit){
            Toast.makeText(context, "Error de usuario o contraseña", Toast.LENGTH_SHORT).show()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LazyColumn(){
            item {
                Header()
                Body(email, password,viewModel)
                Footer()
            }
        }
    }
}

@Composable
fun Header(){
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = null
    )
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
}

@Composable
fun Body(email: String, password: String, viewModel: LoginViewModel) {
    TextInputComponent(
        modifier = Modifier,
        placeholder = "Ingresa tu contraseña",
        email = email,
        onChangeText = {viewModel.onChangeText(it, password)}
    )
    TextInputPassComponent(
        modifier = Modifier,
        placeholder = "Ingresa tu contraseña",
        password = password,
        onChangeText = {viewModel.onChangeText(email, it)}
    )

    Button(
        onClick = { viewModel.onLogin(email, password) },
        modifier = Modifier
            .padding(start = 30.dp, end = 30.dp, top = 20.dp)
            .fillMaxWidth()
            .height(45.dp)
    ) {
        Text(text = "Iniciar sesion")
    }
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .padding(start = 30.dp, end = 30.dp, top = 20.dp)
            .fillMaxWidth()
            .height(45.dp)
    ) {
        Text(text = "Registrarse")
    }
}

@Composable
fun Footer(){
    Text(
        text = "¿Haz olvidado tu contraseña?",
        modifier = Modifier
            .padding(top = 30.dp)
            .fillMaxWidth()
            .clickable { },
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
fun LoginViewPreview() {
    val navController = rememberNavController()
    LoginView( viewModel = LoginViewModel(), navController = navController)
}