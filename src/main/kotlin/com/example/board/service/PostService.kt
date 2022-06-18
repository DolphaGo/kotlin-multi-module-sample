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
        var entity = Post(null, "TEMP", "TEMP", "TEMP") // not null을 지정하다보니, create/update 한번에 구현하려고 하면 기본 생성자로는 깔끔하게 처리할 수가 없군
        if (postReq.isUpdate()) {
            entity = postRepository.findById(postReq.id!!).orElseThrow { NoSuchElementException() }
        }

        entity
            .apply {
                author = postReq.author
                title = postReq.title
                content = postReq.content
            }

        postRepository.save(entity)
    }

    fun findPostById(id: Long): PostReq {
        return postRepository.findById(id).orElseThrow { NoSuchElementException() }
            .let {
                PostReq(it.author, it.title, it.content)
            }
    }
}
