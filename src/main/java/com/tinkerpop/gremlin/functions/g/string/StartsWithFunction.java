package com.tinkerpop.gremlin.functions.g.string;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class StartsWithFunction extends AbstractFunction<Boolean> {

    private static final String FUNCTION_NAME = "starts-with";


    public Atom<Boolean> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() == 2) {
            final String base = (String) arguments.get(0).compute().getValue();
            final String check = (String) arguments.get(1).compute().getValue();
            return new Atom<Boolean>(base.startsWith(check));
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }

}