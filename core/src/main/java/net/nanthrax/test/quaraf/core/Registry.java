package net.nanthrax.test.quaraf.core;

import jakarta.enterprise.util.AnnotationLiteral;
import jakarta.inject.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD, ElementType.TYPE})
public @interface Registry {

    String name();

    public static final class Literal extends AnnotationLiteral<Registry> implements Registry {
        private static final long serialVersionUID = 1L;
        private final String name;

        public static Literal of(String name) {
            return new Literal(name);
        }

        private Literal(String name) {
            this.name = name;
        }

        public String name() {
            return this.name;
        }
    }

}
