package com.medise.nahalit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.medise.nahalit.common.Routes
import com.medise.nahalit.presentation.dashboard.Dashboard
import com.medise.nahalit.presentation.home_screen.HomeScreen
import com.medise.nahalit.presentation.home_screen.components.ProductCard
import com.medise.nahalit.presentation.login_screen.LoginScreen
import com.medise.nahalit.presentation.sign_up_screen.SignupScreen
import com.medise.nahalit.presentation.ui.theme.NahalItTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NahalItTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                        Dashboard(navController = navController)
                    }
                }
            }
        }
    }
}