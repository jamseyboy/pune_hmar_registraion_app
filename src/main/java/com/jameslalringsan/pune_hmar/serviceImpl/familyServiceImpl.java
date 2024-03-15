package com.jameslalringsan.pune_hmar.serviceImpl;

import com.jameslalringsan.pune_hmar.model.AddressModel;
import com.jameslalringsan.pune_hmar.model.FamilyModel;
import com.jameslalringsan.pune_hmar.model.UserModel;
import com.jameslalringsan.pune_hmar.repository.FamilyRepository;
import com.jameslalringsan.pune_hmar.repository.UserRepository;
import com.jameslalringsan.pune_hmar.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class familyServiceImpl implements FamilyService {


    @Autowired
    FamilyRepository familyRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public List<FamilyModel> getFamilyList() {
        return familyRepository.findAll();
    }


    public  String saveFamily(FamilyModel familyModel, Integer userId){

        try{

            UserModel tempUserModel = userRepository.getReferenceById(userId);
            List<FamilyModel> tempFamilyModels = new ArrayList<>();

            familyModel.setFamilyUser(tempUserModel);
            tempFamilyModels.add(familyModel);
            tempUserModel.setFamilyModelList(tempFamilyModels);

            userRepository.save(tempUserModel);
            return "Family Saved Successfully";
        }
        catch (Exception e){
            return e.toString();
        }
    }

}
