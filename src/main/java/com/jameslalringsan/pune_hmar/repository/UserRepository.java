package com.jameslalringsan.pune_hmar.repository;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jameslalringsan.pune_hmar.dto.UserDto;
import com.jameslalringsan.pune_hmar.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer>{


@Query(value="select s.email from basic_info_table s where s.user_id = :userId", nativeQuery = true)
String findEmailByUserId(Integer userId);


}
