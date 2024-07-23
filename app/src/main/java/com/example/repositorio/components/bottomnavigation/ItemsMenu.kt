package com.example.repositorio.components.bottomnavigation

import com.example.repositorio.R

sealed class ItemsMenu (
    val icon: Int,
    val title: String,
    val route : String
){
    //Home profile info admi
    data object Home: ItemsMenu(R.drawable.home, "Casa", "Home")
    data object Profile: ItemsMenu(R.drawable.ic_profile, "Perfil", "Profile")
    data object Info: ItemsMenu(R.drawable.info, "Informacion", "Info")
    data object Admin: ItemsMenu(R.drawable.ic_admi, "Administracion", "Admin")
}