package com.example.repositorio.domain.core.di

import com.example.repositorio.domain.modules.add_author.usecase.GetAuthorCreatedUseCase
import com.example.repositorio.domain.modules.add_author.usecase.GetCampusUseCase
import com.example.repositorio.domain.modules.add_author.usecase.GetCarrerasUseCase
import com.example.repositorio.domain.modules.create_account.usecase.GetCreateAccountUseCase
import com.example.repositorio.domain.modules.create_account_verification.usecase.CreateAccountVerificationUseCase
import com.example.repositorio.domain.modules.home.usecase.BookPdfDownloadUseCase
import com.example.repositorio.domain.modules.home.usecase.BooksUseCase
import com.example.repositorio.domain.modules.login_auth.usecase.GetLoginAuthUseCase
import com.example.repositorio.domain.modules.logout.usecase.GetLogOutUseCase
import com.example.repositorio.domain.modules.reset_password.usecase.GetChangePasswordUseCase
import com.example.repositorio.domain.modules.reset_password.usecase.GetResetPasswordUseCase
import com.example.repositorio.domain.modules.reset_password.usecase.GetResetPasswordVerificationUseCase
import org.koin.dsl.module

fun getDomainModuleDi() = module {
    factory<GetLoginAuthUseCase> { GetLoginAuthUseCase(get()) }
    factory<GetCarrerasUseCase> { GetCarrerasUseCase(get()) }
    factory<GetCampusUseCase> { GetCampusUseCase(get()) }
    factory<GetAuthorCreatedUseCase> { GetAuthorCreatedUseCase(get()) }
    factory<GetCreateAccountUseCase> { GetCreateAccountUseCase(get()) }
    factory<CreateAccountVerificationUseCase> { CreateAccountVerificationUseCase(get()) }
    factory<GetResetPasswordUseCase> { GetResetPasswordUseCase(get()) }
    factory<GetResetPasswordVerificationUseCase> { GetResetPasswordVerificationUseCase(get()) }
    factory<GetChangePasswordUseCase> { GetChangePasswordUseCase(get()) }
    factory<GetLogOutUseCase> { GetLogOutUseCase(get()) }
    factory<BooksUseCase> { BooksUseCase(get()) }
    factory<BookPdfDownloadUseCase> { BookPdfDownloadUseCase(get()) }
}