package org.springframework.boot.webtestclient.autoconfigure;

import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * Bean definitions for {@link WebTestClientAutoConfiguration}.
 */
@Generated
public class WebTestClientAutoConfiguration__TestContext002_BeanDefinitions {
  /**
   * Get the bean definition for 'webTestClientAutoConfiguration'.
   */
  public static BeanDefinition getWebTestClientAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebTestClientAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(WebTestClientAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'springBootWebTestClientBuilderCustomizer'.
   */
  private static BeanInstanceSupplier<SpringBootWebTestClientBuilderCustomizer> getSpringBootWebTestClientBuilderCustomizerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SpringBootWebTestClientBuilderCustomizer>forFactoryMethod(WebTestClientAutoConfiguration.class, "springBootWebTestClientBuilderCustomizer", ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.webtestclient.autoconfigure.WebTestClientAutoConfiguration", WebTestClientAutoConfiguration.class).springBootWebTestClientBuilderCustomizer(args.get(0)));
  }

  /**
   * Get the bean definition for 'springBootWebTestClientBuilderCustomizer'.
   */
  public static BeanDefinition getSpringBootWebTestClientBuilderCustomizerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringBootWebTestClientBuilderCustomizer.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.webtestclient.autoconfigure.WebTestClientAutoConfiguration");
    beanDefinition.setInstanceSupplier(getSpringBootWebTestClientBuilderCustomizerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'webTestClient'.
   */
  private static BeanInstanceSupplier<WebTestClient> getWebTestClientInstanceSupplier() {
    return BeanInstanceSupplier.<WebTestClient>forFactoryMethod(WebTestClientAutoConfiguration.class, "webTestClient", ApplicationContext.class, List.class, List.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.webtestclient.autoconfigure.WebTestClientAutoConfiguration", WebTestClientAutoConfiguration.class).webTestClient(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'webTestClient'.
   */
  public static BeanDefinition getWebTestClientBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebTestClient.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.webtestclient.autoconfigure.WebTestClientAutoConfiguration");
    beanDefinition.setInstanceSupplier(getWebTestClientInstanceSupplier());
    return beanDefinition;
  }
}
