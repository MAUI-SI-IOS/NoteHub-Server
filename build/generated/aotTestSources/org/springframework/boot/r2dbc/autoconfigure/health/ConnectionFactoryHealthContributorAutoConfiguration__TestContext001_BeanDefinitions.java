package org.springframework.boot.r2dbc.autoconfigure.health;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.health.contributor.ReactiveHealthContributor;

/**
 * Bean definitions for {@link ConnectionFactoryHealthContributorAutoConfiguration}.
 */
@Generated
public class ConnectionFactoryHealthContributorAutoConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'connectionFactoryHealthContributorAutoConfiguration'.
   */
  public static BeanDefinition getConnectionFactoryHealthContributorAutoConfigurationBeanDefinition(
      ) {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ConnectionFactoryHealthContributorAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(ConnectionFactoryHealthContributorAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'r2dbcHealthContributor'.
   */
  private static BeanInstanceSupplier<ReactiveHealthContributor> getRdbcHealthContributorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ReactiveHealthContributor>forFactoryMethod(ConnectionFactoryHealthContributorAutoConfiguration.class, "r2dbcHealthContributor", ConfigurableListableBeanFactory.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.r2dbc.autoconfigure.health.ConnectionFactoryHealthContributorAutoConfiguration", ConnectionFactoryHealthContributorAutoConfiguration.class).r2dbcHealthContributor(args.get(0)));
  }

  /**
   * Get the bean definition for 'r2dbcHealthContributor'.
   */
  public static BeanDefinition getRdbcHealthContributorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactiveHealthContributor.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.r2dbc.autoconfigure.health.ConnectionFactoryHealthContributorAutoConfiguration");
    beanDefinition.setInstanceSupplier(getRdbcHealthContributorInstanceSupplier());
    return beanDefinition;
  }
}
