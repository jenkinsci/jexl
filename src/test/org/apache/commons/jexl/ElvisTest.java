package org.apache.commons.jexl;

import junit.framework.TestCase;

/**
 * @author Kohsuke Kawaguchi
 */
public class ElvisTest extends TestCase {
    public void testTernary1() throws Exception {
        Expression e = ExpressionFactory.createExpression("true?1.0:2.0");
        JexlContext jc = JexlHelper.createContext();
        Object o = e.evaluate(jc);
        assertEquals(new Float(1.0f), o);
    }

    public void testTernary2() throws Exception {
        Expression e = ExpressionFactory.createExpression("false?1.0:2.0");
        JexlContext jc = JexlHelper.createContext();
        Object o = e.evaluate(jc);
        assertEquals(new Float(2.0f), o);
    }

    public void testElvis1() throws Exception {
        Expression e = ExpressionFactory.createExpression("1?:2");
        JexlContext jc = JexlHelper.createContext();
        Object o = e.evaluate(jc);
        assertEquals(new Integer(1), o);
    }

    public void testElvis2() throws Exception {
        Expression e = ExpressionFactory.createExpression("null?:2");
        JexlContext jc = JexlHelper.createContext();
        Object o = e.evaluate(jc);
        assertEquals(new Integer(2), o);
    }
}
