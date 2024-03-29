package com.example.AssesmentShopManagement.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data //only for getters and setters
@Table(name = "shop_product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private int id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_price")
    private int price;
    @Column(name = "product_description")
    private String description;
    @ManyToOne()
    @JoinColumn(name = "prod_id")
    private Category category;
}
