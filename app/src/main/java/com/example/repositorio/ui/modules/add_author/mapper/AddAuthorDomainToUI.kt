package com.example.repositorio.ui.modules.add_author.mapper

import com.example.repositorio.domain.modules.add_author.model.AuthorResponseDomainModel
import com.example.repositorio.domain.modules.add_author.model.CampusDomainModel
import com.example.repositorio.domain.modules.add_author.model.CarrerasDomainModel
import com.example.repositorio.ui.modules.add_author.model.AuthorModelUI
import com.example.repositorio.ui.modules.add_author.model.CampusModelUI
import com.example.repositorio.ui.modules.add_author.model.CarrerasModelUI

fun CarrerasDomainModel.toUI(): CarrerasModelUI =
    CarrerasModelUI(
        id = id,
        name = name
    )

fun CampusDomainModel.toUI(): CampusModelUI =
    CampusModelUI(
        id = id,
        name = name
    )
fun AuthorResponseDomainModel.toUI(): AuthorModelUI=
    AuthorModelUI(
        id = id,
        name = name,
        lastFather = lastFather,
        lastMother = lastMother,
        matricula = matricula,
        asesorInterno = asesorInterno,
        asesorExterto = asesorExterto,
        carrera = carrera,
        campus = campus
    )