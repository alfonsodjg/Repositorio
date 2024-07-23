package com.example.repositorio.ui.add_file_admin.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.repositorio.R
import com.example.repositorio.components.Spinner
import com.example.repositorio.components.TextInputComponent
import com.example.repositorio.components.bottomnavigation.ItemsMenu
import com.example.repositorio.ui.add_file_admin.viewmodel.AuthorsViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun AddFileRecovery(){

}
@Composable
fun AddFileAdminView(
    navController: NavController,
    viewModel: AuthorsViewModel = viewModel()
) {
    val systemUiController = rememberSystemUiController()
    val statusBarColor = Color.Yellow
    val state = viewModel.state.collectAsState()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = true
        )
    }
    LaunchedEffect(Unit){
        viewModel.onAuthorList()
        viewModel.onTypes()
    }
    println("Hola que tal ${state.value.authors.size}")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp, horizontal = 20.dp),
            color = Color.Blue,
            shape = RoundedCornerShape(10.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .verticalScroll(state = rememberScrollState())
                        .padding(bottom = 100.dp)
                ) {
                    Button(onClick = { navController.navigate(ItemsMenu.Admin.route) }) {
                        Text(text = "Regresar")
                    }
                    Image(
                        painter = painterResource(id = R.drawable.file),
                        contentDescription = null
                    )
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Abrir archivo")
                    }
                    TextInputComponent(
                        modifier = Modifier, placeholder = "archivo", onChangeText = {}
                    )
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Imagen")
                    }
                    TextInputComponent(
                        modifier = Modifier, placeholder = "archivo", onChangeText = {}
                    )
                    TextInputComponent(
                        modifier = Modifier, placeholder = "Titulo", onChangeText = {}
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .padding(horizontal = 10.dp),
                        value = "",
                        onValueChange = {},
                        placeholder = { Text(text = "Resumen") },
                        shape = RoundedCornerShape(10.dp),
                        maxLines = 6
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp, vertical = 10.dp),
                        value = "",
                        onValueChange = {},
                        placeholder = { Text(text = "Categoria") },
                        shape = RoundedCornerShape(10.dp),
                        maxLines = 6
                    )
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Fecha de publicacion")
                    }
                    Text(text = "Fecha de publicacion")
                    Spinner(
                        text = "Selecciona un autor",
                        authors = state.value.authors
                    )
                    Spinner(
                        text = "",
                        types = state.value.types
                    )
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Crear archivo")
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Limpiar")
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Cancelar")
                    }
                }
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun AddFilePreView() {
    val context = LocalContext.current
    AddFileAdminView(navController = NavController(context))
}