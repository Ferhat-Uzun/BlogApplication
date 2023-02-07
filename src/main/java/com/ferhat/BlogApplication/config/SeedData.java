package com.ferhat.BlogApplication.config;

import com.ferhat.BlogApplication.model.Account;
import com.ferhat.BlogApplication.model.Post;
import com.ferhat.BlogApplication.service.AccountService;
import com.ferhat.BlogApplication.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {
    @Autowired
    private PostService postService;
    @Autowired
    private AccountService accountService;


    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAll();

        if (posts.size() == 0){

            Account account = new Account();
            Account account2 = new Account();

            account.setFirstName("User");
            account.setLastName("User");
            account.setEmail("user@domain.com");
            account.setPassword("password");


            account2.setFirstName("Admin");
            account2.setLastName("admin");
            account2.setEmail("admin@domain.com");
            account2.setPassword("password");

            accountService.save(account);
            accountService.save(account2);

            Post post = new Post();
            post.setTitle("Test 1");
            post.setBody("Test body 1");
            post.setAccount(account);

            Post post2 = new Post();
            post2.setTitle("Test 2");
            post2.setBody("Test body 2");
            post2.setAccount(account2);

            postService.save(post);
            postService.save(post2);
        }
    }
}
