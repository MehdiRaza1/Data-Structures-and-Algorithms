package com.company;

import java.util.*;

public class BinarySearchTree {

    public Node root;

    public BinarySearchTree() {    }

    public void add(int element) {
        root = add(root, element);
    }

    private Node add(Node root, int data) {

        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data)
            root.left = add(root.left, data);
        else
            root.right = add(root.right, data);

        return root;
    }

    public void buildBST(Node root, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
    }

    public void PreorderPrint(Node root) {

        if (root == null) return;

        System.out.print(root.data + " ");
        PreorderPrint(root.left);
        PreorderPrint(root.right);
    }

    public void InorderPrint(Node root) {

        if (root == null) return;

        InorderPrint(root.left);
        System.out.print(root.data + " ");
        InorderPrint(root.right);
    }

    public void PostorderPrint(Node root) {

        if (root == null) return;

        PostorderPrint(root.left);
        PostorderPrint(root.right);
        System.out.print(root.data + " ");
    }

    public void printLevelCount() {
        int count = getLevelCount(root);
        System.out.println(count);
    }

    private int getLevelCount(Node root) {

        if (root == null) return 0;

        int left = getLevelCount(root.left);
        int right = getLevelCount(root.right);

        return Math.max(left, right) + 1;
    }

    public static Node lca(Node root, int v1, int v2) {

        if (root == null)
            return null;

        if(v1>root.data && v2>root.data)
            return lca(root.right, v1, v2);

        if(v1<root.data && v2<root.data)
            return lca(root.left, v1, v2);

        return root;
    }

    public void levelOrderTraversal(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null)
                q.offer(temp.left);
            if (temp.right != null)
                q.offer(temp.right);
        }
    }

    public static class NodeLevel{
        Node node;
        Integer level;
        NodeLevel(Node node, Integer level) {
            this.node= node;
            this.level = level;
        }
    }

    public static void topView(Node root) {

        Queue<NodeLevel> q = new LinkedList<NodeLevel>();

        Map<Integer,Integer> tm = new TreeMap<Integer,Integer>();

        if (root == null) return;

        q.add(new NodeLevel(root, 0));

        while(!q.isEmpty()) {
            NodeLevel temp = q.poll();
            Node temp1 = temp.node;
            Integer level = temp.level;
            if(!tm.containsKey(level)) {
                tm.put(level, temp1.data);
            }
            if (temp1.left != null) {
                q.add(new NodeLevel(temp1.left, level-1));
            }
            if (temp1.right != null) {
                q.add(new NodeLevel(temp1.right, level+1));
            }
        }
        for(Map.Entry<Integer,Integer> e : tm.entrySet()) {
            System.out.print(e.getValue() + " ");
        }

    }

    public boolean search(int data) {
        return search(root, data);
    }

    private boolean search(Node root, int data) {

        if(root == null)
            return false;

        if(data < root.data)
            return search(root.left, data);
        else if(root.data == data)
            return true;
        else
            return search(root.right, data);
    }

    public void deleteNode(int data) { root = deleteNode(root, data); }

    public Node deleteNode(Node root, int data) {

        if (root == null)
            return null;

        if (data < root.data)
            root.left = deleteNode(root.left, data);
        else if (data > root.data)
            root.right = deleteNode(root.right, data);
            // if data is same as root's data, then This is the node to be deleted
        else {
            if (root.left == null && root.right == null)
                return null;
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.data = minValue(root.right);
            // Delete the inorder successor
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    public int minValue(Node root) {
        int minVal = root.data;
        while (root.left != null) {
            minVal = root.left.data;
            root = root.left;
        }
        return minVal;
    }

    public void printINRange(Node root, int X, int Y) {

        if (root == null)
            return;

        if (X <= root.data && Y >= root.data) {
            printINRange(root.left, X, Y);
            System.out.print(root.data + " ");
            printINRange(root.right, X, Y);
        } else if (Y <= root.data) {
            printINRange(root.left, X, Y);
        } else {
            printINRange(root.right, X, Y);
        }
    }

    public void printRootToLeaf(Node root, ArrayList<Integer> path) {

        if (root == null)
            return;

        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(path);
        } else {
            printRootToLeaf(root.left, path);
            printRootToLeaf(root.right, path);
        }
        path.remove(path.size()-1);
    }

    public void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++)
            System.out.print(path.get(i) + "->");
        System.out.println();
    }

    public boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean checkBST(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.data < min || root.data > max)
            return false;

        return (checkBST(root.left, min, root.data-1) && checkBST(root.right, root.data+1, max));
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }

}
