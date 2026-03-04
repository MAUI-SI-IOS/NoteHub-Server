package com.mauisiios.notehub_server.service;

import com.mauisiios.notehub_server.data.repo.NoteTokenRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TokenService}.
 */
@Generated
public class TokenService__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'tokenService'.
   */
  private static BeanInstanceSupplier<TokenService> getTokenServiceInstanceSupplier() {
    return BeanInstanceSupplier.<TokenService>forConstructor(NoteTokenRepository.class)
            .withGenerator((registeredBean, args) -> new TokenService(args.get(0)));
  }

  /**
   * Get the bean definition for 'tokenService'.
   */
  public static BeanDefinition getTokenServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TokenService.class);
    beanDefinition.setInstanceSupplier(getTokenServiceInstanceSupplier());
    return beanDefinition;
  }
}
