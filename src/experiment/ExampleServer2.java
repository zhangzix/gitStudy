package experiment;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 面向对象实验10 第2题Server
 */
public class ExampleServer2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        boolean listening = true;
        int clientNumber = 0;
        try {
            serverSocket = new ServerSocket(4001);
        } catch (IOException e) {
            System.err.println("无法链接到4001端口");
            System.exit(-1);
        }

        while (listening) {
            Socket socket;
            socket = serverSocket.accept();//程序将在此等候客户端的连接
            System.out.println("Client" + clientNumber + "链接成功");
            clientNumber++;
            new CircleArea(socket, clientNumber).start();
        }
    }

    static class CircleArea extends Thread {
        Socket socket;
        int clientNum;

        public CircleArea(Socket socket, int clientNum) {
            super("Client " + clientNum);
            this.socket = socket;
            this.clientNum = clientNum;
        }

        @Override
        public void run() {
            BufferedReader bfr = null;
            PrintWriter out = null;
            String readLine = null;
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                bfr = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf8"));
                while ((readLine = bfr.readLine()) != null) {
                    try {
                        String msg = "";
                        double radius = Double.parseDouble(readLine);
                        msg = "圆的半径为:" + radius + ",面积为:" + radius * radius * Math.PI;
                        System.out.println("Client" + clientNum + " [" + msg + "]");
                        out.println(msg);
                        out.flush();
                    } catch (NumberFormatException e) {
                        out.println("请输入数字类型");
                        out.flush();
                    }
                }

            } catch (Exception e) {

            }
        }
    }
}