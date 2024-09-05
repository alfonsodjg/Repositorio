package com.example.repositorio.domain.core.di

import com.example.repositorio.domain.modules.add_author.usecase.GetAuthorCreatedUseCase
import com.example.repositorio.domain.modules.add_author.usecase.GetCampusUseCase
import com.example.repositorio.domain.modules.add_author.usecase.GetCarrerasUseCase
import com.example.repositorio.domain.modules.create_account.usecase.GetCreateAccountUseCase
import com.example.repositorio.domain.modules.create_account_verification.usecase.CreateAccountVerificationUseCase
import com.example.repositorio.domain.modules.login_auth.usecase.GetLoginAuthUseCase
import org.koin.dsl.module

fun getDomainModuleDi() = module {
    factory<GetLoginAuthUseCase> { GetLoginAuthUseCase(get()) }
    factory<GetCarrerasUseCase> { GetCarrerasUseCase(get()) }
    factory<GetCampusUseCase> { GetCampusUseCase(get()) }
    factory<GetAuthorCreatedUseCase> { GetAuthorCreatedUseCase(get()) }
    factory<GetCreateAccountUseCase> { GetCreateAccountUseCase(get()) }
    factory<CreateAccountVerificationUseCase> { CreateAccountVerificationUseCase(get()) }
}