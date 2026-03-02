package com.mauisiios.notehub_server;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.testcontainers.postgresql.PostgreSQLContainer;

/**
 * Bean definitions for {@link TestcontainersConfiguration}.
 */
@Generated
public class TestcontainersConfiguration__TestContext002_BeanDefinitions {
  /**
   * Get the bean definition for 'testcontainersConfiguration'.
   */
  public static BeanDefinition getTestcontainersConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TestcontainersConfiguration.class);
    beanDefinition.setInstanceSupplier(TestcontainersConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'postgresContainer'.
   */
  private static BeanInstanceSupplier<PostgreSQLContainer> getPostgresContainerInstanceSupplier() {
    return BeanInstanceSupplier.<PostgreSQLContainer>forFactoryMethod(TestcontainersConfiguration.class, "postgresContainer")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("com.mauisiios.notehub_server.TestcontainersConfiguration", TestcontainersConfiguration.class).postgresContainer());
  }

  /**
   * Get the bean definition for 'postgresContainer'.
   */
  public static BeanDefinition getPostgresContainerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PostgreSQLContainer.class);
    beanDefinition.setFactoryBeanName("com.mauisiios.notehub_server.TestcontainersConfiguration");
    beanDefinition.setInstanceSupplier(getPostgresContainerInstanceSupplier());
    return beanDefinition;
  }
}
