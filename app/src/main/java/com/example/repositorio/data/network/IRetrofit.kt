package com.example.repositorio.data.network

import com.example.repositorio.data.add_file_admin.model.AuthorItemResponse
import com.example.repositorio.data.add_file_admin.model.PublicTypeResponse
import com.example.repositorio.data.home.model.BookResponse
import com.example.repositorio.data.login.model.LoginResponse
import com.example.repositorio.data.login.model.UserDataModel
import com.example.repositorio.data.profile.model.UserInfo
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface IRetrofit {
    @POST("/api/auth/login/")
    suspend fun postLogin(@Body userLogin: UserDataModel): Response<LoginResponse>

    @GET("/api/archivo/") ///api/archivo/?page=${page}
    suspend fun getBooks(
        @Header("Authorization") token: String,
    ): Response<BookResponse>

    @GET("/api/auth/users/me/")
    suspend fun getUserInfo(
        @Header("Authorization") token: String
    ): Response<UserInfo>

    @GET("/api/gestion/lista/autores/")
    suspend fun getAuthorsItemResponse(): Response<List<AuthorItemResponse>>

    @GET("/api/gestion/lista/tiposdepublicacion/")
    fun getType(): Response<List<PublicTypeResponse>>
}