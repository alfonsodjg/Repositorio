package com.example.repositorio.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.repositorio.R

@Preview(
    showBackground = true
)
@Composable
fun ErrorPreview() {
    ErrorComponent(
        error = "Codigo invalido"
    )
}

@Composable
fun ErrorComponent(
    error: String
) {
    Surface(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(5.dp),
        color = Color(0xFFCFCDCD)
    ) {
        Row(
            modifier = Modifier.padding(start = 14.dp, end = 14.dp, top = 4.dp, bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_error),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = error,
                fontSize = 12.sp,
                color = Color.Black
            )
        }
    }
}