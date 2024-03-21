package com.jameslalringsan.pune_hmar.model;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "family_table")
public class FamilyModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer familyId;
    @Column
    private  String name;

    @Column
    private String gender;
    @Column
    private  String phoneNumber;

    @Column
    private String relation;

    @Column
    private Date dob;


    @Column
    private String status;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JoinColumn(name ="user_id")
    private UserModel familyUser;


    public FamilyModel() {
        super();
    }

    public FamilyModel(String name, String gender, String phoneNumber,String relation, Date dob, String status) {
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.relation = relation;
        this.dob = dob;
        this.status = status;
    }

    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserModel getFamilyUser() {
        return familyUser;
    }

    public void setFamilyUser(UserModel familyUser) {
        this.familyUser = familyUser;
    }




    public String toString(){

        return "FamilyModel{" +
                "userId= '"+ familyUser + '\'' +", " +
                "name ='" + name + '\'' + ", " +
                "gender='" + gender + '\'' + ","+
                "phoneNumber ='" + phoneNumber + '\'' + ", " +
                "relation ='" + relation + '\'' + ", " +
                "dob ='" + dob + '\'' + "}";
    }
}
