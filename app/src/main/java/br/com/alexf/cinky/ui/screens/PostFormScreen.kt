package br.com.alexf.cinky.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alexf.cinky.model.Post
import br.com.alexf.cinky.model.sampleAuthors
import br.com.alexf.cinky.ui.theme.CinkyTheme

@Composable
fun PostFormScreen(
    modifier: Modifier = Modifier,
    onSendPost: (Post) -> Unit = {},
) {
    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            ),
    ) {
        var message by remember {
            mutableStateOf("")
        }
        val currentTextStyle = LocalTextStyle.current
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Row(
                Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(8.dp)
                    .clickable {
                        onSendPost(
                            Post(
                                author = sampleAuthors.random(),
                                message = message
                            )
                        )
                    },
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "Enviar", style = currentTextStyle.copy(
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                )
                Spacer(Modifier.size(8.dp))
                Icon(
                    Icons.Default.Send, contentDescription = "ícone enviar",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
        BasicTextField(
            value = message,
            onValueChange = {
                message = it
            },
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .heightIn(300.dp),
            decorationBox = { innerTextField ->
                if (message.isEmpty()) {
                    Text(
                        text = "O que você está pensando?",
                        fontStyle = FontStyle.Italic,
                        style = currentTextStyle.copy(
                            color = currentTextStyle.color.copy(alpha = 0.5f)
                        )
                    )
                }
                innerTextField()
            },
            textStyle = currentTextStyle
        )
    }
}

@Preview
@Composable
fun PostFormScreenPreview() {
    CinkyTheme {
        Surface {
            PostFormScreen()
        }
    }
}