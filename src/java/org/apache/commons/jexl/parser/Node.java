/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/* Generated By:JJTree: Do not edit this line. Node.java */

package org.apache.commons.jexl.parser;

/**
 * All AST nodes must implement this interface. It provides basic machinery for
 * constructing the parent and child relationships between nodes.
 */
public interface Node {

    /**
     * This method is called after the node has been made the current node. It
     * indicates that child nodes can now be added to it.
     */
     void jjtOpen();

    /**
     * This method is called after all the child nodes have been added.
     */
     void jjtClose();

    /**
     * This pair of methods are used to inform the node of its parent.
     * @param n the parent node.
     */
     void jjtSetParent(Node n);

     /**
      * Gets the parent node.
      * @return the parent to this node.
      */
     Node jjtGetParent();

    /**
     * This method tells the node to add its argument to the node's list of
     * children.
     * @param n the child node to add
     * @param i the index to add it at.
     */
     void jjtAddChild(Node n, int i);

    /**
     * This method returns a child node. The children are numbered from zero,
     * left to right.
     * @param i the index of the child to get.
     * @return the child at the given index.
     */
     Node jjtGetChild(int i);

    /** 
     * Gets the number of children the node has.
     * @return the number of children the node has. 
     */
     int jjtGetNumChildren();

    /**
     *  Accept the visitor.
     *  @param data arbitrary data.
     *  @param visitor the visitor.
     *  @return the result of the visit. 
     */
     Object jjtAccept(ParserVisitor visitor, Object data);
}
