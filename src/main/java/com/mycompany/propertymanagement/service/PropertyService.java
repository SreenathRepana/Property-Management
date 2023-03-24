package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface PropertyService {

     public PropertyDTO saveProperty(PropertyDTO propertyDTO);
     List<PropertyDTO> getAllProperties();
     PropertyDTO updateProperty(PropertyDTO propertyDTO,Integer propertyId);
     PropertyDTO updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, Integer propertyId);
     PropertyDTO updatePropertyPrice(@RequestBody PropertyDTO propertyDTO,Integer propertyId);
     void deleteProperty(Integer propertyId);
}
