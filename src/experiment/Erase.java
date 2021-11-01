package experiment;

public interface Erase {
    void erase(String s);
}

class Pencil {
    private String type;

    public Pencil() {
        this("unknown");
    }

    public Pencil(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void write(String s) {
        System.out.println("使用铅笔写了" + s);
    }

    @Override
    public String toString() {
        String r;
        r = "一只铅笔";
        if (this.type != null && this.type.length() != 0) {
            r += "，其类型是" + this.type;
        }
        return r;
    }
}

class RubberPencil extends Pencil implements Erase {

    public RubberPencil() {
    }

    public RubberPencil(String type) {
        super(type);
    }

    @Override
    public void erase(String s) {
        System.out.println("使用橡皮铅笔擦除:" + s);
    }

    @Override
    public void write(String s) {
        System.out.println("使用" + getType() + "橡皮铅笔书写: " + s);
    }

    @Override
    public String toString() {
        String r = "一直橡皮铅笔";
        if (getType() != null && getType().length() != 0) {
            r += ",其类型是" + getType();
        }
        return r;
    }
}

class Test1 {
    public static void main(String[] args) {
        Pencil pen = null;
        pen = new Pencil("2B");
        System.out.println(pen);
        pen.write("2B");
        System.out.println();
        pen = new RubberPencil("4B");
        System.out.println(pen);
        pen.write("这是啥");
        if (pen instanceof RubberPencil) {
            pen = (RubberPencil) pen;
            ((RubberPencil) pen).erase("这是啥");
        }
    }
}