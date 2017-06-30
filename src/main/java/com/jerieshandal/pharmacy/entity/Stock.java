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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Stock
 *
 * @author JeriesHG
 * @version 1.0.0
 */
@Entity()
@Table(name = "Stock")
public class Stock extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = -7464393389363582641L;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @OneToOne(optional = true, targetEntity = StockElement.class)
    @JoinColumn(name = "id_stock_element")
    private StockElement stockElement;

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public StockElement getStockElement() {
        return stockElement;
    }

    public void setStockElement(StockElement stockElement) {
        this.stockElement = stockElement;
    }
}
