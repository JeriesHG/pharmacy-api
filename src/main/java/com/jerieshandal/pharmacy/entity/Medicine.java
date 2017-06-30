/*
 * Copyright (c) Jeries Handal - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jeries Handal <Jeries Handal>,  2016.
 */
package com.jerieshandal.pharmacy.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Medicine
 *
 * @author JeriesHG
 * @version 1.0.0
 */
@Entity()
@Table(name = "Medicine")
public class Medicine extends AbstractProduct implements Serializable {

    private static final long serialVersionUID = 6666943960531851054L;

    @Column(name = "weight", nullable = false)
    private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
