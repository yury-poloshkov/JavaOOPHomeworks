package org.example.MyLinkedList;

import org.example.Interface.GBList;
import java.util.Iterator;

public class OneWayLinkedList<E> implements GBList<E> {
    public Node<E> head;
    protected class Node<E>{
        private E item;
        protected Node<E> nextNode;
    }
    public void addFirst(E item){
        Node<E> node = new Node<>();
        node.item = item;
        if (head != null){
            node.nextNode = head;
        }
        head = node;
    }
    public void addLast(E item){
        Node<E> current = new Node<>();
        Node<E> newNode = new Node<>();
        newNode.item = item;
        if (head != null){
            current = head;
            while (current.nextNode != null) {
                current = current.nextNode;
            }
            current.nextNode = newNode;
        }else {
            head = newNode;
        }
    }
    @Override
    public boolean add(E item) {
        try {
        addLast(item);
        return true;
        } catch (ClassCastException exception) {
            System.out.println(exception.getMessage());
        }
        return false;
    }

    @Override
    public void remove(int index) {
        if (head != null && index == 0){
            head = head.nextNode;
        } else if (head != null){
            Node<E> node = new Node<>();
            node = head;
            index--;
            while (node.nextNode.nextNode != null && index > 0){
                node = node.nextNode;
                index--;
            }
            if (index == 0) {
                node.nextNode = node.nextNode.nextNode;
            }
        }
    }

    @Override
    public E get(int index) {
        if (head != null){
            Node<E> node = new Node<>();
            node = head;
            while (node.nextNode != null && index > 0){
                node = node.nextNode;
                index--;
            }
            if (index == 0) {
                return node.item;
            }
        }
        return null;
    }

    @Override
    public int size() {
        int count = 0;
        if (head != null){
            count++;
            Node<E> current = new Node<>();
            current = head;
            while (current.nextNode != null){
                count++;
                current = current.nextNode;
            }
        }
        return count;
    }

    @Override
    public void update(int index, E item) {
        if (head != null){
            Node<E> node = new Node<>();
            node = head;
            while (node.nextNode != null && index > 0){
                node = node.nextNode;
                index--;
            }
            if (index == 0) {
                node.item = item;
            }
        }
    }

    @Override
    public OneWayLinkedList<E>  join(E item) {
        addLast(item);
        return this;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<E>(this);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (head != null){
            Node<E> node = new Node<>();
            node = head;
            result.append("{").append(node.item);
            while (node.nextNode != null) {
                node = node.nextNode;
                result.append("; ").append(node.item);
            }
            result.append("}");
        }
        return result.toString();
    }
    public Node<E> reverseOnewayLinkedList(Node<E> node, Node<E> previousNode){
        if (node == null){
            return null;
        }
        if (node == head){
            reverseOnewayLinkedList(node.nextNode, node);
            node.nextNode = null;
        }
        else{
            if (node.nextNode == null) {
                head = node;
            }
            else {
                reverseOnewayLinkedList(node.nextNode, node);
            }
            node.nextNode = previousNode;
        }
        return previousNode;
    }
    public E findNodeFromEnd(int nFromEnd) {
        Node<E> fastNode = new Node<>();
        Node<E> slowNode = new Node<>();
        fastNode = head;
        slowNode = head;

        for (int i = 0; i < nFromEnd - 1; i++){
            if (fastNode.nextNode != null) {
                fastNode = fastNode.nextNode;
            }
            else {
                return null;
            }
        }
        while (fastNode.nextNode != null){
            fastNode = fastNode.nextNode;
            slowNode = slowNode.nextNode;
        }
        return slowNode.item;
    }
}
