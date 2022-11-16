package com.eep.SpringMVC.model.service.post;

import com.eep.SpringMVC.model.dto.PostResumidoDto;
import com.eep.SpringMVC.model.entitys.Post;
import com.eep.SpringMVC.model.repository.CommentRepository;
import com.eep.SpringMVC.model.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    private final CommentRepository commentRepository;


    @Autowired
    public PostServiceImpl(final PostRepository postRepository, final CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    @Transactional
    public void post(Integer id, String titulo, String post, String userName) {

        postRepository.savePost(id,titulo,post, userName);
    }


    @Override
    public List<Post> getPosts() {
       return postRepository.findAll();
    }

    @Override
    public List<Post> getUserPosts(Integer id) {
        return postRepository.getUserPosts(id);
    }

    @Override
    @Transactional
    public void changePost(Integer id, String post) {
        postRepository.changePost(id, post);
    }

    @Override
    @Transactional
    public void deletePost(Integer id) {
        commentRepository.findCommentByPostId(id).forEach(commentRepository::deleteCommentById);

        postRepository.deletePost(id);
    }
}
