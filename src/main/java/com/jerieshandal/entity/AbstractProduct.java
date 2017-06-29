/*
 * Copyright (c) Jeries Handal - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jeries Handal <Jeries Handal>,  2016.
 */
package com.jerieshandal.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 * AbstractProduct
 *
 * @author JeriesHG
 * @version 1.0.0
 */
@MappedSuperclass
public abstract class AbstractProduct extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 2176380414578994328L;

    @Column(name = "expiration_date", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date expiration;
    @OneToOne(optional = false, targetEntity = StockElement.class)
    @JoinColumn(name = "id_stock_element")
    private StockElement stockElement;
    @Column(name = "pr_name", nullable = false)
    private String name;



    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public StockElement getStockElement() {
        return stockElement;
    }

    public void setStockElement(StockElement stockElement) {
        this.stockElement = stockElement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
