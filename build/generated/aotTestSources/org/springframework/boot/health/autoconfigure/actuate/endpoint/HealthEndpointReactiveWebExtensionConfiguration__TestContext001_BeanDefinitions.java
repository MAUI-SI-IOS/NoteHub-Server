package org.springframework.boot.health.autoconfigure.actuate.endpoint;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.health.actuate.endpoint.HealthEndpointGroups;
import org.springframework.boot.health.actuate.endpoint.ReactiveHealthEndpointWebExtension;
import org.springframework.boot.health.registry.ReactiveHealthContributorRegistry;

/**
 * Bean definitions for {@link HealthEndpointReactiveWebExtensionConfiguration}.
 */
@Generated
public class HealthEndpointReactiveWebExtensionConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'healthEndpointReactiveWebExtensionConfiguration'.
   */
  public static BeanDefinition getHealthEndpointReactiveWebExtensionConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HealthEndpointReactiveWebExtensionConfiguration.class);
    beanDefinition.setInstanceSupplier(HealthEndpointReactiveWebExtensionConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'reactiveHealthEndpointWebExtension'.
   */
  private static BeanInstanceSupplier<ReactiveHealthEndpointWebExtension> getReactiveHealthEndpointWebExtensionInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ReactiveHealthEndpointWebExtension>forFactoryMethod(HealthEndpointReactiveWebExtensionConfiguration.class, "reactiveHealthEndpointWebExtension", ReactiveHealthContributorRegistry.class, ObjectProvider.class, HealthEndpointGroups.class, HealthEndpointProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.health.autoconfigure.actuate.endpoint.HealthEndpointReactiveWebExtensionConfiguration", HealthEndpointReactiveWebExtensionConfiguration.class).reactiveHealthEndpointWebExtension(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'reactiveHealthEndpointWebExtension'.
   */
  public static BeanDefinition getReactiveHealthEndpointWebExtensionBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactiveHealthEndpointWebExtension.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.health.autoconfigure.actuate.endpoint.HealthEndpointReactiveWebExtensionConfiguration");
    beanDefinition.setInstanceSupplier(getReactiveHealthEndpointWebExtensionInstanceSupplier());
    return beanDefinition;
  }
}
