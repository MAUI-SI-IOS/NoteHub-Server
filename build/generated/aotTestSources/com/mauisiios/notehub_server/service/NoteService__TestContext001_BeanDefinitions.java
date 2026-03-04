package com.mauisiios.notehub_server.service;

import com.mauisiios.notehub_server.data.repo.NoteRepository;
import com.mauisiios.notehub_server.data.repo.NoteTokenRepository;
import com.mauisiios.notehub_server.data.repo.TokenRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link NoteService}.
 */
@Generated
public class NoteService__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'noteService'.
   */
  private static BeanInstanceSupplier<NoteService> getNoteServiceInstanceSupplier() {
    return BeanInstanceSupplier.<NoteService>forConstructor(NLPService.class, NoteRepository.class, TokenRepository.class, NoteTokenRepository.class)
            .withGenerator((registeredBean, args) -> new NoteService(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'noteService'.
   */
  public static BeanDefinition getNoteServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NoteService.class);
    beanDefinition.setInstanceSupplier(getNoteServiceInstanceSupplier());
    return beanDefinition;
  }
}
