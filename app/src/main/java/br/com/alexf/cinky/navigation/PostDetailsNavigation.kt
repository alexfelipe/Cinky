package br.com.alexf.cinky.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alexf.cinky.dao.PostsDao
import br.com.alexf.cinky.model.samplePostsList
import br.com.alexf.cinky.ui.screens.PostDetailsScreen

internal const val postDetailsRoute = "postDetailsRoute"
internal const val postId = "postId"

fun NavGraphBuilder.postDetailsScreen(
    onPopBackStack: () -> Unit = {}
) {
    composable("$postDetailsRoute/{$postId}") { backStackEntry ->
        val dao = remember {
            PostsDao()
        }
        val post = backStackEntry.arguments
            ?.getString(postId)?.let { id ->
                dao.find(id)
            }
        post?.let {
            PostDetailsScreen(it)
        } ?: LaunchedEffect(null) {
            onPopBackStack()
        }

    }
}

fun NavController.navigateToPostDetails(id: String) {
    navigate("$postDetailsRoute/$id")
}