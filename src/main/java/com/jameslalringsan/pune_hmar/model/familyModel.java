package com.jameslalringsan.pune_hmar.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class familyModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer familyId;


}
