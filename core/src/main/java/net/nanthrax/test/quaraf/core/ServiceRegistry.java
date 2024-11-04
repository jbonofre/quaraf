package net.nanthrax.test.quaraf.core;

import java.util.List;

public interface ServiceRegistry {

    void register(String service);

    void unregister(String service);

    List<String> services();

}
