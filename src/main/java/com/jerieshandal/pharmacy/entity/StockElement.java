/*
 * Copyright (c) Jeries Handal - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jeries Handal <Jeries Handal>,  2017.
 */
package com.jerieshandal.pharmacy.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * StockElement
 *
 * @author JeriesHG
 * @version 1.0.0
 */
@Entity()
@Table(name = "Stock_element")
public class StockElement extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 3252654738072281635L;
    @Column(name = "price", nullable = false, precision = 2)
    private double price;
    @Column(name = "cost", nullable = false, precision = 2)
    private double cost;
    @Column(name = "vendor", nullable = false)
    private String vendor;

    public StockElement() {
    }

    public StockElement(double price, double cost, String vendor) {
        this.price = price;
        this.cost = cost;
        this.vendor = vendor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
