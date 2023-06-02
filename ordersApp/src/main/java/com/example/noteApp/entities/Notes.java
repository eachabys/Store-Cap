package com.example.noteApp.entities;

import com.example.noteApp.dtos.NotesDto;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notes {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String date;

    @Column
    private String name;

    @Column
    private String lastname;

    @Column
    private Integer customerid;

    @Column
    private Integer productid;
    
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private Integer zip;
    @Column
    private String region;
    @Column
    private Float sales;
    @Column
    private Integer quantity;
    @Column
    private Integer orderid;
    @Column
    private Integer returnid;
    @Column
    private Integer returnsale;
    @Column
    private Integer returnquantity;

    public Notes(NotesDto notesDto){
        if (notesDto.getDate() != null){
            this.date = notesDto.getDate();
        }
        if (notesDto.getName() != null){
            this.name = notesDto.getName();
        }
        if (notesDto.getLastname() != null){
            this.lastname = notesDto.getLastname();
        }
        if (notesDto.getCustomerid() != null){
            this.customerid = notesDto.getCustomerid();
        }
        if (notesDto.getProductid() != null){
            this.productid = notesDto.getProductid();
        }
        if (notesDto.getCity() != null){
            this.city = notesDto.getCity();
        }
        if (notesDto.getState() != null){
            this.state = notesDto.getState();
        }
        if (notesDto.getZip() != null){
            this.zip = notesDto.getZip();
        }
        if (notesDto.getRegion() != null){
            this.region= notesDto.getRegion();
        }
        if (notesDto.getSales() != null){
            this.sales = notesDto.getSales();
        }
        if (notesDto.getQuantity() != null){
            this.quantity = notesDto.getQuantity();
        }
        if (notesDto.getOrderid() != null){
            this.orderid = notesDto.getOrderid();
        }
        if (notesDto.getReturnid() != null){
            this.returnid = notesDto.getReturnid();
        }
        if (notesDto.getReturnsale() != null){
            this.returnsale = notesDto.getReturnsale();
        }
        if (notesDto.getReturnquantity() != null){
            this.returnquantity = notesDto.getReturnquantity();
        }

    }
    @ManyToOne
    @JsonBackReference
    private User user;
}
