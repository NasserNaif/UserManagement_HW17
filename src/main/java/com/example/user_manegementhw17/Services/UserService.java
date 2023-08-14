package com.example.user_manegementhw17.Services;

import com.example.user_manegementhw17.Models.User;
import com.example.user_manegementhw17.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }


    public void addUser(User newUser) {
        userRepo.save(newUser);
    }

    public Boolean updateUser(Integer id, User newUser) {
        User result = userRepo.getUserById(id);

        if (result == null) {
            return false;
        }

        result.setAge(newUser.getAge());
        result.setRole(newUser.getRole());
        result.setName(newUser.getName());
        result.setUsername(newUser.getUsername());
        result.setEmail(newUser.getEmail());
        result.setPassword(newUser.getPassword());

        userRepo.save(result);
        return true;
    }

    public Boolean deleteUser(Integer id) {
        User result = userRepo.getUserById(id);

        if (result == null) {
            return false;
        }

        userRepo.delete(result);
        return true;

    }


}
