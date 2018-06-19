package com.lh.data_structure.stack;

/**
 * 实现一个后进先出的栈
 */
public class MyStack {
    private static final int DEFAULT_CAPACITY = 1 << 4;
    private int top = -1;
    private Object[] stack;

    public MyStack() {
        this.stack = new Object[DEFAULT_CAPACITY];
    }

    public MyStack(int initCapacity) {
        if (initCapacity == 0) {
            this.stack = new Object[DEFAULT_CAPACITY];
        } else if (initCapacity > 0) {
            this.stack = new Object[initCapacity];
        } else {
            throw new RuntimeException("over flow");
        }
    }

    public Object pop() {
        if (top == -1) {
            return null;
        }
        return stack[top--];
    }

    public boolean push(Object ele) {
        if (top == stack.length) {
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
