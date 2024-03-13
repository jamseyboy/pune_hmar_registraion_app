package com.jameslalringsan.pune_hmar.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jameslalringsan.pune_hmar.dto.UserDto;
import com.jameslalringsan.pune_hmar.model.AddressModel;
import com.jameslalringsan.pune_hmar.model.UserModel;
import com.jameslalringsan.pune_hmar.repository.AddressRepository;
import com.jameslalringsan.pune_hmar.repository.UserRepository;

import jakarta.transaction.Transactional;


public interface UserService  {

    

    public List<UserModel> findAll();
    public void saveUser(UserDto userDto);
    public String getEmialByInfoId(Integer userId);



}
