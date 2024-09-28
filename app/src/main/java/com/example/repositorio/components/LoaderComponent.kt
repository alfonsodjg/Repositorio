package com.example.repositorio.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.constraintlayout.compose.ConstraintLayout
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.repositorio.R

@Preview
@Composable
fun LoaderPreView() {
    LoaderComponent()
}

@Composable
fun LoaderComponent() {
    Dialog(
        onDismissRequest = {},
        properties = DialogProperties(
            dismissOnClickOutside = false,
            dismissOnBackPress = false,
            usePlatformDefaultWidth = true,
            decorFitsSystemWindows = false
        )
    ) {
        //Falta enabledTogge
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (loading) = createRefs()
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
            val baseGuideline = createGuidelineFromBottom(
                fraction = 0.3f
            )
            Column(
                modifier = Modifier
                    .size(120.dp)
                    .constrainAs(loading) {
                        top.linkTo(parent.top)
                        bottom.linkTo(baseGuideline)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                LottieAnimation(
                    composition = composition,
                    iterations = LottieConstants.IterateForever
                )
            }
        }
    }
}