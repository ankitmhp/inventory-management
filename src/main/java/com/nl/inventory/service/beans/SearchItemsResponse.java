package com.nl.inventory.service.beans;

import java.util.List;

/**
 * <h2>ItemsSearchResponse</h2>
 * <p>
 * Response class for Search stock items
 * </p>
 * 
 * Created Sep 28, 2017 8:21:16 PM<br/>
 * Project inventory-management<br/>
 * 
 * @author ankitmhp
 * @version 1.0
 * @since JDK 1.8
 */
public class SearchItemsResponse {
  /**
   * resultCode is a String
   */
  private String responseCode;

  /**
   * stockData is a List<StockData>
   */
  List<StockData> stockData;

  /**
   * Getter method
   * 
   * @return the responseCode
   */
  public String getResponseCode() {
    return responseCode;
  }

  /**
   * Setter method
   * 
   * @param responseCode the responseCode to set
   */
  public void setResponseCode(String responseCode) {
    this.responseCode = responseCode;
  }

  /**
   * Getter method
   * 
   * @return the stockData
   */
  public List<StockData> getStockData() {
    return stockData;
  }

  /**
   * Setter method
   * 
   * @param stockData the stockData to set
   */
  public void setStockData(List<StockData> stockData) {
    this.stockData = stockData;
  }
}
