package com.example.repositorio.ui.modules.admin.view

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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
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
import com.example.repositorio.R
import com.example.repositorio.components.CustomBottomBarComponent
import com.example.repositorio.ui.theme.AppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun AdminView(
    onGoToHome: () -> Unit,
    onGoToProfile: () -> Unit,
    onGoToAbout: () -> Unit,
    onGoToAdmin: () -> Unit,
    onGoToAddFile: () -> Unit,
    onGoToAddAuthor: () -> Unit
) {
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
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                contentAlignment = Alignment.Center
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
                fontWeight = FontWeight.W700,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 35.dp),
                textAlign = TextAlign.Center,
                lineHeight = 34.sp,
                color = AppTheme.colors.textColor
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(top = 140.dp),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Button(
                        onClick = {
                            onGoToAddFile()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AppTheme.colors.colorLogin,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(7.dp),
                        modifier = Modifier.width(210.dp)
                    ) {
                        Text(text = "Agregar documento")
                    }
                    Button(
                        onClick = {
                            onGoToAddAuthor()
                        },
                        modifier = Modifier.padding(top = 10.dp)
                                .width(210.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AppTheme.colors.colorLogin,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(7.dp)
                    ) {
                        Text(text = "Agregar autor")
                    }
                }
            }
        }
        Box(
            modifier = Modifier.constrainAs(footer) {
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
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_2,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun AdminPreView() {
    val context = LocalContext.current
    AppTheme {
        AdminView(
            onGoToHome = {},
            onGoToProfile = {},
            onGoToAbout = {},
            onGoToAdmin = {},
            onGoToAddFile = {},
            onGoToAddAuthor = {}
        )
    }
}