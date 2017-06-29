/*
 * Copyright (c) Jeries Handal - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jeries Handal <Jeries Handal>,  2016.
 */
package com.jerieshandal.controller;

import com.jerieshandal.entity.Medicine;
import com.jerieshandal.entity.StockElement;
import com.jerieshandal.repository.MedicineRepository;
import com.jerieshandal.repository.StockElementRepository;
import com.jerieshandal.service.MedicineService;
import java.io.IOException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author JeriesHG
 * @version 1.0.0
 */
@RestController
public class TestController {

    @Autowired
    private StockElementRepository repo;
    @Autowired
    private MedicineService service;

    @RequestMapping(path = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getAll() throws IOException {
        StockElement element = new StockElement();
        element.setCost(10.0);
        element.setPrice(12.0);
        element.setVendor("Acosa");
        repo.save(element);

        Medicine e = new Medicine();
        e.setExpiration(new Date());
        e.setName("Sudagrip");
        e.setStockElement(element);
        e.setWeight(10.5);
        service.create(e);

        return service.readAll();
    }
}
