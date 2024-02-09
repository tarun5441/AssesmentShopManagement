package com.example.AssesmentShopManagement.Services;

import com.example.AssesmentShopManagement.Model.Product;
import com.example.AssesmentShopManagement.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product addproduct(Product product){
        return productRepository.save(product);
    }

    public void deleteproductbyid(Integer id) {
        productRepository.deleteById(id);
    }

    public List<Product> getallproduct() {
        return productRepository.findAll();
    }

    public void deletebyid(Integer userId) {
        productRepository.deleteById(userId);
    }

    public Optional<Product> findproductbyid(int id){
        return productRepository.findById(id);
    }

    public boolean productexistbyid(int id){
        return productRepository.existsById(id);
    }
    public Optional<Product> updateProduct(Product product){
        Optional<Product> updateProduct = Optional.of(productRepository.saveAndFlush(product));
        int id = product.getId();
        if(productRepository.existsById(id)) return updateProduct;
        return null;
    }

}