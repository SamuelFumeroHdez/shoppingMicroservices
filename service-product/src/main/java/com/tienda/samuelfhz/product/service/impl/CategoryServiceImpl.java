package com.tienda.samuelfhz.product.service.impl;

import com.tienda.samuelfhz.product.entity.Category;
import com.tienda.samuelfhz.product.entity.Product;
import com.tienda.samuelfhz.product.repository.CategoryRepository;
import com.tienda.samuelfhz.product.repository.ProductRepository;
import com.tienda.samuelfhz.product.service.CategoryService;
import com.tienda.samuelfhz.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductService productService;

    @Override
    public List<Category> listAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category createCategory(Category category) {
        category.setStatus("CREATED");
        category.setCreateAt(new Date());
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        Category categoryDB = getCategory(category.getId());
        if(categoryDB == null){
            return null;
        }

        categoryDB.setName(category.getName());
        categoryDB.setStatus(category.getStatus());
        categoryDB.setCreateAt(category.getCreateAt());

        return categoryRepository.save(categoryDB);
    }

    @Override
    public Category deleteCategory(Long id) {

        Category categoryDB = getCategory(id);
        if(categoryDB == null){
            return null;
        }

        categoryDB.setStatus("DELETED");

        return categoryRepository.save(categoryDB);
    }

    @Override
    public List<Product> deleteAllProductsInCategory(Category category) {
        List<Product> products = productService.findByCategory(category);

        for(Product p : products) {
            productService.deleteProduct(p.getId());
        }
        return products;
    }
}
