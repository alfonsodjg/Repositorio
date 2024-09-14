package com.example.repositorio.ui.modules.add_file_admin.view

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repositorio.R
import com.example.repositorio.components.SpinnerComponent
import com.example.repositorio.components.TextInputComponent
import com.example.repositorio.ui.modules.add_file_admin.viewmodel.AuthorsViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.repositorio.ui.core.utils.getFileName
import com.example.repositorio.ui.theme.AppTheme


@Composable
fun AddFileRecovery(
    onTopBarChange:(String)->Unit
) {
    LaunchedEffect(Unit){
        onTopBarChange("Agregar archivo")
    }
    AddFileAdminView()
}

@Composable
fun AddFileAdminView(
    viewModel: AuthorsViewModel = viewModel()
) {
    val systemUiController = rememberSystemUiController()
    val statusBarColor = Color.Yellow
    val state = viewModel.state.collectAsState()
    val selectedPdf by viewModel.selectedPdf.collectAsState()
    val selectedImage by viewModel.selectedImage.collectAsState()
    val uploadState by viewModel.uploadState.observeAsState()
    val context = LocalContext.current

    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = true
        )
    }
    LaunchedEffect(Unit) {
        viewModel.onAuthorList()
        viewModel.onTypes()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.containerColor)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp, horizontal = 20.dp),
            color = AppTheme.colors.cardColor,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(state = rememberScrollState())
                    .padding(bottom = 100.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val pdfPickerLauncher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.OpenDocument()
                ) { uri: Uri? ->
                    uri?.let {
                        val fileName = uri.getFileName(context)
                        viewModel.onPdfSelected(fileName)
                    }
                }
                val imagePickerLauncher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.OpenDocument()
                ) { uri: Uri? ->
                    uri?.let {
                        val imageName = uri.getFileName(context)
                        viewModel.onImageSelected(imageName)
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.file),
                        contentDescription = null
                    )
                }
                Button(
                    onClick = { pdfPickerLauncher.launch(arrayOf("application/pdf")) },
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                        .widthIn(min = 170.dp),
                    shape = RoundedCornerShape(7.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppTheme.colors.colorLogin,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Abrir archivo")
                }
                TextField(
                    value = selectedPdf,
                    placeholder = { Text(text = "archivo") },
                    onValueChange = {},
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp, top = 5.dp)
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = AppTheme.colors.cardColor,
                        unfocusedContainerColor = AppTheme.colors.cardColor
                    )
                )
                Button(
                    onClick = { imagePickerLauncher.launch(arrayOf("image/*")) },
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                        .widthIn(min = 170.dp),
                    shape = RoundedCornerShape(7.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppTheme.colors.colorLogin,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Imagen")
                }
                TextField(
                    value = selectedImage,
                    placeholder = { Text(text = "imagen") },
                    onValueChange = {},
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp, top = 5.dp)
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = AppTheme.colors.cardColor,
                        unfocusedContainerColor = AppTheme.colors.cardColor
                    )
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
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                        .widthIn(min = 170.dp),
                    shape = RoundedCornerShape(7.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppTheme.colors.colorLogin,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Fecha de publicacion")
                }
                Text(text = "Fecha de publicacion")
                SpinnerComponent(
                    text = "Selecciona un autor",
                    items = state.value.authors,
                    labelSelector = { it.name }
                )
                SpinnerComponent(
                    text = "Selecciona tipo de publicacion",
                    items = state.value.types,
                    labelSelector = { it.name }
                )
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                        .widthIn(min = 170.dp),
                    shape = RoundedCornerShape(7.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppTheme.colors.colorLogin,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Crear archivo")
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                        .widthIn(min = 170.dp),
                    shape = RoundedCornerShape(7.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppTheme.colors.colorLogin,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Limpiar")
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                        .widthIn(min = 170.dp),
                    shape = RoundedCornerShape(7.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppTheme.colors.colorLogin,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Cancelar")
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
    AppTheme {
        AddFileAdminView()
    }
}