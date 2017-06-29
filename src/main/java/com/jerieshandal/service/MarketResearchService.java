/*
 * Copyright (c) Jeries Handal - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jeries Handal <Jeries Handal>,  2016.
 */
package com.jerieshandal.service;

import com.jerieshandal.repository.MarketResearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MedicineService
 *
 * @author JeriesHG
 * @version 1.0.0
 */
@Service
public class MarketResearchService extends AbstractService {

    @Autowired
    public MarketResearchService(MarketResearchRepository repository) {
        super(repository);
    }
}
