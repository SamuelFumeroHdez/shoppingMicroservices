package com.tienda.samuelfhz.product.controller;

import com.tienda.samuelfhz.product.entity.Category;
import com.tienda.samuelfhz.product.entity.Product;
import com.tienda.samuelfhz.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> listCategories(){
        List<Category> categories = categoryService.listAllCategory();

        return categories.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(categories);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") Long categoryId){
        Category category = categoryService.getCategory(categoryId);

        return category == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category){

        Category categoryCreate = categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryCreate);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @RequestBody Category category){
        category.setId(id);
        Category categoryDB = categoryService.updateCategory(category);

        return categoryDB == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(categoryDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") Long id){
        Category deleteCategory = categoryService.deleteCategory(id);

        return deleteCategory == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(deleteCategory);
    }

    @DeleteMapping(value = "/{id}/products")
    public ResponseEntity<List<Product>> deleteProductsOfCategory(@PathVariable("id") Long id){
        Category category = categoryService.getCategory(id);

        if(category == null){
            return ResponseEntity.notFound().build();
        }else{
            List<Product> deletedProducts = categoryService.deleteAllProductsInCategory(category);
            return deletedProducts.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(deletedProducts);
        }
    }

}
