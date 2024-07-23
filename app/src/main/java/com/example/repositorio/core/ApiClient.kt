package com.example.repositorio.core

import com.example.repositorio.data.network.IRetrofit
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private val retrofit =
        Retrofit.Builder()
            .baseUrl("http://187.210.77.104")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IRetrofit::class.java)

    @JvmStatic
    val instance : IRetrofit
        get() {
            return retrofit
        }
}
//http://187.210.77.104/api/gestion/lista/autores/