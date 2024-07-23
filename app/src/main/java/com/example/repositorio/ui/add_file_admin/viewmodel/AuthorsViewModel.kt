package com.example.repositorio.ui.add_file_admin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repositorio.domain.add_file_admin.usecase.GetAuthorsUseCase
import com.example.repositorio.domain.add_file_admin.usecase.GetTypePublicationsUseCase
import com.example.repositorio.ui.add_file_admin.mapper.toUI
import com.example.repositorio.ui.add_file_admin.viewstate.AuthorsViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AuthorsViewModel : ViewModel() {
    private val authorsUseCase = GetAuthorsUseCase()
    private val getTypes = GetTypePublicationsUseCase()
    private val _state = MutableStateFlow(AuthorsViewState())
    val state = _state.asStateFlow()

    fun onAuthorList() {
        viewModelScope.launch {
            val response = authorsUseCase()
            _state.update {
                it.updateAuthorsList(authors = response!!.map { it.toUI() })
            }
        }
    }

    fun onTypes(){
        viewModelScope.launch {
            val response = getTypes()
            _state.update {
                it.updateTypes(types = response!!.map { it.toUI() })
            }
        }
    }
}