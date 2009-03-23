package org.apache.commons.jexl.parser;

import org.apache.commons.jexl.JexlContext;

/**
 * "x?:y" operator.
 *
 * @author Kohsuke Kawaguchi
 */
public class ASTElvisNode extends SimpleNode {
    /**
     * Create the node given an id.
     *
     * @param id node id.
     */
    public ASTElvisNode(int id) {
        super(id);
    }

    /**
     * Create a node with the given parser and id.
     *
     * @param p a parser.
     * @param id node id.
     */
    public ASTElvisNode(Parser p, int id) {
        super(p, id);
    }

    /** {@inheritDoc} */
    public Object jjtAccept(ParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

    /** {@inheritDoc} */
    public Object value(JexlContext jc) throws Exception {
        Object cond = ((SimpleNode) jjtGetChild(0)).value(jc);
        if(cond!=null)  return cond;

        return ((SimpleNode) jjtGetChild(1)).value(jc);
    }
}
