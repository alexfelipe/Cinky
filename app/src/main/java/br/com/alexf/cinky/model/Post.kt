package br.com.alexf.cinky.model

import java.util.UUID

data class Post(
    val id: String = UUID.randomUUID().toString(),
    val author: Author,
    val message: String,
    val comments: List<Comment>? = null
)