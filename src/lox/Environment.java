package lox;

import java.util.HashMap;
import java.util.Map;

class Environment {
    final Environment enclosing;
    private final Map<String, Object> values = new HashMap<>();
    private final Map<String, Boolean> initialized = new HashMap<>();

    Environment() {
        enclosing = null;
    }

    Environment(Environment enclosing) {
        this.enclosing = enclosing;
    }

    void define(String name, Object value) {
        values.put(name, value);
        initialized.put(name, true);
    }

    Environment ancestor(int distance) {
        Environment environment = this;
        for (int i = 0; i < distance; i++) {
            environment = environment.enclosing;
        }

        return environment;
    }

    Object getAt(int distance, String name) {
        return ancestor(distance).values.get(name);
    }

    void assignAt(int distance, Token name, Object value) {
        ancestor(distance).values.put(name.lexeme, value);
    }

    void defineUninitialized(String name) {
        values.put(name, null);
        initialized.put(name, false);
    }

    Object get(Token name) {
        if (values.containsKey(name.lexeme)) {
            if (!initialized.getOrDefault(name.lexeme, false)) {
                throw new RuntimeError(name, "Cannot read local variable '" +
                        name.lexeme + "' before it is initialized.");
            }
            return values.get(name.lexeme);
        }

        if (enclosing != null)
            return enclosing.get(name);

        throw new RuntimeError(name, "Undefined variable '" +
                name.lexeme + "'.");
    }

    void assign(Token name, Object value) {
        if (values.containsKey(name.lexeme)) {
            values.put(name.lexeme, value);
            initialized.put(name.lexeme, true);
            return;
        }

        if (enclosing != null) {
            enclosing.assign(name, value);
            return;
        }

        throw new RuntimeError(name, "Undefined variable '"
                + name.lexeme + "'.");
    }
}
