package com.example.repositorio.ui.modules.home.viewstate

import com.example.repositorio.ui.modules.home.model.BookResponseModelUI

data class HomeViewState(
    val bookModelUI: BookResponseModelUI = BookResponseModelUI(),
){
    fun updateBooks(bookModelUI: BookResponseModelUI) = copy(bookModelUI = bookModelUI)
}
