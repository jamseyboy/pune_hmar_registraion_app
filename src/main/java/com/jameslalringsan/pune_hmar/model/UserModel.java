package com.jameslalringsan.pune_hmar.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.bind.DefaultValue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","emergencyContactModelList", "addressModelsList","familyModelList", "handler"})
@Table(name = "basic_info_table")
public class UserModel {
    


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    public Integer getuserId() {
		return userId;
	}

	public void setuserId(int userId) {
		this.userId = userId;
	}

	@Column
	private String firstName;

	@Column
    private String lastName;

	@Column(unique = true)
    private String email;

	@Column
    private String gender;

	@Column
    private String phoneNumber;


	@Column
	private Date dob;


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "addressUser", cascade = CascadeType.ALL)
	private List<AddressModel> addressModelsList;


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "emContactUser", cascade = CascadeType.ALL)
	private List<EmergencyContactModel> emergencyContactModelList;





	@OneToMany(fetch = FetchType.LAZY, mappedBy = "familyUser", cascade = CascadeType.ALL)
	private List<FamilyModel> familyModelList;



	public List<AddressModel> getAddressModelsList() {
		return addressModelsList;
	}
	public void setAddressModelsList(List<AddressModel> addressModelsList) {
		this.addressModelsList = addressModelsList;
	}


	public List<EmergencyContactModel> getEmergencyContactModelList() {
		return emergencyContactModelList;
	}
	public void setEmergencyContactModelList(List<EmergencyContactModel> emergencyContactModelList) {
		this.emergencyContactModelList = emergencyContactModelList;
	}


	public List<FamilyModel> getFamilyModelList() { return familyModelList; }
	public void setFamilyModelList(List<FamilyModel> familyModelList) {
		this.familyModelList = familyModelList;
	}




	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}




	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}




	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getphoneNumber() {
		return phoneNumber;
	}
	public void setphoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}



	
 

    public UserModel() {
		super();
	}


	public UserModel( String firstName, String lastName, String email, String gender,Date dob, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.dob=dob;
		this.phoneNumber = phoneNumber;
	
	}

	public UserModel(String firstName, String lastName, String email, String gender, String phoneNumber, Date dob,
			List<AddressModel> addressModelsList, List<EmergencyContactModel> emergencyContactModelList, List<FamilyModel> familyModelList) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.addressModelsList = addressModelsList;
		this.emergencyContactModelList = emergencyContactModelList;
		this.familyModelList = familyModelList;
	}

	@Override
	public String toString(){

		return "UserModel{"+
				"userId = " + userId +
				"firstName =  '"+ firstName + '\'' + ", " +
				"lastName='"+ lastName + '\'' + ", " +
				"email='"+ email + '\'' + ", " +
				"phoneNumber = ' "  + phoneNumber + '\'' + ", " +
				"dob ='" +dob+ "'}";
	}
	
}
