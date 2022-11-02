package com.eep.SpringMVC.model.service.post;

import com.eep.SpringMVC.model.entitys.Post;
import com.eep.SpringMVC.model.repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository repository) {
        this.postRepository = repository;
    }

    @Override
    @Transactional
    public void post(Integer id, String titulo, String post) {

        postRepository.savePost(id,titulo,post);
    }


    @Override
    public List<Post> getPosts() {
       return postRepository.findAll();
    }

    @Override
    public List<Post> getUserPosts(Integer id) {
        return postRepository.getUserPosts(id);
    }
}
