package cn.edu.test;

import cn.edu.usts.Employer;
import cn.edu.usts.FullTimeEmployer;
import cn.edu.usts.PartlyEmployer;

public class EmployerTest {
    public static void main(String[] args) {
        Employer employer = new Employer(100,"abc");
        System.out.println(employer);
        PartlyEmployer employer1 = new PartlyEmployer(110, "zzz", 16);
        System.out.println(employer1);
        System.out.println(employer1.calculateWeeklyPay(10));
        FullTimeEmployer employer2 = new FullTimeEmployer(111, "abc123", 5);
        System.out.println(employer2);
        System.out.println(employer2.calculateYearPay(10));
    }
}
