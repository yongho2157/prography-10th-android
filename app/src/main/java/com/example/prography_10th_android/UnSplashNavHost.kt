package com.example.prography_10th_android

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.prography_10th_android.feature.home.navigation.homeNavGraph
import com.example.prography_10th_android.feature.home.navigation.homeRoute

@Composable
fun UnSplashNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = homeRoute
    ) {
        homeNavGraph()
    }
}
