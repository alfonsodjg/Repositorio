package com.example.repositorio.ui.modules.about.view

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.repositorio.R
import com.example.repositorio.components.CustomBottomBarComponent
import com.example.repositorio.ui.theme.AppTheme
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
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = true
        )
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
            .background(AppTheme.colors.containerColor)
            .windowInsetsPadding(WindowInsets.ime)
    ) {
        val (header, footer) = createRefs()

        Column(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
                .constrainAs(header) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(footer.top)
                    height = Dimension.fillToConstraints
                }
        ) {
            Text(text = "Acerca de...",
                fontSize = 40.sp,
                color = AppTheme.colors.textColor,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(
                    start = 20.dp, end = 20.dp, top = 10.dp
                )
            )
            Text(
                text = "Bienvenido ala aplicación del repositorio institucionaldel tecnológico Superior de Zongolica con sede en Nogales Veracruz.",
                color = AppTheme.colors.textColor,
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
                color = AppTheme.colors.textColor,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp,top = 15.dp)
            )
            Text(
                text = "Version de app 1.0",
                color = AppTheme.colors.textColor,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp,top = 15.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, bottom = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppTheme.colors.colorLogin,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(7.dp)
                ) {
                    Text(text = "Ver manual de usuario")
                }
            }
        }
        Box(
            modifier = Modifier.constrainAs(footer){
                start.linkTo(parent.start)
                top.linkTo(header.bottom)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
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
    showBackground = true,
    device = Devices.PIXEL_2,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun InfoPreView(){
    AppTheme {
        AboutView(
            onGoToHome = {},
            onGoToProfile = {},
            onGoToAbout = {},
            onGoToAdmin = {}
        )
    }
}