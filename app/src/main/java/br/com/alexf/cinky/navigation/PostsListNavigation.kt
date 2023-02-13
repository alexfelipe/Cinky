package br.com.alexf.cinky.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alexf.cinky.model.Post
import br.com.alexf.cinky.model.samplePostsList
import br.com.alexf.cinky.ui.screens.PostsListScreen

internal const val postsListRoute = "postsList"

fun NavGraphBuilder.postsListScreen(
    onNavigateToPostDetails: (Post) -> Unit
) {
    composable(postsListRoute) {
        PostsListScreen(
            samplePostsList,
            onPostClick = onNavigateToPostDetails
        )
    }
}

fun NavController.navigateToPostsList() {
    navigate(postsListRoute)
}