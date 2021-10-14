package jiegou.duilie;

import jiegou.Node;

import java.util.Random;

public class LinkQueue implements IQueue {
    private Node front;
    private Node rear;

    public LinkQueue() {
        front = rear = null;
    }

    @Override
    public void clear() {
        front = rear = null;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int length() {
        Node p = front;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        return length;
    }

    @Override
    public Object peek() {
        if (front != null) {
            return front.data;
        }
        return null;
    }

    @Override
    public void offer(Object x) throws Exception {
        Node p = new Node(x);
        if (front != null) {
            rear.next = p;
            rear = p;
        } else
            front = rear = p;
    }

    @Override
    public Object poll() {
        if (front != null) {
            Node p = front;
            front = p.next;
            if (p == rear) {
                rear = null;
            }
            return p.data;
        }
        return null;
    }

    @Override
    public void display() {

    }
}
