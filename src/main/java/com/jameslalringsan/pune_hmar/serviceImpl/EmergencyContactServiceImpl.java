package com.jameslalringsan.pune_hmar.serviceImpl;

import com.jameslalringsan.pune_hmar.model.AddressModel;
import com.jameslalringsan.pune_hmar.model.EmergencyContactModel;
import com.jameslalringsan.pune_hmar.model.UserModel;
import com.jameslalringsan.pune_hmar.repository.EmergencyContactRepository;
import com.jameslalringsan.pune_hmar.repository.UserRepository;
import com.jameslalringsan.pune_hmar.service.EmergencyContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmergencyContactServiceImpl implements EmergencyContactService {


    @Autowired
    EmergencyContactRepository emergencyContactRepository;

    @Autowired
    UserRepository userRepository;

    public List<EmergencyContactModel> getEmContactList(){


            return emergencyContactRepository.findAll();

    }


    public String saveEmergencyContact(EmergencyContactModel emergencyContactModel, Integer userId){

        try{

            UserModel tempUserModel = userRepository.getReferenceById(userId);

            List<EmergencyContactModel> tempEmContactModel = new ArrayList<>();

            emergencyContactModel.setEmContactUserId(tempUserModel);
            tempEmContactModel.add(emergencyContactModel);
            tempUserModel.setEmergencyContactModelList(tempEmContactModel);

            userRepository.save(tempUserModel);
            return "Emergency Contact Saved Successfully";
        }
        catch(Exception e){

            return " Failed to save due to " + e;

        }

    }
}
