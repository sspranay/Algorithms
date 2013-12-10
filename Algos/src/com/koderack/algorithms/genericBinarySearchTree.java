/*
 * A genric binary search tree implementation
 * with some of the common methods
 * 
 */
package com.koderack.algorithms;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * @author pranay
 */
public class genericBinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    public enum Order {
        INORDER, PREORDER, POSTORDER, LEVELORDER
    }

    private class Node<T> {

        T nodeVal;
        Node<T> left, right;

        public Node(T t) {
            nodeVal = t;
            left = right = null;
        }
    }

    public boolean add(T nodeVal) {
        if (nodeVal == null) {
            throw new IllegalArgumentException("node value can't be null");
        }

        Node<T> node = new Node<>(nodeVal);

        if (root == null) {
            root = node;
            return true;
        }

        return add(node, root);
    }

    public boolean isSymmetric() {
        return isSymmetric(root);
    }

    private boolean isSymmetric(Node<T> root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        if (root.left != null && root.right != null) {
            return isSymmetric(root.left) && isSymmetric(root.right);
        }

        return false;
    }

    public void traverse(Order order) {

        switch (order) {
            case INORDER:
                traverse(Order.INORDER, root);
                break;

            case PREORDER:
                traverse(Order.PREORDER, root);
                break;

            case POSTORDER:
                traverse(Order.POSTORDER, root);
                break;

            case LEVELORDER:
                traverse(Order.LEVELORDER, root);
                break;
        }
    }

    private boolean add(Node<T> node, Node<T> root) {

        if (node.nodeVal.compareTo(root.nodeVal) > 0) {
            if (root.right == null) {
                root.right = node;
                return true;
            } else {
                return add(node, root.right);
            }
        } else if (node.nodeVal.compareTo(root.nodeVal) < 0) {
            if (root.left == null) {
                root.left = node;
                return true;
            } else {
                return add(node, root.left);
            }

        } else {
            throw new IllegalArgumentException("Node already exists");
        }
    }

    private void traverse(Order order, Node<T> currentRoot) {

        if (currentRoot == null) {
            return;
        }

        switch (order) {
            case INORDER:
                traverse(Order.INORDER, currentRoot.left);
                System.out.println(currentRoot.nodeVal); // clean this up to recursively(?) return element
                traverse(Order.INORDER, currentRoot.right);
                break;

            case PREORDER:
                System.out.println(currentRoot.nodeVal); // clean this up to recursively(?) return element
                traverse(Order.PREORDER, currentRoot.left);
                traverse(Order.PREORDER, currentRoot.right);
                break;

            case POSTORDER:
                traverse(Order.POSTORDER, currentRoot.left);
                traverse(Order.POSTORDER, currentRoot.right);
                System.out.println(currentRoot.nodeVal); // clean this up to recursively(?) return element
                break;

            case LEVELORDER:
                Queue<Node<T>> queue = new ArrayDeque<>();
                queue.add(root);
                while (!queue.isEmpty()) {
                    Node<T> node = queue.remove();
                    System.out.println(node.nodeVal);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
        }
    }
}

class DemoGenericBst {

    public static void main(String[] args) {
        genericBinarySearchTree<Integer> bst = new genericBinarySearchTree<>();
//        bst.add(20);
//        bst.add(10);
//        bst.add(25);
//        bst.add(30);
//        bst.add(27);
//        bst.add(40);
//        bst.add(15);
//        bst.add(5);
//        bst.add(7);

        // symmetric tree
        bst.add(5);
        System.out.println("Symmetric ? " + bst.isSymmetric());
        
        bst.add(3);
        System.out.println("Symmetric ? " + bst.isSymmetric());
        
        bst.add(4);
        bst.add(2);
        bst.add(10);
        bst.add(8);
        bst.add(12);
        System.out.println("Symmetric ? " + bst.isSymmetric());
        
//        Bst<Member> bst = new Bst<>();
//        bst.add(new Member(1, "A"));
//        bst.add(new Member(8, "B"));
//        bst.add(new Member(22, "C"));
//        bst.add(new Member(9, "D"));
//        bst.add(new Member(30, "E"));

        System.out.println("inOrder ***********");
        bst.traverse(genericBinarySearchTree.Order.INORDER);

        System.out.println("preOrder ***********");
        bst.traverse(genericBinarySearchTree.Order.PREORDER);
        
        System.out.println("postOrder ***********");
        bst.traverse(genericBinarySearchTree.Order.POSTORDER);

        System.out.println("levelOrder ***********");
        bst.traverse(genericBinarySearchTree.Order.LEVELORDER);

    }
}
