package com.its.beans.dto;

import com.its.beans.entity.BeansEntiry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeansDTO {
    private Long id;
    private String beandMandeling;
    private String beansRobutaStar;
    private String beansHolic;
    private int beansHits;
    private MultipartFile beansFile;
    private String beansFileName;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    public static BeansDTO toBeansDTO(BeansEntiry beansEntiry) {
        BeansDTO beansDTO = new BeansDTO();
        beansDTO.setBeandMandeling(beansEntiry.getBeandMandeling());
        beansDTO.setBeansRobutaStar(beansEntiry.getBeansRobutaStar());
        beansDTO.setBeansHolic(beansEntiry.getBeansHolic());
        beansDTO.setCreatedTime(beansEntiry.getCreatedTime());
        beansDTO.setUpdatedTime(beansEntiry.getUpdatedTime());
        return beansDTO;
    }

}
