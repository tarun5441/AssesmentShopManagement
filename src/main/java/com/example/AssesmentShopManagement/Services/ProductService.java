package com.example.AssesmentShopManagement.Services;

import com.example.AssesmentShopManagement.Model.Category;
import com.example.AssesmentShopManagement.Model.Product;
import com.example.AssesmentShopManagement.Repository.CategoryRepository;
import com.example.AssesmentShopManagement.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public Product addproduct(Product product){
        return productRepository.save(product);
    }

    public void deleteproductbyid(Integer id) {
        productRepository.deleteById(id);
    }

    public List<Product> getallproduct() {
        return productRepository.findAll();
    }

    public String deletebyid(Integer id) {

        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return " Product deleted";
        }

        return "Id does not exist";
    }

    public Optional<Product> findproductbyid(int id){
        return productRepository.findById(id);
    }

    public boolean productexistbyid(int id){
        return productRepository.existsById(id);
    }
    public Product updateProduct(Product product,int id){
        Product product1= findproductbyid(id).get();
        if(product.getName()!=null)product1.setName(product.getName());
        if(product.getPrice()>0)product1.setPrice(product.getPrice());
        if(product.getDescription()!=null)product1.setDescription(product.getDescription());
        return productRepository.save(product1);
    }

    public Product updateProductWithCategory(String prod,String cat){


        List<Category> categoryList= categoryRepository.findByName(cat);
        Category category=categoryList.get(0);
        System.out.println(categoryList);
        if(!categoryRepository.existsById(category.getCategory_id())){
            return null;
        }
        List<Product> productList=productRepository.findByName(prod);
        System.out.println(productList);
        Product product=productList.get(0);
        System.out.println(cat+" "+prod);
        product.setCategory(category);
        return productRepository.save(product);
    }
    public List<Product> getProductByField(Product product){
        String name=product.getName();
        List<Product> productList=productRepository.findByName(name);
        return productList;
    }

}