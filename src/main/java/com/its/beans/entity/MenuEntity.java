package com.its.beans.entity;

import com.its.beans.dto.MenuDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "menu")
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String beans;

    @Column
    private String supplies;
    public static MenuEntity toSaveEntity(MenuDTO menuDTO) {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setBeans(menuDTO.getBeans());
        menuEntity.setSupplies(menuDTO.getSupplies());
        return menuEntity;
    }

    public static MenuEntity toUpdate(MenuDTO menuDTO) {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setId(menuDTO.getId());
        menuEntity.setBeans(menuDTO.getBeans());
        menuEntity.setSupplies(menuDTO.getSupplies());
        return menuEntity;
    }
}
