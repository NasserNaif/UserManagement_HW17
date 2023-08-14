package com.example.user_manegementhw17.Repository;


import com.example.user_manegementhw17.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User getUserById(Integer id);
}
