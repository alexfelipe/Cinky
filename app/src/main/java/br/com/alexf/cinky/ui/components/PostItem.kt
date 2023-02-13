package br.com.alexf.cinky.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import br.com.alexf.cinky.model.Comment
import br.com.alexf.cinky.model.Post
import br.com.alexf.cinky.model.sampleAuthors
import br.com.alexf.cinky.model.samplePostsList
import br.com.alexf.cinky.ui.theme.CinkyTheme

@Composable
fun PostItem(
    post: Post,
    modifier: Modifier = Modifier
) {
    Column(
        modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AuthorWithNameAndId(author = post.author)
            Icon(Icons.Default.MoreVert, contentDescription = "mais opções do post")
        }
        Text(text = post.message)
        post.comments?.let { comments ->
            Row {
                Icon(Icons.Default.Comment, contentDescription = "ícone para comentários")
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = "${comments.size}")
            }
        }
    }
}

@Preview
@Composable
fun PostItemWithoutCommentPreview() {
    CinkyTheme {
        Surface {
            PostItem(post = samplePostsList.find {
                it.comments == null
            } ?: samplePostsList.random())
        }
    }
}

@Preview
@Composable
fun PostItemWithCommentsPreview() {
    CinkyTheme {
        Surface {
            PostItem(
                post = samplePostsList.random().copy(
                    comments = listOf(
                        Comment(
                            author = sampleAuthors.random(),
                            message = LoremIpsum(20).toString().first().toString()
                        )
                    )
                )
            )
        }
    }
}