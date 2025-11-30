package com.beybladereview.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Beyblade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "beyblade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<Review>();
}