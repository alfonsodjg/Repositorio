package com.example.repositorio.ui.home.viewstate

import com.example.repositorio.ui.home.model.BookResponseModelUI

data class HomeViewState(
    val bookModelUI: BookResponseModelUI = BookResponseModelUI(),
){
    fun updateBooks(bookModelUI: BookResponseModelUI) = copy(bookModelUI = bookModelUI)
}
