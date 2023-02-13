package br.com.alexf.cinky.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alexf.cinky.model.samplePostsList
import br.com.alexf.cinky.ui.screens.PostDetailsScreen

internal const val postDetailsRoute = "postDetailsRoute"
internal const val postId = "postId"

fun NavGraphBuilder.postDetailsScreen(
    onPopBackStack: () -> Unit = {}
) {
    composable("$postDetailsRoute/{$postId}") { backStackEntry ->
        val post = backStackEntry.arguments
            ?.getString(postId)?.let { id ->
                samplePostsList.find {
                    it.id == id
                }
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