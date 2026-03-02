package org.springframework.boot.r2dbc.autoconfigure.metrics;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ConnectionPoolMetricsAutoConfiguration}.
 */
@Generated
public class ConnectionPoolMetricsAutoConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'connectionPoolMetricsAutoConfiguration'.
   */
  public static BeanDefinition getConnectionPoolMetricsAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ConnectionPoolMetricsAutoConfiguration.class);
    InstanceSupplier<ConnectionPoolMetricsAutoConfiguration> instanceSupplier = InstanceSupplier.using(ConnectionPoolMetricsAutoConfiguration::new);
    instanceSupplier = instanceSupplier.andThen(ConnectionPoolMetricsAutoConfiguration__TestContext001_Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
