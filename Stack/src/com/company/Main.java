package com.company;

public class Main {

    public static void main(String[] args) {
	StackClass s = new StackClass();

    s.push(1);
    s.push(8);
    s.push(2);
    s.push(3);

    s.pop();

    s.pushAtBottom(3,s);

    s.reverseStack(s);

    while (!s.isEmpty()) {
        System.out.print(s.peek() + " ");
        s.pop();
    }


    }
}
