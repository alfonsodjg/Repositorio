package com.example.repositorio.ui.modules.add_author.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.repositorio.components.SpinnerComponent
import com.example.repositorio.components.TextInputComponent
import com.example.repositorio.ui.modules.add_author.model.CampusModelUI
import com.example.repositorio.ui.modules.add_author.model.CarrerasModelUI
import com.example.repositorio.ui.modules.add_author.model.CreateAuthorRequestUI
import com.example.repositorio.ui.theme.AppTheme
import java.io.File

@Composable
@Preview(
    showSystemUi = true,
    showBackground = true,
    device = Devices.PIXEL_2
)
fun AddAuthorPreView(){
    AppTheme {
        AddAuthorView(
            carreras = emptyList(),
            campus = emptyList(),
            request = CreateAuthorRequestUI(),
            createAuthor = {}
        )
    }
}
@Composable
fun AddAuthorView(
    carreras: List<CarrerasModelUI>,
    campus: List<CampusModelUI>,
    request: CreateAuthorRequestUI,
    updateRequest:(request: CreateAuthorRequestUI)->Unit ={} ,
    createAuthor:()->Unit,
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            .background(AppTheme.colors.containerColor)
    ) {
        Surface(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
            color = AppTheme.colors.cardColor,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column {
                Text(
                    text = "Nombre:",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    color = AppTheme.colors.textColor,
                    modifier = Modifier.padding(start = 15.dp, top = 10.dp, bottom = 0.dp)
                )
                TextInputComponent(
                    modifier = Modifier,
                    placeholder = "Nombre",
                    text = request.name,
                    onChangeText = {
                        updateRequest(
                            request.copy(name = it)
                        )
                    }
                )
                Text(
                    text = "Apellido Paterno:",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    color = AppTheme.colors.textColor,
                    modifier = Modifier.padding(start = 15.dp, top = 10.dp, bottom = 0.dp)
                )
                TextInputComponent(
                    modifier = Modifier,
                    placeholder = "Apellido Paterno",
                    text = request.lastFather,
                    onChangeText = {
                        updateRequest(
                            request.copy(lastFather = it)
                        )
                    }
                )
                Text(
                    text = "Apellido materno:",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    color = AppTheme.colors.textColor,
                    modifier = Modifier.padding(start = 15.dp, top = 10.dp, bottom = 0.dp)
                )
                TextInputComponent(
                    modifier = Modifier,
                    placeholder = "Apellido Materno",
                    text = request.lastMother,
                    onChangeText = {
                        updateRequest(
                            request.copy(lastMother = it)
                        )
                    }
                )
                Text(
                    text = "Matriicula:",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    color = AppTheme.colors.textColor,
                    modifier = Modifier.padding(start = 15.dp, top = 10.dp, bottom = 0.dp)
                )
                TextInputComponent(
                    modifier = Modifier,
                    placeholder = "Matricula",
                    text = request.matricula,
                    onChangeText = {
                        updateRequest(
                            request.copy(matricula = it)
                        )
                    }
                )
                Text(
                    text = "Asesor interno:",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    color = AppTheme.colors.textColor,
                    modifier = Modifier.padding(start = 15.dp, top = 10.dp, bottom = 0.dp)
                )
                TextInputComponent(
                    modifier = Modifier,
                    placeholder = "Asesor Interno",
                    text = request.asesorInterno,
                    onChangeText = {
                        updateRequest(
                            request.copy(asesorInterno = it)
                        )
                    }
                )
                Text(
                    text = "Asesor externo:",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    color = AppTheme.colors.textColor,
                    modifier = Modifier.padding(start = 15.dp, top = 10.dp, bottom = 0.dp)
                )
                TextInputComponent(
                    modifier = Modifier,
                    placeholder = "Asesor Externo",
                    text = request.asesorExterto,
                    onChangeText = {
                        updateRequest(
                            request.copy(asesorExterto = it)
                        )
                    }
                )
                Text(
                    text = "Carrera:",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    color = AppTheme.colors.textColor,
                    modifier = Modifier.padding(start = 15.dp, top = 10.dp, bottom = 0.dp)
                )
                SpinnerComponent(
                    items = carreras,
                    text = "Selecciona una carrera" ,
                    labelSelector = {it.name},
                    selectedOptionIndex = request.carrera,
                    onOptionSelected = {
                        updateRequest(
                            request.copy(carrera = it)
                        )
                    }
                )
                Text(
                    text = "Campus:",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    color = AppTheme.colors.textColor,
                    modifier = Modifier.padding(start = 15.dp, top = 10.dp, bottom = 0.dp)
                )
                SpinnerComponent(
                    items = campus,
                    text = "Selecciona un campus",
                    labelSelector = {it.name},
                    modifier = Modifier.padding(top = 10.dp),
                    selectedOptionIndex = request.campus,
                    onOptionSelected = {
                        updateRequest(
                            request.copy(campus = it)
                        )
                    }
                )
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = { createAuthor()},
                        shape = RoundedCornerShape(7.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AppTheme.colors.colorLogin,
                            contentColor = Color.White
                        ),
                        modifier = Modifier.padding(bottom = 20.dp, top = 10.dp)
                    ) {
                        Text(text = "Agregar autor")
                    }
                }
            }
        }
    }
}