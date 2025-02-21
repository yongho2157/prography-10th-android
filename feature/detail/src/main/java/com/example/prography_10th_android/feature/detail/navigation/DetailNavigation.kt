package com.example.prography_10th_android.feature.detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.prography_10th_android.core.designsystem.component.NavDestination
import com.example.prography_10th_android.feature.detail.DetailRoute

fun NavController.navigateDetail(id: String, navOptions: NavOptions? = null) {
    val route = NavDestination.Detail.route.replace("{id}", id)
    navigate(route, navOptions)
}

fun NavGraphBuilder.detailNavGraph(
    onClickClose: () -> Unit
) {
    composable(
        route = NavDestination.Detail.route,
        arguments = listOf(
            navArgument("id") { type = NavType.StringType }
        )
    ) { backStackEntry ->
        val id = backStackEntry.arguments?.getString("id")
        requireNotNull(id) { "아이디가 존재하지 않습니다." }
        DetailRoute(
            id = id,
            onClickClose = onClickClose
        )
    }
}
