package com.mycompany.propertymanagement.service.impl;

//import com.mycompany.propertymanagement.converter.UserConverter;
import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.exception.BusinessException;
import com.mycompany.propertymanagement.exception.ErrorModel;
import com.mycompany.propertymanagement.repository.UserRepository;
import com.mycompany.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.propertymanagement.converter.UserConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        Optional<UserEntity> optent=userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if(optent.isPresent()){
            List<ErrorModel> errorModels=new ArrayList<>();
            ErrorModel errorModel=new ErrorModel();
            errorModel.setCode("Email Already Exists");
            errorModel.setMessage("please check ur password are use another email");
            errorModels.add(errorModel);

            throw new BusinessException(errorModels);

        }
        UserEntity userEntity=userConverter.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO=userConverter.convertEntityToDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        UserDTO userDTO=null;
        Optional<UserEntity> optionalUserEntity= userRepository.findByOwnerEmailAndPassword(email,password);
        if(optionalUserEntity.isPresent()){
            userDTO=userConverter.convertEntityToDTO(optionalUserEntity.get());
        }
        else{
            List<ErrorModel> errorModels=new ArrayList<>();
            ErrorModel errorModel=new ErrorModel();
            errorModel.setCode("Invalid Credentials");
            errorModel.setMessage("Incorrect Email and Password");
            errorModels.add(errorModel);

            throw new BusinessException(errorModels);
        }
        return userDTO;

    }
}
