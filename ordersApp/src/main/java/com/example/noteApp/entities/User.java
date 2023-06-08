package com.example.noteApp.entities;

import com.example.noteApp.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Users")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true)
    private String username;

    @Column(unique=true)
    private String password;

    @Column
    private String name;

    @Column
    private String lastname;
    
    @Column
    private BigInteger phonenumber;

    @Column(unique=true)
    private String email;

    @OneToMany(mappedBy= "user", fetch=FetchType.LAZY, cascade= {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Notes> notesSet=new HashSet<>();

    public User(UserDto userDto){
        if (userDto.getUsername() != null){
            this.username = userDto.getUsername();
        }
        if (userDto.getPassword() != null){
            this.password = userDto.getPassword();
        }
        if (userDto.getName() != null){
            this.name = userDto.getName();
        }
        if (userDto.getLastname() != null){
            this.lastname = userDto.getLastname();
        }
        if (userDto.getPhonenumber() != null){
            this.phonenumber = userDto.getPhonenumber();
        }
        if (userDto.getEmail() != null){
            this.email = userDto.getEmail();
        }
    }
}
