package com.its.beans.service;

import com.its.beans.dto.MenuDTO;
import com.its.beans.entity.MenuEntity;
import com.its.beans.repostiory.MenuReopstiory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuReopstiory menuReopstiory;

    public Long  save(MenuDTO menuDTO) {
        return menuReopstiory.save(MenuEntity.toSaveEntity(menuDTO)).getId();
    }

    public List<MenuDTO> findAll() {
         List<MenuEntity> menuEntityList =menuReopstiory.findAll();
         List<MenuDTO> menuDTOList =new ArrayList<>();
         for(MenuEntity menuEntity : menuEntityList){
             menuDTOList.add(MenuDTO.toMenuDTO(menuEntity));
         }return menuDTOList;
    }

    public MenuDTO findById(Long id) {
         Optional<MenuEntity> optionalMenuEntity=menuReopstiory.findById(id);
         if(optionalMenuEntity.isEmpty()){
              MenuEntity menuEntity =optionalMenuEntity.get();
              MenuDTO menuDTO = MenuDTO.toMenuDTO(menuEntity);
              return menuDTO;
         }return null;
    }

    public void update(MenuDTO menuDTO) {
        menuReopstiory.update(MenuEntity.toUpdate(menuDTO));
    }

    public void delate(Long id) {
        menuReopstiory.deleteById(id);
    }
}
