package com.example.foodShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/food_store")
public class MainController {

    @GetMapping
    public String getPage(Model model){

        return "main";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/purchase_page")
    public String getPurchasePage(){
        return "purchase---page";
    }
}
