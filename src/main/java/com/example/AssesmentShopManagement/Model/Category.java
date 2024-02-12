package com.example.AssesmentShopManagement.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Table(name="shop_category")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {
   @Id
   @GeneratedValue
   @Column(name = "category_id")
    private int category_id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

// Bidirectional mapping making an infinite case
//    @OneToMany(mappedBy = "product_id", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private List<Product> productlist=new ArrayList<>();
}
