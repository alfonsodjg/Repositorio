package com.example.repositorio.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repositorio.R

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun TopBarPreView(){
    TopBarScaffoldComponent(
        title = "Title top bar",
        onBackClick = {  },
        onActionClick = {}
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarScaffoldComponent(
    modifier: Modifier = Modifier,
    title: String,
    enableAction: Boolean = false,
    onBackClick: () -> Unit,
    onActionClick: () -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    TopAppBar(
        modifier =Modifier.fillMaxWidth(),
        title = {
            Text(
                text = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max)
                    .clickable(
                        indication = null,
                        interactionSource = null
                    ) {
                        keyboardController?.hide()
                        focusManager.clearFocus()
                    },
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W800
            )
        },
        navigationIcon = {
                         IconButton(onClick = { onBackClick() }) {
                             Image(
                                 modifier = Modifier.size(24.dp),
                                 painter = painterResource(id = R.drawable.ic_back),
                                 contentDescription = null
                             )
                         }
        },
        actions = {}
    )
}