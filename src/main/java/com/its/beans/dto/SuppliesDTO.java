package com.its.beans.dto;

import com.its.beans.entity.SuppliseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuppliesDTO {
    private Long id;
    private String smallHandmill;
    private String roundHandmill;
    private String dripper;
    private String dripFilter;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private int Hits;

    public SuppliesDTO(String smallHandmill, String roundHandmill, String dripper, String dripFilter, LocalDateTime createdTime, LocalDateTime updatedTime , int Hits)  {
        this.smallHandmill = smallHandmill;
        this.roundHandmill = roundHandmill;
        this.dripper = dripper;
        this.dripFilter = dripFilter;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.Hits = Hits;

    }

    public static SuppliesDTO toSuppliesDTO(SuppliseEntity suppliseEntity) {
        SuppliesDTO suppliesDTO = new SuppliesDTO();
        suppliesDTO.setSmallHandmill(suppliseEntity.getSmallHandmill());
        suppliesDTO.setRoundHandmill(suppliesDTO.getRoundHandmill());
        suppliesDTO.setDripper(suppliesDTO.getDripper());
        suppliesDTO.setDripFilter(suppliseEntity.getDripFilter());
        suppliesDTO.setHits(0);
        return suppliesDTO;
    }
}
