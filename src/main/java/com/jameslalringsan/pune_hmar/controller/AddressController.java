package com.jameslalringsan.pune_hmar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.jameslalringsan.pune_hmar.model.AddressModel;
import com.jameslalringsan.pune_hmar.model.UserModel;
import com.jameslalringsan.pune_hmar.service.AddressService;

@RestController
@RequestMapping(path = "hsa/address")
public class AddressController {


        @Autowired
        public AddressService addressService;

        @Autowired
        public AddressController(AddressService addressService) {
            this.addressService = addressService;
        }

        

        @GetMapping()
        public List<AddressModel> getAlllist(){

            return addressService.getAddressList();
        }

        //Below is used to store all user address info in address table
        @PostMapping("/saveAddress")
        public String saveAddress(@RequestParam(name = "userId") Integer userId ,@RequestBody AddressModel addressModel){

            System.out.println(userId);

            try{

                return addressService.saveAddress(addressModel, userId);
            }
            catch(Exception e){
                return "Error" + e ;

            }


            
        }
}
