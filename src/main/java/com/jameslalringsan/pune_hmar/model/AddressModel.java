package com.jameslalringsan.pune_hmar.model;

import org.hibernate.annotations.Collate;
import org.hibernate.annotations.SqlFragmentAlias;
import org.hibernate.engine.internal.ForeignKeys;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "address_table")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;


    @Column
    private String perAddress;

    @Column
    private String tempAddress;

   
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JoinColumn(name ="user_id")
    private UserModel user;




    
    public AddressModel() {
        super();
    }

    
    public AddressModel(String perAddress, String tempAddress) {
        this.perAddress = perAddress;
        this.tempAddress = tempAddress;
    }





    public Integer getaddressId() {
        return addressId;
    }
    public void setaddressId(Integer addressId) {
        this.addressId = addressId;
    }


    public String getperAddress() {
        return perAddress;
    }
    public void setperAddress(String perAddress) {
        this.perAddress = perAddress;
    }


    public String gettempAddress() {
        return tempAddress;
    }
    public void settempAddress(String tempAddress) {
        this.tempAddress = tempAddress;
    }

    
    public UserModel getuser() {
        return user;
    }
    public void setuser(UserModel user) {
        this.user = user;
    }


    public String toString(){

        return "AddressModel{" + "userId= '"+ user + '\'' +", perAddress ='" + perAddress + '\'' + ", tempAddress= '" + tempAddress + "'}";
    }

}
