package com.example.foodShop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String foodName;
    private String foodDescription;
    private String foodPrice;
    private String foodImage;
}
