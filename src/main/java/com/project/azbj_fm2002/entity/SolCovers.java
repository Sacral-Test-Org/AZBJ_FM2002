package com.project.azbj_fm2002.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "sol_covers")
public class SolCovers {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "sum_insured_whole_cover")
    private Double sumInsuredWholeCover;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSumInsuredWholeCover() {
        return sumInsuredWholeCover;
    }

    public void setSumInsuredWholeCover(Double sumInsuredWholeCover) {
        this.sumInsuredWholeCover = sumInsuredWholeCover;
    }
}
