package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PropertyServiceImpl implements PropertyService {

    @Value("${pms.dummy:}")
    private String dummy;

    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        PropertyEntity pe=propertyConverter.convertDTOtoEntity(propertyDTO);
        propertyRepository.save(pe);
        propertyDTO=propertyConverter.convertEntityToDTO(pe);

        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        System.out.println("InService"+ dummy);

        List<PropertyEntity> listofprop=(List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDTO> listprops=new ArrayList<>();
        for(PropertyEntity pe:listofprop){
            PropertyDTO dto=propertyConverter.convertEntityToDTO(pe);
            listprops.add(dto);
        }
        return listprops;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO,Integer propretyid) {
        Optional<PropertyEntity> optEnt= propertyRepository.findById(propretyid);
        PropertyDTO dto=null;
        if(optEnt.isPresent()){
            PropertyEntity pe=optEnt.get();
            pe.setAdress(propertyDTO.getAdress());
            pe.setDescription(propertyDTO.getDescription());
            pe.setPrice(propertyDTO.getPrice());
            pe.setTitle(propertyDTO.getTitle());
            pe.setOwnerEmail(propertyDTO.getOwnerEmail());
            pe.setOwnerName(propertyDTO.getOwnerName());
            dto=propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Integer propertyId) {
        Optional<PropertyEntity> opten=propertyRepository.findById(propertyId);
        PropertyDTO dto=null;
        if(opten.isPresent()){
            PropertyEntity pe=opten.get();
            pe.setDescription(propertyDTO.getDescription());
            dto=propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);

        }
        return dto;
    }


    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Integer propertyId) {
        Optional<PropertyEntity> optEnt= propertyRepository.findById(propertyId);
        PropertyDTO dto=null;
        if(optEnt.isPresent()){
            PropertyEntity pe=optEnt.get();
            pe.setPrice(propertyDTO.getPrice());
            dto=propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Integer propertyId) {
        propertyRepository.deleteById(propertyId);
    }


}
