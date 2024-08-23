package com.example.repositorio.ui.modules.add_file_admin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repositorio.domain.modules.add_file_admin.usecase.GetAuthorsUseCase
import com.example.repositorio.domain.modules.add_file_admin.usecase.GetTypePublicationsUseCase
import com.example.repositorio.domain.modules.add_file_admin.usecase.UploadBookUseCase
import com.example.repositorio.ui.modules.add_file_admin.mapper.toUI
import com.example.repositorio.ui.modules.add_file_admin.viewstate.AuthorsViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.ResponseBody

class AuthorsViewModel : ViewModel() {
    private val authorsUseCase = GetAuthorsUseCase()
    private val getTypes = GetTypePublicationsUseCase()
    private val uploadBookUseCase = UploadBookUseCase()
    private val _state = MutableStateFlow(AuthorsViewState())
    private val _selectedPdf = MutableStateFlow("")
    val selectedPdf: StateFlow<String> = _selectedPdf
    private val _selectedImage = MutableStateFlow("")
    val selectedImage: StateFlow<String> = _selectedImage
    private val _uploadState = MutableLiveData<Result<ResponseBody>>()
    val uploadState: LiveData<Result<ResponseBody>> = _uploadState
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
    fun onPdfSelected(fileName: String) {
        _selectedPdf.value = fileName
    }
    fun onImageSelected(imageName: String) {
        _selectedImage.value = imageName
    }
    /*fun uploadBook(
        titulo: String,
        imagenFile: File?,
        materia: String,
        fechaPublicacion: String,
        tipoPublicacion: String,
        pdfFile: File?,
        resumen: String,
        autor: String
    ) {
        viewModelScope.launch {
            val result = uploadBookUseCase(
                titulo,
                imagenFile,
                materia,
                fechaPublicacion,
                tipoPublicacion,
                pdfFile,
                resumen,
                autor
            )
            _uploadState.value = result
        }
    }*/
}