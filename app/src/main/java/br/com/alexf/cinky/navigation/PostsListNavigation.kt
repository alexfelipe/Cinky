package br.com.alexf.cinky.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alexf.cinky.dao.PostsDao
import br.com.alexf.cinky.model.Post
import br.com.alexf.cinky.model.samplePostsList
import br.com.alexf.cinky.ui.screens.PostsListScreen
import br.com.alexf.cinky.ui.uistate.PostsListUiState

const val postsListRoute = "postsList"

fun NavGraphBuilder.postsListScreen(
    onNavigateToPostDetails: (Post) -> Unit
) {
    composable(postsListRoute) {
        val dao = remember {
            PostsDao()
        }
        val posts by dao.posts.collectAsState()
        val uiState = remember(posts) {
            PostsListUiState(posts)
        }
        PostsListScreen(
            uiState,
            onPostClick = onNavigateToPostDetails
        )
    }
}

fun NavController.navigateToPostsList() {
    navigate(postsListRoute)
}