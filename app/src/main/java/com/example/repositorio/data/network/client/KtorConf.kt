package com.example.repositorio.data.network.client

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.resources.Resources
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson

object KtorConf {
    private const val MAX_ATTEMPTS = 4
    fun KtorClient() = HttpClient(OkHttp) {
        expectSuccess = true

        install(Logging) {
            logger = Logger.ANDROID
            level = LogLevel.ALL
        }
        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            url {
                host = "187.210.77.104"
                protocol = URLProtocol.HTTP
            }
        }
        install(Resources)
        install(ContentNegotiation){
            gson(contentType = ContentType.Application.Json)
        }
    }
}