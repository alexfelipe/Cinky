package br.com.alexf.cinky.ui.uistate

import br.com.alexf.cinky.model.Post

data class PostsListUiState(
    val posts: List<Post> = emptyList()
)