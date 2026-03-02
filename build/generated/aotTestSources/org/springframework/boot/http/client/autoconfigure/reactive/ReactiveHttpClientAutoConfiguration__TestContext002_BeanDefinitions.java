package org.springframework.boot.http.client.autoconfigure.reactive;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.http.client.reactive.ClientHttpConnectorBuilder;
import org.springframework.boot.http.client.reactive.ReactorClientHttpConnectorBuilder;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.client.ReactorResourceFactory;
import org.springframework.http.client.reactive.ClientHttpConnector;

/**
 * Bean definitions for {@link ReactiveHttpClientAutoConfiguration}.
 */
@Generated
public class ReactiveHttpClientAutoConfiguration__TestContext002_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.http.client.autoconfigure.reactive.ReactiveHttpClientAutoConfiguration'.
   */
  private static BeanInstanceSupplier<ReactiveHttpClientAutoConfiguration> getReactiveHttpClientAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ReactiveHttpClientAutoConfiguration>forConstructor(Environment.class)
            .withGenerator((registeredBean, args) -> new ReactiveHttpClientAutoConfiguration(args.get(0)));
  }

  /**
   * Get the bean definition for 'reactiveHttpClientAutoConfiguration'.
   */
  public static BeanDefinition getReactiveHttpClientAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactiveHttpClientAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(getReactiveHttpClientAutoConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'clientHttpConnectorBuilder'.
   */
  private static BeanInstanceSupplier<ClientHttpConnectorBuilder> getClientHttpConnectorBuilderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ClientHttpConnectorBuilder>forFactoryMethod(ReactiveHttpClientAutoConfiguration.class, "clientHttpConnectorBuilder", ResourceLoader.class, ReactiveHttpClientsProperties.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.http.client.autoconfigure.reactive.ReactiveHttpClientAutoConfiguration", ReactiveHttpClientAutoConfiguration.class).clientHttpConnectorBuilder(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'clientHttpConnectorBuilder'.
   */
  public static BeanDefinition getClientHttpConnectorBuilderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ClientHttpConnectorBuilder.class);
    beanDefinition.setTargetType(ResolvableType.forClass(ClientHttpConnectorBuilder.class));
    beanDefinition.setFactoryBeanName("org.springframework.boot.http.client.autoconfigure.reactive.ReactiveHttpClientAutoConfiguration");
    beanDefinition.setInstanceSupplier(getClientHttpConnectorBuilderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'clientHttpConnector'.
   */
  private static BeanInstanceSupplier<ClientHttpConnector> getClientHttpConnectorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ClientHttpConnector>forFactoryMethod(ReactiveHttpClientAutoConfiguration.class, "clientHttpConnector", ResourceLoader.class, ObjectProvider.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.http.client.autoconfigure.reactive.ReactiveHttpClientAutoConfiguration", ReactiveHttpClientAutoConfiguration.class).clientHttpConnector(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'clientHttpConnector'.
   */
  public static BeanDefinition getClientHttpConnectorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ClientHttpConnector.class);
    beanDefinition.setLazyInit(true);
    beanDefinition.setFactoryBeanName("org.springframework.boot.http.client.autoconfigure.reactive.ReactiveHttpClientAutoConfiguration");
    beanDefinition.setInstanceSupplier(getClientHttpConnectorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link ReactiveHttpClientAutoConfiguration.ReactorNetty}.
   */
  @Generated
  public static class ReactorNetty {
    /**
     * Get the bean definition for 'reactorNetty'.
     */
    public static BeanDefinition getReactorNettyBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactiveHttpClientAutoConfiguration.ReactorNetty.class);
      beanDefinition.setInstanceSupplier(ReactiveHttpClientAutoConfiguration.ReactorNetty::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'reactorResourceFactoryClientHttpConnectorBuilderCustomizer'.
     */
    private static BeanInstanceSupplier<ClientHttpConnectorBuilderCustomizer> getReactorResourceFactoryClientHttpConnectorBuilderCustomizerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ClientHttpConnectorBuilderCustomizer>forFactoryMethod(ReactiveHttpClientAutoConfiguration.ReactorNetty.class, "reactorResourceFactoryClientHttpConnectorBuilderCustomizer", ReactorResourceFactory.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.http.client.autoconfigure.reactive.ReactiveHttpClientAutoConfiguration$ReactorNetty", ReactiveHttpClientAutoConfiguration.ReactorNetty.class).reactorResourceFactoryClientHttpConnectorBuilderCustomizer(args.get(0)));
    }

    /**
     * Get the bean definition for 'reactorResourceFactoryClientHttpConnectorBuilderCustomizer'.
     */
    public static BeanDefinition getReactorResourceFactoryClientHttpConnectorBuilderCustomizerBeanDefinition(
        ) {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ClientHttpConnectorBuilderCustomizer.class);
      beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(ClientHttpConnectorBuilderCustomizer.class, ReactorClientHttpConnectorBuilder.class));
      beanDefinition.setFactoryBeanName("org.springframework.boot.http.client.autoconfigure.reactive.ReactiveHttpClientAutoConfiguration$ReactorNetty");
      beanDefinition.setInstanceSupplier(getReactorResourceFactoryClientHttpConnectorBuilderCustomizerInstanceSupplier());
      return beanDefinition;
    }
  }
}
