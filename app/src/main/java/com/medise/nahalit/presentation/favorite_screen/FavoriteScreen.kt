package com.medise.nahalit.presentation.favorite_screen

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.medise.nahalit.presentation.dashboard.CustomBottomBar

@Composable
fun FavoriteScreen(
    navController: NavController
) {
    val state = rememberScaffoldState()

    Scaffold(
        scaffoldState = state,
        bottomBar = {
            CustomBottomBar(navController = navController)
        }
    ) {
        it.calculateBottomPadding()
    }
}