/*
 * Copyright (c) Jeries Handal - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jeries Handal <Jeries Handal>,  2016.
 */
package com.jerieshandal.pharmacy.controller;

import com.jerieshandal.pharmacy.json.JSONResponse;
import com.jerieshandal.pharmacy.json.ResponseStatus;
import com.jerieshandal.pharmacy.service.StockElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProductPackController
 *
 * @author JeriesHG
 * @version 1.0.0
 */
@RestController
@RequestMapping(path = "/product-packs", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductPackController {

    @Autowired
    private StockElementService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity retrieveProductPacks() {
        ResponseEntity.BodyBuilder entity = ResponseEntity.status(HttpStatus.OK);
        
        JSONResponse response = new JSONResponse(ResponseStatus.success);
        response.put("productPacks", service.retrieveProductPacks());

        return entity.body(response);
    }
}
