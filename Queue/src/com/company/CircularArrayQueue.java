package com.company;

public class CircularArrayQueue {
    int arr[];
    int size;
    int rear = -1;
    int front = -1;

    CircularArrayQueue(int n) {
        arr = new int[n];
        this.size = n;
    }

    public boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    public boolean isFull() {
        return (rear+1) % size == front;
    }

    public void add(int data) {

        if (isFull()) {
            System.out.println("Full Queue");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % size;
        arr[rear] = data;
    }

    public int remove() {
        if (isEmpty())
            return -1;

        int result = arr[front];

        if (rear == front)
            rear = front = -1;
        else
            front = (front+1) % size;

        return front;
    }

    public int peek() {
        if (isEmpty())
            return -1;

        return arr[front];
    }

}
