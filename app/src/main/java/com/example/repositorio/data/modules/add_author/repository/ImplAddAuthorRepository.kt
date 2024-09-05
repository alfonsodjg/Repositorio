package com.example.repositorio.data.modules.add_author.repository

import com.example.repositorio.data.modules.add_author.mapper.toDomain
import com.example.repositorio.data.modules.add_author.model.AuthorResponse
import com.example.repositorio.data.modules.add_author.model.CampusResponse
import com.example.repositorio.data.modules.add_author.model.CarrerasResponse
import com.example.repositorio.data.modules.add_author.model.CreateAuthorRequest
import com.example.repositorio.data.modules.add_author.resource.AddAuthorResource
import com.example.repositorio.data.network.client.KtorConf
import com.example.repositorio.data.utils.castErrorToServiceDataError
import com.example.repositorio.data.utils.toServiceErrorDomain
import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.add_author.model.AuthorResponseDomainModel
import com.example.repositorio.domain.modules.add_author.model.CampusDomainModel
import com.example.repositorio.domain.modules.add_author.model.CarrerasDomainModel
import com.example.repositorio.domain.modules.add_author.model.CreateAuthorRequestDomain
import com.example.repositorio.domain.modules.add_author.repository.IAddAuthorRepository
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get
import io.ktor.client.plugins.resources.post
import io.ktor.client.request.header
import io.ktor.client.request.setBody


class ImplAddAuthorRepository : IAddAuthorRepository {
    override suspend fun getCarreras(): ServiceDomainHandler<List<CarrerasDomainModel>> {
        val ktor = KtorConf.KtorClient()
        return try {
            val response: List<CarrerasResponse> =
                ktor.get(AddAuthorResource.CarrerasResource()).body()
            ServiceDomainHandler.Success(response.map { it.toDomain() })
        } catch (e: Exception) {
            ServiceDomainHandler.Error(
                e.castErrorToServiceDataError().toServiceErrorDomain()
            )
        } finally {
            ktor.close()
        }
    }

    override suspend fun getCampus(): ServiceDomainHandler<List<CampusDomainModel>> {
        val ktor = KtorConf.KtorClient()
        return try {
            val response: List<CampusResponse> = ktor.get(AddAuthorResource.CampusResource()).body()
            ServiceDomainHandler.Success(response.map { it.toDomain() })
        } catch (e: Exception) {
            ServiceDomainHandler.Error(
                e.castErrorToServiceDataError().toServiceErrorDomain()
            )
        }
    }

    override suspend fun createAuthor(
        token: String,
        request: CreateAuthorRequestDomain
    ): ServiceDomainHandler<AuthorResponseDomainModel> {
        val ktor = KtorConf.KtorClient()
        return try {
            val response: AuthorResponse = ktor.post(AddAuthorResource.CreateAuthorResource()) {
                header("Authorization", "Bearer $token")
                setBody(
                    CreateAuthorRequest(
                        files = request.files,
                        name = request.name,
                        lastFather = request.lastFather,
                        lastMother = request.lastMother,
                        matricula = request.matricula,
                        asesorInterno = request.asesorInterno,
                        asesorExterto = request.asesorExterto,
                        carrera = request.carrera,
                        campus = request.campus
                    )
                )
            }.body()
            ServiceDomainHandler.Success(
                response.toDomain()
            )
        } catch (e: Exception) {
            ServiceDomainHandler.Error(
                e.castErrorToServiceDataError().toServiceErrorDomain()
            )
        }
    }
}