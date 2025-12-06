package com.beybladereview.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private double rating;
    private String reviewer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "beyblade_id")
    @JsonIgnore
    private Beyblade beyblade;
}