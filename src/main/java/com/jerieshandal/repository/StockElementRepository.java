/*
 * Copyright (c) Jeries Handal - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jeries Handal <Jeries Handal>,  2016.
 */
package com.jerieshandal.repository;

import com.jerieshandal.entity.StockElement;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 * StockElementRepository
 *
 * @author JeriesHG
 * @version 1.0.0
 */
public interface StockElementRepository extends AbstractRepository<StockElement> {

    @Query(value = "SELECT me.pr_name medicine, bp.pr_name product, ((bp.price + me.price)-((bp.price + me.price)*0.15)) price, me.expiration_date expiration "
            + "FROM ("
            + "SELECT pr_name, s.price, s.cost, m.expiration_date "
            + "FROM Medicine as m "
            + "LEFT JOIN Stock_element as s "
            + "ON m.id_stock_element = s.id "
            + "WHERE DATEDIFF(DAY, m.expiration_date, CURRENT_DATE()) < 11 "
            + ") as me, "
            + "(SELECT pr_name, s.price, s.cost "
            + "FROM Beauty_product as bp "
            + "LEFT JOIN Stock_element as s "
            + "ON bp.id_stock_element = s.id "
            + "INNER JOIN Market_research as mr "
            + "ON mr.id_beauty_product = bp.Id "
            + "GROUP BY pr_name "
            + "HAVING (SUM(mr.rate)/COUNT(mr.Id)) > 0.69 "
            + ") as bp "
            + "ORDER BY ((bp.price + me.price) - (bp.cost - me.cost))",
            nativeQuery = true)
    List<Object> retrieveProductPacks();
}
