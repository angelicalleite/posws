package br.edu.fapce.api.app;

import br.edu.fapce.api.exception.AppExceptionMapper;
import br.edu.fapce.api.exception.InternalServerMapper;
import br.edu.fapce.api.exception.NotFoundMapper;
import br.edu.fapce.api.exception.SqlExceptionMapper;
import br.edu.fapce.api.filters.Auth;
import br.edu.fapce.api.filters.Logger;
import br.edu.fapce.api.monitor.MonitorApp;
import br.edu.fapce.api.monitor.MonitorRequest;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Configurar de recursos da aplicação como registro de pacotes e classes.
 */
public class App extends ResourceConfig {

    public App() {

        // register application resources
        packages("br.com.fapce.api.resources");

        // register filters
        register(Auth.class);
        register(Logger.class);

        // register exception mappers
        register(AppExceptionMapper.class);
        register(SqlExceptionMapper.class);
        register(NotFoundMapper.class);
        register(InternalServerMapper.class);

        // register monitoring
        register(MonitorApp.class);
        register(MonitorRequest.class);
    }
}