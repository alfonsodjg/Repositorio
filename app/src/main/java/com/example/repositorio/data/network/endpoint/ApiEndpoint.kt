package com.example.repositorio.data.network.endpoint

object ApiEndpoint {
    const val LOGIN = "/api/auth/login/"
    const val LOG_OUT = "/api/auth/logout/"
    const val CREATE_ACCOUNT = "/api/auth/signup/"
    const val CREATE_ACCOUNT_VERIFICATION = "/api/auth/signup/verify/"
    const val GET_CARRERAS = "/api/gestion/lista/carreras/"
    const val GET_CAMPUS = "/api/gestion/lista/campus/"
    const val CREATE_AUTHOR = "/api/gestion/autor/create/"
    const val RESET_PASSWORD = "/api/auth/password/reset/"
    const val RESET_PASSWORD_VERIFICATION = "/api/auth/password/reset/verify/"
    const val CHANGE_PASSWORD = "/api/auth/password/reset/verified/"
    const val GET_ALL_BOOKS = "/api/archivo/"
    const val DOWNLOAD_BOOK_PDF = "/api/archivo/{id}"
}