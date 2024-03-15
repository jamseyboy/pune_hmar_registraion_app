package com.jameslalringsan.pune_hmar.serviceImpl;

import com.jameslalringsan.pune_hmar.model.AddressModel;
import com.jameslalringsan.pune_hmar.model.UserModel;
import com.jameslalringsan.pune_hmar.repository.AddressRepository;
import com.jameslalringsan.pune_hmar.repository.UserRepository;
import com.jameslalringsan.pune_hmar.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class addressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRepository userRepository;
    public List<AddressModel> getAddressList(){

        return addressRepository.findAll();
    }

    public String saveAddress(AddressModel addressModel, Integer userId){

        try{

            UserModel tempUserModel = userRepository.getReferenceById(userId);
            List<AddressModel> temAddressModels = new ArrayList<>();

            addressModel.setAddressUser(tempUserModel);
            temAddressModels.add(addressModel);
            tempUserModel.setAddressModelsList(temAddressModels);

            userRepository.save(tempUserModel);
            return "Address Saved Successfully";

        }catch (Exception e){

            return e.toString();
        }

    }
}
