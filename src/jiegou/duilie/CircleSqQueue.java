package jiegou.duilie;

public class CircleSqQueue implements IQueue {
    private Object[] queueElem;
    private int front;
    private int rear;

    public CircleSqQueue(int maxSize) {
        front = rear = 0;
        queueElem = new Object[maxSize];
    }

    @Override
    public void clear() {
        front = rear = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public int length() {
        return (rear - front + queueElem.length) % queueElem.length;
    }

    @Override
    public Object peek() {//获取队首元素
        if (isEmpty()) {
            return null;
        }
        return queueElem[front];
    }

    @Override
    //入队列
    public void offer(Object x) throws Exception {
        if ((rear + 1) % queueElem.length == front) {
            throw new Exception("队列已满");
        } else {
            queueElem[rear] = x;
            rear = (rear + 1) % queueElem.length;
        }
    }

    @Override
    //出队列
    public Object poll() {
        if (isEmpty()) {
            return null;
        }
        Object t = queueElem[front];
        front = (front + 1) % queueElem.length;
        return t;
    }

    @Override
    public void display() {
        if (isEmpty()) {
            System.out.println("队列为空");
        } else {
            for (int i = front; i != rear; i = (i + 1) % queueElem.length) {
                System.out.print(queueElem[i].toString() + " ");
            }
            System.out.println();
        }
    }
}
