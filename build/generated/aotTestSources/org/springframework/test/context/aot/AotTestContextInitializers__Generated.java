package org.springframework.test.context.aot;

import com.mauisiios.notehub_server.intergation.NLPNoteTest__TestContext001_ApplicationContextInitializer;
import com.mauisiios.notehub_server.intergation.TestNoteRoutes__TestContext002_ApplicationContextInitializer;
import java.lang.Class;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.springframework.aot.generate.Generated;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Generated mappings for {@link AotTestContextInitializers}.
 */
@Generated
public class AotTestContextInitializers__Generated {
  public static Map<String, Supplier<ApplicationContextInitializer<? extends ConfigurableApplicationContext>>> getContextInitializers(
      ) {
    Map<String, Supplier<ApplicationContextInitializer<? extends ConfigurableApplicationContext>>> map = new HashMap<>();
    map.put("com.mauisiios.notehub_server.intergation.NLPNoteTest", () -> new NLPNoteTest__TestContext001_ApplicationContextInitializer());
    map.put("com.mauisiios.notehub_server.intergation.TestNoteRoutes", () -> new TestNoteRoutes__TestContext002_ApplicationContextInitializer());
    return map;
  }

  public static Map<String, Class<? extends ApplicationContextInitializer<?>>> getContextInitializerClasses(
      ) {
    Map<String, Class<? extends ApplicationContextInitializer<?>>> map = new HashMap<>();
    map.put("com.mauisiios.notehub_server.intergation.NLPNoteTest", NLPNoteTest__TestContext001_ApplicationContextInitializer.class);
    map.put("com.mauisiios.notehub_server.intergation.TestNoteRoutes", TestNoteRoutes__TestContext002_ApplicationContextInitializer.class);
    return map;
  }
}
