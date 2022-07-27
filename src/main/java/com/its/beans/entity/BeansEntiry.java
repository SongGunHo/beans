package com.its.beans.entity;

import com.its.beans.dto.BeansDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "beans")
public class BeansEntiry extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String beandMandeling;

    @Column
    private String beansRobutaStar;

    @Column
    private String beansHolic;
    @Column
    private String beansFileName;
    @Column
    private int beansHits;

    public static BeansEntiry toSaveEntity(BeansDTO beansDTO) {
        BeansEntiry beansEntiry = new BeansEntiry();
        beansEntiry.setBeandMandeling(beansDTO.getBeandMandeling());
        beansEntiry.setBeansRobutaStar(beansDTO.getBeansRobutaStar());
        beansEntiry.setBeansHolic(beansDTO.getBeansHolic());
        beansEntiry.setBeansFileName(beansDTO.getBeansFileName());
        beansEntiry.setBeansHits(0);
        return beansEntiry;
    }

    public static BeansEntiry toUpdate(BeansDTO beansDTO) {
        BeansEntiry beansEntiry = new BeansEntiry();
        beansEntiry.setId(beansDTO.getId());
        beansEntiry.setBeandMandeling(beansDTO.getBeandMandeling());
        beansEntiry.setBeansRobutaStar(beansDTO.getBeansRobutaStar());
        beansEntiry.setBeansHolic(beansDTO.getBeansHolic());
        beansEntiry.setBeansHits(0);
        return beansEntiry;
    }
}
