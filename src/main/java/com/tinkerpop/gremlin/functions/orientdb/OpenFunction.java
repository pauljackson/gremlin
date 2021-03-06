package com.tinkerpop.gremlin.functions.orientdb;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.orientdb.OrientGraph;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;

import java.io.File;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OpenFunction extends AbstractFunction<Graph> {

    private final String FUNCTION_NAME = "open";
    private static final String ADMIN = "admin";

    public Atom<Graph> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        if (arguments.size() == 1) {
            String url = (String) arguments.get(0).compute().getValue();
            final File directory = new File(url);
            if (!directory.exists())
                directory.mkdirs();

            try {
                OrientGraph graph = new OrientGraph("local:" + url, ADMIN, ADMIN);
                return new Atom<Graph>(graph);
            } catch (Error e) {
                throw new RuntimeException("Dependencies not available for this graph");
            }
        } else if (arguments.size() == 3) {
            String url = (String) arguments.get(0).compute().getValue();
            String username = (String) arguments.get(1).compute().getValue();
            String password = (String) arguments.get(2).compute().getValue();
            final File directory = new File(url);
            if (!directory.exists())
                directory.mkdirs();

            try {
                OrientGraph graph = new OrientGraph("local:" + url, username, password);
                return new Atom<Graph>(graph);
            } catch (Error e) {
                throw new RuntimeException("Dependencies not available for this graph");
            }
        } else {
            throw new RuntimeException(createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }
}