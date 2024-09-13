package com.example.repositorio.navigation.navGraph

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.repositorio.navigation.destinations.MainNavRoutes
import com.example.repositorio.navigation.destinations.login.LoginDestinations
import com.example.repositorio.navigation.destinations.login.LoginPipeNav
import com.example.repositorio.navigation.model.ScaffoldMainModel
import com.example.repositorio.navigation.model.TopBarUI
import com.example.repositorio.navigation.utils.ScaffoldDefaults
import com.example.repositorio.ui.modules.create_account.CreateAccountRecovery
import com.example.repositorio.ui.modules.create_account_verification.CreateAccountVerificationRecovery
import com.example.repositorio.ui.modules.login.LoginRecovery
import com.example.repositorio.ui.modules.reset_password.change_password.ChangePassRecovery
import com.example.repositorio.ui.modules.reset_password.email_detail.ResetPasswordRecovery
import com.example.repositorio.ui.modules.reset_password.verification_code.ResetPasswordVerificationRecovery

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.loginGraph(
    startDestination: Any = LoginDestinations.Login,
    onTopBarChange: (ScaffoldMainModel) -> Unit = {},
    navigateTo: (LoginPipeNav) -> Unit,
    showAlertBottomSheet: MutableState<Boolean>
) {
    navigation<MainNavRoutes.LoginRoot>(
        startDestination = startDestination
    ) {
        composable<LoginDestinations.Login> {
            LaunchedEffect(Unit) {
                onTopBarChange(ScaffoldMainModel(topBar = TopBarUI.NoActionBar))
            }
            LoginRecovery(
                onGoToCreateAccount = {
                    navigateTo(LoginPipeNav.CreateAccount)
                },
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
                onTopBarChange = {
                    onTopBarChange(
                        ScaffoldDefaults.navigateBar(
                            title = it,
                            enableActionIcon = true,
                            imgLightSrc = "",
                            imgDarkSrc = "",
                            showExitDialog = false
                        )
                    )
                },
                goToVerification = {
                    navigateTo(LoginPipeNav.CreateAccountVerification)
                },
                showAlertBottomSheet = showAlertBottomSheet
            )
        }
        composable<LoginDestinations.CreateAccountVerification> {
            CreateAccountVerificationRecovery(
                onTopBarChange = {
                    onTopBarChange(
                        ScaffoldDefaults.navigateBar(
                            title = it,
                            enableActionIcon = true,
                            imgLightSrc = "",
                            imgDarkSrc = "",
                            showExitDialog = true
                        )
                    )
                },
                showAlertBottomSheet = showAlertBottomSheet
            )
        }
        composable<LoginDestinations.ResetPassword> {
            ResetPasswordRecovery(
                onTopBarChange = {
                    onTopBarChange(
                        ScaffoldDefaults.navigateBar(
                            title = it,
                            enableActionIcon = true,
                            imgLightSrc = "",
                            imgDarkSrc = "",
                            showExitDialog = false
                        )
                    )
                },
                goToVerification = {
                    navigateTo(LoginPipeNav.ResetPasswordVerification)
                },
                showAlertBottomSheet = showAlertBottomSheet
            )
        }
        composable<LoginDestinations.ResetPasswordVerification> {
            ResetPasswordVerificationRecovery(
                onTopBarChange = {
                    onTopBarChange(
                        ScaffoldDefaults.navigateBar(
                            title = it,
                            enableActionIcon = true,
                            imgLightSrc = "",
                            imgDarkSrc = "",
                            showExitDialog = true
                        )
                    )
                },
                goToChangePass = {
                    navigateTo(LoginPipeNav.ResetPasswordChangePassword)
                },
                showAlertBottomSheet = showAlertBottomSheet
            )
        }
        composable<LoginDestinations.ResetPasswordChangePassword> {
            ChangePassRecovery(
                onTopBarChange = {
                    onTopBarChange(
                        ScaffoldDefaults.navigateBar(
                            title = it,
                            enableActionIcon = true,
                            imgLightSrc = "",
                            imgDarkSrc = "",
                            showExitDialog = true
                        )
                    )
                },
                showAlertBottomSheet = showAlertBottomSheet
            )
        }
    }
}