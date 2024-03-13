package com.jameslalringsan.pune_hmar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jameslalringsan.pune_hmar.model.EmergencyContactModel;
import com.jameslalringsan.pune_hmar.repository.EmergencyContactRepository;

@Service
public class EmergencyContactService {

    @Autowired
    private EmergencyContactRepository emergencyContactRepository;


    public List<EmergencyContactModel> getlist(){

        return emergencyContactRepository.findAll();
        
    }

    public String saveEmergencyContact(EmergencyContactModel emergencyContactModel){

        try{
            emergencyContactRepository.save(emergencyContactModel);
            return "Emergency Contact Saved Successfully";
        }
        catch(Exception e){

            return " Failed to save due to " + e;

        }

    }



}
