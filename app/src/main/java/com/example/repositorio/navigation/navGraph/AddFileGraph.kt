package com.example.repositorio.navigation.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.repositorio.navigation.destinations.MainNavRoutes
import com.example.repositorio.navigation.destinations.addfile.AddFileDestinations
import com.example.repositorio.navigation.destinations.addfile.AddFilePipeNav
import com.example.repositorio.navigation.model.ScaffoldMainModel
import com.example.repositorio.ui.modules.add_file_admin.view.AddFileAdminView

fun NavGraphBuilder.addFileGraph(
    startDestination: Any = AddFileDestinations.AddFile,
    onTopBarChange: (ScaffoldMainModel) -> Unit,
    navigateTo: (AddFilePipeNav) -> Unit
){
    navigation<MainNavRoutes.AddFileRoot>(
        startDestination = startDestination
    ){
        composable<AddFileDestinations.AddFile> {
            AddFileAdminView()
        }
    }
}