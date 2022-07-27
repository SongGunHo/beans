package com.its.beans.dto;

import com.its.beans.entity.MenuEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO {
    private Long id;
    private String beans;
    private String supplies;

    public MenuDTO(String beans, String supplies) {
        this.beans = beans;
        this.supplies = supplies;
    }

    public static MenuDTO toMenuDTO(MenuEntity menuEntity) {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setBeans(menuEntity.getBeans());
        menuDTO.setSupplies(menuEntity.getSupplies());
        return menuDTO;
    }
}
