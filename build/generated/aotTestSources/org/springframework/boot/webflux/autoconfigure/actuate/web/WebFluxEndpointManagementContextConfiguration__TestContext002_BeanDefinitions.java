package org.springframework.boot.webflux.autoconfigure.actuate.web;

import java.lang.SuppressWarnings;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.CorsEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.boot.actuate.endpoint.EndpointAccessResolver;
import org.springframework.boot.actuate.endpoint.web.EndpointMediaTypes;
import org.springframework.boot.actuate.endpoint.web.WebEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.annotation.ControllerEndpointsSupplier;
import org.springframework.boot.webflux.actuate.endpoint.web.ControllerEndpointHandlerMapping;
import org.springframework.boot.webflux.actuate.endpoint.web.WebFluxEndpointHandlerMapping;
import org.springframework.core.env.Environment;

/**
 * Bean definitions for {@link WebFluxEndpointManagementContextConfiguration}.
 */
@Generated
public class WebFluxEndpointManagementContextConfiguration__TestContext002_BeanDefinitions {
  /**
   * Get the bean definition for 'webFluxEndpointManagementContextConfiguration'.
   */
  public static BeanDefinition getWebFluxEndpointManagementContextConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebFluxEndpointManagementContextConfiguration.class);
    beanDefinition.setInstanceSupplier(WebFluxEndpointManagementContextConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'webEndpointReactiveHandlerMapping'.
   */
  @SuppressWarnings("removal")
  private static BeanInstanceSupplier<WebFluxEndpointHandlerMapping> getWebEndpointReactiveHandlerMappingInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<WebFluxEndpointHandlerMapping>forFactoryMethod(WebFluxEndpointManagementContextConfiguration.class, "webEndpointReactiveHandlerMapping", WebEndpointsSupplier.class, ControllerEndpointsSupplier.class, EndpointMediaTypes.class, CorsEndpointProperties.class, WebEndpointProperties.class, Environment.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.webflux.autoconfigure.actuate.web.WebFluxEndpointManagementContextConfiguration", WebFluxEndpointManagementContextConfiguration.class).webEndpointReactiveHandlerMapping(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5)));
  }

  /**
   * Get the bean definition for 'webEndpointReactiveHandlerMapping'.
   */
  public static BeanDefinition getWebEndpointReactiveHandlerMappingBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebFluxEndpointHandlerMapping.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.webflux.autoconfigure.actuate.web.WebFluxEndpointManagementContextConfiguration");
    beanDefinition.setInstanceSupplier(getWebEndpointReactiveHandlerMappingInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'controllerEndpointHandlerMapping'.
   */
  @SuppressWarnings("removal")
  private static BeanInstanceSupplier<ControllerEndpointHandlerMapping> getControllerEndpointHandlerMappingInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ControllerEndpointHandlerMapping>forFactoryMethod(WebFluxEndpointManagementContextConfiguration.class, "controllerEndpointHandlerMapping", ControllerEndpointsSupplier.class, CorsEndpointProperties.class, WebEndpointProperties.class, EndpointAccessResolver.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.webflux.autoconfigure.actuate.web.WebFluxEndpointManagementContextConfiguration", WebFluxEndpointManagementContextConfiguration.class).controllerEndpointHandlerMapping(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'controllerEndpointHandlerMapping'.
   */
  @SuppressWarnings("removal")
  public static BeanDefinition getControllerEndpointHandlerMappingBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ControllerEndpointHandlerMapping.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.webflux.autoconfigure.actuate.web.WebFluxEndpointManagementContextConfiguration");
    beanDefinition.setInstanceSupplier(getControllerEndpointHandlerMappingInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'serverCodecConfigurerEndpointJsonMapperBeanPostProcessor'.
   */
  private static BeanInstanceSupplier<WebFluxEndpointManagementContextConfiguration.ServerCodecConfigurerEndpointJsonMapperBeanPostProcessor> getServerCodecConfigurerEndpointJsonMapperBeanPostProcessorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<WebFluxEndpointManagementContextConfiguration.ServerCodecConfigurerEndpointJsonMapperBeanPostProcessor>forFactoryMethod(WebFluxEndpointManagementContextConfiguration.class, "serverCodecConfigurerEndpointJsonMapperBeanPostProcessor", ObjectProvider.class)
            .withGenerator((registeredBean, args) -> WebFluxEndpointManagementContextConfiguration.serverCodecConfigurerEndpointJsonMapperBeanPostProcessor(args.get(0)));
  }

  /**
   * Get the bean definition for 'serverCodecConfigurerEndpointJsonMapperBeanPostProcessor'.
   */
  public static BeanDefinition getServerCodecConfigurerEndpointJsonMapperBeanPostProcessorBeanDefinition(
      ) {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebFluxEndpointManagementContextConfiguration.class);
    beanDefinition.setTargetType(WebFluxEndpointManagementContextConfiguration.ServerCodecConfigurerEndpointJsonMapperBeanPostProcessor.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(getServerCodecConfigurerEndpointJsonMapperBeanPostProcessorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link WebFluxEndpointManagementContextConfiguration.HealthConfiguration}.
   */
  @Generated
  public static class HealthConfiguration {
    /**
     * Get the bean definition for 'healthConfiguration'.
     */
    public static BeanDefinition getHealthConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(WebFluxEndpointManagementContextConfiguration.HealthConfiguration.class);
      beanDefinition.setInstanceSupplier(WebFluxEndpointManagementContextConfiguration.HealthConfiguration::new);
      return beanDefinition;
    }
  }
}
