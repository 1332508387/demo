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
     * @param data
     */
    public void add(Object data) {
        Node node = new Node(data, null);
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
    public Object get(int index) {
         if (index < 0 || index > size - 1) {
             throw new IndexOutOfBoundsException();
         }
         return getPreNode(index).getData();
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

    /**
     *
     *
     * @return
     */
    public Object remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        Object data = null;

        Node currNode = getPreNode(index);
        Node preNode = getPreNode(index - 1);
        preNode.next = currNode.next;

        if (currNode == head) {
            head = currNode.next;
        }
        if (currNode == tail) {
            tail = preNode;
        }

        data = currNode.data;
        // gc
        currNode.next = null;
        currNode.data = null;

        size--;

        return data;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.print();
        myLinkedList.add("aaa");
        myLinkedList.add("bbb");
        myLinkedList.add("ccc");
        System.out.println("0->" + myLinkedList.get(0));
        System.out.println("2->" + myLinkedList.get(2));
//        System.out.println("2->" + myLinkedList.get(3).getData());
        myLinkedList.print();

        System.out.println();
        myLinkedList.remove(0);
        myLinkedList.remove(0);
        myLinkedList.print();
        System.out.println("size:" + myLinkedList.size());
    }
}
