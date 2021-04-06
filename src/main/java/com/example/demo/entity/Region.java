package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="region")
public class Region {
    @Id
    private  int regionId;
    private  String regiondescription;

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegiondescription() {
        return regiondescription;
    }

    public void setRegiondescription(String regiondescription) {
        this.regiondescription = regiondescription;
    }
}
