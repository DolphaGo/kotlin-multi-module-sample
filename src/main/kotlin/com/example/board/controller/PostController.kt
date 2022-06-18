package com.example.board.controller

import com.example.board.dto.PostReq
import com.example.board.service.PostService
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/v1/posts")
@RestController
class PostController(
    private val postService: PostService
) {

    @PostMapping
    fun post(@RequestBody postReq: PostReq) {
        postService.create(postReq)
    }

    @PutMapping
    fun update(@RequestBody postReq: PostReq) {
        postService.create(postReq)
    }

    @GetMapping
    fun getList() = postService.getListAll()

    @GetMapping("/{id}")
    fun getPost(@PathVariable("id") id: Long) = postService.findPostById(id)
}
