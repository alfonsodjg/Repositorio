package com.example.repositorio.ui.modules.profile.view

import android.app.Activity
import android.provider.ContactsContract.Profile
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
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
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.repositorio.ui.modules.profile.viewmodel.BookViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.repositorio.R
import com.example.repositorio.components.CustomBottomBarComponent
import com.example.repositorio.core.utils.SaveToken
import com.example.repositorio.ui.modules.share.shareviewmodel.ShareViewModelLogOut
import com.example.repositorio.ui.theme.AppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import org.koin.androidx.compose.koinViewModel


@Composable
fun ProfileRecovery(
    viewModel: BookViewModel = viewModel(),
    onGoToHome: () -> Unit,
    onGoToProfile: () -> Unit,
    onGoToAbout: () -> Unit,
    onGoToAdmin: () -> Unit,
    showBottomSheetLogOut: MutableState<Boolean>,
    onLogOut:()->Unit
) {
    val state = viewModel.viewState.observeAsState()
    val systemUiController = rememberSystemUiController()
    val statusBarColor = Color.Yellow
    val context = LocalContext.current

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
        matricula = state.value?.userInfoModelUI?.matricula.toString(),
        onGoToHome = onGoToHome,
        onGoToProfile = onGoToProfile,
        onGoToAbout = onGoToAbout,
        onGoToAdmin = onGoToAdmin,
        onLogOut = onLogOut
    )
    BackHandler {
        showBottomSheetLogOut.value = true
    }
}

@Composable
fun ProfileView(
    name: String,
    lastName: String,
    lastNameTwo: String,
    matricula: String,
    onGoToHome: () -> Unit,
    onGoToProfile: () -> Unit,
    onGoToAbout: () -> Unit,
    onGoToAdmin: () -> Unit,
    onLogOut:()->Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

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
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(top = 50.dp)
            )
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 150.dp)
                    .padding(start = 15.dp, end = 15.dp, top = 100.dp),
                color = AppTheme.colors.cardColor,
                shape = RoundedCornerShape(10.dp)
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 15.dp, vertical = 15.dp)
                ) {
                    Text(
                        text = "Nombre: $name",
                        fontSize = 16.sp,
                        color = AppTheme.colors.textColor,
                        fontWeight = FontWeight.W400
                    )
                    Text(
                        text = "Apellido paterno: $lastName",
                        fontSize = 16.sp,
                        color = AppTheme.colors.textColor,
                        fontWeight = FontWeight.W400
                    )
                    Text(
                        text = "Apellido materno: $lastNameTwo",
                        fontSize = 16.sp,
                        color = AppTheme.colors.textColor,
                        fontWeight = FontWeight.W400
                    )
                    Text(
                        text = "Matricula: $matricula",
                        fontSize = 16.sp,
                        color = AppTheme.colors.textColor,
                        fontWeight = FontWeight.W400
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 50.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    modifier = Modifier.height(50.dp),
                    onClick = { onLogOut() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppTheme.colors.colorLogin,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(7.dp)
                ) {
                    Text(
                        text = "Cerrar sesion",
                        fontSize = 12.sp
                    )
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
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_2
)
@Composable
fun ProfilePreView(
) {
    AppTheme {
        ProfileView(
            name = "Ivan",
            lastName = "Jeronimo",
            lastNameTwo = "Mariano",
            matricula = "186w0999",
            onGoToHome = {},
            onGoToProfile = {},
            onGoToAbout = {},
            onGoToAdmin = {},
            onLogOut = {}
        )
    }
}