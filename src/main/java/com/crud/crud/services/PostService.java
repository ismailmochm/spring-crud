package com.crud.crud.services;

import com.crud.crud.models.Post;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    Post createPost(Post post);

    Post updatePost(Post post);

    void deletePost(Long id);

}
