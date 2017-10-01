package com.nl.inventory.service.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <h2>ItemsSearchRequest</h2>
 * <p>
 * Request class for Search stock items
 * </p>
 * 
 * Created Sep 28, 2017 8:22:02 PM<br/>
 * Project inventory-management<br/>
 * 
 * @author ankitmhp
 * @version 1.0
 * @since JDK 1.8
 */
public class SearchItemsRequest {

  /**
   * productName is a String
   */
  @JsonProperty("productName")
  private String productName;

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

}
