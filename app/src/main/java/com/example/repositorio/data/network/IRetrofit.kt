package com.example.repositorio.data.network

import com.example.repositorio.data.modules.add_file_admin.model.AuthorItemResponse
import com.example.repositorio.data.modules.add_file_admin.model.PublicTypeResponse
import com.example.repositorio.data.modules.home.model.BookResponse

import com.example.repositorio.data.modules.profile.model.UserInfo
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface IRetrofit {
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
    suspend fun getType(): Response<List<PublicTypeResponse>>

    @Multipart
    @POST("tu_endpoint")
    suspend fun uploadFile(
        @Part("titulo") titulo: RequestBody,
        @Part imagen: MultipartBody.Part?,
        @Part("materia") materia: RequestBody,
        @Part("fechaPublicacion") fechaPublicacion: RequestBody,
        @Part("tipoPublicacion") tipoPublicacion: RequestBody,
        @Part pdf: MultipartBody.Part?,
        @Part("resumen") resumen: RequestBody,
        @Part("autor") autor: RequestBody
    ): Response<ResponseBody>
}