package br.com.alexf.cinky.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.alexf.cinky.model.Author

@Composable
fun AuthorWithNameAndId(author: Author) {
    Row {
        Text(text = author.name)
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = author.id,
            style = LocalTextStyle.current.copy(
                color = LocalTextStyle.current.color.copy(alpha = 0.5f)
            )
        )
    }
}
