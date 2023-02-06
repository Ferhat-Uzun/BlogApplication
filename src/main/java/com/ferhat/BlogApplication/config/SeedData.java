package com.ferhat.BlogApplication.config;

import com.ferhat.BlogApplication.model.Post;
import com.ferhat.BlogApplication.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {
    @Autowired
    private PostService postService;


    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAll();

        if (posts.size() == 0){
            Post post = new Post();
            post.setTitle("Test 1");
            post.setBody("Test body 1");

            Post post2 = new Post();
            post2.setTitle("Test 2");
            post2.setBody("Test body 2");

            postService.save(post);
            postService.save(post2);
        }
    }
}
