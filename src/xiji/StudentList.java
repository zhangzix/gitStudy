package xiji;

import java.util.Scanner;

public class StudentList {
    Node head;

    public StudentList() {
        this.head = new Node();
    }

    public void insert(int i, Student data) throws Exception {
        Node p = head;
        int j = -1;
        while (p != null && j < i - 1) {
            p = p.next;
            ++j;
        }
        if (j > i - 1 || p == null)
            throw new Exception("插入位置不合法");
        Node s = new Node(data);
        s.next = p.next;
        p.next = s;
    }

    public void display() {
        Node p = head.next;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] stu_arr = s.split(" ");
        StudentList stuList = new StudentList();
        int i = 0;
        for (String stu_str : stu_arr) {
            String[] stu = stu_str.split(",");
            stuList.insert(i++, new Student(stu[0], stu[1]));
        }
        stuList.display();
    }
}

class Node {
    Student data;
    Node next;

    public Node() {
        this(null, null);
    }

    public Node(Student data) {
        this(data, null);
    }

    public Node(Student data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class Student {
    String num;
    String score;

    public Student(String num, String score) {
        this.num = num;
        this.score = score;
    }

    @Override
    public String toString() {
        return "[" +
                "num=" + num +
                ",score=" + score +
                ']';
    }
}
