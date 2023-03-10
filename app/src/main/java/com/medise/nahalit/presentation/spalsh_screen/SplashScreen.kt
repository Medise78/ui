package com.medise.nahalit.presentation.spalsh_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.medise.nahalit.common.Routes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Lottie(navController)
    }


}

@Composable
fun Lottie(
    navController: NavController
) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.Url("https://assets4.lottiefiles.com/packages/lf20_p1qiuawe.json"))
    LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever)
    LaunchedEffect(key1 = true) {
        delay(4000L)
        navController.navigate(Routes.LoginScreen.route){
            navController.popBackStack()
        }
    }
}