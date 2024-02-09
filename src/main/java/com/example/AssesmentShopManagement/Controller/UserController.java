package com.example.AssesmentShopManagement.Controller;

import com.example.AssesmentShopManagement.Model.User;
import com.example.AssesmentShopManagement.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userservice;

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.OK)
    public User save(@RequestBody User user){
        User res = userservice.save(user);
        return res;
    }

    @GetMapping("/read")
    public List<User> read(){
        List<User> res = userservice.read();
        return res;
    }

    @DeleteMapping("/deletebyid/{id}")
    public void deletebyid(@PathVariable Integer id){
        userservice.deletebyid(id);
    }

    @PostMapping("/update/{id}")
    public Optional<User> update(@PathVariable int id,@RequestBody User user){
        Optional<User> res = userservice.updateuser(user);
        return res;
    }

    @PostMapping("/existbyid/{id}")
    public boolean existbyid(@PathVariable int id){
        return userservice.existbyid(id);
    }

    @GetMapping("/exists/email")
    public Boolean existbyemail(@RequestBody User user){
        String userEmail = user.getEmail();
        return userservice.existByEmail(userEmail);
    }

    @PostMapping("/login")
    public String loginuser(@RequestBody User user){
        String email = user.getEmail();
        String password = user.getPassword();
        return userservice.userLogin(email,password);
    }
}
