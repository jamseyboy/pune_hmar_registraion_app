package com.jameslalringsan.pune_hmar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jameslalringsan.pune_hmar.dto.UserDto;
import com.jameslalringsan.pune_hmar.model.UserModel;
import com.jameslalringsan.pune_hmar.service.UserService;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping(path = "hsa/users")
public class UserController {


    public UserService userservice;

    
    @Autowired
     public UserController(UserService userservice) {
        this.userservice = userservice;
    }



    @GetMapping()
     public ResponseEntity<List<UserModel>> getlist(){

        return new ResponseEntity<List<UserModel>>(userservice.findAll(), HttpStatus.OK);
     }



     @PostMapping("/saveUser")
     public void save( @RequestBody UserDto userDto){

      //UserModel testUserModel = new UserModel("Teresaa", "Zotee", "Teresaa@gmail.com", "Femal", "1997-04-12",);
         System.out.println("Below is the model passed");
         System.out.println(userDto);
        userservice.saveUser(userDto);
     }



     
     @GetMapping("/email")
     public String getemailId(@RequestParam("userId") Integer userId){

      return userservice.getEmialByInfoId(userId);
     } 

     
}
