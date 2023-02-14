package br.com.alexf.cinky.dao

import br.com.alexf.cinky.model.Post
import br.com.alexf.cinky.model.samplePostsList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PostsDao {

    val posts = _posts.asStateFlow()

    fun save(post: Post) {
        _posts.update {
            listOf(post) + it
        }
    }

    fun find(id: String): Post? {
        return _posts.value.find { it.id == id }
    }

    fun remove(post: Post) {
        _posts.update { posts ->
            posts.filterNot { it.id == post.id }
        }
    }

    companion object {
        private val _posts = MutableStateFlow(samplePostsList)
    }

}