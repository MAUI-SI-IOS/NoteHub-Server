package org.springframework.boot.webflux.autoconfigure;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.micrometer.metrics.MaximumAllowableTagsMeterFilter;
import org.springframework.boot.micrometer.metrics.autoconfigure.MetricsProperties;
import org.springframework.boot.micrometer.observation.autoconfigure.ObservationProperties;
import org.springframework.http.server.reactive.observation.DefaultServerRequestObservationConvention;

/**
 * Bean definitions for {@link WebFluxObservationAutoConfiguration}.
 */
@Generated
public class WebFluxObservationAutoConfiguration__TestContext002_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.webflux.autoconfigure.WebFluxObservationAutoConfiguration'.
   */
  private static BeanInstanceSupplier<WebFluxObservationAutoConfiguration> getWebFluxObservationAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<WebFluxObservationAutoConfiguration>forConstructor(ObservationProperties.class)
            .withGenerator((registeredBean, args) -> new WebFluxObservationAutoConfiguration(args.get(0)));
  }

  /**
   * Get the bean definition for 'webFluxObservationAutoConfiguration'.
   */
  public static BeanDefinition getWebFluxObservationAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebFluxObservationAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(getWebFluxObservationAutoConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'metricsHttpServerUriTagFilter'.
   */
  private static BeanInstanceSupplier<MaximumAllowableTagsMeterFilter> getMetricsHttpServerUriTagFilterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MaximumAllowableTagsMeterFilter>forFactoryMethod(WebFluxObservationAutoConfiguration.class, "metricsHttpServerUriTagFilter", MetricsProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.webflux.autoconfigure.WebFluxObservationAutoConfiguration", WebFluxObservationAutoConfiguration.class).metricsHttpServerUriTagFilter(args.get(0)));
  }

  /**
   * Get the bean definition for 'metricsHttpServerUriTagFilter'.
   */
  public static BeanDefinition getMetricsHttpServerUriTagFilterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MaximumAllowableTagsMeterFilter.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.webflux.autoconfigure.WebFluxObservationAutoConfiguration");
    beanDefinition.setInstanceSupplier(getMetricsHttpServerUriTagFilterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'defaultServerRequestObservationConvention'.
   */
  private static BeanInstanceSupplier<DefaultServerRequestObservationConvention> getDefaultServerRequestObservationConventionInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DefaultServerRequestObservationConvention>forFactoryMethod(WebFluxObservationAutoConfiguration.class, "defaultServerRequestObservationConvention")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.webflux.autoconfigure.WebFluxObservationAutoConfiguration", WebFluxObservationAutoConfiguration.class).defaultServerRequestObservationConvention());
  }

  /**
   * Get the bean definition for 'defaultServerRequestObservationConvention'.
   */
  public static BeanDefinition getDefaultServerRequestObservationConventionBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DefaultServerRequestObservationConvention.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.webflux.autoconfigure.WebFluxObservationAutoConfiguration");
    beanDefinition.setInstanceSupplier(getDefaultServerRequestObservationConventionInstanceSupplier());
    return beanDefinition;
  }
}
