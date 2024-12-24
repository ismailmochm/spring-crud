package com.crud.crud.controller;

import com.crud.crud.models.Post;
import com.crud.crud.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> findAllPost(){
        List<Post> listPost  = postService.findAll();
        return new ResponseEntity<>(listPost, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> saveNewPost(@RequestBody Post post){
        Post newPost  = postService.createPost(post);
        return new ResponseEntity<>(newPost, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") Long postId, @RequestBody Post post){
        post.setId(postId);
        Post updateData  = postService.updatePost(post);
        return new ResponseEntity<>(updateData, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long postId){
        postService.deletePost(postId);
        return new ResponseEntity<>("Post has been successfully deleted", HttpStatus.OK);
    }

}
