package net.nanthrax.test.quaraf.core.spi;

import jakarta.enterprise.util.AnnotationLiteral;
import jakarta.inject.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD, ElementType.TYPE})
public @interface Service {

    String name();

    long priority();

    public static final class Literal extends AnnotationLiteral<Service> implements Service {
        private static final long serialVersionUID = 1L;
        private final String name;
        private final long priority;

        public static Literal of(String name, long priority) {
            return new Literal(name, priority);
        }

        private Literal(String name, long priority) {
            this.name = name;
            this.priority = priority;
        }

        public String name() {
            return this.name;
        }

        public long priority() {
            return this.priority;
        }
    }

}
