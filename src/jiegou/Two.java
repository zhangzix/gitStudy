package jiegou;

import java.util.Scanner;

/**
 * 【问题描述】
 * 输入n个整数，创建一个双向循环链表进行存储。这些整数从第二个开始，递增有序（设a2<a3<...<an） (ai为第i个整数)。
 * 试编写程序，创建双向循环链表，依次将输入的整数存储在该链表的各节点中。然后，将第一个结点删除并插入链表中的适当位置，使整个链表递增有序。
 * 【输入形式】
 * 先输入整数的个数，再输入整数列。
 * 【输出形式】
 * 以整数递增的顺序，依次输出双向循环链表各个节点存储的整数。
 * 【样例输入】5 3 1 2 4 5
 * 【样例输出】
 * 1 2 3 4 5
 */
public class Two {
    DoubleNode head;

    public Two() {
        this.head = new DoubleNode();
        head.preNode = head;
        head.nextNode = head;
    }

    public void insert(int i, int num) throws Exception {
        DoubleNode p = head.nextNode;
        int j = 0;
        while (!p.equals(head) && j < i) {
            p = p.nextNode;
            ++j;
        }
        if (j != i && p.equals(head)) {
            throw new Exception("插入位置不合法");
        }
        DoubleNode node = new DoubleNode(num);
        p.preNode.nextNode = node;
        node.preNode = p.preNode;
        node.nextNode = p;
        p.preNode = node;
    }

    public void display() {
        DoubleNode node = head.nextNode;
        while (!node.equals(head)) {
            System.out.print(node.data + " ");
            node = node.nextNode;
        }
        System.out.println();
    }

    public int getNum(int i) throws Exception {
        DoubleNode p = head.nextNode;
        int j = 0;
        while (!p.equals(head) && j < i) {
            p = p.nextNode;
            ++j;
        }
        if (j != i)
            throw new Exception("删除位置不合理");
        return p.data;
    }

    public int remove(int i) throws Exception {
        DoubleNode p = head.nextNode;
        int j = 0;
        while (!p.equals(head) && j < i) {
            p = p.nextNode;
            ++j;
        }
        if (j != i)
            throw new Exception("删除位置不合理");
        int data = p.data;
        p.preNode.nextNode = p.nextNode;
        p.nextNode.preNode = p.preNode;
        return data;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Two two = new Two();

        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            two.insert(i,sc.nextInt());
        }
        int data = two.remove(0);
        for (int i = 0; i <= size; i++) {
            if (i == size) {
                two.insert(size-1, data);
                break;
            }
            int tNum = two.getNum(i);
            if (data <= tNum) {
                two.insert(i, data);
                break;
            }
        }
        two.display();


    }
}

class DoubleNode {
    int data;
    DoubleNode preNode = this;
    DoubleNode nextNode = this;

    public DoubleNode() {
    }

    public DoubleNode(int data) {
        this.data = data;
    }

    //增加节点
    public void after(DoubleNode node) {
        DoubleNode nextNext = nextNode;
        this.nextNode = node;
        node.preNode = this;
        node.nextNode = nextNext;
        nextNext.preNode = node;

    }

    //获取下一个节点
    public DoubleNode getNextNode() {
        return this.nextNode;
    }

    //获取上一个节点
    public DoubleNode getPreNode() {
        return this.preNode;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}
