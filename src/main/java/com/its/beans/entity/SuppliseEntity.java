package com.its.beans.entity;

import com.its.beans.dto.SuppliesDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "suppiles")
public class SuppliseEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String smallHandmill;
    @Column
    private String  roundHandmill;
    @Column
    private String dripper;
    @Column
    private String dripFilter;

    public static SuppliseEntity toSaveEntity(SuppliesDTO suppliesDTO) {
        SuppliseEntity suppliseEntity = new SuppliseEntity();
        suppliseEntity.setSmallHandmill(suppliesDTO.getSmallHandmill());
        suppliseEntity.setRoundHandmill(suppliesDTO.getRoundHandmill());
        suppliseEntity.setDripper(suppliesDTO.getDripper());
        suppliseEntity.setDripFilter(suppliesDTO.getDripFilter());
        return suppliseEntity;
    }
}
