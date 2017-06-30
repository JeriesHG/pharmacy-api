/*
 * Copyright (c) Jeries Handal - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jeries Handal <Jeries Handal>,  2016.
 */
package com.jerieshandal.pharmacy.service;

import com.jerieshandal.pharmacy.entity.AbstractEntity;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * IService
 *
 * @author JeriesHG
 * @version 1.0.0
 */
@Service
public interface IService {

    public AbstractEntity create(AbstractEntity object);

    public <T> T update(T e);

    public boolean delete(long id);

    public <T> T findById(long id);

    public <T> List<T> readAll();
}
