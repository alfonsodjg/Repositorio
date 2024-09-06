package com.example.repositorio.data.core.di

import com.example.repositorio.data.modules.add_author.repository.ImplAddAuthorRepository
import com.example.repositorio.data.modules.create_account.repository.ImplCreateAccount
import com.example.repositorio.data.modules.create_account_verification.repository.ImplCreateAccountVerificationRepository
import com.example.repositorio.data.modules.login_auth.repository.ImplLoginAuthRepository
import com.example.repositorio.data.modules.reset_password.repository.ImplResetPasswordRepository
import com.example.repositorio.domain.modules.add_author.repository.IAddAuthorRepository
import com.example.repositorio.domain.modules.create_account.repository.ICreateAccount
import com.example.repositorio.domain.modules.create_account_verification.repository.ICreateAccountVerification
import com.example.repositorio.domain.modules.login_auth.repository.ILoginAuthRepository
import com.example.repositorio.domain.modules.reset_password.repository.IResetPasswordRepository
import org.koin.dsl.module

fun getDataModuleDi() = module{
    factory<ILoginAuthRepository> { ImplLoginAuthRepository() }
    factory<IAddAuthorRepository> { ImplAddAuthorRepository() }
    factory<ICreateAccount> { ImplCreateAccount() }
    factory<ICreateAccountVerification> { ImplCreateAccountVerificationRepository() }
    factory<IResetPasswordRepository> { ImplResetPasswordRepository() }
}