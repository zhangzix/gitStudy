package jiegou;

import java.util.Scanner;

public class Node {
    public Student data;
    public Node next;

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

    public static void main(String[] args) {
        /**
         * 201,98 202,94 203,89
         * 201,0 202,0 203,0
         * 201,98 202,98 203,98
         */
        try {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            String[] stu_arr = s.split(" ");
            for (String stu_str : stu_arr) {
                String[] stu = stu_str.split(",");
                Student student = new Student(stu[0], stu[1]);

                System.out.println(student);
            }
        } catch (Exception e) {

        }

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
