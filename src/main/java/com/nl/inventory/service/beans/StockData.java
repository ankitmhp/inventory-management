package com.nl.inventory.service.beans;

import java.time.LocalDateTime;

/**
 * <h2>StockData</h2>
 * <p>
 * Bean class for Stock details
 * </p>
 *
 * Created Sep 30, 2017 5:01:39 PM<br/>
 * Project inventory-management<br/>
 * 
 * @author ankitmhp
 * @version 1.0
 * @since JDK 1.8
 */
public class StockData {

  /**
   * productId is a String
   */
  private String productId;

  /**
   * productName is a String
   */
  private String productName;

  /**
   * productStock is a int
   */
  private int productStock;

  /**
   * itemLastOrdered is a LocalDateTime
   */
  private LocalDateTime itemLastOrdered;

  /**
   * itemLastPromoted is a LocalDateTime
   */
  private LocalDateTime itemLastPromoted;

  /**
   * productDetails is a String
   */
  private String productDetails;

  /**
   * Getter method
   * 
   * @return the productId
   */
  public String getProductId() {
    return productId;
  }

  /**
   * Setter method
   * 
   * @param productId the productId to set
   */
  public void setProductId(String productId) {
    this.productId = productId;
  }

  /**
   * Getter method
   * 
   * @return the productName
   */
  public String getProductName() {
    return productName;
  }

  /**
   * Setter method
   * 
   * @param productName the productName to set
   */
  public void setProductName(String productName) {
    this.productName = productName;
  }

  /**
   * Getter method
   * 
   * @return the productStock
   */
  public int getProductStock() {
    return productStock;
  }

  /**
   * Setter method
   * 
   * @param productStock the productStock to set
   */
  public void setProductStock(int productStock) {
    this.productStock = productStock;
  }

  /**
   * Getter method
   * 
   * @return the itemLastOrdered
   */
  public LocalDateTime getItemLastOrdered() {
    return itemLastOrdered;
  }

  /**
   * Setter method
   * 
   * @param itemLastOrdered the itemLastOrdered to set
   */
  public void setItemLastOrdered(LocalDateTime itemLastOrdered) {
    this.itemLastOrdered = itemLastOrdered;
  }

  /**
   * Getter method
   * 
   * @return the itemLastPromoted
   */
  public LocalDateTime getItemLastPromoted() {
    return itemLastPromoted;
  }

  /**
   * Setter method
   * 
   * @param itemLastPromoted the itemLastPromoted to set
   */
  public void setItemLastPromoted(LocalDateTime itemLastPromoted) {
    this.itemLastPromoted = itemLastPromoted;
  }

  /**
   * Getter method
   * 
   * @return the productDetails
   */
  public String getProductDetails() {
    return productDetails;
  }

  /**
   * Setter method
   * 
   * @param productDetails the productDetails to set
   */
  public void setProductDetails(String productDetails) {
    this.productDetails = productDetails;
  }
}
