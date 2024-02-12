package com.example.AssesmentShopManagement.Services;

import com.example.AssesmentShopManagement.Model.Category;
import com.example.AssesmentShopManagement.Model.Product;
import com.example.AssesmentShopManagement.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Optional<Category> findcategorybyid(int id){
        return categoryRepository.findById(id);
    }
    public Category updateCategory(Category category,int id){
        Category category1= findcategorybyid(id).get();
        if(category.getName()!=null)category1.setName(category.getName());

        if(category.getDescription()!=null)category1.setDescription(category.getDescription());
        return categoryRepository.save(category1);
    }

    public List<Category> getCategoryByField(Category category){

        if(category.getDescription()!=null && category.getName()!=null)
            return categoryRepository.findByNameAndDescription(category.getName(), category.getDescription());
        else if(category.getName()!=null) {
            return categoryRepository.findByName(category.getName());
        }
        else if(category.getDescription()!=null)
            return categoryRepository.findByDescription(category.getDescription());


        return null;
    }

    public String deleteById(int id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return " Category deleted ";
        } else
            return "Id does not exist";
    }

}
