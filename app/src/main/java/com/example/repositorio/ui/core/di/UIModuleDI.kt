package com.example.repositorio.ui.core.di

import com.example.repositorio.ui.modules.add_author.viewmodel.AddAuthorViewModel
import com.example.repositorio.ui.modules.create_account.viewmodel.CreateAccountViewModel
import com.example.repositorio.ui.modules.create_account_verification.viewmodel.CreateAccountVerificationViewModel
import com.example.repositorio.ui.modules.login.viewmodel.LoginViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun getUIModuleDI() = module {
    factory { androidApplication() }
    viewModel { LoginViewModel(get()) }
    viewModel { AddAuthorViewModel(get(), get(), get()) }
    viewModel { CreateAccountViewModel(get()) }
    viewModel { CreateAccountVerificationViewModel(get()) }
}