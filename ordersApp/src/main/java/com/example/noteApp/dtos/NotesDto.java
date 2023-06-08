package com.example.noteApp.dtos;

import com.example.noteApp.entities.Notes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotesDto {
    private Integer id;
    private String name;
    private String date;
    private String lastname;
    private Integer productid;
    private Integer customerid;
    private String city;
    private String state;
    private Integer zip;
    private String region;
    private Double sales;
    private Integer quantity;
    private Integer orderid;
    private UserDto userDto;
    private Integer returnstatus;
    private Double returnamount;
    private Integer returnquantity;


    public NotesDto(Notes notes){
        if (notes.getId()!=null) {
            this.id = notes.getId(); 
        }
        if (notes.getName() != null) {
            this.name = notes.getName();
        }
        if (notes.getDate() != null) {
            this.date = notes.getDate();
        }
        if (notes.getLastname() != null) {
            this.lastname = notes.getLastname();
        }
        if (notes.getProductid() != null) {
            this.productid = notes.getProductid();
        }
        if (notes.getCustomerid() != null) {
            this.customerid = notes.getCustomerid();
        }
        if (notes.getCity() != null) {
            this.city = notes.getCity();
        }
        if (notes.getState() != null) {
            this.state = notes.getState();
        }
        if (notes.getQuantity() != null) {
            this.quantity= notes.getQuantity();
        }
        if (notes.getZip() != null) {
            this.zip = notes.getZip();
        }
        if (notes.getRegion() != null) {
            this.region = notes.getRegion();
        }
        if (notes.getSales() != null) {
            this.sales = notes.getSales();
        }
        if (notes.getOrderid() != null) {
            this.orderid = notes.getOrderid();
        }
        if (notes.getReturnstatus() != null) {
            this.returnstatus = notes.getReturnstatus();
        }
        if (notes.getReturnamount() != null) {
            this.returnamount = notes.getReturnamount();
        }
        if (notes.getReturnquantity() != null) {
            this.returnquantity = notes.getReturnquantity();
        }
        if (notes.getUser() != null) {
            this.userDto = new UserDto(notes.getUser());
        }
    }
}