package com.example.repositorio.ui.modules.share.shareviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.logout.usecase.GetLogOutUseCase
import com.example.repositorio.ui.modules.share.mapper.toUI
import com.example.repositorio.ui.modules.share.shareviewstate.ShareViewStateLogOut
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ShareViewModelLogOut(
   private val logOutUseCase: GetLogOutUseCase
): ViewModel() {
    private val _viewState = MutableStateFlow(ShareViewStateLogOut())
    val viewState = _viewState.asStateFlow()

    fun logOut(token: String){
        viewModelScope.launch {
            val response = logOutUseCase(token)

            when(response){
                is ServiceDomainHandler.Error -> {
                    println("Error cerrar sesion: ${response.exception.code} message: ${response.exception.message}")
                }
                is ServiceDomainHandler.Success -> {
                    _viewState.update {
                        it.updateResponse(response.data.toUI())
                    }
                }
            }
        }
    }
}