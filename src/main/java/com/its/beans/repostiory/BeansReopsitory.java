package com.its.beans.repostiory;

import com.its.beans.entity.BeansEntiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BeansReopsitory extends JpaRepository<BeansEntiry,Long > {
    void update(BeansEntiry toUpdate);
}
