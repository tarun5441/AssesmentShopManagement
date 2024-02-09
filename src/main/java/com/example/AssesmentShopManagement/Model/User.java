package com.example.AssesmentShopManagement.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="shop_user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password")
    private String password;



}
