package com.jameslalringsan.pune_hmar.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jameslalringsan.pune_hmar.dto.UserDto;
import com.jameslalringsan.pune_hmar.model.UserModel;
import com.jameslalringsan.pune_hmar.repository.AddressRepository;
import com.jameslalringsan.pune_hmar.repository.UserRepository;
import com.jameslalringsan.pune_hmar.service.UserService;

import jakarta.websocket.server.ServerEndpoint;


@Service
public class userServiceImpl implements UserService{


    @Autowired
    private UserRepository userRepository;

    //@Autowired
    //private AddressRepository addressRepository;


    public void saveUser(UserDto userDto){
        

        UserModel newUser = new UserModel(); 
        BeanUtils.copyProperties(userDto, newUser);

    
        ////String jsonData = "{\"firstName\":\"Teresaa\",\"lastName\":\"Zote\",\"email\":\"Teresaa@gmail.com\",\"gender\":\"female\",\"phoneNumber\":\"8132827315\",\"dob\":\"1997-12-09\",\"addressModelList\":[{\"perAddress\":\"Rengkai\",\"tempAddress\":\"Pune\"}]}";

        //List<AddressModel> tempAddressModel = new ArrayList<>();

        //for (AddressModel addressModelIn : userDto.getAddressModelsList()){

        //    AddressModel addressModel = new AddressModel(addressModelIn.getperAddress(), addressModelIn.gettempAddress());
        //    addressModel.setuser(userModel);
        //    tempAddressModel.add(addressModel);
       // }

        //userModel.setAddressModelsList(tempAddressModel);
        userRepository.save(newUser);
    }


    @Override
    public List<UserModel> findAll(){

        try{
            return userRepository.findAll();
        }catch(Exception e){
            throw e;
        }

    }



    public String getEmialByInfoId(Integer userId){

        return userRepository.findEmailByUserId(userId);
    }




}
