package com.example.repositorio.data.modules.add_author.mapper

import com.example.repositorio.data.modules.add_author.model.AuthorResponse
import com.example.repositorio.data.modules.add_author.model.CampusResponse
import com.example.repositorio.data.modules.add_author.model.CarrerasResponse
import com.example.repositorio.domain.modules.add_author.model.AuthorResponseDomainModel
import com.example.repositorio.domain.modules.add_author.model.CampusDomainModel
import com.example.repositorio.domain.modules.add_author.model.CarrerasDomainModel

fun CarrerasResponse.toDomain(): CarrerasDomainModel =
    CarrerasDomainModel(
        id = id ?: -1,
        name = name ?: ""
    )

fun CampusResponse.toDomain(): CampusDomainModel =
    CampusDomainModel(
        id = id ?: -1,
        name = name ?: ""
    )

fun AuthorResponse.toDomain(): AuthorResponseDomainModel =
    AuthorResponseDomainModel(
        id = id ?: -1,
        name = name ?: "",
        lastFather = lastFather ?: "",
        lastMother = lastMother ?: "",
        matricula = matricula ?: "",
        asesorInterno = asesorInterno ?: "",
        asesorExterto = asesorExterto ?: "",
        carrera = carrera ?: "",
        campus = campus ?: ""
    )