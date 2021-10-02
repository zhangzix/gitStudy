package demo;

import org.junit.Test;

public class Student {
    private Integer StuNum;
    private String StuName;
    private String Gender;

    public Student() {
        this(110, "大哥", "未知");
    }

    public Student(Integer stuNum, String stuName, String gender) {
        StuNum = stuNum;
        StuName = stuName;
        Gender = gender;
    }

    public Integer getStuNum() {
        return StuNum;
    }

    public void setStuNum(Integer stuNum) {
        StuNum = stuNum;
    }

    public String getStuName() {
        return StuName;
    }

    public void setStuName(String stuName) {
        StuName = stuName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StuNum=" + StuNum +
                ", StuName='" + StuName + '\'' +
                ", Gender='" + Gender + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(new Student());
    }
}
