package org.springframework.boot.r2dbc.autoconfigure;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.sql.autoconfigure.init.SqlInitializationProperties;

/**
 * Bean definitions for {@link R2dbcInitializationAutoConfiguration}.
 */
@Generated
public class R2dbcInitializationAutoConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'r2dbcInitializationAutoConfiguration'.
   */
  public static BeanDefinition getRdbcInitializationAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(R2dbcInitializationAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(R2dbcInitializationAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'r2dbcScriptDatabaseInitializer'.
   */
  private static BeanInstanceSupplier<ApplicationR2dbcScriptDatabaseInitializer> getRdbcScriptDatabaseInitializerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ApplicationR2dbcScriptDatabaseInitializer>forFactoryMethod(R2dbcInitializationAutoConfiguration.class, "r2dbcScriptDatabaseInitializer", ConnectionFactory.class, SqlInitializationProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.r2dbc.autoconfigure.R2dbcInitializationAutoConfiguration", R2dbcInitializationAutoConfiguration.class).r2dbcScriptDatabaseInitializer(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'r2dbcScriptDatabaseInitializer'.
   */
  public static BeanDefinition getRdbcScriptDatabaseInitializerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ApplicationR2dbcScriptDatabaseInitializer.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.r2dbc.autoconfigure.R2dbcInitializationAutoConfiguration");
    beanDefinition.setInstanceSupplier(getRdbcScriptDatabaseInitializerInstanceSupplier());
    return beanDefinition;
  }
}
