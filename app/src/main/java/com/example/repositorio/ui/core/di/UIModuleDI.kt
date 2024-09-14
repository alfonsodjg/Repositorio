package com.example.repositorio.ui.core.di

import com.example.repositorio.ui.modules.add_author.viewmodel.AddAuthorViewModel
import com.example.repositorio.ui.modules.create_account.viewmodel.CreateAccountViewModel
import com.example.repositorio.ui.modules.create_account_verification.viewmodel.CreateAccountVerificationViewModel
import com.example.repositorio.ui.modules.login.viewmodel.LoginViewModel
import com.example.repositorio.ui.modules.reset_password.change_password.viewmodel.ChangePasswordViewModel
import com.example.repositorio.ui.modules.reset_password.email_detail.viewmodel.ResetPassViewModel
import com.example.repositorio.ui.modules.reset_password.verification_code.viewmodel.VerificationCodeViewModel
import com.example.repositorio.ui.modules.share.shareviewmodel.ShareViewModelLogOut
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun getUIModuleDI() = module {
    factory { androidApplication() }
    viewModel { LoginViewModel(get()) }
    viewModel { AddAuthorViewModel(get(), get(), get()) }
    viewModel { CreateAccountViewModel(get()) }
    viewModel { CreateAccountVerificationViewModel(get()) }
    viewModel { ResetPassViewModel(get()) }
    viewModel { VerificationCodeViewModel(get()) }
    viewModel { ChangePasswordViewModel(get()) }
    viewModel { ShareViewModelLogOut(get()) }
}