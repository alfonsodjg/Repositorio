package com.example.repositorio.ui.modules.add_author.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AddAuthorView(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Soy el agregar author")
    }
}