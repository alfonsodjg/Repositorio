package com.example.repositorio.ui.profile.viewstate

import com.example.repositorio.ui.profile.model.UserInfoModelUI

data class BooksViewState(
    val userInfoModelUI: UserInfoModelUI = UserInfoModelUI()
){
    fun updateUserInfo( userInfoModelUI: UserInfoModelUI) = copy(userInfoModelUI = userInfoModelUI)
}
