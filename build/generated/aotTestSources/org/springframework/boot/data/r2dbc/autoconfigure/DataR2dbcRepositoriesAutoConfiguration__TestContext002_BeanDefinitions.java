package org.springframework.boot.data.r2dbc.autoconfigure;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DataR2dbcRepositoriesAutoConfiguration}.
 */
@Generated
public class DataR2dbcRepositoriesAutoConfiguration__TestContext002_BeanDefinitions {
  /**
   * Get the bean definition for 'dataR2dbcRepositoriesAutoConfiguration'.
   */
  public static BeanDefinition getDataRdbcRepositoriesAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DataR2dbcRepositoriesAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(DataR2dbcRepositoriesAutoConfiguration::new);
    return beanDefinition;
  }
}
