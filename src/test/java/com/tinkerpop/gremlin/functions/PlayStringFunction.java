package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PlayStringFunction extends AbstractFunction<String> {

    public Atom<String> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        return new Atom<String>("Goodbye.");
    }

    public String getFunctionName() {
        return "play-string";
    }
}
