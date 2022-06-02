package com.company;

public class Main {

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        ll.insertNodeAtLast(ll.head,9);
        ll.insertNodeAtFirst(42);
        ll.insertNodeAtFirst(454);
        ll.insertNodeAtFirst(45);
        ll.insertNodeAtFirst(56);
        ll.insertNodeAtFirst(6);
        ll.insertNodeAtFirst(69);
        ll.insertNodeAtFirst(9);
        ll.insertNodeAtFirst(56);
        ll.insertNodeAtFirst(4);
        ll.insertNodeAtFirst(45);
        ll.insertNodeAtFirst(3);
        ll.insertNodeAtFirst(69);
        ll.insertNodeAtFirst(6);
        ll.insertNodeAtFirst(69);

        ll.insertNode(34,5);

        ll.print(ll.head);

        System.out.println();

        Node newHeadList = ll.RecursiveReverseList(ll.head);

//        ll.deleteLastNode();

//        ll.head = ll.merge_sort(ll.head, ll.lastNode());

        ll.print(newHeadList);

        /*
        ll.bubbleSort(ll.head);

        ll.removeAll(69);

        ll.swapNodes(6,3);

        ll.removeGreaterThanX(1);

        ll.print(ll.head);

        ll.removeAll(69);

        ll.deleteFirstNode();

        Node reversedList = ll.reverseList(ll.head);

        ll.print(reversedList);

        ll.deleteLastNode();

        ll.deleteNode(2);

        ll.removeKey(34);

        System.out.println();

        ll.print(ll.head);
        ll.insertNodeInSortedList(ll.head,5);

        System.out.println();

        Node nthNode = ll.nodeFromTail(ll.head, 3);
        System.out.println(nthNode.data);

        ll.print(ll.head);

        System.out.println();

        System.out.println(ll.length());

        Node middleNode = ll.findMiddle(ll.head);

        System.out.println(middleNode.data);

        System.out.println();

        DoublyList dll = new DoublyList();

        dll.insertLast(142);
        dll.insertLast(9);
        dll.insertLast(5);
        dll.insertLast(11);
        dll.insertLast(332);
        dll.insertLast(332);
        dll.insertLast(35);
        dll.insertLast(34);

        dll.insertFirst(234);

        dll.printDoublyList();
        System.out.println();
        dll.printDoublyListInReverse();
        System.out.println();

        dll.deleteFirst();
        dll.deleteFirst();
        dll.deleteFirst();

        dll.deleteLast();
        dll.deleteLast();

        dll.printDoublyList();
        System.out.println();
        dll.printDoublyListInReverse();
        System.out.println();

        CircularList cll = new CircularList();

        cll.insertFirstInCircularList(23);
        cll.insertFirstInCircularList(3);
        cll.insertFirstInCircularList(2);

        cll.removeFirstNode();

        cll.printCircularList();

         */


    }
}
