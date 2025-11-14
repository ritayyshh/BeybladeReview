package com.beybladereview.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beybladereview.api.models.Beyblade;

public interface IBeybladeRepository extends JpaRepository<Beyblade, Integer> {

}