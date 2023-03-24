package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<UserDTO> registration(@RequestBody UserDTO userDTO){
        userDTO= userService.register(userDTO);
        ResponseEntity<UserDTO> responseEntity=new ResponseEntity<>(userDTO, HttpStatus.CREATED);
//         propertyService.saveProperty(propertyDTO);
//         System.out.println(propertyDTO);
        return responseEntity;
    }

}
