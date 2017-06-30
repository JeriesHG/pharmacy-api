/*
 * Copyright (c) Jeries Handal - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jeries Handal <Jeries Handal>,  2016.
 */
package com.jerieshandal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * MarketResearch
 *
 * @author JeriesHG
 * @version 1.0.0
 */
@Entity()
@Table(name = "Market_research")
public class MarketResearch extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1508131899880348624L;

    @Column(name = "rate", nullable = false)
    private double rate;
    @JsonIgnore
    @ManyToOne(targetEntity = BeautyProduct.class)
    @JoinColumn(name = "id_beauty_product", nullable = false)
    private BeautyProduct beautyProduct;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public BeautyProduct getBeautyProduct() {
        return beautyProduct;
    }

    public void setBeautyProduct(BeautyProduct beautyProduct) {
        this.beautyProduct = beautyProduct;
    }
}
