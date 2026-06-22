package com.dailycodework.dream_shops.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;

//Explain these @ANNOTATIONS
@Getter                 //All getter for image properties?
@Setter                 //All setters for image properties
@AllArgsConstructor     //Can create Image objects when Arguments are passed in (values) for ALL images properties
@NoArgsConstructor      //Can create Image objects when NO arguments are passed in (for image properties)
@Entity                 //Implement that a DB table will be implemented by this CLASS (Image)
public class Image {
    //Setting up Primary Key for the DB table (Image)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String fileType;

    @Lob                        //Explain
    private Blob blob;          //Imported from java.sql.Blob package
    private String downloadUrl;

    //use @ANNOTATIONS to establish entity relationship with Product/Image
    @ManyToOne                          //Many images belong to ONE Product
    @JoinColumn(name = "product_id")    //What table column is used to make the LINK (relationship) between the tables (Products and Image)
    private Product product;
}

/*
NOTE: "jakarta.persistence.*" imports entire package.
It contains many individual sub-packages, e.g., @Id, @ManyToOne, @JoinColumn, @GeneratedValue etc.
NOTE: 1 Product to MANY Images, hence @ManyToOne annotation is used. In Product class, it is @OneToMany relationship with Images!!
*/