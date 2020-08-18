package com.epam.rd.java.basic.practice6.part5;

import java.util.Objects;

public class Tree<E extends Comparable<E>> {

    Node<E> root;
    
    public boolean add(E element) {

        if(root == null) {
            root = new Node<>(element);
            return true;
        }

        return putElement(root, element);

    }

    public void add(E[] elements) {

        if(elements.length == 0) {
            return;
        }

        int k = 0;

        if(root == null) {
            root = new Node<>(elements[0]);
            k = 1;
        }

        for(int i = k; i < elements.length; i++) {
            add(elements[i]);
        }

    }

    public boolean remove(E element) {
        return deleteRecursive(root, element);
    }

    public void print() {
        print(root, "");
    }



    public boolean putElement(Node<E> node, E element) {

        Node<E> currentNode = node;
        Node<E> neededNode = currentNode;

        while (currentNode != null) { // we find parent of null node. It will be "neededNode"

            if(element.compareTo(currentNode.element) > 0) {

                neededNode = currentNode;
                currentNode = currentNode.rightNode;

            } else if(element.compareTo(currentNode.element) < 0) {

                neededNode = currentNode;
                currentNode = currentNode.leftNode;

            } else {
                return false;
            }

        }

        if(element.compareTo(Objects.requireNonNull(neededNode).element) > 0) { // we find place for new node in binary tree

            Node<E> newNode = new Node<>(element);
            newNode.parentNode = neededNode;
            neededNode.rightNode = newNode;

        } else {

            Node<E> newNode = new Node<>(element);
            newNode.parentNode = neededNode;
            neededNode.leftNode = newNode;

        }
        return true;

    }

    public boolean deleteRecursive(Node<E> current, E value) {
        if (current == null) {
            return false;
        }

        if (value == current.element) {

            if (current.leftNode == null && current.rightNode == null) {    // Case 1: no children
                Node<E> parent = current.parentNode;

                if(parent.rightNode != null && parent.rightNode.equals(current)){
                    parent.rightNode = null;
                } else {
                    parent.leftNode = null;
                }

                return true;
            }

            if (current.rightNode == null) {        // Case 2: only 1 child
                return toNodeParentOfCurrentAndChildOfCurrent(current, current.leftNode);
            }

            if (current.leftNode == null) {
                return toNodeParentOfCurrentAndChildOfCurrent(current, current.rightNode);
            }

            E smallestValue = findSmallestValue(current.rightNode);     // Case 3: 2 children
            current.element = smallestValue;
            current.rightNode = returnNodeOfElementThatWillBeDeleted(current.rightNode, smallestValue);
            return true;
        }

        if (value.compareTo(current.element) < 0) {
            return deleteRecursive(current.leftNode, value);
        }

        return deleteRecursive(current.rightNode, value);
    }

    public Node<E> returnNodeOfElementThatWillBeDeleted(Node<E> current, E value) {

        if (current == null) {
            return null;
        }

        if (value == current.element) {
            // Case 1: no children
            if (current.rightNode == null && current.leftNode == null) {
                return null;
            }

            // Case 2: only 1 child
            if (current.leftNode == null) {
                return current.rightNode;
            }

            if (current.rightNode == null) {
                return current.leftNode;
            }

            // Case 3: 2 children
            E smallestValue = findSmallestValue(current.rightNode);
            current.element = smallestValue;
            current.rightNode = returnNodeOfElementThatWillBeDeleted(current.rightNode, smallestValue);
            return current;
        }
        if (value.compareTo(current.element) > 0) {
            current.rightNode = returnNodeOfElementThatWillBeDeleted(current.rightNode, value);
            return current;
        }

        current.leftNode = returnNodeOfElementThatWillBeDeleted(current.leftNode, value);
        return current;
    }

    public boolean toNodeParentOfCurrentAndChildOfCurrent(Node<E> currentNode, Node<E> childNode) {

        Node<E> parentNode = currentNode.parentNode;

        if(parentNode.rightNode == currentNode) {
            parentNode.rightNode = childNode;
            return true;
        }
        else if (parentNode.leftNode == currentNode) {
            parentNode.leftNode = childNode;
            return true;
        } else {
            return false;
        }

    }

    public E findSmallestValue(Node<E> root) {
        return root.leftNode == null ? root.element : findSmallestValue(root.leftNode);
    }

    public void print(Node<E> node, String indentation) {

        if(node != null) {

            print(node.leftNode, indentation + "  ");
            System.out.println(indentation + node.element);
            print(node.rightNode, indentation + "  ");

        }
    }

    public static final class Node<E> {

        private E element;
        Node<E> parentNode = null;
        Node<E> leftNode = null;
        Node<E> rightNode = null;

        public Node(E element) {
            this.element = element;
        }

    }
    
}
