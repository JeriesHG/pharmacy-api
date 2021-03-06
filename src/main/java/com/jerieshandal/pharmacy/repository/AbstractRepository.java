/*
 * Copyright (c) Jeries Handal - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jeries Handal <Jeries Handal>,  2016.
 */
package com.jerieshandal.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * AbstractRepository
 *
 * @author JeriesHG
 * @version 1.0.0
 */
@NoRepositoryBean
public interface AbstractRepository<T> extends JpaRepository<T, Long> {

}
