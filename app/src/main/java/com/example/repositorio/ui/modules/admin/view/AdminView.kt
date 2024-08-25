package com.example.repositorio.ui.modules.admin.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
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
import com.example.repositorio.R
import com.example.repositorio.components.CustomBottomBarComponent
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun AdminView(
    onGoToHome:()->Unit,
    onGoToProfile:()->Unit,
    onGoToAbout:()->Unit,
    onGoToAdmin:()->Unit,
    onGoToAddFile:()->Unit
){
    val systemUiController = rememberSystemUiController()
    val statusBarColor = Color.Yellow

    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = true
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.largo),
                    contentDescription = null,
                    modifier = Modifier.width(330.dp)
                )
            }
            Text(
                text = "SITIO DE ADMINISTRADOR",
                fontSize = 35.sp,
                fontWeight = FontWeight.W800,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 35.dp),
                textAlign = TextAlign.Center,
                lineHeight = 34.sp
            )

            Box(
                modifier = Modifier.fillMaxWidth()
                    .weight(1f)
                    .padding(top = 140.dp),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Button(onClick = {
                        onGoToAddFile()
                    }) {
                        Text(text = "Agregar documento")
                    }
                    Button(
                        onClick = {
                        },
                        modifier = Modifier.padding(top = 10.dp)
                    ) {
                        Text(text = "Agregar documento")
                    }
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
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun AdminPreView(){
    val context = LocalContext.current
    AdminView(
        onGoToHome = {},
        onGoToProfile = {},
        onGoToAbout = {},
        onGoToAdmin = {},
        onGoToAddFile = {}
    )
}