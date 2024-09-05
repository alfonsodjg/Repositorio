package com.example.repositorio.data.modules.create_account.resource

import com.example.repositorio.data.network.endpoint.ApiEndpoint
import io.ktor.resources.Resource

@Resource("")
class CreateAccountResource{
    @Resource(ApiEndpoint.CREATE_ACCOUNT)
    class CreateAccount(val parent: CreateAccountResource = CreateAccountResource())
}