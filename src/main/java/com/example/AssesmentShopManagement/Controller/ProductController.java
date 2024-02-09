package com.example.AssesmentShopManagement.Controller;

import com.example.AssesmentShopManagement.Model.Product;
import com.example.AssesmentShopManagement.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/product/add-product")
    @ResponseStatus(HttpStatus.OK)
    public Product addproduct(@RequestBody Product product){
        return productService.addproduct(product);
    }
    @GetMapping("/products")
    public List<Product> getallproduct() {
        return productService.getallproduct();
    }
    @DeleteMapping("/products/{id}")
    public void deleteproductbyid(@PathVariable Integer id)  {
        productService.deleteproductbyid(id);
    }
    @PostMapping("/productexistbyid/{id}")
    public boolean existbyid(@PathVariable int id){
        return productService.productexistbyid(id);
    }
    @PostMapping("/product/{id}")
    public Optional<Product> updateProduct(@RequestBody Product product){
        Optional<Product>updatedproduct = productService.updateProduct(product);
        return updatedproduct;
    }
    @GetMapping("/findproductbyid/{id}")
    public Product findproductbyid(@PathVariable int id){
        Product product = productService.findproductbyid(id).get();
        return product;
    }
}