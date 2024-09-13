package com.example.repositorio.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun ProgressPreView() {
    ProgressComponent(
        step1 = Color.Red
    )
}

@Composable
fun ProgressComponent(
    step1: Color = Color.Red,
    step2: Color = Color.LightGray,
    step3: Color = Color.LightGray
) {
    Row(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 10.dp)
            .fillMaxWidth()
            .height(30.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(8.dp)
                .border(100.dp,color = step1, shape = RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp))
        )

        Box(
            modifier = Modifier
                .padding(start = 5.dp)
                .background(step2)
                .weight(1f)
                .height(8.dp)
        )

        Box(
            modifier = Modifier
                .padding(start = 5.dp)
                .weight(1f)
                .height(8.dp)
                .border(100.dp,color = step3, shape = RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp))
        )
    }
}