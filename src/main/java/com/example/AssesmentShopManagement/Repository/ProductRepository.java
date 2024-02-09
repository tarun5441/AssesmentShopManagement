package com.example.AssesmentShopManagement.Repository;

import com.example.AssesmentShopManagement.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
