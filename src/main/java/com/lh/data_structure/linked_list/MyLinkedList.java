package com.lh.data_structure.linked_list;

/**
 * 链表的实现
 */
public class MyLinkedList {
    private int size;
    private Node head;
    private Node tail;

    static class Node {
        private Object data;
        private Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }
    }

    /**
     * 项链表中添加节点
     *
     * @param node
     */
    public void add(Node node) {
        if (head == null) {
            head = node;
            tail = head;
        } else {
            Node preNode = getPreNode(size - 1);
            preNode.next = node;
            tail = preNode.next;
        }
        size++;
    }

    private Node getPreNode(int index) {
        Node currNode = head;
        if (currNode == null) {
            throw new RuntimeException("list is empty");
        }
        for (int i = 0; i < index; i++) {
            currNode = currNode.next;
        }
        return currNode;
    }

    /**
     * 获取指定索引位置节点
     *
     * @param index
     * @return
     */
    public Node get(int index) {
         if (index < 0 || index > size - 1) {
             throw new IndexOutOfBoundsException();
         }
         return getPreNode(index);
    }

    /**
     * 遍历链表
     */
    public void print() {
        Node currNode = head;
        if (currNode == null) {
            System.out.println("null");
        }
        for (int i = 0; i < size; i++) {
            System.out.println(currNode.data);
            currNode = currNode.getNext();
        }
    }


    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.print();
        myLinkedList.add(new Node("aaa", null));
        myLinkedList.add(new Node("bbb", null));
        myLinkedList.add(new Node("ccc", null));
        System.out.println("0->" + myLinkedList.get(0).getData());
        System.out.println("2->" + myLinkedList.get(2).getData());
        myLinkedList.print();
    }
}
