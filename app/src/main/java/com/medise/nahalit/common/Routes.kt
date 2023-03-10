package com.medise.nahalit.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Routes(val route: String, val icon: ImageVector? = null, val name: String = "") {

    object SplashScreen : Routes("splash_screen")
    object HomeScreen : Routes("home_screen", Icons.Default.Home, name = "خانه")
    object DetailScreen : Routes("detail_screen")
    object FavoriteScreen : Routes("favorite_screen", Icons.Default.Favorite, name = "علاقه مندی")
    object ContactScreen : Routes("contact_us", Icons.Default.Phone, name = "ارتباط با ما")
    object BuyScreen : Routes("buy_screen", Icons.Default.Person, name = "سبد خرید")
    object ProfileScreen : Routes("profile_screen", Icons.Default.Person, name = "پروفایل")
    object LoginScreen : Routes("login_screen")
    object SignupScreen : Routes("signup_screen")
    object RecruitmentScreen : Routes("recruitment_screen")


    companion object {
        val list = listOf(
            HomeScreen, FavoriteScreen, ContactScreen, BuyScreen, ProfileScreen
        )
    }
}