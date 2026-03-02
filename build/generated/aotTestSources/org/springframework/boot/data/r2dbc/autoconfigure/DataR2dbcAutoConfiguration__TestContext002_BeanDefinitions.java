package org.springframework.boot.data.r2dbc.autoconfigure;

import com.mauisiios.notehub_server.data.entity.NoteEntity;
import java.lang.Class;
import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.data.domain.ManagedTypes;
import org.springframework.data.r2dbc.convert.MappingR2dbcConverter;
import org.springframework.data.r2dbc.convert.R2dbcConverter;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.mapping.R2dbcMappingContext;
import org.springframework.data.relational.RelationalManagedTypes;
import org.springframework.r2dbc.core.DatabaseClient;

/**
 * Bean definitions for {@link DataR2dbcAutoConfiguration}.
 */
@Generated
public class DataR2dbcAutoConfiguration__TestContext002_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.data.r2dbc.autoconfigure.DataR2dbcAutoConfiguration'.
   */
  private static BeanInstanceSupplier<DataR2dbcAutoConfiguration> getDataRdbcAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DataR2dbcAutoConfiguration>forConstructor(DatabaseClient.class)
            .withGenerator((registeredBean, args) -> new DataR2dbcAutoConfiguration(args.get(0)));
  }

  /**
   * Get the bean definition for 'dataR2dbcAutoConfiguration'.
   */
  public static BeanDefinition getDataRdbcAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DataR2dbcAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(getDataRdbcAutoConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'r2dbcEntityTemplate'.
   */
  private static BeanInstanceSupplier<R2dbcEntityTemplate> getRdbcEntityTemplateInstanceSupplier() {
    return BeanInstanceSupplier.<R2dbcEntityTemplate>forFactoryMethod(DataR2dbcAutoConfiguration.class, "r2dbcEntityTemplate", R2dbcConverter.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.data.r2dbc.autoconfigure.DataR2dbcAutoConfiguration", DataR2dbcAutoConfiguration.class).r2dbcEntityTemplate(args.get(0)));
  }

  /**
   * Get the bean definition for 'r2dbcEntityTemplate'.
   */
  public static BeanDefinition getRdbcEntityTemplateBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(R2dbcEntityTemplate.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.data.r2dbc.autoconfigure.DataR2dbcAutoConfiguration");
    beanDefinition.setInstanceSupplier(getRdbcEntityTemplateInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance for 'r2dbcManagedTypes'.
   */
  private static InstanceSupplier<RelationalManagedTypes> rdbcManagedTypesInstance() {
    return (registeredBean ->  {
      List<Class<?>> types = List.of(NoteEntity.class);
      ManagedTypes managedTypes = ManagedTypes.fromIterable(types);
      return RelationalManagedTypes.from(managedTypes);
    } );
  }

  /**
   * Get the bean definition for 'r2dbcManagedTypes'.
   */
  public static BeanDefinition getRdbcManagedTypesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DataR2dbcAutoConfiguration.class);
    beanDefinition.setTargetType(RelationalManagedTypes.class);
    beanDefinition.setInstanceSupplier(DataR2dbcAutoConfiguration__TestContext002_BeanDefinitions.rdbcManagedTypesInstance());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'r2dbcMappingContext'.
   */
  private static BeanInstanceSupplier<R2dbcMappingContext> getRdbcMappingContextInstanceSupplier() {
    return BeanInstanceSupplier.<R2dbcMappingContext>forFactoryMethod(DataR2dbcAutoConfiguration.class, "r2dbcMappingContext", ObjectProvider.class, R2dbcCustomConversions.class, RelationalManagedTypes.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.data.r2dbc.autoconfigure.DataR2dbcAutoConfiguration", DataR2dbcAutoConfiguration.class).r2dbcMappingContext(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'r2dbcMappingContext'.
   */
  public static BeanDefinition getRdbcMappingContextBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(R2dbcMappingContext.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.data.r2dbc.autoconfigure.DataR2dbcAutoConfiguration");
    beanDefinition.setInstanceSupplier(getRdbcMappingContextInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'r2dbcConverter'.
   */
  private static BeanInstanceSupplier<MappingR2dbcConverter> getRdbcConverterInstanceSupplier() {
    return BeanInstanceSupplier.<MappingR2dbcConverter>forFactoryMethod(DataR2dbcAutoConfiguration.class, "r2dbcConverter", R2dbcMappingContext.class, R2dbcCustomConversions.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.data.r2dbc.autoconfigure.DataR2dbcAutoConfiguration", DataR2dbcAutoConfiguration.class).r2dbcConverter(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'r2dbcConverter'.
   */
  public static BeanDefinition getRdbcConverterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MappingR2dbcConverter.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.data.r2dbc.autoconfigure.DataR2dbcAutoConfiguration");
    beanDefinition.setInstanceSupplier(getRdbcConverterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'r2dbcCustomConversions'.
   */
  private static BeanInstanceSupplier<R2dbcCustomConversions> getRdbcCustomConversionsInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<R2dbcCustomConversions>forFactoryMethod(DataR2dbcAutoConfiguration.class, "r2dbcCustomConversions")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.data.r2dbc.autoconfigure.DataR2dbcAutoConfiguration", DataR2dbcAutoConfiguration.class).r2dbcCustomConversions());
  }

  /**
   * Get the bean definition for 'r2dbcCustomConversions'.
   */
  public static BeanDefinition getRdbcCustomConversionsBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(R2dbcCustomConversions.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.data.r2dbc.autoconfigure.DataR2dbcAutoConfiguration");
    beanDefinition.setInstanceSupplier(getRdbcCustomConversionsInstanceSupplier());
    return beanDefinition;
  }
}
