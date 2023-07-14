package org.example;

import org.example.MyLinkedList.OneWayLinkedList;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        OneWayLinkedList<Integer> testList = new OneWayLinkedList<>();
        testList.addLast(-1);
        int listSize = 10;
        int minValue = 1;
        int maxValue = minValue + 100;
        for (int i = 0; i < listSize; i++) {
            testList.addFirst((int) (minValue + (Math.random() * (maxValue - minValue))));
        }
        System.out.println("OriginalList: " + testList.toString() + " size = " + testList.size());
        testList.reverseOnewayLinkedList(testList.head, testList.head);
        testList.addLast(-2);
        System.out.println("ReversedList: " + testList.toString() + " size = " + testList.size());
        int nFromEnd = (int) (Math.random() * listSize);
        System.out.println(nFromEnd + "-nd item from end : " + testList.findNodeFromEnd(nFromEnd));
        System.out.println("(index)" + (nFromEnd) + "-nd item: " + testList.get(nFromEnd));
        testList.update(nFromEnd,-3);
        System.out.println("UpdatedList: " + testList.toString());
        testList.remove(nFromEnd);
        testList.remove(0);
        testList.remove(testList.size()-1);
        System.out.println("CutedList: " + testList.toString() + "; cuted size = " + testList.size());
        testList.join(-4).join(-5).join(-6);
        System.out.println("AppendedList: " + testList.toString() + " size = " + testList.size());
        // test Iterator
        for (var node: testList) {
            System.out.println(node);
        }
    }
}