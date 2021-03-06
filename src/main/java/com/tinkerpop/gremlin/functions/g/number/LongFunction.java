package com.tinkerpop.gremlin.functions.g.number;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LongFunction extends AbstractFunction<Long> {

    private static final String FUNCTION_NAME = "long";

    public Atom<Long> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() == 1) {
            final Object object = arguments.get(0).compute().getValue();
            final Double temp = Double.valueOf(object.toString());
            return new Atom<Long>(temp.longValue());
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage("One long convertible object required"));
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}