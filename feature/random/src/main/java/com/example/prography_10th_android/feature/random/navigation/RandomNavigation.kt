package com.example.prography_10th_android.feature.random.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.prography_10th_android.core.designsystem.component.NavDestination
import com.example.prography_10th_android.feature.random.RandomRoute

fun NavController.navigateRandom(id: String, navOptions: NavOptions? = null) {
    navigate(NavDestination.Random.route, navOptions)
}

fun NavGraphBuilder.randomNavGraph(
    onClickInfo: (String) -> Unit
) {
    composable(
        route = NavDestination.Random.route,
    ) {
        RandomRoute(
            onClickInfo = onClickInfo
        )
    }
}
