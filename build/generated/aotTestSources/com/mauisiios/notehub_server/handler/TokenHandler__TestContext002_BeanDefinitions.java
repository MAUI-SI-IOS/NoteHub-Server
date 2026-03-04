package com.mauisiios.notehub_server.handler;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TokenHandler}.
 */
@Generated
public class TokenHandler__TestContext002_BeanDefinitions {
  /**
   * Get the bean definition for 'tokenHandler'.
   */
  public static BeanDefinition getTokenHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TokenHandler.class);
    beanDefinition.setInstanceSupplier(TokenHandler::new);
    return beanDefinition;
  }
}
