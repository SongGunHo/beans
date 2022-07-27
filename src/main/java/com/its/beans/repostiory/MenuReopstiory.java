package com.its.beans.repostiory;

import com.its.beans.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuReopstiory extends JpaRepository<MenuEntity,Long> {
    void update(MenuEntity toUpdate);
}
