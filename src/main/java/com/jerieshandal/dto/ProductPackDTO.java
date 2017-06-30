/*
 * Copyright (c) Jeries Handal - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jeries Handal <Jeries Handal>,  2016.
 */

package com.jerieshandal.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * ProductPackDTO
 *
 * @author JeriesHG
 * @version 1.0.0
 */
public class ProductPackDTO  implements Serializable{

    private static final long serialVersionUID = -7007045601688340092L;
    
    private String beautyProduct;
    private String medicine;
    private double price;
    private Date expiration;

    public String getBeautyProduct() {
        return beautyProduct;
    }

    public void setBeautyProduct(String beautyProduct) {
        this.beautyProduct = beautyProduct;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
}
