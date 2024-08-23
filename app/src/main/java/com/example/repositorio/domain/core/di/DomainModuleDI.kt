package com.example.repositorio.domain.core.di

import com.example.repositorio.domain.modules.login_auth.usecase.GetLoginAuthUseCase
import org.koin.dsl.module

fun getDomainModuleDi() = module {
    factory<GetLoginAuthUseCase> { GetLoginAuthUseCase(get()) }
}