package com.dailycodework.dream_shops.service.product;

import com.dailycodework.dream_shops.model.Product;
import com.dailycodework.dream_shops.request.AddProductRequest;
import com.dailycodework.dream_shops.request.ProductUpdateRequest;

import java.util.List;

public interface IProductService {
    Product addProduct(AddProductRequest product);
    Product getProductById(Long id);

    void deleteProductById(Long id);
    Product updateProduct(ProductUpdateRequest request, Long productId);

    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String category, String name);      //should be (String brand, String name)
    Long countProductsByBrandAndName(String brand, String name);
}

/*NOTE: See notes @47:00 in model/Product.java
The request/AddProductRequest path is implemented to create a new Product << not directly but indirectly making a new object from a COPY of Product class!!
Therefore, we need to reflect that in the interface method,
    addProduct(Product product) >> addProduct(AddProductRequest product)
Since we need this method to create a new Product, change it to Product addProduct() from void addProduct()
Since IProductService interface is extended in ProductService, where all the Product related services are implemented << its addProduct() takes the same
arguments, return the same value as the interface (No conflict >> No Error)
*/
