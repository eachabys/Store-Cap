package com.example.noteApp.dtos;

import com.example.noteApp.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto  implements Serializable{
    private Long id;
    private String username;
    private String password;
    private String name;
    private String lastname;
    private BigInteger phonenumber;
    private String email;

    private Set<NotesDto> notesDtoSet = new HashSet<>();

    public UserDto(User user) {
        if (user.getId()!=null) {
            this.id = user.getId();
        }
        if (user.getUsername() != null) {
            this.username = user.getUsername();
        }
        if (user.getPassword() != null) {
            this.password = user.getPassword();
        }
        if (user.getName() != null) {
            this.name = user.getName();
        }
        if (user.getLastname() != null) {
            this.lastname = user.getLastname();
        }
        if (user.getPhonenumber() != null) {
            this.phonenumber = user.getPhonenumber();
        }
        if (user.getEmail() != null) {
            this.email = user.getEmail();
        }  
    }
}
