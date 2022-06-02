package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        
        tree.add(100);
        tree.add(50);
        tree.add(11);
        tree.add(17);
        tree.add(52);
        tree.add(130);
        tree.add(320);
        tree.add(56);
        tree.add(111);
        tree.add(57);
        tree.add(10);
        tree.add(114);
        tree.add(54);
        tree.add(12);
        tree.add(81);
        tree.add(32);
        tree.add(9);
        tree.add(7);
        tree.add(8);
        tree.add(6);
        tree.add(5);
        tree.add(4);

        tree.PreorderPrint(tree.root);
        System.out.println();
        tree.InorderPrint(tree.root);
        System.out.println();
        tree.PostorderPrint(tree.root);
        System.out.println();

        tree.levelOrderTraversal(tree.root);

        System.out.println();
        tree.printRootToLeaf(tree.root, new ArrayList<Integer>());

    }
}
