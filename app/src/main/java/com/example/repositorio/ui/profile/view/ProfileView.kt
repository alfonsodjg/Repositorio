package com.example.repositorio.ui.profile.view

import android.app.Activity
import android.provider.ContactsContract.Profile
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.repositorio.ui.profile.viewmodel.BookViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.repositorio.R
import com.example.repositorio.core.utils.SaveToken
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun ProfileRecovery(
    viewModel: BookViewModel = viewModel()
) {
    val state = viewModel.viewState.observeAsState()
    val systemUiController = rememberSystemUiController()
    val statusBarColor = Color.Yellow

    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = true
        )
    }

    LaunchedEffect(Unit) {
        SaveToken.token?.let { viewModel.fetchUserInfo(it) }
    }
    ProfileView(
        name = state.value?.userInfoModelUI?.first_name.toString(),
        lastName = state.value?.userInfoModelUI?.last_name.toString(),
        lastNameTwo = state.value?.userInfoModelUI?.apellido_materno.toString(),
        matricula = state.value?.userInfoModelUI?.matricula.toString()
    )
}

@Composable
fun ProfileView(
    name: String,
    lastName: String,
    lastNameTwo: String,
    matricula: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            .background(Color.White)
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(top = 50.dp)
            )
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 150.dp)
                .padding(start = 15.dp, end = 15.dp, top = 100.dp),
            color = Color.White,
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(1.dp, color = Color.Black)
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 15.dp)
            ) {
                Text(
                    text = "Nombre: $name",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Apellido paterno: $lastName",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Apellido materno: $lastNameTwo",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Matricula: $matricula",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 90.dp),
            contentAlignment = Alignment.Center
        ) {
            Button(
                modifier = Modifier.height(50.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Cerrar sesion")
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ProfilePreView(
) {
    ProfileView(
        name = "Ivan",
        lastName = "Jeronimo",
        lastNameTwo = "Mariano",
        matricula = "186w0999"
    )
}