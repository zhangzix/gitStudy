package experiment;

public class Student extends Personal {
    private int studentID;
    private String department;
    private String grade;

    public Student() {
    }

    public Student(int studentID, String department, String grade) {
        this.studentID = studentID;
        this.department = department;
        this.grade = grade;
    }

    public String getInfo() {
        return "学生:{学号:" + this.studentID + ",系部:" + this.department + ",年级:" + this.grade + "}";
    }

    @Override
    public String toString() {
        return "学生:{" +
                "学号:" + studentID +
                ", 系部:'" + department + '\'' +
                ", 年级:'" + grade + '\'' +
                '}';
    }

    public void print() {
        System.out.println(this.toString());
    }
}

class TestStudent {
    public static void main(String[] args) {
        Student stu = new Student(19200, "信工院", "大三");
        System.out.println(stu.getInfo());
        stu.print();
    }
}