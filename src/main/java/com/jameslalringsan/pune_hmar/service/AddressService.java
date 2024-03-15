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
public interface AddressService {




    public List<AddressModel> getAddressList();

    public String saveAddress(AddressModel addressModel, Integer userId);
}
