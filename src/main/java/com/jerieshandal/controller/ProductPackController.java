/*
 * Copyright (c) Jeries Handal - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jeries Handal <Jeries Handal>,  2016.
 */
package com.jerieshandal.controller;

import com.jerieshandal.json.JSONResponse;
import com.jerieshandal.json.ResponseStatus;
import com.jerieshandal.service.StockElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    public JSONResponse retrieveProductPacks() {
        JSONResponse response = new JSONResponse(ResponseStatus.success);

        response.put("productPacks", service.retrieveProductPacks());

        return response;
    }
}
