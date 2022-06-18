package com.example.board.service

import com.example.board.dto.PostReq
import com.example.board.entity.Post
import com.example.board.repository.PostRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class PostService(
    private val postRepository: PostRepository
) {

    fun getListAll(): List<PostReq> {
        return postRepository.findAll()
            .map {
                PostReq(it.author, it.title, it.content)
            }
    }

    @Transactional
    fun create(postReq: PostReq) {
        val post = Post(
            author = postReq.author,
            title = postReq.title,
            content = postReq.content
        )

        postRepository.save(post)
    }

    fun findPostById(id: Long): PostReq {
        return postRepository.findById(id).orElseThrow { NoSuchElementException() }
            .let {
                PostReq(it.author, it.title, it.content)
            }
    }
}
