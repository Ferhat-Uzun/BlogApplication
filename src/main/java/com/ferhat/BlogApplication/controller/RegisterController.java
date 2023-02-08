package com.ferhat.BlogApplication.controller;

import com.ferhat.BlogApplication.model.Account;
import com.ferhat.BlogApplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/register")
    String getRegisterPage(Model model){
        Account account = new Account();
        model.addAttribute("account",account);
        return "register";
    }

    @PostMapping("/register")
    String registerNewUser(@ModelAttribute Account account){
        accountService.save(account);
        return "redirect:/";
    }
}
