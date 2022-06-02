package com.company;

import java.util.NoSuchElementException;

public class DoublyList {

    private DoublyNode head;
    private DoublyNode tail;
    private int length;

    public DoublyList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int length() {
        return length;
    }

    public void printDoublyList() {
        DoublyNode temp = head;
        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void printDoublyListInReverse() {
        DoublyNode temp = tail;
        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.previous;
        }
    }

    public void insertLast(int data) {
        DoublyNode dn = new DoublyNode(data);
        if (isEmpty())
            head = dn;
        else {
            tail.next = dn;
            dn.previous = tail;
        }
        tail = dn;
        length++;
    }

    public void insertFirst(int data) {
        DoublyNode node = new DoublyNode(data);
        if (isEmpty())
            tail = node;
        else
            head.previous = node;

        node.next = head;
        head = node;
        length++;
    }

    public DoublyNode deleteFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        DoublyNode temp = head;

        if (head == tail)
            tail = null;
        else
            head.next.previous = null;

        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public DoublyNode deleteLast() {
        DoublyNode temp = tail;

        if (isEmpty()) throw new NoSuchElementException();

        if (head==tail)
            head=null;
        else
            tail.previous.next = null;

        tail = tail.previous;
        temp.previous = null;
        length--;
        return temp;
    }

    public static DoublyNode sortedInsert(DoublyNode head, int data) {
        DoublyNode node = new DoublyNode(data);
        if (head == null) {
            return node;
        } else if (data <= head.data) {
            node.next = head;
            head.previous = node;
            return node;
        } else {
            DoublyNode ptr = sortedInsert(head.next, data);
            head.next = ptr;
            ptr.previous = head;
            return head;
        }

    }

    public static DoublyNode reverse(DoublyNode head) {

        if (head == null) return null;

        DoublyNode temp = head;
        DoublyNode newHead = head;

        while (temp != null) {

            DoublyNode previous = temp.previous;
            temp.previous = temp.next;
            temp.next = previous;
            newHead = temp;

            temp = temp.previous;
        }
        return newHead;
    }

    public void swapData(DoublyNode first, DoublyNode second) {
        int value = first.data;
        first.data = second.data;
        second.data = value;
    }

    public void bubbleSort() {
        if (head == null)
            return;

        boolean task = true;
        DoublyNode start = head;

        while (task == true) {
            task = false;

            while (start != null && start.next != null) {
                if (start.data > start.next.data) {
                    swapData(start, start.next);
                    // Active the next iteration
                    task = true;
                }
                // Visit to next node
                start = start.next;
            }
            // Get first node
            start = this.head;
        }
    }

    public DoublyNode partition(DoublyNode first, DoublyNode last) {
        DoublyNode current = first;
        DoublyNode location = first.previous;
        int temp = 0;
        while (current != null && current != last)
        {
            if (current.data <= last.data)
            {
                if (location == null)
                {
                    location = first;
                }
                else
                {
                    location = location.next;
                }
                // Swap node values
                temp = current.data;
                current.data = location.data;
                location.data = temp;
            }
            // Visit to next node
            current = current.next;
        }
        if (location == null)
        {
            location = first;
        }
        else
        {
            location = location.next;
        }
        // Swap last node value
        temp = last.data;
        last.data = location.data;
        location.data = temp;
        return location;
    }

    public void quickSort(DoublyNode first, DoublyNode last) {
        // Check first and last node valid or not
        if (first != last && first != null && last != null && last.next != first) {
            DoublyNode node = this.partition(first, last);
            if (node != null) {
                this.quickSort(node.next, last);
                this.quickSort(first, node.previous);
            }
        }
    }

    public static DoublyNode middleNode(DoublyNode head, DoublyNode tail) {
        if (head.next == null || head == tail)
            return head;
        else {
            DoublyNode low = head;
            DoublyNode high = head;
            while (high != null && high.next != null && high.next.next != null && high.next != tail && head.next.next != tail) {
                low = low.next;
                high = high.next.next;
            }
            return low;
        }
    }

    public static DoublyNode mergeList(DoublyNode list1, DoublyNode list2)
    {
        if (list1 == null)
        {
            //When list1 is empty
            return list2;
        }
        else if (list2 == null)
        {
            return list1;
        }
        else
        {
            // Some auxiliary variables
            DoublyNode result = null;
            DoublyNode tail = null;
            DoublyNode node = null;
            // Combine list elements in sorted order
            // This process takes(m+n) time
            // Here m is size of list1
            // And n is size of list2
            while (list1 != null || list2 != null)
            {
                if (list1 != null && list2 != null)
                {
                    //When both list contain nodes
                    if (list1.data < list2.data)
                    {
                        //When first list element are smallest
                        node = list1;
                        list1 = list1.next;
                    }
                    else
                    {
                        //When second list element are smallest
                        node = list2;
                        list2 = list2.next;
                    }
                }
                else if (list1 != null)
                {
                    //When first list contain element
                    //Get sublist
                    node = list1;
                    //Set that list1 empty
                    list1 = null;
                }
                else
                {
                    //When second list contain element
                    //get sublist
                    node = list2;
                    list2 = null;
                }
                if (result == null)
                {
                    //When get first node of resultant list
                    result = node;
                    node.next = null;
                    node.previous = null;
                }
                else
                {
                    //Add node at end of resultant list
                    tail.next = node;
                    node.previous = tail;
                }
                tail = node;
            }
            return result;
        }
    }
    // Perform merge sort
    public static DoublyNode mergeSort(DoublyNode head, DoublyNode tail)
    {
        if (head == null || head == tail || head.next == null)
        {
            // When have zero or one node
            return head;
        }
        // Find the relative middle node
        DoublyNode middle = middleNode(head, tail);
        // Get the right sublist
        DoublyNode right = mergeSort(middle.next, tail);
        // Separating sublist
        if (middle.next != null)
        {
            middle.next.previous = null;
        }
        middle.next = null;
        //Get the left sublist
        DoublyNode left = mergeSort(head, middle);
        // Sorted merge in two list
        return mergeList(left, right);
    }
    // Handles the request to perform merge sort operation
    public static void mergeSortList(DoublyNode dll) {
        dll.next = mergeSort(dll.next, dll.previous);
        DoublyNode node = dll.next;
        // First last node
        while (node.next != null)
            node = node.next;

        // Set new rear node
        dll.previous = node;
    }


}
