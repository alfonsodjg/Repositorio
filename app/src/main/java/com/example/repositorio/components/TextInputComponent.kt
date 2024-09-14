package com.example.repositorio.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.repositorio.ui.theme.AppTheme

@Composable
fun TextInputComponent(
    modifier: Modifier,
    placeholder: String,
    text: String? = "",
    onChangeText: (String) -> Unit,
    isEmailValid: (Boolean) -> Unit = {}
) {
    val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
    OutlinedTextField(
        value = text ?: "",
        onValueChange = {
            onChangeText(it)
            isEmailValid(emailRegex.matches(it))
        },
        placeholder = {
            Text(
                text = placeholder,
                color = Color.Gray
            )
        },
        modifier = modifier
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .fillMaxWidth()
            .height(60.dp),
        shape = RoundedCornerShape(10.dp),
        textStyle = TextStyle(color = AppTheme.colors.textInput, fontSize = 13.sp),
        singleLine = true
    )
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
fun TextInputComponentPreView() {
    TextInputComponent(modifier = Modifier, "Ingresa tu contraseña", "", onChangeText = {})
}