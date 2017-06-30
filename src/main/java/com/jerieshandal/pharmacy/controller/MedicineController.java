/*
 * Copyright (c) Jeries Handal - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jeries Handal <Jeries Handal>,  2017.
 */
package com.jerieshandal.pharmacy.controller;

import com.jerieshandal.pharmacy.entity.Medicine;
import com.jerieshandal.pharmacy.json.JSONResponse;
import com.jerieshandal.pharmacy.json.ResponseStatus;
import com.jerieshandal.pharmacy.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity readAll() {
        ResponseEntity.BodyBuilder entity = ResponseEntity.status(HttpStatus.OK);

        JSONResponse response = new JSONResponse(ResponseStatus.success);
        response.put("medicines", service.readAll());

        return entity.body(response);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody Medicine medicine) {
        ResponseEntity.BodyBuilder entity = ResponseEntity.status(HttpStatus.CREATED);
        
        if (medicine == null || medicine.getStockElement() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Medicine createdMedicine = (Medicine) service.create(medicine);

        JSONResponse response = new JSONResponse(ResponseStatus.success);
        response.put("medicine", createdMedicine);

        
        if (createdMedicine == null) {
            response.setResponse(ResponseStatus.fail);
            entity = ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }

        return entity.body(response);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity findById(@PathVariable long id) {
        ResponseEntity.BodyBuilder entity = ResponseEntity.status(HttpStatus.FOUND);

        Medicine medicine = service.findById(id);

        JSONResponse response = new JSONResponse(ResponseStatus.success);
        response.put("medicine", medicine);

        if (medicine == null) {
            response.setResponse(ResponseStatus.fail);
            entity = ResponseEntity.status(HttpStatus.NOT_FOUND);
        }

        return entity.body(response);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable long id) {
        ResponseEntity.BodyBuilder entity = ResponseEntity.status(HttpStatus.OK);

        JSONResponse response = new JSONResponse(ResponseStatus.success);
        boolean result = service.delete(id);

        if (!result) {
            entity = ResponseEntity.status(HttpStatus.NOT_FOUND);
            response.setResponse(ResponseStatus.fail);
        }

        return entity.body(response);
    }
}
