package br.com.alexf.cinky.navigation

import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alexf.cinky.dao.PostsDao
import br.com.alexf.cinky.ui.screens.PostFormScreen

internal const val postFormRoute = "postFormRoute"

fun NavGraphBuilder.postFormScreen(
    onPopBackStack: () -> Unit = {}
) {
    composable(postFormRoute) {
        val dao = remember {
            PostsDao()
        }
        PostFormScreen(
            onSendPost = {
                dao.save(it)
                onPopBackStack()
            }
        )
    }
}

fun NavController.navigateToPostForm() {
    navigate(postFormRoute)
}