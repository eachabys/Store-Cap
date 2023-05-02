package com.postgresql.trendsdemo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="login")
public class Person {
    @Id
    private String username;
    private String password;
}
