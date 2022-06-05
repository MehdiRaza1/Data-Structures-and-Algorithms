package com.company;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class LinkedList {

    Node head;
    int length = 0;

    public void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public int length() {

        if (head == null) return 0;

        int size = 0;

        Node temp = head;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public Node insertNodeAtFirst(int data) {

        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
        length++;
        return head;
    }

    public Node insertNodeAtLast(Node head,int element) {

        Node newNode = new Node(element);

        if (head == null) {
            head = newNode;
            return head;
        }
        Node temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        length++;
        return head;
    }

    public Node insertNode(int element, int position) {
        Node newNode = new Node(element);
        if (position < 1 || position > length()) {
            System.out.println("Invalid Position");
        } else if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node previous = head;
            int counter = 1;
            while(counter < position - 1) {
                previous = previous.next;
                counter++;
            }
            Node temp = previous.next;
            newNode.next = temp;
            previous.next = newNode;
        }
        length++;
        return newNode;
    }

    public Node deleteFirstNode() {
        if (head == null)
            return null;

        head = head.next;
        length--;
        return head;
    }

    public Node deleteLastNode() {

        if (head == null || head.next == null)
            return head;

        Node previous = null;
        Node current = head;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        length--;
        return current;
    }

    public void deleteNode(int position) {
        if (position < 1 || position > length()) {
            System.out.println("Invalid Position");
        } else if (position == 1) {
            head = head.next;
            } else {
            Node previous = head;
            int counter = 1;
            while(counter < position) {
                previous = previous.next;
                counter++;
            }
            Node temp = previous.next;
            previous.next = temp.next;
        }
        length--;
    }

    public void removeKey(int key) {

        if (head == null)
            return;

        if (head.data == key) {
            head = head.next;
            length--;
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != null && current.data != key) {
            previous = current;
            current = current.next;
        }

        if (current == null) return;

        previous.next = current.next;
        length--;
    }

    public static void removeDuplicatesFromUnsortedList(Node head) {
        // Hash to store seen values
        HashSet<Integer> hs = new HashSet<>();

        /* Pick elements one by one */
        Node current = head;
        Node prev = null;
        while (current != null) {
            int currentValue = current.data;

            // If current value is seen before
            if (hs.contains(currentValue)) {
                prev.next = current.next;
            } else {
                hs.add(currentValue);
                prev = current;
            }
            current = current.next;
        }
    }

    public void removeDuplicateInSortedList() {

        if (head == null) return;

        Node temp = head;

        while (temp != null && temp.next!=null) {

            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
                length--;
            } else
                temp = temp.next;
        }
    }

    public boolean search(Node head ,int searchKey) {

        if (head == null)
            return false;

        Node temp = head;
        while (temp != null /*&& temp.data == searchKey*/) {
            if (temp.data == searchKey)
                return true;
        }
        return false;
    }

    static boolean compareLists(Node head1, Node head2) {

        if (head1 == null && head2 == null)
            return true;

        if (head1 == null && head2 != null || head1 != null && head2 == null)
            return false;

        if (head1.data != head2.data)
            return false;

        return compareLists(head1.next, head2.next);
    }

    public static void reversePrint(Node head) {
        if (head == null) return;
        reversePrint(head.next);
        System.out.println(head.data);
    }

    public Node reverseList(Node head) {
        if (head == null)
            return null;

        Node temp = head;
        Node previous = null;
        Node next = null;

        while (temp != null) {
            next = temp.next;
            temp.next = previous;
            previous = temp;
            temp = next;
        }
        return previous;
    }

    public Node RecursiveReverseList(Node head) {
        if (head == null || head.next == null)
            return head;

        Node newHead = RecursiveReverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public void removeAll (int x) {

        if (head == null) return;

        while (head.data == x) {
            head = head.next;
            length--;
            if (head == null)
                break;
        }

        if (head != null) {

            Node temp = head;

            while (temp.next != null) {

                if (temp.next.data == x) {
                    temp.next = temp.next.next;
                    length--;
                } else
                    temp = temp.next;
            }
        }
    }

    public void removeGreaterThanX (int x) {

        if (head == null)
            return;

            while (head.data > x) {
                head = head.next;
                length--;
                if (head == null)
                    break;
            }

        if (head != null) {

            Node temp = head;

            while (temp.next != null) {

                if (temp.next.data > x) {
                    temp.next = temp.next.next;
                    length--;
                } else
                    temp = temp.next;

            }
        }
    }

    public Node insertNodeInSortedList(Node head,int data) {

        Node newNode = new Node(data);
        length++;
        if (head == null) {
            return newNode;
        } else if (head.data > newNode.data) {
            newNode.next = head;
            return newNode;
        } else {
        Node current = head;
        Node temp = null;

        while (current != null && current.data < newNode.data) {
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
        return head;
        }
    }

    public Node findMiddle(Node head) {

        if (head == null) return null;

        Node midNode = head;
        Node lastNode = head;
        while (lastNode != null && lastNode.next != null) {
            midNode = midNode.next;
            lastNode = lastNode.next.next;
        }
        return midNode;
    }

    public Node nodeFromTail(Node head, int n) {

        Node ptr = head;
        int counter = 0;

        while (head != null) {
            head = head.next;

            if (counter < n)
                counter++;
            else if (head != null)
                ptr = ptr.next;
        }
        return ptr;
    }

    public boolean containsLoop() {
        Node fastPtr = head;
        Node slowPtr = head;

        while (fastPtr!=null && fastPtr.next!=null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr)
                return true;
        }
        return false;
    }

    public Node startOfCycle(Node head) {

        Node fastPtr = head;
        Node slowPtr = head;

        while(fastPtr!=null && fastPtr.next!=null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }

    public Node getStartingNode(Node slowPtr) {
        Node temp = head;
        while (temp!=slowPtr) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }

    public void endCycle(Node head) {
        Node fastPtr = head;
        Node slowPtr = head;

        while(fastPtr!=null && fastPtr.next!=null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                removeLoop(slowPtr);
                return;
            }
        }
    }

    private void removeLoop(Node slowPtr) {
        Node temp = head;
        while (slowPtr.next!=temp.next) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
    }

    public Node mergeLists(Node head1, Node head2) {

        if (head1 == null) 
            return head2;
        if (head2 == null) 
            return head1;

        Node temp = null;

        if (head1.data < head2.data) {
            temp = head1;
            head1 = head1.next;
        } else {
            temp = head2;
            head2 = head2.next;
        }
        // Node temp = new Node(Integer.MIN_VALUE);
        Node tail = temp;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        if (head1==null)
            tail.next = head2;
        else if (head2 == null)
            tail.next = head1;

        return temp;
    }

    public static int findMergeNode(Node head1, Node head2) {

        Node temp1 = head1;
        Node temp2 = head2;

        while(temp1 != temp2) {
            if (temp1.next == null)
                temp1 = head2;
            else
                temp1 = temp1.next;

            if (temp2.next == null)
                temp2 = head1;
            else
                temp2 = temp2.next;
            }
        return temp1.data;
    }

    public Iterator<Integer> iterator() {
        Iterator<Integer> it = new Iterator<Integer>() {
            Node temp = head;
            @Override
            public boolean hasNext() {
                return temp != null;
            }
            @Override
            public Integer next() {
                if (temp == null) {
                    return null;
                }
                Integer value = temp.data;
                temp = temp.next;
                return value;
            }
        };
        return it;
    }

    public Object[] toArray() {
        Object[] result = new Object[length()];
        int i = 0;
        for (Node x = head; x != null; x = x.next)
            result[i++] = x.data;
        return result;
    }

    public boolean removeAll(Collection<?> c) {
        Objects.requireNonNull(c);
        boolean modified = false;
        Iterator<?> it = iterator();
        while (it.hasNext()) {
            if (c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    public boolean retainAll(Collection<?> c) {
        Objects.requireNonNull(c);
        boolean modified = false;
        Iterator<Integer> it = iterator();
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    public void clear() {
        Iterator<Integer> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public void swapNodes(int n1, int n2) {

        if(head == null || n1 == n2) {
            return;
        }

        Node prevNode1 = null, prevNode2 = null;
        Node node1 = head, node2 = head;

        //Search for node1
        while(node1 != null && node1.data != n1){
            prevNode1 = node1;
            node1 = node1.next;
        }

        //Search for node2
        while(node2 != null && node2.data != n2){
            prevNode2 = node2;
            node2 = node2.next;
        }

        if(node1 != null && node2 != null) {

            //If previous node to node1 is not null then, it will point to node2
            if(prevNode1 != null)
                prevNode1.next = node2;
            else
                head  = node2;

            //If previous node to node2 is not null then, it will point to node1
            if(prevNode2 != null)
                prevNode2.next = node1;
            else
                head  = node1;

            //Swaps the next nodes of node1 and node2
            Node temp = node1.next;
            node1.next = node2.next;
            node2.next = temp;
        }
        else {
            System.out.println("Swapping is not possible");
        }
    }

    private static void swap(Node n1, Node n2) {
        int temp = n1.data;
        n1.data = n2.data;
        n2.data = temp;
    }

    public static void bubbleSort(Node head ) {
        if (head == null) return;

        Node firstVal = head;
        while (firstVal != null) {
            Node secondVal = firstVal.next;
            while (secondVal != null) {

                if (firstVal.data > secondVal.data)
                    swap(firstVal, secondVal);

                secondVal = secondVal.next;
            }
            firstVal = firstVal.next;
        }
    }

    public static void booleanBubbleSort(Node head) {
        if (head == null) return;

        Node current = null;
        boolean status = false;

        do {
            current = head;
            status = false;
            while (current != null && current.next != null)
            {
                if (current.data > current.next.data) {
                    swap(current, current.next);
                    status = true;
                }
                current = current.next;
            }
        } while (status);
    }

    public void selectionSortList(Node head) {

        if(head == null)
            return;

        Node current = head;

            while(current != null) {
                //Node index will point to node next to current
                Node index = current.next;

                while(index != null) {
                    //If current node's data is greater than index's node data, swap the data between them
                    if(current.data > index.data)
                        swap(current, index);

                    index = index.next;
                }
                current = current.next;
            }
    }

    public Node lastNode() {
        Node temp = this.head;

        while (temp != null && temp.next != null)
            temp = temp.next;

        return temp;
    }

    public Node partition(Node first, Node last) {

        Node pivot = first, front = first;

        while (front != null && front != last) {

            if (front.data < last.data) {
                pivot = first;
                swap(first, front);
                first = first.next;
            }
            front = front.next;
        }
        swap(first, last);
        return pivot;
    }

    public void quickSort(Node first, Node last) {
        if (first == last)
            return;

        Node pivot = partition(first, last);

        if (pivot != null && pivot.next != null)
            quickSort(pivot.next, last);

        if (pivot != null && first != pivot)
            quickSort(first, pivot);

    }

    public Node merge_sort(Node first, Node last) {
        if (first == null || first == last || first.next == null)
            return first;

        Node middle = findMiddle(first);

        Node right_nodes = merge_sort(middle.next, last);

        middle.next = null;

        Node left_nodes = merge_sort(first, middle);

        return merge_list(left_nodes, right_nodes);
    }

    public Node merge_list(Node list1, Node list2) {
        if (list1 == null)
            return list2;

        else if (list2 == null)
            return list1;

        else {
            Node result = null;
            Node tail = null;
            Node node = null;

            while (list1 != null || list2 != null) {
                if (list1 != null && list2 != null) {
                    //When both list contain nodes
                    if (list1.data < list2.data) {
                        //When first list element are smallest
                        node = list1;
                        list1 = list1.next;
                    }
                    else {
                        //When second list element are smallest
                        node = list2;
                        list2 = list2.next;
                    }
                }
                else if (list1 != null) {
                    //When first list contain element
                    //Get sublist
                    node = list1;
                    //Set that list1 empty
                    list1 = null;
                }
                else {
                    //When second list contain element
                    //get sublist
                    node = list2;
                    list2 = null;
                }
                if (result == null) {
                    //When get first node of resultant list
                    result = node;
                }
                else {
                    //Add node at end of resultant list
                    tail.next = node;
                }
                tail = node;
            }
            return result;
        }
    }

}
