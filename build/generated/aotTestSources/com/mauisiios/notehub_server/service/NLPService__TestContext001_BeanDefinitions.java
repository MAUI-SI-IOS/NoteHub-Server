package com.mauisiios.notehub_server.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link NLPService}.
 */
@Generated
public class NLPService__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'nLPService'.
   */
  public static BeanDefinition getNLPServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NLPService.class);
    beanDefinition.setInitMethodNames("init");
    beanDefinition.setInstanceSupplier(NLPService::new);
    return beanDefinition;
  }
}
