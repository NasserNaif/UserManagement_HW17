package com.example.user_manegementhw17.Controllers;


import com.example.user_manegementhw17.APIs.ApiResponse;
import com.example.user_manegementhw17.Models.User;
import com.example.user_manegementhw17.Services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserControllers {
    private final UserService userService;

    @GetMapping("/get")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User newUser, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }

        userService.addUser(newUser);
        return ResponseEntity.status(201).body(new ApiResponse("User added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User newUser, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }

        Boolean isUpdated = userService.updateUser(id, newUser);

        if (isUpdated) {
            return ResponseEntity.status(201).body(new ApiResponse("user updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("wrong ID"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        Boolean isDeleted = userService.deleteUser(id);

        if (isDeleted) {
            return ResponseEntity.status(201).body(new ApiResponse("user deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("wrong ID"));
    }
}
