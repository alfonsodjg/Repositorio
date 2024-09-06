package com.example.repositorio.data.modules.reset_password.resource

import com.example.repositorio.data.network.endpoint.ApiEndpoint
import io.ktor.resources.Resource

@Resource("")
class ResetPasswordResource {
    @Resource(ApiEndpoint.RESET_PASSWORD)
    class ResetPass(val parent: ResetPasswordResource = ResetPasswordResource())

    @Resource(ApiEndpoint.RESET_PASSWORD_VERIFICATION)
    class ResetPassVerification(val parent: ResetPasswordResource = ResetPasswordResource(), val code: String)
    @Resource(ApiEndpoint.CHANGE_PASSWORD)
    class ChangePassword(val parent: ResetPasswordResource = ResetPasswordResource())
}