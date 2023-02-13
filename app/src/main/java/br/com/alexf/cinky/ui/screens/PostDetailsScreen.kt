package br.com.alexf.cinky.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alexf.cinky.model.Post
import br.com.alexf.cinky.model.sampleComments
import br.com.alexf.cinky.model.samplePostsList
import br.com.alexf.cinky.ui.components.AuthorWithNameAndId
import br.com.alexf.cinky.ui.theme.CinkyTheme

@Composable
fun PostDetailsScreen(
    post: Post,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AuthorWithNameAndId(author = post.author)
        Text(text = post.message)
        post.comments?.let {
            Divider()
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                item {
                    Text(text = "Comentários")
                }
                items(post.comments) { comment ->
                    AuthorWithNameAndId(comment.author)
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(text = comment.message)
                    Spacer(modifier = Modifier.size(8.dp))
                    Divider()
                }
            }
        }
    }
}


@Preview
@Composable
fun PostDetailsScreenPreview() {
    CinkyTheme {
        Surface {
            PostDetailsScreen(samplePostsList.random())
        }
    }
}

@Preview
@Composable
fun PostDetailsScreenWithCommentsPreview() {
    CinkyTheme {
        Surface {
            PostDetailsScreen(
                samplePostsList.random()
                    .copy(comments = sampleComments)
            )
        }
    }
}