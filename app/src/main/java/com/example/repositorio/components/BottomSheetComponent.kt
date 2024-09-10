package com.example.repositorio.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@RequiresApi(Build.VERSION_CODES.Q)
@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_2
)
@Composable
fun BottomPreView() {
    BottomSheetComponent(
        title = "Servicio no disponible",
        description = "Por el momento el servicio no esta disponible, intentalo mas tarde",
        textButton = "Cerrar",
        onDismiss = {},
        onGoHome = {}
    )
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun BottomSheetComponent(
    title: String,
    description: String,
    textButton: String,
    onDismiss: () -> Unit,
    onGoHome: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = true,
            decorFitsSystemWindows = false
        )
    ) {
        EnableEdgeToEdgeDialog(key = Unit)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xCCE0E0E0)),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(
            ) {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
                    color = Color.White
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(360.dp)
                            .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                    ) {
                        Text(
                            text = title,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W800,
                            color = Color.Black
                        )
                        Text(
                            text = description,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W400,
                            modifier = Modifier.padding(top = 24.dp),
                            color = Color.Black
                        )
                        Box(
                            modifier = Modifier.fillMaxWidth()
                                .width(100.dp)
                        ) {
                            Button(
                                onClick = {
                                    //onGoHome()
                                    onDismiss()
                                },
                                modifier = Modifier
                                    .height(85.dp)
                                    .padding(top = 15.dp, bottom = 20.dp)
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Blue,
                                    contentColor = Color.Black
                                )
                            ) {
                                Text(text = textButton,
                                    color = Color.White)
                            }
                        }
                        Spacer(modifier = Modifier.windowInsetsBottomHeight(WindowInsets.systemBars))
                    }
                }
            }
        }
    }
}