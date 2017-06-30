/*
 * Copyright (c) Jeries Handal - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jeries Handal <Jeries Handal>,  2017.
 */
package com.jerieshandal.pharmacy.controller;

import com.jerieshandal.pharmacy.json.JSONResponse;
import com.jerieshandal.pharmacy.json.ResponseStatus;
import com.jerieshandal.pharmacy.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * MedicineController
 *
 * @author JeriesHG
 * @version 1.0.0
 */
@RestController
@RequestMapping(path = "/medicines", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicineController {

    @Autowired
    private MedicineService service;

    @RequestMapping(method = RequestMethod.GET)
    public JSONResponse readAll() {
        JSONResponse response = new JSONResponse(ResponseStatus.success);

        response.put("medicines", service.readAll());

        return response;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public JSONResponse findById(@PathVariable int id) {
        JSONResponse response = new JSONResponse();

        response.put("medicine", service.findById(id));

        return response;
    }
}
