package experiment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *  面向对象实验10 第3题Client
 */
public class ExampleClient03 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4001);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String name = scanner.nextLine();
        new Client3OutputThread(socket, name).start();
        new Client3InputThread(socket, name).start();
    }

    static class Client3OutputThread extends Thread {
        Socket socket;
        String name;
        boolean loop = true;

        public Client3OutputThread(Socket socket, String name) {
            super(name + "-Thread ");
            this.socket = socket;
            this.name = name;
        }

        @Override
        public void run() {
            PrintWriter out = null;
            BufferedReader reader = null;
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                reader = new BufferedReader(new InputStreamReader(System.in));
                out.println(name + " go online");
                out.flush();
                while (loop) {
                    String line = reader.readLine();
                    if (line.equals("exit")) {
                        loop = false;
                        line = " 退出";
                    }
                    out.println(name + " : " + line);
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    reader.close();
                    out.close();
                } catch (Exception e) {

                }
            }
        }
    }

    static class Client3InputThread extends Thread {
        Socket socket;
        boolean loop = true;

        public Client3InputThread(Socket socket, String name) {
            super(name);
            this.socket = socket;
        }

        @Override
        public void run() {
            BufferedReader reader = null;
            String line = null;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf8"));
                while (true) {
                    if ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                }
            } catch (Exception e) {

            }

        }
    }
}

