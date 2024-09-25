package com.example.repositorio.ui.modules.home

import android.content.Intent
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.repositorio.components.SnackBarMessageSimple
import com.example.repositorio.core.utils.SaveToken
import com.example.repositorio.navigation.main.DialogEvents
import com.example.repositorio.navigation.main.core.SingleActionUI
import com.example.repositorio.ui.modules.home.view.HomeView
import com.example.repositorio.ui.modules.home.viewmodel.HomeViewModel
import com.example.repositorio.ui.modules.home.viewstate.BookDetail
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeRecovery(
    viewModel: HomeViewModel = koinViewModel(),
    onGoToHome: () -> Unit,
    onGoToProfile: () -> Unit,
    onGoToAbout: () -> Unit,
    onGoToAdmin: () -> Unit,
    showBottomSheetLogOut: MutableState<Boolean>
) {
    val state = viewModel.viewState.collectAsStateWithLifecycle()
    val sharedFlow = viewModel.sharedFlow.collectAsState(initial = SingleActionUI.None)
    val context = LocalContext.current
    val snackScope = rememberCoroutineScope()
    val snackBarHotState = remember {
        SnackbarHostState()
    }
    LaunchedEffect(Unit) {
        viewModel.getBooks(token = SaveToken.token ?: "")
    }
    state.value.callBackViewState = {
        when(it){
            BookDetail.DownloadSuccess -> {
                snackScope.launch {
                    snackBarHotState.showSnackbar(
                        message = "Libro descargado correctamente",
                        duration = SnackbarDuration.Long,
                        actionLabel = "Abrir"
                    )
                }
            }
        }
    }
    Box {
        HomeView(
            onGoToHome = onGoToHome,
            onGoToProfile = onGoToProfile,
            onGoToAbout = onGoToAbout,
            onGoToAdmin = onGoToAdmin,
            books = state.value.response.results,
            onDownloadBook = {
                viewModel.downloadPdfBook(context,it)
            },
            onShareBook = {
                viewModel.sharePdf(context, it)
            }
        )
        Box (
            modifier = Modifier.padding(top = 16.dp)
        ){
            SnackBarMessageSimple(
                snackBarHostState = snackBarHotState,
                textAction = "Abrir",
                onAction = {
                    state.value.pdfFile?.let { uri->
                        val sharedIntent = Intent(Intent.ACTION_VIEW)
                        sharedIntent.setDataAndType(uri, "application/pdf")
                        sharedIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or Intent.FLAG_GRANT_READ_URI_PERMISSION)
                        context.startActivity(Intent.createChooser(sharedIntent,"Abrir"))
                    }
                    snackBarHotState.currentSnackbarData?.dismiss()
                }
            )
        }
    }
    BackHandler {
        showBottomSheetLogOut.value = true
    }
    DialogEvents(singleActionUI = sharedFlow.value)
}