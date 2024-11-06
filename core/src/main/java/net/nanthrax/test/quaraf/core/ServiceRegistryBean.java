package net.nanthrax.test.quaraf.core;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import net.nanthrax.test.quaraf.core.spi.QService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ServiceRegistryBean {

    private final static Logger LOGGER = LoggerFactory.getLogger(ServiceRegistryBean.class);

    @Inject @Any
    private Instance<QService> services;

    public void start() {
        LOGGER.info("Starting Quaraf service registry ...");
        services.stream().forEach(service -> {
            try {
                service.start();
            } catch (Exception e) {
                LOGGER.warn("Can't start service {}", service, e);
            }
        });
    }

    public void stop() {
        LOGGER.info("Stopping Quaraf service registry ...");
        services.stream().forEach(service -> {
            try {
                service.stop();
            } catch (Exception e) {
                LOGGER.warn("Can't stop service {}", service, e);
            }
        });
    }

    public List<QService> services() {
        return services.stream().collect(Collectors.toList());
    }

}
