package com.jameslalringsan.pune_hmar.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jameslalringsan.pune_hmar.dto.UserDto;
import com.jameslalringsan.pune_hmar.model.LoginModel;
import com.jameslalringsan.pune_hmar.model.UserModel;
import com.jameslalringsan.pune_hmar.repository.AddressRepository;
import com.jameslalringsan.pune_hmar.repository.CredentialsRepository;
import com.jameslalringsan.pune_hmar.repository.UserRepository;
import com.jameslalringsan.pune_hmar.service.UserService;

import jakarta.websocket.server.ServerEndpoint;


@Service
public class userServiceImpl implements UserService{


    @Autowired
    private UserRepository userRepository;


    @Autowired
    private CredentialsRepository credentialsRepository;





///Method to save user details
    public void saveUser(UserDto userDto){
        UserModel newUser = new UserModel(); 
        BeanUtils.copyProperties(userDto, newUser);
        userRepository.save(newUser);
    }


//Method to retrieve all user info
    @Override
    public List<UserModel> findAll(){
        try{
            return userRepository.findAll();
        }catch(Exception e){
            throw e;
        }
    }


//mehthod to reteive emailid using userId
    public String getEmailByUserId(Integer userId){
        return userRepository.findEmailByUserId(userId);
    }


//method to get user id using email
    public  Integer getUserIdByEmail(String email){
        return userRepository.getUserIdByEmail(email);
    }


//method to establish login service with encrypted password and email
    public String loginUser(LoginModel loginModel){
        try{


             String requestEmail = loginModel.getEmail();
             String DBpassword = credentialsRepository.findPasswordByEmail(requestEmail);


             System.out.println("DB Pw: " + DBpassword + " Model PW: " + loginModel.getPassword());
           
            if(loginModel !=null && loginModel.getPassword().equals(DBpassword)){

                return "1";
            }
            else if (DBpassword == null){
                return "0";
            }else if(loginModel.getPassword() !=null && DBpassword != null && !Objects.equals(loginModel.getPassword(), DBpassword)){
                return "10";
            }
            else{
                return "-1";
            }
        }catch(Exception e){
            System.out.println(e);
            return "-1";   
        }    
    }


    public String registerUser(LoginModel loginModel){

        try{
            credentialsRepository.save(loginModel);

            return "1"; //success registration

        }catch(Exception e){
            String errorMessage = e.getMessage();
            if(errorMessage.contains("[Duplicate")){
                return "0";
            }
            else{
                return "-1";
            }
            
        }
    }







}
