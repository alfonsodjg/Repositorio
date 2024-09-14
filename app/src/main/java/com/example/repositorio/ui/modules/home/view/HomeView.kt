package com.example.repositorio.ui.modules.home.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.repositorio.core.utils.SaveToken
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.repositorio.R
import com.example.repositorio.components.CustomBottomBarComponent
import com.example.repositorio.domain.modules.home.model.BooksDomainModel
import com.example.repositorio.ui.modules.home.viewmodel.HomeViewModel
import com.example.repositorio.ui.theme.AppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Preview(
    device = Devices.PIXEL_2,
    showSystemUi = true,
    showBackground = true
)
@Composable
fun HomePreView() {
    AppTheme {
        HomeView(
            onGoToHome = {},
            onGoToProfile = {},
            onGoToAbout = {},
            onGoToAdmin = {}
        )
    }
}

@Composable
fun HomeView(
    viewModel: HomeViewModel = viewModel(),
    onGoToHome: () -> Unit,
    onGoToProfile: () -> Unit,
    onGoToAbout: () -> Unit,
    onGoToAdmin: () -> Unit
) {
    val state = viewModel.viewState.collectAsState()
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

    LaunchedEffect(Unit) {
        viewModel.getBooks(SaveToken.token!!)
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
            Image(
                painter = painterResource(id = R.drawable.largo),
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 5.dp)
            )
            state.value.bookModelUI.results.forEach {
                Column {
                    BookCard(book = it)
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

@Composable
fun BookCard(book: BooksDomainModel) {
    Surface(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        color = AppTheme.colors.cardColor,
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Column {
                AsyncImage(
                    model = book.imagen,
                    contentDescription = null,
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp)
                )
                Text(
                    text = "Titulo: ${book.titulo}",
                    fontSize = 16.sp,
                    color = AppTheme.colors.textColor
                )
                Text(
                    text = "Materia: ${book.materia}",
                    fontSize = 14.sp,
                    color = AppTheme.colors.textColor
                )
            }
        }
    }
}