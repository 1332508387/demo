package com.lh.data_structure.stack;

public class MyStack {
    private static final int CAPACITY = 1 << 4;
    private int top = -1;
    private Object[] stack = new Object[CAPACITY];

    public Object pop() {
        if (top == -1) {
            return null;
        }
        return stack[top--];
    }

    public boolean push(Object ele) {
        if (top == CAPACITY - 1) {
            return false;
        }
        stack[++top] = ele;
        return true;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        System.out.println(myStack.isEmpty());
        myStack.push("aaa");
        myStack.push("bbb");
        myStack.push("ccc");
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.isEmpty());
    }

}
