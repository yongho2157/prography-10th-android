package com.example.prography_10th_android.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.prography_10th_android.feature.home.HomeRoute

const val homeRoute = "home_route"

fun NavController.navigateHome(navOptions: NavOptions) {
    navigate(homeRoute, navOptions)
}

fun NavGraphBuilder.homeNavGraph() {
    composable(homeRoute) {
        HomeRoute()
    }
}
