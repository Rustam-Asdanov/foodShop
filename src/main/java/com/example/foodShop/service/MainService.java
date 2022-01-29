package com.example.foodShop.service;

import com.example.foodShop.model.Food;
import com.example.foodShop.repository.FoodRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class MainService {

    private final FoodRepository foodRepository;

    public MainService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public void saveNewFood(Food theFood, MultipartFile multipartFile) {
        theFood.setFoodImage(multipartFile.getOriginalFilename());
        System.out.println(theFood);
        foodRepository.save(theFood);

        try {
            multipartFile.transferTo(
                    new File("C:\\Users\\Rustam\\Desktop\\Developia\\" +
                            "FINAL PROJECTS\\BACKEND PROJECT\\easy project\\" +
                            "foodShop\\foodShop\\src\\main\\resources\\static\\" +
                            "baseImages\\" + multipartFile.getOriginalFilename())
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Food> getFoodList() {
        return foodRepository.findAll();
    }
}
