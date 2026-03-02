package org.springframework.boot.r2dbc.autoconfigure.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredMethodArgumentsResolver;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ConnectionPoolMetricsAutoConfiguration}.
 */
@Generated
public class ConnectionPoolMetricsAutoConfiguration__TestContext002_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ConnectionPoolMetricsAutoConfiguration apply(RegisteredBean registeredBean,
      ConnectionPoolMetricsAutoConfiguration instance) {
    AutowiredMethodArgumentsResolver.forRequiredMethod("bindConnectionPoolsToRegistry", ConfigurableListableBeanFactory.class, MeterRegistry.class).resolve(registeredBean, args -> instance.bindConnectionPoolsToRegistry(args.get(0), args.get(1)));
    return instance;
  }
}
