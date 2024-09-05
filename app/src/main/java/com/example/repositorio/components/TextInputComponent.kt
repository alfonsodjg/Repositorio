package com.example.repositorio.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextInputComponent(
    modifier:Modifier,
    placeholder:String,
    text: String?="",
    onChangeText: (String) -> Unit
){
    OutlinedTextField(
        value = text?: "" ,
        onValueChange = {onChangeText(it)},
        placeholder = {
            Text(text = placeholder)
        },
        modifier = modifier
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .fillMaxWidth()
            .height(60.dp),
        shape = RoundedCornerShape(10.dp)
    )
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
fun TextInputComponentPreView(){
    TextInputComponent(modifier = Modifier, "Ingresa tu contraseña", "", onChangeText = {})
}