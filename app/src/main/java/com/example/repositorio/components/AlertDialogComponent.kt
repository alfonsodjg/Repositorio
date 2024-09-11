package com.example.repositorio.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun AlertPreView() {
    AlertDialogComponent(
        title = "Ocurrio un error",
        description = "El correo que proporcionaste no se encuentra registrado",
        onDismiss = {},
        showAlertDialog = remember {
            mutableStateOf(false)
        }
    )
}

@Composable
fun AlertDialogComponent(
    title: String,
    description: String,
    onDismiss: () -> Unit,
    showAlertDialog: MutableState<Boolean>
) {
    if (showAlertDialog.value){
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            AlertDialog(
                onDismissRequest = {
                    onDismiss()
                },
                confirmButton = {
                    Text(
                        text = "Aceptar",
                        modifier = Modifier.clickable {
                            onDismiss()
                        }
                    )
                },
                title = { Text(text = title) },
                text = { Text(text = description) },
                shape = RoundedCornerShape(19.dp)
            )
        }
    }
}