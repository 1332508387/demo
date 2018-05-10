package com.lh.collection;

import java.awt.print.PrinterGraphics;
import java.util.Random;

public class MyTree {
    private Node root;

    private static class Node {
        Integer value;
        Node left;
        Node right;

        public Node() {
        }

        public Node(Integer value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public void add(Integer value) {
        if (root == null) {
            root = new Node(value, null, null);
        } else {
            getLeaf(root, new Node(value, null, null));
        }

    }

    private boolean getLeaf(Node parent, Node curr) {
        if (curr.value < parent.value) {
            if (parent.left == null) {
                parent.left = curr;
                return true;
            } else {
                getLeaf(parent.left, curr);
            }
        } else if (curr.value > parent.value) {
            if (parent.right == null) {
                parent.right = curr;
                return true;
            }
            getLeaf(parent.right, curr);
        }
        return false;
    }

    public void scanner(Node root) {
        if (root.left != null)
            scanner(root.left);
        System.out.print(root.value + " ");
        if (root.right != null)
            scanner(root.right);
    }

    public void scanner() {
        scanner(root);
    }

    public Node search(Integer value) {
        Node currNode = root;
        while (true) {
            if (currNode == null) {
                break;
            }
            if (value == currNode.value) {
                return currNode;
            }
            if (value < currNode.value) {
                currNode = currNode.left;
            }
            if (value > currNode.value) {
                currNode = currNode.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MyTree myTree = new MyTree();
//        Random random = new Random();
//
//        for (int i = 0; i < 50; i++) {
//            int num = random.nextInt(10000);
//            System.out.print(num + " ");
//
//            myTree.add(num);
//        }
//        System.out.println();
        myTree.add(25);
        myTree.add(32);
        myTree.add(75);
        myTree.add(100);
        myTree.add(35);
        myTree.add(10);
        myTree.scanner();

        System.out.println();
        Node node = myTree.search(75);
        if (node == null) {
            System.out.println("未找到");
        } else {
            System.out.println(node);
        }
        System.out.println();
        System.out.println(myTree.root);
    }
}
