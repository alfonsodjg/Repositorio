package com.example.repositorio.navigation.navGraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.repositorio.navigation.destinations.MainNavRoutes
import com.example.repositorio.navigation.destinations.login.LoginDestinations
import com.example.repositorio.navigation.destinations.login.LoginPipeNav
import com.example.repositorio.navigation.model.ScaffoldMainModel
import com.example.repositorio.ui.modules.create_account.CreateAccountRecovery
import com.example.repositorio.ui.modules.create_account_verification.CreateAccountVerificationRecovery
import com.example.repositorio.ui.modules.login.LoginRecovery
import com.example.repositorio.ui.modules.reset_password.change_password.ChangePassRecovery
import com.example.repositorio.ui.modules.reset_password.email_detail.ResetPasswordRecovery
import com.example.repositorio.ui.modules.reset_password.verification_code.ResetPasswordVerificationRecovery

fun NavGraphBuilder.loginGraph(
    startDestination: Any = LoginDestinations.Login,
    onTopBarChange: (ScaffoldMainModel) -> Unit,
    navigateTo: (LoginPipeNav) -> Unit
) {
    navigation<MainNavRoutes.LoginRoot>(
        startDestination = startDestination
    ) {
        composable<LoginDestinations.Login> {
            LoginRecovery(
                onGoToCreateAccount = {
                    navigateTo(LoginPipeNav.CreateAccount) },
                onGoToHome = {
                    navigateTo(LoginPipeNav.HomeApp)
                },
                onGoToResetPass = {
                    navigateTo(LoginPipeNav.ResetPassword)
                }
            )
        }
        composable<LoginDestinations.CreateAccount> {
            CreateAccountRecovery(
                goToVerification = {
                    navigateTo(LoginPipeNav.CreateAccountVerification)
                }
            )
        }
        composable<LoginDestinations.CreateAccountVerification> {
            CreateAccountVerificationRecovery()
        }
        composable<LoginDestinations.ResetPassword> {
            ResetPasswordRecovery(
                goToVerification = {
                    navigateTo(LoginPipeNav.ResetPasswordVerification)
                }
            )
        }
        composable<LoginDestinations.ResetPasswordVerification> {
            ResetPasswordVerificationRecovery(
                goToChangePass = {
                    navigateTo(LoginPipeNav.ResetPasswordChangePassword)
                }
            )
        }
        composable<LoginDestinations.ResetPasswordChangePassword> {
            ChangePassRecovery()
        }
    }
}