package com.crud.crud.services;

import com.crud.crud.models.Post;
import com.crud.crud.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post createPost(Post post) {
        post.setCreatedDate(new Date());
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Post post) {
        Post findDataById = postRepository.findById(post.getId()).get();
        findDataById.setText(post.getText());
        findDataById.setModifieDate(new Date());
        return postRepository.save(findDataById);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
