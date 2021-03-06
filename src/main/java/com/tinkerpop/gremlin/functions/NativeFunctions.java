package com.tinkerpop.gremlin.functions;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class NativeFunctions extends AbstractFunctions {

    private final String namespace;

    public NativeFunctions(final String namespace) {
        this.namespace = namespace;
    }

    public String getNamespace() {
        return this.namespace;
    }
}
