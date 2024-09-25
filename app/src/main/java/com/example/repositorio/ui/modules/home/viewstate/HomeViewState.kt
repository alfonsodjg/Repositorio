package com.example.repositorio.ui.modules.home.viewstate

import android.net.Uri
import com.example.repositorio.ui.modules.home.model.BookModelUI

sealed class BookDetail {
    data object DownloadSuccess : BookDetail()
}

data class HomeViewState(
    val response: BookModelUI = BookModelUI(),
    val pdfFile: Uri? = null,
    var callBackViewState: (BookDetail) -> Unit = {},
) {
    fun updateBooks(
        response: BookModelUI
    ) = copy(response = response)
    fun updatePdfFile(pdfFile: Uri?) = copy(pdfFile = pdfFile)
}
