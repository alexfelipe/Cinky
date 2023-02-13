package br.com.alexf.cinky.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alexf.cinky.model.Post
import br.com.alexf.cinky.model.samplePostsList
import br.com.alexf.cinky.ui.components.PostItem
import br.com.alexf.cinky.ui.theme.CinkyTheme

@Composable
fun PostsListScreen(
    posts: List<Post>,
    modifier: Modifier = Modifier,
    onPostClick: (Post) -> Unit = {}
) {
    LazyColumn(modifier) {
        items(posts) { post ->
            PostItem(
                post, Modifier
                    .padding(8.dp)
                    .clickable {
                        onPostClick(post)
                    }
            )
            Divider()
        }
    }
}


@Preview
@Composable
fun PostsListScreenPreview() {
    CinkyTheme {
        Surface {
            PostsListScreen(samplePostsList)
        }
    }
}
