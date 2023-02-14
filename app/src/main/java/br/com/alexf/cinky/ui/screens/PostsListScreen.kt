package br.com.alexf.cinky.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alexf.cinky.model.Post
import br.com.alexf.cinky.model.samplePostsList
import br.com.alexf.cinky.ui.components.PostItem
import br.com.alexf.cinky.ui.theme.CinkyTheme
import br.com.alexf.cinky.ui.uistate.PostsListUiState

@Composable
fun PostsListScreen(
    uiState: PostsListUiState,
    modifier: Modifier = Modifier,
    onPostClick: (Post) -> Unit = {},
    onRemovePost: (Post) -> Unit = {}
) {
    LazyColumn(modifier) {
        items(
            uiState.posts,
            key = { post ->
                post.id
            }
        ) { post ->
            PostItem(
                post, Modifier
                    .padding(8.dp)
                    .clickable(
                        indication = null,
                        interactionSource = remember {
                            MutableInteractionSource()
                        },
                    ) {
                        onPostClick(post)
                    },
                onRemovePost = {
                    onRemovePost(post)
                }
            )
            Divider()
        }
    }
}


@Preview
@Composable
fun PostsListScreenWithoutPostsPreview() {
    CinkyTheme {
        Surface {
            PostsListScreen(PostsListUiState())
        }
    }
}

@Preview
@Composable
fun PostsListScreenWithPostsPreview() {
    CinkyTheme {
        Surface {
            PostsListScreen(
                PostsListUiState(
                    samplePostsList
                )
            )
        }
    }
}
