package experiment;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 *  面向对象实验10 第2题Client
 */
public class ExampleClient2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4001);
        new PutCircleRadius(socket).start();
        new GetCircleArea(socket).start();
    }

    static class PutCircleRadius extends Thread {
        Socket socket;
        Scanner scanner = new Scanner(System.in);

        public PutCircleRadius(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            PrintWriter out = null;
            try {
                String temp = "";
                out = new PrintWriter(socket.getOutputStream(), true);
                do {
                    temp = scanner.nextLine();
                    out.println(temp);
                    out.flush();
                    if (temp.equals("exit")) break;
                } while (true);

            } catch (Exception e) {

            }
        }
    }

    static class GetCircleArea extends Thread {
        Socket socket;

        public GetCircleArea(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            BufferedReader reader = null;
            try {
                String readLine = null;
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while ((readLine = reader.readLine()) != null) {
                    System.out.println(readLine);
                }
            } catch (IOException e) {

            } finally {
                try {
                    reader.close();
                } catch (Exception e) {

                }
            }
        }
    }
}
