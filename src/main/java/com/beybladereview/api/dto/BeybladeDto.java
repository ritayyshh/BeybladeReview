package com.beybladereview.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeybladeDto {
    private int id;
    private String name;
    private String blader;
    private String series;
    private String type;
    private String bitBeast;
    private String system;
    private String spinDirection;
    private double attackPower;
    private double defensePower;
    private double staminaPower;
    private String description;
}