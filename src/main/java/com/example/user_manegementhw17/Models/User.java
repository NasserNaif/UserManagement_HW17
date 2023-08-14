package com.example.user_manegementhw17.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @NotEmpty(message = "name must not be empty")
    @Size(min = 4, message = "name must be more than 4 characters")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotEmpty(message = "username must not be empty")
    @Size(min = 4, message = "username must be more than 4 characters")
    @Column(columnDefinition = "varchar(20) not null unique ")
    private String username;

    @NotEmpty(message = "password must not be empty")
    @Column(columnDefinition = "varchar(20) not null ")
    private String password;

    @NotEmpty(message = "email must not be empty")
    @Email(message = "email must be more than 4 characters")
    @Column(columnDefinition = "varchar(25) not null unique ")
    private String email;

    @NotEmpty(message = "role must not be empty")
    @Pattern(regexp = "(admin|user)", message = "role must be admin or user only")
    @Column(columnDefinition = "varchar(5) check(role='user' or role='admin') ")
    private String role;

    @NotNull(message = "age must not be null")
    @Column(columnDefinition = "int not null ")
    private Integer age;
}
