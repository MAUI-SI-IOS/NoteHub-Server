package com.mauisiios.notehub_server.handler;

import com.mauisiios.notehub_server.service.NoteService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link NoteHandler}.
 */
@Generated
public class NoteHandler__TestContext002_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'noteHandler'.
   */
  private static BeanInstanceSupplier<NoteHandler> getNoteHandlerInstanceSupplier() {
    return BeanInstanceSupplier.<NoteHandler>forConstructor(NoteService.class)
            .withGenerator((registeredBean, args) -> new NoteHandler(args.get(0)));
  }

  /**
   * Get the bean definition for 'noteHandler'.
   */
  public static BeanDefinition getNoteHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NoteHandler.class);
    beanDefinition.setInstanceSupplier(getNoteHandlerInstanceSupplier());
    return beanDefinition;
  }
}
