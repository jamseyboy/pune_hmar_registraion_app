package com.jameslalringsan.pune_hmar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jameslalringsan.pune_hmar.model.EmergencyContactModel;
import com.jameslalringsan.pune_hmar.repository.EmergencyContactRepository;

@Service
public interface EmergencyContactService  {

    public List<EmergencyContactModel> getEmContactList();

    public String saveEmergencyContact(EmergencyContactModel emergencyContactModel, Integer userId);



}
