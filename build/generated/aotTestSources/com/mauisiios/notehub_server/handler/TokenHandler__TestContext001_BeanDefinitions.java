package com.mauisiios.notehub_server.handler;

import com.mauisiios.notehub_server.service.TokenService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TokenHandler}.
 */
@Generated
public class TokenHandler__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'tokenHandler'.
   */
  private static BeanInstanceSupplier<TokenHandler> getTokenHandlerInstanceSupplier() {
    return BeanInstanceSupplier.<TokenHandler>forConstructor(TokenService.class)
            .withGenerator((registeredBean, args) -> new TokenHandler(args.get(0)));
  }

  /**
   * Get the bean definition for 'tokenHandler'.
   */
  public static BeanDefinition getTokenHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TokenHandler.class);
    beanDefinition.setInstanceSupplier(getTokenHandlerInstanceSupplier());
    return beanDefinition;
  }
}
