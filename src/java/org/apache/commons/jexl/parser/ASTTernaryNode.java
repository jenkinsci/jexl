package org.apache.commons.jexl.parser;

import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.util.Coercion;

/**
 * "x?y:z" operator.
 *
 * @author Kohsuke Kawaguchi
 */
public class ASTTernaryNode extends SimpleNode {
    /**
     * Create the node given an id.
     *
     * @param id node id.
     */
    public ASTTernaryNode(int id) {
        super(id);
    }

    /**
     * Create a node with the given parser and id.
     *
     * @param p a parser.
     * @param id node id.
     */
    public ASTTernaryNode(Parser p, int id) {
        super(p, id);
    }

    /** {@inheritDoc} */
    public Object jjtAccept(ParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

    /** {@inheritDoc} */
    public Object value(JexlContext jc) throws Exception {
        Object cond = ((SimpleNode) jjtGetChild(0)).value(jc);
        boolean leftValue = Coercion.coerceBoolean(cond).booleanValue();

        return ((SimpleNode) jjtGetChild(leftValue?1:2)).value(jc);
    }
}
