package com.example.repositorio.ui.modules.share.mapper

import com.example.repositorio.domain.modules.logout.model.LogOutDomainModel
import com.example.repositorio.ui.modules.share.sharemodel.LogOutModelUI

fun LogOutDomainModel.toUI(): LogOutModelUI =
    LogOutModelUI(
        success = success,
        detail = detail
    )