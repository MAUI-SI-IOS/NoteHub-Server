package org.springframework.boot.testcontainers.properties;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TestcontainersPropertySourceAutoConfiguration}.
 */
@Generated
public class TestcontainersPropertySourceAutoConfiguration__TestContext002_BeanDefinitions {
  /**
   * Get the bean definition for 'testcontainersPropertySourceAutoConfiguration'.
   */
  public static BeanDefinition getTestcontainersPropertySourceAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TestcontainersPropertySourceAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(TestcontainersPropertySourceAutoConfiguration::new);
    return beanDefinition;
  }
}
