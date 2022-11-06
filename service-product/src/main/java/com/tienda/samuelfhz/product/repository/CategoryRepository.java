package com.tienda.samuelfhz.product.repository;

import com.tienda.samuelfhz.product.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
