package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO){
        PropertyEntity pe=new PropertyEntity();
        pe.setAdress(propertyDTO.getAdress());
        pe.setDescription(propertyDTO.getDescription());
        pe.setPrice(propertyDTO.getPrice());
        pe.setTitle(propertyDTO.getTitle());
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setOwnerName(propertyDTO.getOwnerName());
        return pe;
    }
    public PropertyDTO convertEntityToDTO(PropertyEntity propertyEntity){
        PropertyDTO propertyDTO=new PropertyDTO();
        propertyDTO.setAdress(propertyEntity.getAdress());
        propertyDTO.setDescription(propertyEntity.getDescription());
        propertyDTO.setPrice(propertyEntity.getPrice());
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setOwnerEmail(propertyEntity.getOwnerEmail());
        propertyDTO.setOwnerName(propertyEntity.getOwnerName());
        return propertyDTO;
    }

}
