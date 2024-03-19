package com.jameslalringsan.pune_hmar.controller;

import com.jameslalringsan.pune_hmar.model.FamilyModel;
import com.jameslalringsan.pune_hmar.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "hsa/family")
public class FamilyController {


    @Autowired
    public FamilyService familyService;

    @GetMapping()
    public List<FamilyModel> getAllList(){

        return  familyService.getFamilyList();
    }

    @PostMapping("/saveFamily")
    public  String saveFamily(@RequestParam(name = "userId") Integer userId,@RequestBody FamilyModel familyModel ){

        try{
            familyService.saveFamily(familyModel, userId);
            return "1";
        }catch (Exception e){

            return e.toString();
        }

    }

}
