package com.company;

import java.util.ArrayList;

public class ArrayListStack {
    ArrayList<Integer> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void add(int data) {
        list.add(data);
    }

    public int pop() {

        if (isEmpty())
            return -1;

        int top = list.get(list.size()-1);
        list.remove(list.size()-1);
        return top;
    }

    public int peek() {
        if (isEmpty())
            return -1;
        return list.get(list.size())-1;
    }
}
