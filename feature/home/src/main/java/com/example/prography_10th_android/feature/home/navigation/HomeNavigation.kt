package com.example.prography_10th_android.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.prography_10th_android.core.designsystem.component.NavDestination
import com.example.prography_10th_android.feature.home.HomeRoute


fun NavController.navigateHome(navOptions: NavOptions) {
    navigate(NavDestination.Home.route, navOptions)
}

fun NavGraphBuilder.homeNavGraph(
    onPhotoClick: (String) -> Unit
) {
    composable(NavDestination.Home.route) {
        HomeRoute(onPhotoClick = onPhotoClick)
    }
}
