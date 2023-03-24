package com.mycompany.propertymanagement.controller;


import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.service.PropertyService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class propertyController {
    @Value("${pms.dummy:}")
    private String dummy;

    @Value("${spring.datasource.url:}")
    private String dbUrl;

    @Autowired
    private PropertyService propertyService;



    @GetMapping("/hello")
    public String sayHello(){
        return "Sreenath Repana";
    }
     @GetMapping("/siri")
    public String Sreenath(){
        return "Hi ra";
     }

     @PostMapping("/properites")
     public ResponseEntity<PropertyDTO> Property(@RequestBody PropertyDTO propertyDTO){
            propertyDTO=propertyService.saveProperty(propertyDTO);
           ResponseEntity<PropertyDTO> responseEntity=new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
//         propertyService.saveProperty(propertyDTO);
//         System.out.println(propertyDTO);
        return responseEntity;
     }
     @GetMapping("/properites")
     public ResponseEntity<List<PropertyDTO>> getAllProperties(){
         System.out.println(dummy);
         System.out.println(dbUrl);
         List<PropertyDTO> propertyList=propertyService.getAllProperties();
         ResponseEntity<List<PropertyDTO>> responseEntity=new ResponseEntity<>(propertyList,HttpStatus.OK);
         return responseEntity;

     }

     @PutMapping("/properites/{propertyId}")
     public ResponseEntity<PropertyDTO> updateProperties(@RequestBody PropertyDTO propertyDTO,@PathVariable Integer propertyId){
         propertyDTO=propertyService.updateProperty(propertyDTO,propertyId);
         ResponseEntity<PropertyDTO> responseEntity=new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
         return responseEntity;
     }

     @PatchMapping("/updatedesc/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO,@PathVariable Integer propertyId){
         propertyDTO=propertyService.updatePropertyDescription(propertyDTO,propertyId);
         ResponseEntity<PropertyDTO> responseEntity=new ResponseEntity<>(propertyDTO, HttpStatus.OK);
         return responseEntity;
    }

    @PatchMapping("updateprice/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO,@PathVariable Integer propertyId){
        propertyDTO=propertyService.updatePropertyPrice(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO> responseEntity=new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("delprop/{propertyId}")
    public ResponseEntity deleteProperty(@PathVariable Integer propertyId){
      propertyService.deleteProperty(propertyId);
      ResponseEntity<Void> responseEntity=new ResponseEntity<>( null ,HttpStatus.NO_CONTENT);
      return responseEntity;
    }

}
