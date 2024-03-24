package com.jameslalringsan.pune_hmar.controller;

import java.util.List;

import com.jameslalringsan.pune_hmar.dto.UserIdDto;
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
import com.jameslalringsan.pune_hmar.model.LoginModel;
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
     public String save( @RequestBody UserDto userDto){


         System.out.println("Below is the model passed");
         System.out.println(userDto);

         try{
             userservice.saveUser(userDto);
             UserIdDto userId = new UserIdDto(userservice.getUserIdByEmail(userDto.getEmail()));
             return userId.getRetrieveduserID().toString();

         }catch(Exception e){
            System.out.println(e);
            return  "Error in saving user basic Info, Email ID: " + userDto.getEmail() + " already in use.";

         }

     }



     
     @GetMapping("/email")
     public String getemailId(@RequestParam("userId") Integer userId){

      return userservice.getEmailByUserId(userId);
     }


     @PostMapping("/loginUser")
     public String loginUser(@RequestBody LoginModel loginModel){

        System.out.println(loginModel);

       return userservice.loginUser(loginModel); // if 1 success, 0 umatch pw, -1 exception
     }


     @PostMapping("/registerUser")
     public String registerUser(@RequestBody LoginModel loginModel){


        System.out.println(loginModel.getEmail() + loginModel.getStatus() + loginModel.getPassword());
       return userservice.registerUser(loginModel);


     }

     
}
