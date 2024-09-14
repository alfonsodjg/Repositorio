package com.example.repositorio.ui.modules.share.shareviewstate

import com.example.repositorio.ui.modules.share.sharemodel.LogOutModelUI

data class ShareViewStateLogOut(
    val response: LogOutModelUI = LogOutModelUI("", "")
){
    fun updateResponse(
        response: LogOutModelUI
    ) = copy(response = response)
}
