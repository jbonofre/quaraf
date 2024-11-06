package net.nanthrax.test.quaraf.core.services;

import jakarta.enterprise.context.ApplicationScoped;
import net.nanthrax.test.quaraf.core.spi.QService;
import net.nanthrax.test.quaraf.core.spi.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@ApplicationScoped
@Service(name = "test", priority = QService.DEFAULT_PRIORITY)
public class TestService implements QService {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestService.class);

    @Override
    public void start() throws Exception {
        LOGGER.info("Starting test service ...");
    }

    @Override
    public void stop() {
        LOGGER.info("Stopping test service ...");
    }

}
