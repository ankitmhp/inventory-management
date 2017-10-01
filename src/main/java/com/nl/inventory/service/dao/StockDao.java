package com.nl.inventory.service.dao;

import java.sql.SQLException;
import java.util.List;

import com.nl.inventory.service.beans.StockData;

/**
 * <h2>StockDao</h2>
 * <p>
 * Data access object Interface for Inventory Management.
 * </p>
 *
 * Created Sep 30, 2017 12:35:15 PM<br/>
 * Project inventory-management<br/>
 * 
 * @author ankitmhp
 * @version 1.0
 * @since JDK 1.8
 */
public interface StockDao {
  /**
   * @param searchParam
   * @return List<StockData>
   * @throws SQLException
   */
  List<StockData> searchStock(String searchParam) throws SQLException;
}
