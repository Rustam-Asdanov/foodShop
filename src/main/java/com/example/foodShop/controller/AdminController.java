package com.example.foodShop.controller;

import com.example.foodShop.model.Food;
import com.example.foodShop.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final MainService mainService;

    public AdminController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping
    public String getPage(){
        return "admin---page";
    }

    @GetMapping("/getFoodBase")
    public String getFoodBase(Model model){
        model.addAttribute("foodList", mainService.getFoodList());
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

    @GetMapping("/getNewFoodPage")
    public String getNewFoodPage(Model model){
        model.addAttribute("food",new Food());
        return "new---food";
    }

    @PostMapping("/addNewFood")
    public String addNewFood(
            @ModelAttribute("food") Food theFood,
            @RequestParam("someImage") MultipartFile multipartFile
            ){

        mainService.saveNewFood(theFood,multipartFile);

        return "redirect:/admin/getFoodBase";
    }

    @GetMapping("/deleteFood/{id}")
    public String deleteFoodById(
            @PathVariable("id") long id
    ){
        return "redirect:/admin/getFoodBase";
    }
}
