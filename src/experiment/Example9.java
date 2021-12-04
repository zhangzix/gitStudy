package experiment;

/**
 * 实验九 多线程程序设计
 */
public class Example9 {
    public static void main(String[] args) {
        new ExampleT1();
        new ExampleT2();
        new ExampleT3();
    }
}

/**
 * 1、设计一个多线程程序，在2个线程中分别求101--500之间的所有奇数、偶数之和。分别用Thread类和Runnable接口实现。
 */
class ExampleT1 {
    public ExampleT1() {
        new T1().start();
        new Thread(new T2()).start();
    }

    class T1 extends Thread {
        @Override
        public void run() {
            int sum = 0;
            for (int i = 101; i <= 500; i++) {
                if (i % 2 != 0) sum += i;
            }
            System.out.println(currentThread().getName() + " 继承Thread类，奇数和为：" + sum);
        }
    }

    class T2 implements Runnable {
        int sum = 0;

        @Override
        public void run() {
            for (int i = 101; i <= 500; i++) {
                if (i % 2 == 0) sum += i;
            }
            System.out.println(Thread.currentThread().getName() + " 实现Runnable接口，偶数和为：" + sum);
        }
    }
}

/**
 * 2、泰州火车站下面有三个火车票代售点，假如说泰州到南京的火车票总共是20张，如何用程序来实现三个售票点同时卖票的功能。
 */
class ExampleT2 {
    public ExampleT2() {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);
        t1.setName("售票窗口1");
        t2.setName("售票窗口2");
        t3.setName("售票窗口3");
        t1.start();
        t2.start();
        t3.start();
    }

    class Ticket implements Runnable {
        private int num = 30;
        boolean loop = true;

        public void SellOne() {
            synchronized (this) {
                if (num <= 0) {
                    loop = false;
                    System.out.println("售卖结束");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "正在售第" + num-- + "张票");
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (loop) {
                SellOne();
            }
        }
    }
}

/**
 * 3、生产者/消费者问题
 */
class ExampleT3 {
    public ExampleT3() {
        Buffer buffer = new Buffer();
        new Producer(buffer, 101).start();
        new Consumer(buffer, 200).start();
        new Consumer(buffer, 201).start();
    }

    //生产者线程
    class Producer extends Thread {
        private Buffer buffer;
        private int number;

        public Producer(Buffer buffer, int number) {
            this.buffer = buffer;
            this.number = number;
        }

        @Override
        public void run() {
            for (int i = 0; i < 6; ) {
                buffer.put(i);
                System.out.println("生产者#" + number + "生产" + (i++));
                try {
                    Thread.sleep((int) (Math.random() * 2000));
                } catch (InterruptedException exc) {
                }
            }
        }
    }

    //消费者线程
    class Consumer extends Thread {
        private Buffer buffer;
        private int number;


        public Consumer(Buffer buffer, int number) {
            this.buffer = buffer;
            this.number = number;
        }

        public void run() {
            for (int i = 0; i < 3; i++) {
                int v = buffer.get();
                System.out.println("消费者#" + number + "消费" + v);
            }
        }
    }

    //生产者与消费者共享的缓冲区,必须实现读,写的同步
    class Buffer {
        private int contents;
        private boolean available = false;

        public synchronized int get() {
            while (!available) {
                try {
                    this.wait();
                } catch (InterruptedException exc) {
                }
            }
            int value = contents;
            //消费者取出内容,改变存取控制available
            available = false;
            System.out.println("取出" + contents);
            this.notifyAll();
            return value;
        }

        public synchronized void put(int value) {
            while (available) {
                try {
                    this.wait();
                } catch (InterruptedException exc) {
                }
            }
            contents = value;
            //生产者放入内容,改变存取控制available
            available = true;
            System.out.println("放入" + contents);
            this.notifyAll();
        }
    }
    //演示生产者-消费者问题的主程序


}