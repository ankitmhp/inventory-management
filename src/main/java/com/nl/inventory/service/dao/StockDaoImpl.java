package com.nl.inventory.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.nl.inventory.service.beans.StockData;


/**
 * <h2>StockImpl</h2>
 * <p>
 * Data access object class for Inventory Management.
 * </p>
 * 
 * Created Sep 30, 2017 12:34:52 PM<br/>
 * Project inventory-management<br/>
 * 
 * @author ankitmhp
 * @version 1.0
 * @since JDK 1.8
 */
public class StockDaoImpl implements StockDao {
  /**
   * logger is used for manual logging.
   */
  private static Log log = LogFactory.getLog(StockDaoImpl.class);
  /**
   * calendarCon is a Connection
   */
  private Connection stockCon;

  /**
   * searchStockDataSql is a String
   */
  private static String searchStockDataSql = "select * from TB_STOCK" + " where productName like ?";

  /**
   * @return
   * @throws SQLException
   */
  protected Connection getInventoryConnection() throws SQLException {
    if (stockCon == null || stockCon.isClosed()) {
      stockCon = getConnection("java:jboss/datasources/InventoryDataSource");
    }
    return stockCon;
  }

  /**
   * Getter.
   * 
   * @return - the sql connection. If the connection isn't made yet, we make it.
   * @throws SQLException
   */
  private Connection getConnection(String jdbc) throws SQLException {
    Connection con;
    try {
      InitialContext context = new InitialContext();
      DataSource dataSource;
      dataSource = (DataSource) context.lookup(jdbc);
      con = dataSource.getConnection();
      con.setAutoCommit(true);
    } catch (NamingException e) {
      throw new SQLException(e);
    }
    return con;
  }

  /**
   * Close the connection. this method is used to close the connection
   * 
   * @param ps
   * @param rs
   * 
   * @throws SQLException
   */
  public void closeInventoryConnection(ResultSet rs, PreparedStatement ps) throws SQLException {
    if (rs != null && !rs.isClosed()) {
      rs.close();
    }
    if (ps != null && !ps.isClosed()) {
      ps.close();
    }
    if (stockCon != null && !stockCon.isClosed()) {
      stockCon.close();
    }
  }



  /**
   * @param searchParam
   * 
   * @return List<StockData>
   * @throws SQLException
   */
  public List<StockData> searchStock(String searchParam) throws SQLException {
    log.debug("Step -2.2 : Creating connection and fetching data from DB.");
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      ps = getInventoryConnection().prepareStatement(searchStockDataSql);
      ps.setString(1, searchParam);
      rs = ps.executeQuery();
      log.debug("Step -2.3 : Search query successfully executed.");
      if (!rs.next()) {
        log.warn("Unable to get stock details from result set.");
        throw new SQLException();
      }
      return mapRsToStockData(rs);
    } catch (SQLException e) {
      log.error("Unable to get stock details, SQLException", e);
      throw new SQLException(e);
    } finally {
      try {
        closeInventoryConnection(rs, ps);
      } catch (SQLException e) {
        log.error("Unable to close connection, SQLException: ", e);
      }
    }
  }

  /**
   * @param rs
   * @return
   * @throws SQLException
   */
  private List<StockData> mapRsToStockData(ResultSet rs) throws SQLException {
    log.debug("Step -2.4 : Mapping result set to stock data.");
    List<StockData> stockDataList = new ArrayList<StockData>();
    while (rs.next()) {
      StockData stockData = new StockData();
      stockData.setProductId(rs.getString(1));
      stockData.setProductName(rs.getString(2));
      stockData.setProductStock(rs.getInt(3));
      stockData.setItemLastOrdered(rs.getTimestamp(4).toLocalDateTime());
      stockData.setItemLastPromoted(rs.getTimestamp(5).toLocalDateTime());
      stockData.setProductDetails(rs.getString(6));
      stockDataList.add(stockData);
    }
    if(log.isDebugEnabled()){
      log.debug("No of records retrieved :" + stockDataList.size());
    }
    return stockDataList;
  }

}
