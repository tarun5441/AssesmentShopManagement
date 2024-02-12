package com.example.AssesmentShopManagement.Controller;

import com.example.AssesmentShopManagement.Model.Category;
import com.example.AssesmentShopManagement.Model.Product;
import com.example.AssesmentShopManagement.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping("/category/add-category")
    @ResponseStatus(HttpStatus.OK)
    public Category save(@RequestBody Category category){
        System.out.println("Check");
        return categoryService.saveCategory(category);
    }

    @DeleteMapping("/category/{id}")
    public void deleteById(@PathVariable Integer id)  {
        categoryService.deleteById(id);
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/findcategorybyid/{id}")
    public Category findproductbyid(@PathVariable int id){
        Category category = categoryService.findcategorybyid(id).get();
        return category;
    }
    @PostMapping("/category/{id}")
    public Category updateCategory(@PathVariable int id,@RequestBody Category category){
        Category updatedcategory = categoryService.updateCategory(category,id);
        return updatedcategory;
    }

     @PostMapping("/categories")
     public List<Category> getCategoryByField(@RequestBody(required = false) Category category){
         System.out.println(category);
         if(category==null){
             return categoryService.getAllCategories();
         }

         return categoryService.getCategoryByField(category);

     }

}