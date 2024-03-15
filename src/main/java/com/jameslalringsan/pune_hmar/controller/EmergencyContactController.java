package com.jameslalringsan.pune_hmar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jameslalringsan.pune_hmar.model.EmergencyContactModel;
import com.jameslalringsan.pune_hmar.service.EmergencyContactService;

@RestController
@RequestMapping(path = "hsa/emergencyContact")
public class EmergencyContactController {

    @Autowired
    public EmergencyContactService emergencyContactService;




    
    //Retrive all Emergency Contacts Saved in database//
    @GetMapping
    public List<EmergencyContactModel> getAlllist(){

        return emergencyContactService.getEmContactList();
    }


    //Save emergency contact info to db//
    @PostMapping("/saveEmergencyContact")
    public String saveEmergencyContact(@RequestParam(name = "userId") Integer userId, @RequestBody EmergencyContactModel emergencyContactModel){

        try{
            return emergencyContactService.saveEmergencyContact(emergencyContactModel, userId);
        }catch(Exception e){
            return e.toString();
        }

    }

}
