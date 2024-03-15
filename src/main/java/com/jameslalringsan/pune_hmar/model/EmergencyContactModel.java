package com.jameslalringsan.pune_hmar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "em_contact_table")
public class EmergencyContactModel {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer emContactId;

    @Column
    private String contactNumber;

    @Column
    private String contactName;

    @Column
    private String relation;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JoinColumn(name ="user_id")
    private UserModel emContactUser;


    
    public EmergencyContactModel() {
        super();
    }


    public EmergencyContactModel(String contactNumber, String contactName, String relation) {
        this.contactNumber = contactNumber;
        this.contactName = contactName;
        this.relation = relation;
    }

    
    public Integer getemContactId() {
        return emContactId;
    }
    public void setemContactId(Integer emContactId) {
        this.emContactId = emContactId;
    }


    public String getcontactNumber() {
        return contactNumber;
    }
    public void setcontactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }


    public String getcontactName() {
        return contactName;
    }
    public void setcontactName(String contactName) {
        this.contactName = contactName;
    }


    
    public String getRelation() {
        return relation;
    }
    public void setRelation(String relation) {
        this.relation = relation;
    }

    
    public UserModel getemContactUser() {
        return emContactUser;
    }
    public void setEmContactUserId(UserModel emContactUser) {
        this.emContactUser = emContactUser;
    }



    public String toString() {
        return "EmergencyContactModel{" +
                "userId= '"+ emContactUser + '\'' +", " +
                "contactNumber ='" + contactNumber + '\'' + ", " +
                "contactName= '" + contactName + '\''+ "," +
                "relation= ' "+ relation + "}";
    }
}
