package com.example.repositorio.ui.modules.add_author.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.add_author.usecase.GetAuthorCreatedUseCase
import com.example.repositorio.domain.modules.add_author.usecase.GetCampusUseCase
import com.example.repositorio.domain.modules.add_author.usecase.GetCarrerasUseCase
import com.example.repositorio.ui.modules.add_author.mapper.toUI
import com.example.repositorio.ui.modules.add_author.model.CreateAuthorRequestUI
import com.example.repositorio.ui.modules.add_author.model.toDomain
import com.example.repositorio.ui.modules.add_author.viewstate.AddAuthorViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AddAuthorViewModel(
    private val getCarreras: GetCarrerasUseCase,
    private val getCampusUseCase: GetCampusUseCase,
    private val getAuthorCreatedUseCase: GetAuthorCreatedUseCase
) : ViewModel() {
    private val _viewState = MutableStateFlow(AddAuthorViewState())
    val viewState = _viewState.asStateFlow()

    fun onGetCarreras() {
        viewModelScope.launch {
            when (val response = getCarreras()) {
                is ServiceDomainHandler.Error -> {

                }

                is ServiceDomainHandler.Success -> {
                    _viewState.update {
                        it.updateCarreras(carreras = response.data.map { carreras -> carreras.toUI() })
                    }
                }
            }
            onGetCampus()
        }
    }

    private fun onGetCampus() {
        viewModelScope.launch {
            when (val response = getCampusUseCase()) {
                is ServiceDomainHandler.Error -> {}
                is ServiceDomainHandler.Success -> {
                    _viewState.update {
                        it.updateCampus(campus = response.data.map { campus -> campus.toUI() })
                    }
                }
            }
        }
    }

    fun updateRequest(request: CreateAuthorRequestUI){
        viewModelScope.launch {
            _viewState.update {
                it.updateRequest(request)
            }
        }
    }

    fun createAuthor(
        token: String,
        request: CreateAuthorRequestUI
        ) {
        viewModelScope.launch {
            val response = getAuthorCreatedUseCase(
                token = token,
                requestDomain = request.toDomain()
            )
            when (response) {
                is ServiceDomainHandler.Error -> {
                    println("A ocurrido un error veamos el codigo: ${response.exception.code} y el mensaje es: ${response.exception.message}")
                }
                is ServiceDomainHandler.Success -> {
                    _viewState.update {
                        it.updateAuthor(author = response.data.toUI())
                    }
                }
            }
        }
    }
}