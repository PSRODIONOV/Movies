package service;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() { // регистрация REST контроллеров
        //register(UserController.class);
        register(MovieController.class);
    }
}
