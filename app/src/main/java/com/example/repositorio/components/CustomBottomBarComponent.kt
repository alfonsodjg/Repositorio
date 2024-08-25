package com.example.repositorio.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.repositorio.R

@Composable
fun CustomBottomBarComponent(
    onGoToHome: () -> Unit,
    onGoToProfile: () -> Unit,
    onGoToAbout:()->Unit,
    onGoToAdmin:()->Unit
) {
    Surface(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth().background(Color.White),
        color = Color.Blue,
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable { onGoToHome() },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp).padding(top = 5.dp)
                )
                Text(text = "Home", fontSize = 12.sp, fontWeight = FontWeight.W800)
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable { onGoToProfile() },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.usuario),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp).padding(top = 5.dp)
                )
                Text(text = "Profile", fontSize = 12.sp, fontWeight = FontWeight.W800)
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable { onGoToAbout() },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.information),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp).padding(top = 5.dp)
                )
                Text(text = "About", fontSize = 12.sp, fontWeight = FontWeight.W800)
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable { onGoToAdmin() },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_admi),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp).padding(top = 5.dp)
                )
                Text(text = "Admin", fontSize = 12.sp, fontWeight = FontWeight.W800)
            }
        }
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    CustomBottomBarComponent(
        onGoToHome = { /*TODO*/ },
        onGoToProfile = {},
        onGoToAbout = {},
        onGoToAdmin = {}
    )
}