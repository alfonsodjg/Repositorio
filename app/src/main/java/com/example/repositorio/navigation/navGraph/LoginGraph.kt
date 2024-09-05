package com.example.repositorio.navigation.navGraph

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
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
                onGoToCreateAccount = { navigateTo(LoginPipeNav.CreateAccount) },
                onGoToHome = {
                    navigateTo(LoginPipeNav.HomeApp)
                }
            )
        }
        composable<LoginDestinations.CreateAccount> {
            CreateAccountRecovery(
                goToVerification = { navigateTo(LoginPipeNav.CreateAccountVerification) }
            )
        }
        composable<LoginDestinations.CreateAccountVerification> {
            CreateAccountVerificationRecovery()
        }
    }
}