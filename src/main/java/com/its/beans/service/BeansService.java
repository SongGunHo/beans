package com.its.beans.service;

import com.its.beans.common.PagingConst;
import com.its.beans.dto.BeansDTO;
import com.its.beans.entity.BeansEntiry;
import com.its.beans.repostiory.BeansReopsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BeansService {
    private final BeansReopsitory beansReopsitory;

    public Long  save(BeansDTO beansDTO){
        Long  savedId=    beansReopsitory.save(BeansEntiry.toSaveEntity(beansDTO)).getId();
    return savedId;
    }

    public List<BeansDTO> findAll() {
         List<BeansEntiry> beansEntiryList =beansReopsitory.findAll();
         List<BeansDTO> beansDTOList = new ArrayList<>();
         for(BeansEntiry beansEntiry : beansEntiryList){
             beansDTOList.add(BeansDTO.toBeansDTO(beansEntiry));
         }return beansDTOList;
    }

    public BeansDTO findById(Long id) {
         Optional<BeansEntiry> optionalBeansEntiry= beansReopsitory.findById(id);
         if(optionalBeansEntiry.isEmpty()){
              BeansEntiry beansEntiry =optionalBeansEntiry.get();
              BeansDTO beansDTO = BeansDTO.toBeansDTO(beansEntiry);
              return beansDTO;
         }else{
             return null;
         }
    }

    public void delate(Long id) {
        beansReopsitory.deleteById(id);
    }

    public void update(BeansDTO beansDTO) {
        beansReopsitory.update(BeansEntiry.toUpdate(beansDTO));
    }

}
