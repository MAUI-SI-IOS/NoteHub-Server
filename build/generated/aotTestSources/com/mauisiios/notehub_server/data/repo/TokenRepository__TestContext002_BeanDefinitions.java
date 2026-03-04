package com.mauisiios.notehub_server.data.repo;

import com.mauisiios.notehub_server.data.entity.TokenEntity;
import java.lang.Class;
import java.lang.String;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactoryBean;
import org.springframework.data.repository.query.QueryLookupStrategy;

/**
 * Bean definitions for {@link TokenRepository}.
 */
@Generated
public class TokenRepository__TestContext002_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'tokenRepository'.
   */
  private static BeanInstanceSupplier<R2dbcRepositoryFactoryBean> getTokenRepositoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<R2dbcRepositoryFactoryBean>forConstructor(Class.class)
            .withGenerator((registeredBean, args) -> new R2dbcRepositoryFactoryBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'tokenRepository'.
   */
  public static BeanDefinition getTokenRepositoryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(R2dbcRepositoryFactoryBean.class);
    beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(R2dbcRepositoryFactoryBean.class, TokenRepository.class, TokenEntity.class, String.class));
    beanDefinition.setLazyInit(false);
    beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, "com.mauisiios.notehub_server.data.repo.TokenRepository");
    beanDefinition.getPropertyValues().addPropertyValue("queryLookupStrategyKey", QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND);
    beanDefinition.getPropertyValues().addPropertyValue("lazyInit", false);
    beanDefinition.getPropertyValues().addPropertyValue("namedQueries", new RuntimeBeanReference("r2dbc.named-queries#0"));
    beanDefinition.getPropertyValues().addPropertyValue("repositoryFragments", new RuntimeBeanReference("r2dbc.TokenRepository.fragments#0"));
    beanDefinition.getPropertyValues().addPropertyValue("entityOperations", new RuntimeBeanReference("r2dbcEntityTemplate"));
    beanDefinition.setInstanceSupplier(getTokenRepositoryInstanceSupplier());
    return beanDefinition;
  }
}
