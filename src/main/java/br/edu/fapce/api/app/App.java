package br.edu.fapce.api.app;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * Configurar de recursos da aplicação como registro de pacotes e classes.
 */
public class App extends ResourceConfig {

    public App() {

        // register application resources
        packages("br.com.fapce.api.resources");

    }
}