package com.example.AssesmentShopManagement.Services;

import com.example.AssesmentShopManagement.Model.User;
import com.example.AssesmentShopManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepo;
    private TokenService tokenService;

    @Autowired
    public UserService(UserRepository userRepo,TokenService tokenService) {
        this.userRepo = userRepo;
        this.tokenService = tokenService;
    }

    public User save(User user){
        System.out.println(user);
        User res = userRepo.save(user);
        return res;
    }

    public List<User> read(){
        List<User> res = userRepo.findAll();
        return res;
    }

    public void deletebyid(Integer userid){
        userRepo.deleteById(userid);
    }

    public boolean existbyid(int id){
        return userRepo.existsById(id);
    }
    public Optional<User> updateuser(User user){
        Optional<User> updateuser = Optional.of(userRepo.saveAndFlush(user));
        if(existbyid(user.getId())) {
            return updateuser;
        }
        System.out.println("user not exist");
        return null;
    }

    public String userLogin(String email,String password){
        boolean foundUsers = existByEmail(email);
        if(foundUsers) {
            User userObj = userRepo.getUserByUserName(email);
            if(userObj.getPassword().equals(password)){
                return "{" +
                        "\"message\":"+"Successfully logged in\",\n"+
                        "\"data\": "+userObj+",\n"+
                        "\"Email: "+ userObj.getEmail()+"\n" +
                        "\"token: " + tokenService.createTokenFunction(userObj.getId()) + "\"" +
                        "}";
            }

        }
        return "{" +
                "\"message\":"+"Authentication failed\",\n"+
                "}";

    }

    public Boolean existByEmail(String email){
        Optional<User> user = Optional.ofNullable(userRepo.getUserByUserName(email));
        if(!user.isEmpty()) return true;
        return false;
    }

}
