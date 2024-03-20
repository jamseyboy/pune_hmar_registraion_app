package com.jameslalringsan.pune_hmar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jameslalringsan.pune_hmar.model.LoginModel;




public interface CredentialsRepository  extends JpaRepository<LoginModel, Integer>{


    @Query(value = "select s.password from login_table s where s.email =:email", nativeQuery = true)
    String findPasswordByEmail(String email);

}
