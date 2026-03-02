package org.springframework.boot.r2dbc.autoconfigure;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link R2dbcAutoConfiguration}.
 */
@Generated
public class R2dbcAutoConfiguration__TestContext002_BeanDefinitions {
  /**
   * Get the bean definition for 'r2dbcAutoConfiguration'.
   */
  public static BeanDefinition getRdbcAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(R2dbcAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(R2dbcAutoConfiguration::new);
    return beanDefinition;
  }
}
