package com.eep.SpringMVC.model.service.post;

import com.eep.SpringMVC.model.dto.PostResumidoDto;
import com.eep.SpringMVC.model.entitys.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    void post(Integer id, String titulo, String post, String userName);

    List<Post> getPosts();

    List<Post> getUserPosts(Integer id);

    void changePost(Integer id, String post);

    void deletePost(Integer id);
}
