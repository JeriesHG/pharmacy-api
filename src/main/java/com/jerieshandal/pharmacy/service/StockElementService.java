/*
 * Copyright (c) Jeries Handal - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jeries Handal <Jeries Handal>,  2016.
 */
package com.jerieshandal.pharmacy.service;

import com.jerieshandal.pharmacy.dto.ProductPackDTO;
import com.jerieshandal.pharmacy.repository.StockElementRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MedicineService
 *
 * @author JeriesHG
 * @version 1.0.0
 */
@Service
public class StockElementService extends AbstractService {

    private final StockElementRepository repository;

    @Autowired
    public StockElementService(StockElementRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<ProductPackDTO> retrieveProductPacks() {
        List<ProductPackDTO> c = new ArrayList<>();

        try {
            repository.retrieveProductPacks().stream().forEach(e -> {
                Object[] objectPack = (Object[]) e;

                ProductPackDTO productPack = new ProductPackDTO();
                hydrateProductPack(productPack, objectPack);
                c.add(productPack);
            });
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }

        return c;
    }

    private void hydrateProductPack(ProductPackDTO productPack, Object[] objectPack) {
        productPack.setMedicine((String) objectPack[0]);
        productPack.setBeautyProduct((String) objectPack[1]);
        productPack.setPrice(Double.valueOf(objectPack[2] + ""));
        productPack.setExpiration((Date) objectPack[3]);
    }
}
