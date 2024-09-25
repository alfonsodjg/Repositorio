package com.example.repositorio.components

import android.graphics.ColorFilter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.repositorio.ui.theme.AppTheme

@Composable
fun SnackBarMessageSimple(
    modifier: Modifier = Modifier,
    snackBarHostState: SnackbarHostState,
    image: Painter? = null,
    textAction: String = "",
    onAction: () -> Unit = {}
) {
    SnackbarHost(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .shadow(elevation = 10.dp),
        hostState = snackBarHostState
    ) {
        Snackbar(
            containerColor = AppTheme.colors.snackBarColor,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(AppTheme.colors.snackBarColor),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(start = 8.dp),
                    text = it.visuals.message,
                    color = Color.Black,
                    fontWeight = FontWeight.W500
                )
                Box(
                    modifier = Modifier
                        .defaultMinSize(42.dp)
                        .clickable(
                            indication = null,
                            interactionSource = null
                        ) {
                            onAction()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = textAction,
                        color = AppTheme.colors.textRed,
                        fontWeight = FontWeight.W600
                    )
                }
            }
        }
    }
}