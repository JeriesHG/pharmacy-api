/*
 * Copyright (c) Jeries Handal - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jeries Handal <Jeries Handal>,  2016.
 */
package com.jerieshandal.service;

import com.jerieshandal.entity.AbstractEntity;
import com.jerieshandal.exception.EntityNotFoundException;
import com.jerieshandal.message.LogMessage;
import com.jerieshandal.repository.AbstractRepository;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AbstractService
 *
 * @author JeriesHG
 * @version 1.0.0
 */
public abstract class AbstractService implements IService {

    private final AbstractRepository repository;
    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    public AbstractService(AbstractRepository repo) {
        this.repository = repo;
    }

    @Override
    public AbstractEntity create(AbstractEntity object) {
        AbstractEntity saved = null;

        try {
            saved = (AbstractEntity) repository.save(object);
            LOGGER.info(LogMessage.CREATE_OBJECT.getMessage(), saved.getClass().getSimpleName());
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }

        return saved;
    }

    @Override
    public <T> T update(T e) {
        T saved = null;

        try {
            saved = (T) repository.save(e);
            LOGGER.info(LogMessage.UPDATE_OBJECT.getMessage(), e.getClass().getSimpleName());
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }

        return saved;
    }

    @Override
    public boolean delete(long id) {
        boolean result = true;

        try {
            if (repository.exists(id)) {
                repository.delete(id);
                LOGGER.info(LogMessage.DELETE_OBJECT.getMessage(), id);
            } else {
                throw new EntityNotFoundException();
            }
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            result = false;
        }

        return result;
    }

    @Override
    public <T> T findById(long id) {
        T e = null;

        try {
            if (repository.exists(id)) {
                e = (T) repository.findOne(id);
                LOGGER.info(LogMessage.FIND_OBJECT.getMessage(), id);
            } else {
                throw new EntityNotFoundException();
            }
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }

        return e;
    }

    @Override
    public <T> List<T> readAll() {
        List<T> c = new ArrayList<>();

        try {
            c = repository.findAll();
            LOGGER.info(LogMessage.READ_ALL.getMessage(), c.size());
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }

        return c;
    }
}
