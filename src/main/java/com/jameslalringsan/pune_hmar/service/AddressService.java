package com.jameslalringsan.pune_hmar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;
import com.jameslalringsan.pune_hmar.model.AddressModel;
import com.jameslalringsan.pune_hmar.model.UserModel;
import com.jameslalringsan.pune_hmar.repository.AddressRepository;
import com.jameslalringsan.pune_hmar.repository.UserRepository;


@Service
public class AddressService {

        @Autowired
        private AddressRepository addressRepository;

        @Autowired
        private UserRepository userRepository;



        public List<AddressModel> getlist(){

            return addressRepository.findAll();
        }

        public String saveAddress(AddressModel addressModel, Integer userId){


          UserModel tempUserModel = userRepository.getReferenceById(userId);
          List<AddressModel> temAddressModels = new ArrayList<>();

          addressModel.setuser(tempUserModel);
          temAddressModels.add(addressModel);
          tempUserModel.setAddressModelsList(temAddressModels);

          userRepository.save(tempUserModel);
          return "Address Saved Successfully";
        }
}
