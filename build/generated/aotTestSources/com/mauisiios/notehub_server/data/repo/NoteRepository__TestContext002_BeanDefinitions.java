package com.mauisiios.notehub_server.data.repo;

import com.mauisiios.notehub_server.data.entity.NoteEntity;
import java.lang.Class;
import java.lang.Long;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactoryBean;
import org.springframework.data.repository.query.QueryLookupStrategy;

/**
 * Bean definitions for {@link NoteRepository}.
 */
@Generated
public class NoteRepository__TestContext002_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'noteRepository'.
   */
  private static BeanInstanceSupplier<R2dbcRepositoryFactoryBean> getNoteRepositoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<R2dbcRepositoryFactoryBean>forConstructor(Class.class)
            .withGenerator((registeredBean, args) -> new R2dbcRepositoryFactoryBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'noteRepository'.
   */
  public static BeanDefinition getNoteRepositoryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(R2dbcRepositoryFactoryBean.class);
    beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(R2dbcRepositoryFactoryBean.class, NoteRepository.class, NoteEntity.class, Long.class));
    beanDefinition.setLazyInit(false);
    beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, "com.mauisiios.notehub_server.data.repo.NoteRepository");
    beanDefinition.getPropertyValues().addPropertyValue("queryLookupStrategyKey", QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND);
    beanDefinition.getPropertyValues().addPropertyValue("lazyInit", false);
    beanDefinition.getPropertyValues().addPropertyValue("namedQueries", new RuntimeBeanReference("r2dbc.named-queries#0"));
    beanDefinition.getPropertyValues().addPropertyValue("repositoryFragments", new RuntimeBeanReference("r2dbc.NoteRepository.fragments#0"));
    beanDefinition.getPropertyValues().addPropertyValue("entityOperations", new RuntimeBeanReference("r2dbcEntityTemplate"));
    beanDefinition.setInstanceSupplier(getNoteRepositoryInstanceSupplier());
    return beanDefinition;
  }
}
