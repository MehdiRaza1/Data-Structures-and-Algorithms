package com.company;

public class Queue {

    class Node {
        int data;
        Node next;

        public Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public void add(int data) {
        Node n = new Node(data);

        if (tail == null) {
            tail = head = n;
            return;
        }
        tail.next = n;
        tail = n;
    }

    public int remove() {
        if (isEmpty())
            return -1;

        int front = head.data;
        if (head == tail) {
            tail = null;
        }
        head = head.next;
        return front;
    }

    public int peek() {
        if (isEmpty())
            return -1;

        return head.data;
    }



}
