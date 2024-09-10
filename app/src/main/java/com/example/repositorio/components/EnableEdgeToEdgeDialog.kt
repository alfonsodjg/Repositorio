package com.example.repositorio.components

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.window.DialogWindowProvider
import androidx.core.view.WindowInsetsControllerCompat

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun EnableEdgeToEdgeDialog(
    key:Any,
    stackColor: Color  = Color.Transparent
){
    val activityWindow = getActivityWindow()
    val dialogWindow = getDialogWindow()
    val parentView = LocalView.current.parent as View
    val isDarkTheme = isSystemInDarkTheme()
    SideEffect {
        if (activityWindow != null && dialogWindow != null) {
            dialogWindow.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            val attributes = WindowManager.LayoutParams()
            attributes.copyFrom(activityWindow.attributes)
            attributes.type = dialogWindow.attributes.type
            dialogWindow.attributes = attributes
            parentView.layoutParams = FrameLayout.LayoutParams(
                activityWindow.decorView.width,
                activityWindow.decorView.height
            )
            dialogWindow.isStatusBarContrastEnforced = true
            WindowInsetsControllerCompat(dialogWindow, dialogWindow.decorView)
                .isAppearanceLightNavigationBars = !isDarkTheme
            dialogWindow.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
            dialogWindow.setBackgroundDrawableResource(android.R.color.transparent)
            dialogWindow.setDimAmount(0f)
        }
    }
    DisposableEffect(key) {
        onDispose {
            activityWindow?.statusBarColor = stackColor.toArgb()
            activityWindow?.navigationBarColor = stackColor.toArgb()
        }
    }
}
@Composable
fun getDialogWindow(): Window? = (LocalView.current.parent as? DialogWindowProvider)?.window

@Composable
fun getActivityWindow(): Window? = LocalView.current.context.getActivityWindow()

private tailrec fun Context.getActivityWindow(): Window? =
    when (this) {
        is Activity -> window
        is ContextWrapper -> baseContext.getActivityWindow()
        else -> null
    }