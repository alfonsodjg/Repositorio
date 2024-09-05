package com.example.repositorio.ui.modules.add_author.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repositorio.components.SpinnerComponent
import com.example.repositorio.components.TextInputComponent
import com.example.repositorio.ui.modules.add_author.model.CampusModelUI
import com.example.repositorio.ui.modules.add_author.model.CarrerasModelUI
import com.example.repositorio.ui.modules.add_author.model.CreateAuthorRequestUI
import java.io.File

@Composable
@Preview(
    showSystemUi = true,
    showBackground = true
)
fun AddAuthorPreView(){
    AddAuthorView(
        carreras = emptyList(),
        campus = emptyList(),
        request = CreateAuthorRequestUI(),
        createAuthor = {}
    )
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
        modifier = Modifier.fillMaxSize()
    ) {
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
            Button(onClick = { createAuthor()}) {
                Text(text = "Agregar autor")
            }
        }
    }
}