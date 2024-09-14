package com.example.repositorio.ui.modules.add_author

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.repositorio.core.utils.SaveToken
import com.example.repositorio.ui.modules.add_author.view.AddAuthorView
import com.example.repositorio.ui.modules.add_author.viewmodel.AddAuthorViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AddAuthorRecovery(
    viewModel: AddAuthorViewModel = koinViewModel(),
    onTopBarChange:(String)->Unit
) {
    val state = viewModel.viewState.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        onTopBarChange("Agregar autor")
        viewModel.onGetCarreras()
    }

    AddAuthorView(
        carreras = state.value.carreras,
        campus = state.value.campus,
        request = state.value.requestUI,
        updateRequest = { request->
            viewModel.updateRequest(request)
        },
        createAuthor = {
            viewModel.createAuthor(
                token = SaveToken.token?:"",
                request = state.value.requestUI
            )
            println("Valor de token en crear autor ${SaveToken.token}")
        }
    )
}