package com.jameslalringsan.pune_hmar.service;

import com.jameslalringsan.pune_hmar.model.FamilyModel;
import com.jameslalringsan.pune_hmar.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FamilyService {



    public List<FamilyModel> getFamilyList();

    public String saveFamily(FamilyModel familyModel, Integer userId);
}
