package com.tienda.samuelfhz.product.service;

import com.tienda.samuelfhz.product.entity.Category;
import com.tienda.samuelfhz.product.entity.Product;

import java.util.List;

public interface CategoryService {

    List<Category> listAllCategory();
    Category getCategory(Long id);
    Category createCategory(Category category);
    Category updateCategory(Category category);
    Category deleteCategory(Long id);
    List<Product> deleteAllProductsInCategory(Category category);
}
