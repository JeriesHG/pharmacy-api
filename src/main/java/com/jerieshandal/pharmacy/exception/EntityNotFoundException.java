/*
 * Copyright (c) Jeries Handal - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jeries Handal <Jeries Handal>,  2016.
 */
package com.jerieshandal.pharmacy.exception;

/**
 * EntityNotFoundException
 *
 * @author JeriesHG
 * @version 1.0.0
 */
public class EntityNotFoundException extends Exception {

    private static final long serialVersionUID = 2814863945965946766L;

    public EntityNotFoundException() {
        super("Entity was not found!");
    }
}
