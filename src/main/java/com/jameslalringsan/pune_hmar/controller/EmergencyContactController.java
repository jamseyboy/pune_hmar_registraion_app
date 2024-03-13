package com.jameslalringsan.pune_hmar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jameslalringsan.pune_hmar.model.EmergencyContactModel;
import com.jameslalringsan.pune_hmar.service.EmergencyContactService;

@RestController
@RequestMapping(path = "hsa/emergencyContact")
public class EmergencyContactController {

    public EmergencyContactService emergencyContactService;

    @Autowired
    public EmergencyContactController(EmergencyContactService emergencyContactService){

        this.emergencyContactService=emergencyContactService;
    }
    
    //Retrive all Emergency Contacts Saved in database//
    @GetMapping
    public List<EmergencyContactModel> getlist(){

        return emergencyContactService.getlist();
    }


    //Save emergency contact info to db//
    @PostMapping("/saveEmergencyContact")
    public String saveEmergencyContact(@RequestBody EmergencyContactModel emergencyContactModel){

       String savedValue = emergencyContactService.saveEmergencyContact(emergencyContactModel);

       return savedValue;
    }

}
