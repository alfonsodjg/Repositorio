package com.example.repositorio.data.modules.create_account_verification.resource

import com.example.repositorio.data.network.endpoint.ApiEndpoint
import io.ktor.resources.Resource

@Resource("")
class CreateAccountVerificationResource {
    @Resource(ApiEndpoint.CREATE_ACCOUNT_VERIFICATION)
    class CreateAccountVerification(
        val parent: CreateAccountVerificationResource = CreateAccountVerificationResource(),
        val code: String
    )
}