package com.nl.inventory.service.rest;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.nl.inventory.service.beans.SearchItemsRequest;
import com.nl.inventory.service.beans.SearchItemsResponse;
import com.nl.inventory.service.beans.StockData;
import com.nl.inventory.service.dao.StockDao;
import com.nl.inventory.service.utils.InventoryOperationsUtil;
import com.nl.inventory.service.utils.SpringAwareService;

/**
 * <h2>SearchItemsServiceImpl</h2>
 * <p>
 * Get the lists of items available in the warehouse
 * </p>
 *
 * Created Sep 28, 2017 8:11:56 PM<br/>
 * Project inventory-management<br/>
 * 
 * @author ankitmhp
 * @version 1.0
 * @since JDK 1.8
 */
@Path("/searchitemsservice")
@RolesAllowed("STORE_MANAGER")
public class SearchItemsServiceImpl {
  /**
   * logger is used for manual logging.
   */
  private static Log log = LogFactory.getLog(SearchItemsServiceImpl.class);

  /**
   * inventoryOperationsUtil is a InventoryOperationsUtil
   */
  private InventoryOperationsUtil inventoryOperationsUtil;

  /**
   * stockDao is a StockDao
   */
  private StockDao stockDao;

  /**
   * This method is the entry point of the search request.
   * 
   * Step -1 : Validate the request. 
   * Step -2 : Reteives stock data from database. 
   * Step -3 : Map the results to response object and return it.
   * 
   * @param searchItemsRequest
   * @return SearchItemsResponse
   */
  @Path("/getitems")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public SearchItemsResponse processSearchItemsRequest(SearchItemsRequest searchItemsRequest) {
    if (log.isInfoEnabled()) {
      log.info("Step -1 :Received a request to fetch item details, validating request.");
    }
    SearchItemsResponse searchItemsResponse = new SearchItemsResponse();
    try {
       if (((InventoryOperationsUtil) SpringAwareService.getBean("inventoryOperationsUtil"))
       .validateSearchRequest(searchItemsRequest)) {
        log.debug("Step -2: Retreiving stock data.");
        searchItemsResponse = this.retrieveStockData(searchItemsRequest, searchItemsResponse);
        searchItemsResponse.setResponseCode("OK");
        log.debug("Step -3: Result code is OK, returning response.");
      } else {
        searchItemsResponse.setResponseCode("NOK, Input validation failed.");
      }
    } catch (SQLException e) {
      if (log.isErrorEnabled()) {
        log.error("Unable to retreive stock details, ", e);
      }
      searchItemsResponse.setResponseCode("NOK, Unable to retreive stock details.");
    }

    return searchItemsResponse;

  }

  /**
   * This method connects to DAO and mapes retreived records to JAVA Object
   * 
   * @param searchItemsRequest
   * @param searchItemsResponse
   * @return SearchItemsResponse
   * @throws SQLException
   */
  private SearchItemsResponse retrieveStockData(SearchItemsRequest searchItemsRequest,
      SearchItemsResponse searchItemsResponse) throws SQLException {
    String productName = searchItemsRequest.getProductName();
    log.debug("Step -2.1 :searching stock data.");
    List<StockData> fetchedStockData = ((StockDao) SpringAwareService.getBean("stockDao")).searchStock(productName);
    searchItemsResponse = ((InventoryOperationsUtil) SpringAwareService.getBean("inventoryOperationsUtil"))
        .mapToResponse(fetchedStockData);
    return searchItemsResponse;


  }

  /**
   * Getter method
   * 
   * @return the inventoryOperationsUtil
   */
  public InventoryOperationsUtil getInventoryOperationsUtil() {
    return inventoryOperationsUtil;
  }

  /**
   * Setter method
   * 
   * @param inventoryOperationsUtil the inventoryOperationsUtil to set
   */
  public void setInventoryOperationsUtil(InventoryOperationsUtil inventoryOperationsUtil) {
    this.inventoryOperationsUtil = inventoryOperationsUtil;
  }

  /**
   * Getter method
   * 
   * @return the stockDao
   */
  public StockDao getStockDao() {
    return stockDao;
  }

  /**
   * Setter method
   * 
   * @param stockDao the stockDao to set
   */
  public void setStockDao(StockDao stockDao) {
    this.stockDao = stockDao;
  }
}
