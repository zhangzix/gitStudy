package cn.edu.usts;

public class FullTimeEmployer extends Employer {
    private int yearPay;

    public FullTimeEmployer(int yearPay) {
        this.yearPay = yearPay;
    }

    public FullTimeEmployer() {
        super();
    }

    @Override
    public String getStatus() {
        return "FullTime";
    }

    public FullTimeEmployer(int id, String name, int yearPay) {
        super(id, name);
        this.yearPay = yearPay;
    }

    @Override
    public String toString() {
        return "FullTimeEmployer{" +
                "ID=" + super.getId() +
                ",Name=" + super.getName() +
                ",yearPay=" + yearPay +
                '}';
    }

    public int getYearPay() {
        return yearPay;
    }

    public void setYearPay(int yearPay) {
        this.yearPay = yearPay;
    }

    public int calculateYearPay(int year) {
        return year * this.yearPay;
    }
}
