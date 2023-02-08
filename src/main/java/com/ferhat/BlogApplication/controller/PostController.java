package com.ferhat.BlogApplication.controller;

import com.ferhat.BlogApplication.model.Account;
import com.ferhat.BlogApplication.model.Post;
import com.ferhat.BlogApplication.service.AccountService;
import com.ferhat.BlogApplication.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private AccountService accountService;

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long id, Model model){
        Optional<Post> optionalPost = postService.getById(id);
        if (optionalPost.isPresent()){
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            return "post";
        }
        else {
            return "404";
        }
    }

    @GetMapping("/posts/new")
    String createNewPost(Model model){
        Optional<Account> optionalAccount = accountService.findByEmail("admin@domain.com");
        if (optionalAccount.isPresent()){
            Post post = new Post();
            post.setAccount(optionalAccount.get());
            model.addAttribute("post", post);
            return "post_new";
        }else{
            return "404";
        }
    }

    @PostMapping("/posts/new")
    String saveNewPost(@ModelAttribute Post post){
        postService.save(post);
        return "redirect:/posts/" +post.getId();
    }


}
