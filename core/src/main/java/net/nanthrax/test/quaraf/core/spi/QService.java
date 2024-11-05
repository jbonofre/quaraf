package net.nanthrax.test.quaraf.core.spi;

import java.util.Locale;

public interface QService {

    int DEFAULT_PRIORITY = 1000;

    default void register() throws Exception {

    }

    default void unregister() throws Exception {

    }

    default int priority() {
        return DEFAULT_PRIORITY;
    }

    default String name() {
        return getClass().getSimpleName().toLowerCase(Locale.ROOT).replaceAll("Service", "");
    }

}
