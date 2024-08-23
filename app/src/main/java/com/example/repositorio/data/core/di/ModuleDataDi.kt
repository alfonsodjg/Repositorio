package com.example.repositorio.data.core.di

import com.example.repositorio.data.modules.login_auth.repository.ImplLoginAuthRepository
import com.example.repositorio.domain.modules.login_auth.repository.ILoginAuthRepository
import org.koin.dsl.module

fun getDataModuleDi() = module{
    factory<ILoginAuthRepository> { ImplLoginAuthRepository() }
}