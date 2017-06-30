/*
 * Copyright (c) Jeries Handal - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jeries Handal <Jeries Handal>,  2016.
 */
package com.jerieshandal.pharmacy.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * BeautyProduct
 *
 * @author JeriesHG
 * @version 1.0.0
 */
@Entity()
@Table(name = "Beauty_product")
public class BeautyProduct extends AbstractProduct implements Serializable {

    private static final long serialVersionUID = 3291402708196537427L;

    @OneToMany(mappedBy = "beautyProduct", targetEntity = MarketResearch.class)
    private Collection<MarketResearch> marketResearchs = new ArrayList<>();

    public Collection<MarketResearch> getMarketResearchs() {
        return marketResearchs;
    }

    public void setMarketResearchs(Collection<MarketResearch> marketResearchs) {
        this.marketResearchs = marketResearchs;
    }
}
