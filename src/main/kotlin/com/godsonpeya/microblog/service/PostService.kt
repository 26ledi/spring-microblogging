package com.godsonpeya.microblog.service

import com.godsonpeya.microblog.entity.Post
import com.godsonpeya.microblog.entity.User
import com.godsonpeya.microblog.repository.PostRepository
import com.godsonpeya.microblog.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostService @Autowired constructor(private var postRepository:PostRepository) {


    fun getPosts(): List<Post> = postRepository.findAll()


    fun getOne(id: Long): Post =
        postRepository.findById(id).orElseThrow { IllegalArgumentException("User with id = $id was not found") }

    fun savePost(post: Post): Post = postRepository.save(post)  //TODO validate data

    fun updatePost(id:Long, postInput: Post): Post {
        val postFound = getOne(id)

        postFound.content = postInput.content
        postFound.userId= postInput.userId
        postFound.createdAt=postInput.createdAt
        postFound.updatedAt=postInput.updatedAt
//        userFound.posts = userInput.posts

        return postRepository.save(postFound)
    }

    fun deletePost(id:Long):String{
        val postFound= getOne(id)

        postRepository.delete(postFound)
        return "Post has been deleted"
    }
}