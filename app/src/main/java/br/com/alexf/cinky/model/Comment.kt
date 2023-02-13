package br.com.alexf.cinky.model

import java.util.UUID

class Comment(
    val id: String = UUID.randomUUID().toString(),
    val author: Author,
    val message: String,
)