package com.example.AssesmentShopManagement.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Table(name="category")
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

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();
}
