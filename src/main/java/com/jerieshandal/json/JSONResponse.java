/*
 * Copyright (c) Jeries Handal - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jeries Handal <Jeries Handal>,  2016.
 */
package com.jerieshandal.json;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * JSONResponse
 *
 * @author JeriesHG
 * @version 1.0.0
 */
public class JSONResponse implements Serializable {

    private static final long serialVersionUID = 8951328875933630292L;

    private final Map<String, Object> data;
    private ResponseStatus response;
    private String message;

    public JSONResponse() {
        response = ResponseStatus.success;
        data = new HashMap<>();
    }

    public JSONResponse(ResponseStatus response) {
        this.response = response;
        data = new HashMap<>();
    }

    public void put(String key, Object value) {
        data.put(key, value);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseStatus getResponse() {
        return response;
    }

    public void setResponse(ResponseStatus response) {
        this.response = response;
    }

    public Map<String, Object> getData() {
        return data;
    }
}
