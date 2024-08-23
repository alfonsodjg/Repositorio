package com.example.repositorio.ui.modules.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repositorio.domain.modules.home.mapper.toUI
import com.example.repositorio.domain.modules.home.usecase.BooksUseCase
import com.example.repositorio.ui.modules.home.viewstate.HomeViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    private val getBooksUseCase = BooksUseCase()

    private val _viewState = MutableStateFlow(HomeViewState())
    val viewState = _viewState.asStateFlow()

    fun getBooks(token: String) {
        viewModelScope.launch {
            val response = getBooksUseCase.getBooks(token)

            _viewState.update {
                it.updateBooks(bookModelUI = response!!.toUI())
            }
            }
        }
    }