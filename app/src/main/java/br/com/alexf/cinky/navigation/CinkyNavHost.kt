package br.com.alexf.cinky.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import br.com.alexf.cinky.dao.PostsDao

@Composable
fun CinkyNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = postsListRoute,
    ) {
        postsListScreen(
            onNavigateToPostDetails = { post ->
                navController.navigateToPostDetails(post.id)
            }
        )
        postDetailsScreen(
            onPopBackStack = {
                navController.popBackStack()
            }
        )
        postFormScreen(
            onPopBackStack = {
                navController.popBackStack()
            }
        )
    }
}
