package com.example.repositorio.ui.profile.viewmodel

import androidx.lifecycle.*
import com.example.repositorio.domain.profile.usecase.ProfileUseCase
import com.example.repositorio.ui.profile.mapper.toUI
import com.example.repositorio.ui.profile.viewstate.BooksViewState
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {
    private val profileUseCase = ProfileUseCase()

    private val _viewState = MutableLiveData(BooksViewState())
    val viewState: LiveData<BooksViewState> = _viewState


    fun fetchUserInfo(token: String) {
        viewModelScope.launch {
            val response = profileUseCase.getUserInfo(token)

            response?.let {
                val userInfo = it.toUI()
                _viewState.value = _viewState.value?.updateUserInfo(userInfo)
            }
        }
    }
}