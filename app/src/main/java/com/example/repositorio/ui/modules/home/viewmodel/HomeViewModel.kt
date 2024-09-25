package com.example.repositorio.ui.modules.home.viewmodel

import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.home.usecase.BookPdfDownloadUseCase
import com.example.repositorio.ui.modules.home.mapper.toUI
import com.example.repositorio.domain.modules.home.usecase.BooksUseCase
import com.example.repositorio.navigation.main.core.SingleActionUI
import com.example.repositorio.ui.modules.home.viewstate.BookDetail
import com.example.repositorio.ui.modules.home.viewstate.HomeViewState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getBooksUseCase: BooksUseCase,
    private val downloadUseCase: BookPdfDownloadUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(HomeViewState())
    val viewState = _viewState.asStateFlow()
    private val _sharedFlow: MutableSharedFlow<SingleActionUI> = MutableSharedFlow()
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun getBooks(token: String) {
        viewModelScope.launch {
            _sharedFlow.emit(SingleActionUI.ShowLoader)
            when(val response = getBooksUseCase.getBooks(token)){
                is ServiceDomainHandler.Error -> {
                    _sharedFlow.emit(SingleActionUI.HideLoader)
                    println("Error ${response.exception.code} message: ${response.exception.message}")
                }
                is ServiceDomainHandler.Success -> {
                    Log.d("HomeViewModel", "Response body: $response")
                    _sharedFlow.emit(SingleActionUI.HideLoader)
                    _viewState.update {
                        it.updateBooks(
                            response = response.data.toUI()
                        )
                    }
                }
            }
        }
    }
    fun downloadPdfBook(idBook: Int, token: String) {
        if (viewState.value.pdfFile != null){
            _viewState.value.callBackViewState(BookDetail.DownloadSuccess)
            return
        }
        viewModelScope.launch {
            _sharedFlow.emit(SingleActionUI.ShowLoader)
            when(val response = downloadUseCase(idBook, token)){
                is ServiceDomainHandler.Error -> {
                    _sharedFlow.emit(SingleActionUI.HideLoader)
                    println("Ocurrio un error ${response.exception.code} message: ${response.exception.message}")
                }
                is ServiceDomainHandler.Success -> {
                    println("Succes: ${response.data.uri}")
                    _sharedFlow.emit(SingleActionUI.HideLoader)
                    _viewState.update {
                        it.updatePdfFile(response.data.uri)
                    }
                    _viewState.value.callBackViewState(BookDetail.DownloadSuccess)
                }
            }
        }
    }
    fun downloadPdfBook(context: Context, pdfUrl: String) {
        val request = DownloadManager.Request(Uri.parse(pdfUrl))
            .setTitle("Descargando PDF")
            .setDescription("Descargando ${Uri.parse(pdfUrl).lastPathSegment}")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, Uri.parse(pdfUrl).lastPathSegment)

        val downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val downloadId = downloadManager.enqueue(request)

        viewModelScope.launch {
            val pdfUri = Uri.parse(pdfUrl)
            _viewState.update {
                it.updatePdfFile(pdfUri)
            }
            _viewState.value.callBackViewState(BookDetail.DownloadSuccess)
        }
    }
    fun sharePdf(context: Context,  pdfUrl: String) {
        pdfUrl.let { pdfUri ->
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_STREAM, pdfUri)
                type = "application/pdf"
            }
            context.startActivity(Intent.createChooser(shareIntent, "Compartir Libro"))
        } ?: run {
            println("No hay PDF disponible para compartir")
        }
    }
}