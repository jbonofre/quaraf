package net.nanthrax.test.quaraf.core;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Default
@Registry(name = "in-memory")
public class InMemoryServiceRegistryBean implements ServiceRegistry {

    private List<String> services = new ArrayList<>();

    @Override
    public void register(String service) {
        services.add(service);
    }

    @Override
    public void unregister(String service) {
        services.remove(service);
    }

    @Override
    public List<String> services() {
        return services;
    }

}
