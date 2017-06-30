/*
 * Copyright (c) Jeries Handal - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jeries Handal <Jeries Handal>,  2016.
 */
package com.jerieshandal.pharmacy.message;

/**
 * LogMessage
 *
 * @author JeriesHG
 * @version 1.0.0
 */
public enum LogMessage {

    /**
     * Returns log when creating a new object in a repository
     */
    CREATE_OBJECT("object=\"{}\" message=\"Created Object\""),
    /**
     * Returns deleted object name
     */
    DELETE_OBJECT("object=\"{}\" message=\"Deleted Object\""),
    /**
     * Returns updated object name
     */
    UPDATE_OBJECT("object=\"{}\" message=\"Updated Object\""),
    /**
     * Returns found object name
     */
    FIND_OBJECT("object=\"{}\" message=\"Object Found\""),
    /**
     * Returns amount of objects found
     */
    READ_ALL("size=\"{}\" message=\"Found items in the repository\"");

    private final String message;

    private LogMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
