package org.springframework.boot.webflux.autoconfigure.error;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.webflux.error.DefaultErrorAttributes;
import org.springframework.boot.webflux.error.ErrorAttributes;
import org.springframework.boot.webflux.error.ErrorWebExceptionHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.http.codec.ServerCodecConfigurer;

/**
 * Bean definitions for {@link ErrorWebFluxAutoConfiguration}.
 */
@Generated
public class ErrorWebFluxAutoConfiguration__TestContext002_BeanDefinitions {
  /**
   * Get the bean definition for 'errorWebFluxAutoConfiguration'.
   */
  public static BeanDefinition getErrorWebFluxAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ErrorWebFluxAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(ErrorWebFluxAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'errorWebExceptionHandler'.
   */
  private static BeanInstanceSupplier<ErrorWebExceptionHandler> getErrorWebExceptionHandlerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ErrorWebExceptionHandler>forFactoryMethod(ErrorWebFluxAutoConfiguration.class, "errorWebExceptionHandler", ErrorAttributes.class, WebProperties.class, ObjectProvider.class, ServerCodecConfigurer.class, ApplicationContext.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.webflux.autoconfigure.error.ErrorWebFluxAutoConfiguration", ErrorWebFluxAutoConfiguration.class).errorWebExceptionHandler(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4)));
  }

  /**
   * Get the bean definition for 'errorWebExceptionHandler'.
   */
  public static BeanDefinition getErrorWebExceptionHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ErrorWebExceptionHandler.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.webflux.autoconfigure.error.ErrorWebFluxAutoConfiguration");
    beanDefinition.setInstanceSupplier(getErrorWebExceptionHandlerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'errorAttributes'.
   */
  private static BeanInstanceSupplier<DefaultErrorAttributes> getErrorAttributesInstanceSupplier() {
    return BeanInstanceSupplier.<DefaultErrorAttributes>forFactoryMethod(ErrorWebFluxAutoConfiguration.class, "errorAttributes")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.webflux.autoconfigure.error.ErrorWebFluxAutoConfiguration", ErrorWebFluxAutoConfiguration.class).errorAttributes());
  }

  /**
   * Get the bean definition for 'errorAttributes'.
   */
  public static BeanDefinition getErrorAttributesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DefaultErrorAttributes.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.webflux.autoconfigure.error.ErrorWebFluxAutoConfiguration");
    beanDefinition.setInstanceSupplier(getErrorAttributesInstanceSupplier());
    return beanDefinition;
  }
}
