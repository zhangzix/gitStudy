package experiment;

import java.util.*;

public class ApplicationTest {

    public static void main(String[] args) {

        Stu stu1 = new Stu(110, "张三", "男");
        Stu stu2 = new Stu(119, "李四", "男");
        Stu stu3 = new Stu(109, "芙蓉", "女");
        Set set = new TreeSet();
        set.add(stu1);
        set.add(stu2);
        set.add(stu3);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class Stu implements Comparable<Stu> {
    public int stuNo;
    public String name;
    public String grade;

    public Stu(int stuNo, String name, String grade) {
        this.stuNo = stuNo;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "stuNo=" + stuNo +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }


    @Override
    public int compareTo(Stu stu) {
        return this.stuNo - stu.stuNo;
    }
}




