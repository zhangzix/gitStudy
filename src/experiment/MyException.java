package experiment;

public class MyException extends Exception {
    public MyException() {
        super("我的个人异常类");
    }

    public MyException(String message) {
        super("鬼一样的异常:" + message);
    }

    public MyException(Throwable cause) {
        super(cause);
    }


}

class A {
    public static void main(String[] args) {
        try {
            throw new MyException("这是啥");
        }catch (MyException e){
            System.out.println("--------");
            System.out.println(e);
            System.out.println("--------");
            e.printStackTrace();
            System.out.println("--------");

        }finally {
            System.out.println("???");
        }
    }
}
