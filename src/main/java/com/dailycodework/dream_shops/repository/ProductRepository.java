package com.dailycodework.dream_shops.repository;

import com.dailycodework.dream_shops.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JpaRepository takes TWO arguments == <ENTITY, ID>
// BY extending JpaRepository, we get access to a large set of DEFAULT methods for CRUD, pagination, sorting, and batch operations
// NOTE: Listed below are CUSTOM methods that are REQUIRED to perform custom tasks in our project
public interface ProductRepository extends JpaRepository<Product, Long> {
    //
    List<Product> findByCategoryName(String category);
    //
    List<Product> findByBrand(String brand);
    //
    List<Product> findByCategoryNameAndBrand(String category, String brand);
    //
    List<Product> findByName(String name);
    //
    List<Product> findByBrandAndName(String brand, String name);
    //
    Long countByBrandAndName(String brand, String name);
}
