package net.nanthrax.test.quaraf.core.spi;

public interface QService {

    int DEFAULT_PRIORITY = 1000;

    default void start() throws Exception {}

    default void stop() throws Exception {}


}
