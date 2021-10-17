package xiji;

import java.util.Scanner;

/**
 * 	栈操作（栈-基本题）
 * 【问题描述】
 * 假设给定的整数栈初始状态为空，栈的最大容量为100。从标准输入中输入一组栈操作，按操作顺序输出出栈元素序列。栈操作：1表示入栈操作，后跟一个整数（不为1、0和-1）为入栈元素；0表示出栈操作；-1表示操作结束。
 * 【输入形式】
 * 从标准输入读取一组栈操作，入栈的整数和表示栈操作的整数之间都以一个空格分隔。
 * 【输出形式】
 * 在一行上按照操作的顺序输出出栈元素序列，以一个空格分隔各元素，最后一个元素后也要有一个空格。如果栈状态为空时进行出栈操作，或栈满时进行入栈操作，则输出字符串“error”，并且字符串后也要有一空格。所有操作都执行完后，栈也有可能不为空。
 * 【样例输入】
 * 1 3 1 5 1 7 0 0 1 8 0 1 12 1 13 0 0 0 0 1 90 1 89 0 -1
 * 【样例输出】
 * 7 5 8 13 12 3 error 89
 */
public class StackDemo {
    private int[] stackElem;
    private int top;


    public StackDemo(int maxSize) {
        this.stackElem = new int[maxSize];
        top = 0;
    }

    public StackDemo() {
        this(100);
    }

    public void clear() {
        top = 0;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int length() {
        return top;
    }

    public void push(int x) throws Exception {
        if (top == stackElem.length) {
            throw new Exception("error");
        }
        stackElem[top++] = x;
    }

    public Object pop() throws Exception {
        if (isEmpty()) {
//            throw new Exception("error");
            return "error";
        }
        return stackElem[--top];
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        StackDemo stack = new StackDemo(100);
        boolean flag = true;
        String line = scanner.nextLine();
        String[] s = line.split(" ");
        for (int i = 0; i < s.length; i++) {
            int t = Integer.parseInt(s[i]);
            if (t == 1) {
                stack.push(Integer.parseInt(s[i + 1]));
            }
            if (t == 0) {
                Object pop = stack.pop();
                System.out.print(pop + " ");
            }
            if (t == -1) {
                break;
            }
        }
    }
}
