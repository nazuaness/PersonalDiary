package com.diary.web.Services;

import com.diary.web.Entities.User;
import com.diary.web.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceUser {
    @Autowired
    private UserRepository Repository;

    public boolean saveUser(String email, String password) {
        User byEmail = Repository.findByEmail(email);
        if(byEmail == null) {
            User user = new User(email,password);
            Repository.save(user);
            return true;
        }
        return false;
    }

    public User getUser(String email) {
        return Repository.findByEmail(email);
    }

    public boolean userChecker(String email, String password){
        User user = Repository.findByEmail(email);
        if(user != null){
            if(user.getPassword().equals(password)){
                return true;
            }
            return false;
        }
        else{
            return false;
        }
    }

    public boolean updateUser(String email, String oldPassword, String newPassword){
        if(userChecker(email,oldPassword)){
            User user = Repository.findByEmail(email);
            user.setPassword(newPassword);
            Repository.save(user);
            return true;
        }
        return false;
    }


    public boolean deleteUser(String email, String password){
        if(userChecker(email,password)){
            User user = Repository.findByEmail(email);
            Repository.delete(user);
            return true;
        }
        else{
            return false;
        }
    }



}
