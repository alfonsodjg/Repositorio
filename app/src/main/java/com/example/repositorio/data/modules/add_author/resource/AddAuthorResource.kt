package com.example.repositorio.data.modules.add_author.resource

import com.example.repositorio.data.network.endpoint.ApiEndpoint
import io.ktor.resources.Resource

@Resource("")
class AddAuthorResource {
    @Resource(ApiEndpoint.GET_CARRERAS)
    class CarrerasResource(val parent: AddAuthorResource = AddAuthorResource())

    @Resource(ApiEndpoint.GET_CAMPUS)
    class CampusResource(val parent: AddAuthorResource = AddAuthorResource())

    @Resource(ApiEndpoint.CREATE_AUTHOR)
    class CreateAuthorResource(val parent: AddAuthorResource = AddAuthorResource())
}