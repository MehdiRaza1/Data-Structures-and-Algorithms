package com.company;

public class StackClass {
    public StackNode head;

    public boolean isEmpty() {
        return head == null;
    }

    public void push(int data) {
        StackNode n = new StackNode(data);

        if (isEmpty()) {
            head = n;
            return;
        }
        n.next = head;
        head = n;
    }

    public int pop() {
        if (isEmpty())
            return -1;

        int top = head.data;
        head = head.next;
        return top;
    }

    public int peek() {
        if (isEmpty())
            return -1;
        return head.data;
    }

    public void pushAtBottom(int data, StackClass s) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(data, s);
        s.push(top);
    }

    public void reverseStack(StackClass s) {
        if (s.isEmpty())
            return;

        int top = s.pop();
        reverseStack(s);
        pushAtBottom(top, s);
    }

}
