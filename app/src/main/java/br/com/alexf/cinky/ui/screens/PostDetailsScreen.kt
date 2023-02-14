package br.com.alexf.cinky.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alexf.cinky.model.Post
import br.com.alexf.cinky.model.sampleComments
import br.com.alexf.cinky.model.samplePostsList
import br.com.alexf.cinky.ui.components.AuthorWithNameAndId
import br.com.alexf.cinky.ui.theme.CinkyTheme
import coil.compose.AsyncImage

@Composable
fun PostDetailsScreen(
    post: Post,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Row(
                Modifier.padding(8.dp),
                horizontalArrangement =
                Arrangement.spacedBy(8.dp)
            ) {
                AsyncImage(
                    model = post.author.picture,
                    contentDescription = null,
                    Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                    placeholder = ColorPainter(Color(0xFF8EA0B3)),
                    error = ColorPainter(Color(0xFF8EA0B3))
                )
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    AuthorWithNameAndId(author = post.author)
                    Text(text = post.message)
                }
            }
            Divider()
        }
        post.comments?.let {
            item {
                Text(
                    text = "Comentários",
                    Modifier.padding(8.dp),
                    fontStyle = MaterialTheme.typography.bodyMedium.fontStyle
                )
            }
            items(post.comments) { comment ->
                Row(
                    Modifier.padding(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    AsyncImage(
                        model = post.author.picture,
                        contentDescription = null,
                        Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        placeholder = ColorPainter(Color(0xFF8EA0B3)),
                        error = ColorPainter(Color(0xFF8EA0B3))
                    )
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        AuthorWithNameAndId(comment.author)
                        Text(text = comment.message)
                    }
                }
                Divider()
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