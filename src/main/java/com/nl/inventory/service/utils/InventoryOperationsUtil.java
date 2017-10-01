package com.nl.inventory.service.utils;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.nl.inventory.service.beans.SearchItemsRequest;
import com.nl.inventory.service.beans.SearchItemsResponse;
import com.nl.inventory.service.beans.StockData;

/**
 * <h2>InventoryOperationsUtil</h2>
 * <p>
 * Utility class for inventory management
 * </p>
 * 
 * Created Sep 28, 2017 8:29:13 PM<br/>
 * Project inventory-management<br/>
 * 
 * @author ankitmhp
 * @version 1.0
 * @since JDK 1.8
 */
public class InventoryOperationsUtil {
  /**
   * logger is used for manual logging.
   */
  private static Log log = LogFactory.getLog(InventoryOperationsUtil.class);

  /**
   * @param searchItemsRequest
   * @return
   */
  public boolean validateSearchRequest(SearchItemsRequest searchItemsRequest) {
    log.debug("Step -1.1: Validating message.");
    if (searchItemsRequest != null) {
      log.debug("Step -1.2: Validation successfull.");
      return true;
    }
    log.debug("Step -1.2: Message Validation failed.");
    return false;
  }

  /**
   * @param fetchedStockData
   * @return
   */
  public SearchItemsResponse mapToResponse(List<StockData> fetchedStockData) {
    log.debug("Step -3.1:Mapping to response.");
    SearchItemsResponse searchItemsResponse = new SearchItemsResponse();
    searchItemsResponse.setStockData(fetchedStockData);
    return searchItemsResponse;
  }

}
