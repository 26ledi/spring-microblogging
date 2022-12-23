package com.godsonpeya.microblog.controller

import com.godsonpeya.microblog.entity.Post
import com.godsonpeya.microblog.entity.User
import com.godsonpeya.microblog.service.PostService
import com.godsonpeya.microblog.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class PostController @Autowired constructor(private val postService: PostService) {

    @GetMapping("/posts")
    fun getUserList(): List<Post> = postService.getPosts()

    @GetMapping("/posts/{id}")
    fun getPost(@PathVariable id: Long): Post = postService.getOne(id)

    @PostMapping("/posts")
    fun createPost(@RequestBody post: Post): Post = postService.savePost(post)

    @PutMapping("/posts/{id}")
    fun updatePost(@PathVariable id: Long, @RequestBody post: Post): Post = postService.updatePost(id, post)

    @DeleteMapping("/posts/{id}")
    fun deletePost(@PathVariable id: Long): String = postService.deletePost(id)
}