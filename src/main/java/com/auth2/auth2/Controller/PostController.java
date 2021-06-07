package com.auth2.auth2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth2.auth2.Repository.CommentRepository;
import com.auth2.auth2.Repository.PostRepository;
import com.auth2.auth2.entity.Comment;
import com.auth2.auth2.entity.Post;

@RestController
@RequestMapping("post")
public class PostController {
	@Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @PostMapping
    public Post savePost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @GetMapping("/{id}/comment")
    public List<Comment> getPostsComment(@PathVariable(value = "id")Integer postId) {
        return commentRepository.findCommentByPostId(postId);
    }

  
}
