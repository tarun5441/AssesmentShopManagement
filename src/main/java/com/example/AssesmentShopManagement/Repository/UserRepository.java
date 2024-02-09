package com.example.AssesmentShopManagement.Repository;

import com.example.AssesmentShopManagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    //sql: select * from user where email=:username;
    @Query("SELECT u FROM User u WHERE u.email = :userName")
    User getUserByUserName(String userName);
}
