package com.dailycodework.dream_shops.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
