package jiegou.zhan;

import jiegou.Node;

public class LinkStack implements IStack {
    private Node top;//栈顶


    @Override
    public void clear() {
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int length() {
        Node p = top;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        return length;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return top.data;
    }

    @Override
    public void push(Object x) throws Exception {
        Node p = new Node(x);
        p.next = top;
        top = p;

    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        Object data = top.data;
        top = top.next;
        return data;
    }

    @Override
    public void display() {
        Node p = top;
        while (p != null) {
            System.out.print(p.data.toString() + " ");
            p = p.next;

        }
        System.out.println();
    }

    @Override
    public String toString() {
        Node p = top;
        StringBuilder sb = new StringBuilder();
        while (p != null) {
            sb.append(p.data.toString());
            p = p.next;
        }
        return sb.toString();
    }
}
