package com.company;

import java.util.NoSuchElementException;

public class CircularList {

    private CircularNode last;
    private int length;

    public CircularList() {
        last = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void printCircularList() {
        if (last == null) return;
        CircularNode first = last.next;
        while (first!=last) {
            System.out.print(first.data + " ");
            first = first.next;
        }
        System.out.print(first.data);
    }

    public void insertFirstInCircularList(int data) {
        CircularNode temp = new CircularNode(data);
        if (last == null)
            last = temp;
        else
            temp.next = last.next;
        last.next = temp;
        length++;
    }

    public void insertLastInCircularList(int data) {

        CircularNode temp = new CircularNode(data);
        if (last == null) {
            last = temp;
            last.next = last;
        } else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        length++;
    }

    public CircularNode removeFirstNode() {
        if (isEmpty()) throw new NoSuchElementException();

        CircularNode temp = last.next;
        if (last.next == last)
            last = null;
        else
            last.next = temp.next;

        temp.next = null;
        length--;
        return temp;
    }

}
