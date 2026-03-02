package com.mauisiios.notehub_server;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link NoteHubServerApplication}.
 */
@Generated
public class NoteHubServerApplication__TestContext002_BeanDefinitions {
  /**
   * Get the bean definition for 'noteHubServerApplication'.
   */
  public static BeanDefinition getNoteHubServerApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NoteHubServerApplication.class);
    beanDefinition.setInstanceSupplier(NoteHubServerApplication::new);
    return beanDefinition;
  }
}
