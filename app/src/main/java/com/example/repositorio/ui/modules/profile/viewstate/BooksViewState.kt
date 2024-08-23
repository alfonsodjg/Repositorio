package com.example.repositorio.ui.modules.profile.viewstate

import com.example.repositorio.ui.modules.profile.model.UserInfoModelUI

data class BooksViewState(
    val userInfoModelUI: UserInfoModelUI = UserInfoModelUI()
){
    fun updateUserInfo( userInfoModelUI: UserInfoModelUI) = copy(userInfoModelUI = userInfoModelUI)
}
