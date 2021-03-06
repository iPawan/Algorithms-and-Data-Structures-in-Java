package com.rampatra.common;

import java.util.NoSuchElementException;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 * User: ramswaroop
 * Date: 4/19/15
 * Time: 6:36 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    /**
     * Inserts a node into the BST.
     *
     * @param value
     */
    public BinaryNode<E> put(E value) {
        return put(root, value);
    }

    public BinaryNode<E> put(BinaryNode<E> node, E value) {
        BinaryNode<E> newNode = new BinaryNode<>(value, null, null);

        if (node == null) {
            return root = new BinaryNode<>(value, null, null);
        } else {
            if (value.compareTo(node.value) < 0) {
                if (node.left == null) {
                    return node.left = newNode;
                } else {
                    return put(node.left, value);
                }
            } else {
                if (node.right == null) {
                    return node.right = newNode;
                } else {
                    return put(node.right, value);
                }
            }
        }
    }


    /**
     * Returns the node with minimum value.
     *
     * @return
     */
    public BinaryNode<E> min() {
        return min(root);
    }

    public BinaryNode<E> min(BinaryNode<E> node) {
        if (node == null) throw new NoSuchElementException();

        if (node.left == null) {
            return node;
        } else {
            return min(node.left);
        }
    }

    public void printList(BinaryNode<E> node) {
        BinaryNode<E> current = node;
        out.print("[");
        if (current == null) {
            out.println("]");
            return;
        }
        while (current.right != node) {
            out.print(current.value + ",");
            current = current.right;
        }
        out.println(current.value + "]");
    }
}
