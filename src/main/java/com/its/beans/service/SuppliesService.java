package com.its.beans.service;

import com.its.beans.dto.SuppliesDTO;
import com.its.beans.entity.SuppliseEntity;
import com.its.beans.repostiory.SuppliesReopsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SuppliesService {
    private final SuppliesReopsitory suppliesReopsitory;

    public Long  save(SuppliesDTO suppliesDTO) {
     return    suppliesReopsitory.save(SuppliseEntity.toSaveEntity(suppliesDTO)).getId();
    }

    public List<SuppliesDTO> findAll() {
         List<SuppliseEntity> suppliseEntityList= suppliesReopsitory.findAll();
         List<SuppliesDTO> suppliesDTOList= new ArrayList<>();
         for(SuppliseEntity  suppliseEntity :suppliseEntityList){
              suppliesDTOList.add(SuppliesDTO.toSuppliesDTO(suppliseEntity));
         }return suppliesDTOList;
    }

    public SuppliesDTO finById(Long id) {
         Optional<SuppliseEntity> optionalSuppliseEntity= suppliesReopsitory.findById(id);
         if(optionalSuppliseEntity.isEmpty()){
              SuppliseEntity suppliseEntity = optionalSuppliseEntity.get();
              SuppliesDTO suppliesDTO = SuppliesDTO.toSuppliesDTO(suppliseEntity);
              return suppliesDTO;
         }else {
             return null;
         }
    }
}
