package org.springframework.boot.webflux.autoconfigure.actuate.endpoint.web;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.actuate.endpoint.web.WebEndpointsSupplier;
import org.springframework.boot.health.actuate.endpoint.HealthEndpointGroups;
import org.springframework.boot.webflux.actuate.endpoint.web.AdditionalHealthEndpointPathsWebFluxHandlerMapping;

/**
 * Bean definitions for {@link WebFluxHealthEndpointExtensionAutoConfiguration}.
 */
@Generated
public class WebFluxHealthEndpointExtensionAutoConfiguration__TestContext002_BeanDefinitions {
  /**
   * Get the bean definition for 'webFluxHealthEndpointExtensionAutoConfiguration'.
   */
  public static BeanDefinition getWebFluxHealthEndpointExtensionAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebFluxHealthEndpointExtensionAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(WebFluxHealthEndpointExtensionAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'healthEndpointWebFluxHandlerMapping'.
   */
  private static BeanInstanceSupplier<AdditionalHealthEndpointPathsWebFluxHandlerMapping> getHealthEndpointWebFluxHandlerMappingInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AdditionalHealthEndpointPathsWebFluxHandlerMapping>forFactoryMethod(WebFluxHealthEndpointExtensionAutoConfiguration.class, "healthEndpointWebFluxHandlerMapping", WebEndpointsSupplier.class, HealthEndpointGroups.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.webflux.autoconfigure.actuate.endpoint.web.WebFluxHealthEndpointExtensionAutoConfiguration", WebFluxHealthEndpointExtensionAutoConfiguration.class).healthEndpointWebFluxHandlerMapping(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'healthEndpointWebFluxHandlerMapping'.
   */
  public static BeanDefinition getHealthEndpointWebFluxHandlerMappingBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AdditionalHealthEndpointPathsWebFluxHandlerMapping.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.webflux.autoconfigure.actuate.endpoint.web.WebFluxHealthEndpointExtensionAutoConfiguration");
    beanDefinition.setInstanceSupplier(getHealthEndpointWebFluxHandlerMappingInstanceSupplier());
    return beanDefinition;
  }
}
