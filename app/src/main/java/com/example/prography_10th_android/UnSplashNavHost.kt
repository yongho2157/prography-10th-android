package com.example.prography_10th_android

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.prography_10th_android.core.designsystem.component.NavDestination
import com.example.prography_10th_android.core.designsystem.component.UnSplashNavigationBar
import com.example.prography_10th_android.core.designsystem.component.UnSplashTopBar
import com.example.prography_10th_android.feature.home.navigation.homeNavGraph

@Composable
fun UnSplashNavHost() {
    val navController = rememberNavController()

    Scaffold(topBar = {
        UnSplashTopBar()
    }, bottomBar = {
        UnSplashNavigationBar(navController = navController)
    }) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = NavDestination.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            homeNavGraph()
        }
    }
}
