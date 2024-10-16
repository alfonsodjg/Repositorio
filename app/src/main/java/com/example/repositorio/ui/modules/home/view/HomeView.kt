package com.example.repositorio.ui.modules.home.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.repositorio.core.utils.SaveToken
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.repositorio.R
import com.example.repositorio.domain.modules.home.model.BooksDomainModel
import com.example.repositorio.ui.modules.home.viewmodel.HomeViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun HomeView(
    navController: NavController,
    viewModel: HomeViewModel = viewModel()
) {
    val state = viewModel.viewState.collectAsState()
    val systemUiController = rememberSystemUiController()
    val statusBarColor = Color.Yellow

    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = true
        )
    }

    val token = SaveToken.token
    println("Token desde home ok? ${SaveToken.token}")

    LaunchedEffect(Unit) {
        viewModel.getBooks(SaveToken.token!!)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 100.dp)
        ) {
            item {
                Image(
                    painter = painterResource(id = R.drawable.largo),
                    contentDescription = null,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 35.dp)
                )
            }
            items(state.value.bookModelUI.results){
                BookCard(book = it)
            }
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
        color = Color(0xFFFFFFFF),
        border = BorderStroke(1.dp, color = Color(0xFF000000))
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
                Text(text = "Titulo: ${book.titulo}", fontSize = 22.sp, color = Color.Black)
                Text(text = "Materia: ${book.materia}", fontSize = 20.sp, color = Color.Black)
            }
        }
    }
}