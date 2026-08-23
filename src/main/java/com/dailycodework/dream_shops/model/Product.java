package com.dailycodework.dream_shops.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
// @AllArgsConstructor << this was later removed (@52:25) after implementing a new constructor
@NoArgsConstructor                      // NOW to create a Product, it doesn't require all the arguments/properties to be provided
@Entity
public class Product {
    @Id                                 //Designate "id" CLASS property as DB Primary_Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;           //BigDecimal imported from java.math.BigDecimal
    private int inventory;              //To track "quantity" of Product in stock
    private String description;

//To establish ENTITY relationship with Category/Product
    @ManyToOne(cascade = CascadeType.ALL)
    //NOTE: Unlike the Image (below), when a product is removed from the DB its associated Category will NOT be removed from the DB
    @JoinColumn(name = "category_id")
    private Category category;

//To establish ENTITY relationship with Image/Product
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    //NOTE: when a Product is removed from the DB, all the images associated with (OneToMany) also will be removed!!
    //NOTE: Category is a stand-alone table!!
    private List<Image> images;         //List<e> imported from java.util.List

//This constructor is REQUIRED >> e.g. To create a new Product object using createProduct() method in ProductService.java (@52:25)
    public Product(String name, String brand, BigDecimal price, int inventory, String description, Category category) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.inventory = inventory;
        this.description = description;
        this.category = category;
    }
}

/*@47:00
NOTE: Product is a DB table (@Entity). Data in it has be preserved, i.e., use @Setter and @Getter instead of @Data.
NOTE: To create a new table entry, i.e., a new "Product" Class/Object >> we are implementing a REQUEST path.
Hence a new folder/file was created >> "request/AddProductRequest"
This file contains the barebones to create a new object/table entry.
NOTE: AddProductRequest is NOT a table entity (marely a replica) << hence we can use @Data instead of @Getter/@Setter
*/
