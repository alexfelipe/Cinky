package br.com.alexf.cinky.model

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import kotlin.random.Random

val messageSize = Random.nextInt(10, 50)
val loremIpsumMessage get() = LoremIpsum(messageSize).values.first()

val sampleAuthors = listOf(
    Author(id = "alexfelipe", name = "Alex"),
    Author(id = "pericles", name = "Perez"),
    Author(id = "junior", name = "Junior"),
    Author(id = "fran", name = "Fran"),
    Author(id = "denize", name = "Denize"),
    Author(id = "jhois", name = "Jhois"),
    Author(id = "Mario", name = "Soutinho"),
)

val currentUser = sampleAuthors.random()

val sampleComments = listOf(
    Comment(
        author = sampleAuthors.random(),
        message = loremIpsumMessage
    ),Comment(
        author = sampleAuthors.random(),
        message = loremIpsumMessage
    ),Comment(
        author = sampleAuthors.random(),
        message = loremIpsumMessage
    ),Comment(
        author = sampleAuthors.random(),
        message = loremIpsumMessage
    ),Comment(
        author = sampleAuthors.random(),
        message = loremIpsumMessage
    ),Comment(
        author = sampleAuthors.random(),
        message = loremIpsumMessage
    ),
    Comment(
        author = sampleAuthors.random(),
        message = loremIpsumMessage
    ),
)

val samplePostsList = listOf(
    Post(
        message = loremIpsumMessage,
        author = sampleAuthors.random(),
    ),
    Post(
        message = loremIpsumMessage,
        author = sampleAuthors.random(),
        comments = sampleComments.take(2)
    ),
    Post(
        message = loremIpsumMessage,
        author = sampleAuthors.random(),
        comments = sampleComments.take(1)
    ),
    Post(
        message = loremIpsumMessage,
        author = sampleAuthors.random(),
        comments = sampleComments.take(3)
    ),  
    Post(
        message = loremIpsumMessage,
        author = sampleAuthors.random(),
        comments = sampleComments
    ),
)
