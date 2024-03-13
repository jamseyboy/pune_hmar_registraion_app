package com.jameslalringsan.pune_hmar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

    @Column
    private Integer infoId;


    
    public EmergencyContactModel() {
        super();
    }


    public EmergencyContactModel(Integer emContactId, String contactNumber, String contactName, String relation,
            Integer infoId) {
        this.emContactId = emContactId;
        this.contactNumber = contactNumber;
        this.contactName = contactName;
        this.relation = relation;
        this.infoId = infoId;
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

    
    public Integer getinfoId() {
        return infoId;
    }
    public void setinfoId(Integer infoId) {
        this.infoId = infoId;
    }






}
