package com.example.repositorio.domain.modules.add_author.usecase

import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.add_author.model.CarrerasDomainModel
import com.example.repositorio.domain.modules.add_author.repository.IAddAuthorRepository

class GetCarrerasUseCase(
    private val repository: IAddAuthorRepository
) {
    suspend operator fun invoke(): ServiceDomainHandler<List<CarrerasDomainModel>> =
        repository.getCarreras()
}