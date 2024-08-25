package com.example.repositorio.ui.modules.about.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.repositorio.R
import com.example.repositorio.components.CustomBottomBarComponent
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun AboutView(
    onGoToHome:()->Unit,
    onGoToProfile:()->Unit,
    onGoToAbout:()->Unit,
    onGoToAdmin:()->Unit
){
    val systemUiController = rememberSystemUiController()
    val statusBarColor = Color.Yellow

    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = true
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            .background(Color.White)
    ) {
        Text(text = "Acerca de...",
            fontSize = 40.sp,
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(
                start = 20.dp, end = 20.dp, top = 10.dp
            )
        )
        Text(
            text = "Bienvenido ala aplicación del repositorio institucionaldel tecnológico Superior de Zongolica con sede en Nogales Veracruz.",
            color = Color.Black,
            modifier = Modifier.padding(top = 5.dp,start = 20.dp, end = 20.dp)
        )
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.newlogo),
                contentDescription = null
            )
        }
        Text(
            text = "El Instituto Tecnológico Superior de Zongolica ahora cuenta con una aplicación móvil en la cual los estudiantes podrán consultarla información de tesis y proyectos de residencias profesionales.",
            color = Color.Black,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp,top = 15.dp)
        )
        Text(
            text = "Version de app 1.0",
            color = Color.Black,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp,top = 15.dp)
        )
       Box(
           modifier = Modifier.fillMaxWidth().weight(1f)
               .padding(top = 30.dp, bottom = 10.dp),
           contentAlignment = Alignment.Center
       ) {
           Button(onClick = { /*TODO*/ }) {
               Text(text = "Ver manual de usuario")
           }
       }
        Box(
            modifier = Modifier.fillMaxWidth().height(50.dp)
                .background(Color.Black),
            contentAlignment = Alignment.BottomEnd
        ) {
            CustomBottomBarComponent(
                onGoToHome = onGoToHome,
                onGoToProfile = onGoToProfile,
                onGoToAbout = onGoToAbout,
                onGoToAdmin = onGoToAdmin
            )
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun InfoPreView(){
    AboutView(
        onGoToHome = {},
        onGoToProfile = {},
        onGoToAbout = {},
        onGoToAdmin = {}
    )
}