package org.springframework.boot.testcontainers.service.connection;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ServiceConnectionAutoConfiguration}.
 */
@Generated
public class ServiceConnectionAutoConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'serviceConnectionAutoConfiguration'.
   */
  public static BeanDefinition getServiceConnectionAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ServiceConnectionAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(ServiceConnectionAutoConfiguration::new);
    return beanDefinition;
  }
}
