package cn.edu.usts;

public class PartlyEmployer extends Employer {
    private int hourPay;

    public int getHourPay() {
        return hourPay;
    }

    public void setHourPay(int hourPay) {
        this.hourPay = hourPay;
    }

    public PartlyEmployer() {
        super();
    }

    @Override
    public String toString() {
        return "PartlyEmployer{" +
                "ID='" + super.getId() + '\'' +
                ",Name='" + super.getName() + '\'' +
                ",hourPay='" + hourPay + '\'' +
                '}';
    }

    public PartlyEmployer(int id, String name, int hourPay) {
        super(id, name);
        this.hourPay = hourPay;
    }

    public int calculateWeeklyPay(int hour) {
        return hour * this.hourPay;
    }

    public PartlyEmployer(int hourPay) {
        super(10, "Hello");
        this.hourPay = hourPay;
    }
}
