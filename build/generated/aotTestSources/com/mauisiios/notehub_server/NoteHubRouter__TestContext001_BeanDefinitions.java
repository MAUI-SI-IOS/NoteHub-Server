package com.mauisiios.notehub_server;

import com.mauisiios.notehub_server.handler.NoteHandler;
import com.mauisiios.notehub_server.handler.TokenHandler;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * Bean definitions for {@link NoteHubRouter}.
 */
@Generated
public class NoteHubRouter__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'noteHubRouter'.
   */
  public static BeanDefinition getNoteHubRouterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NoteHubRouter.class);
    beanDefinition.setInstanceSupplier(NoteHubRouter::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'notesRoutes'.
   */
  private static BeanInstanceSupplier<RouterFunction> getNotesRoutesInstanceSupplier() {
    return BeanInstanceSupplier.<RouterFunction>forFactoryMethod(NoteHubRouter.class, "notesRoutes", NoteHandler.class, TokenHandler.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("noteHubRouter", NoteHubRouter.class).notesRoutes(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'notesRoutes'.
   */
  public static BeanDefinition getNotesRoutesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RouterFunction.class);
    beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(RouterFunction.class, ServerResponse.class));
    beanDefinition.setFactoryBeanName("noteHubRouter");
    beanDefinition.setInstanceSupplier(getNotesRoutesInstanceSupplier());
    return beanDefinition;
  }
}
