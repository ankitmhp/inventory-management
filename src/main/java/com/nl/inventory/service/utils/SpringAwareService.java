package com.nl.inventory.service.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/**
 * <h2>SpringAwareService</h2>
 * <p>
 * This class instance is called once when Spring initializes its container.
 * </p>
 * 
 * Created Oct 1, 2017 12:54:43 PM<br/>
 * Project inventory-management<br/>
 * 
 * @author ankitmhp
 * @version 1.0
 * @since JDK 1.8
 */
public class SpringAwareService implements ApplicationContextAware {

  /**
   * ctx is a ApplicationContext
   */
  private static ApplicationContext ctx;

  /**
   * Called by Spring container.
   * 
   * @param applicationContext current application context
   */
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    ctx = applicationContext;
  }

  /**
   * For use within your application to get the current application context
   * 
   * @return
   */
  public static ApplicationContext getContext() {
    return ctx;
  }

  /**
   * Wraps Application context to help you to get directly a bean from spring.
   * 
   * @param beanName bean name
   * @return bean object
   */
  public static Object getBean(String beanName) {
    return ctx.getBean(beanName);
  }

}
