package com.example.repositorio.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.repositorio.ui.theme.AppTheme

@Composable
fun FooterComponent(
    onGoToAccount:()->Unit
){
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = AppTheme.colors.colorRegisterAccount
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .clickable { onGoToAccount() },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "No tengo cuenta",
                modifier = Modifier,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W600,
                color = AppTheme.colors.textBlackWhite,
                fontSize = 14.sp
            )
            OutlinedButton(
                onClick = { onGoToAccount() },
                modifier = Modifier
                    .padding(start = 10.dp)
                    .heightIn(min = 30.dp),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(1.dp, AppTheme.colors.textBlackWhite)
            ) {
                Text(
                    text = "Registrarme",
                    textAlign = TextAlign.Center,
                    color = Color.Red,
                    fontSize = 14.sp
                )
            }
        }
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun FooterPreView(){
    AppTheme {
        FooterComponent(
            onGoToAccount = {}
        )
    }
}