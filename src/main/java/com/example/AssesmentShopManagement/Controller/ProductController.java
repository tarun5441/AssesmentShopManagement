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
    public String deleteProductById(@PathVariable int id){
        return productService.deletebyid(id);
    }
    @PostMapping("/productexistbyid/{id}")
    public boolean existbyid(@PathVariable int id){
        return productService.productexistbyid(id);
    }
    @PostMapping("/product/{id}")
    public Product updateProduct(@PathVariable int id,@RequestBody Product product){
        Product updatedproduct = productService.updateProduct(product,id);
        return updatedproduct;
    }
    @GetMapping("/findproductbyid/{id}")
    public Product findproductbyid(@PathVariable int id){
        Product product = productService.findproductbyid(id).get();
        return product;
    }

    @PostMapping("/product/{prod}/{cat}")
    public Product updateProductWithCategory(@PathVariable String prod, @PathVariable String cat){
        return productService.updateProductWithCategory(prod,cat);
    }
    @PostMapping("/products")
    public List<Product> getProductByField(@RequestBody(required = false) Product product){

        if(product==null)
            return productService.getallproduct();

        return productService.getProductByField(product);

    }
}