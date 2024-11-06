package net.nanthrax.test.quaraf.core;

import io.quarkus.runtime.Shutdown;
import io.quarkus.runtime.Startup;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Collectors;

@ApplicationScoped
public class Quaraf {

    private static final Logger LOGGER = LoggerFactory.getLogger(Quaraf.class);

    @Inject
    private ServiceRegistryBean serviceRegistry;

    @Startup
    void init() {
        LOGGER.info("Starting Quaraf");
        LOGGER.info("\tServices available: {}", serviceRegistry.services());
        serviceRegistry.start();
    }

    @Shutdown
    void close() {
        LOGGER.info("Stopping Quaraf");
        serviceRegistry.stop();
    }

}
