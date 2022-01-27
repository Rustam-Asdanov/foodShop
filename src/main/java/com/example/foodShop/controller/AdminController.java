package com.example.foodShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String getPage(){
        return "admin---page";
    }

    @GetMapping("/getFoodBase")
    public String getFoodBase(){
        return "food---base";
    }

    @GetMapping("/getOrdersPage")
    public String getOrdersPage(){
        return "";
    }

    @GetMapping("/addNewAdmin")
    public String addNewAdmin(){
        return "";
    }

    @GetMapping("/addNewFood")
    public String addNewFood(){
        return "new---food";
    }
}
