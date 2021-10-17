package xiji;

import java.util.Scanner;

/**
 * 	队列元素逆置
 * 【问题描述】
 * 已知Q是一个非空队列，S是一个空栈。仅使用少量工作变量以及对队列和栈的基本操作，编写一个算法，将队列Q中的所有元素逆置。
 * 【输入形式】
 * 输入的第一行为队列元素个数，第二行为队列从首至尾的元素
 * 【输出形式】
 * 输出队列的逆置
 * 【样例输入】
 * 3
 * 1 2 3
 * 【样例输出】
 * 3 2 1
 * 【评分标准】
 * 需采用队列与栈的知识，否则不能得分
 */
public class StackAndQueue {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int Size = scanner.nextInt();
        MyQueue queue = new MyQueue(Size + 1);
        MyStack stack = new MyStack(Size);
        for (int i = 0; i < Size; i++) {
            int num = scanner.nextInt();
            queue.offer(num);
        }
        Object data = queue.poll();
        while (data != null) {
            stack.push((int) data);
            data = queue.poll();
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }

    }
}

class MyQueue {
    private int queueElem[];
    private int front;//队尾删除
    private int rear;//队尾插入

    public MyQueue(int MaxSize) {
        this.queueElem = new int[MaxSize];
        front = rear = 0;
    }

    public void clear() {
        front = rear = 0;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public int length() {
        return (rear - front + queueElem.length) % queueElem.length;
    }

    //入队
    public void offer(int data) throws Exception {
        if ((rear + 1) % queueElem.length == front) {
            throw new Exception("队列满了");
        }
        queueElem[rear] = data;
        rear = (rear + 1) % queueElem.length;
    }

    //出队
    public Object poll() {
        if (isEmpty()) {
            return null;
        }
        Object data = queueElem[front];
        front = (front + 1) % queueElem.length;
        return data;
    }

}

class MyStack {
    private int[] stackElem;
    private int top;

    public MyStack(int MaxSize) {
        stackElem = new int[MaxSize];
        top = 0;
    }

    public void clear() {
        top = 0;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(int data) throws Exception {
        if (top == stackElem.length) {
            throw new Exception("栈满");
        }
        stackElem[top++] = data;
    }

    public Object pop() throws Exception {
        if (isEmpty()) {
            return null;
        }
        return stackElem[--top];

    }
}
