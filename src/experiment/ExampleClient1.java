package experiment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * 面向对象实验10 第1题Client
 */
public class ExampleClient1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4001);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入消息至服务器");
        String message = "";
        String temp;
        while (!(temp = br.readLine()).equals("send")) {
            message = message + temp + "\n";
        }

        PrintStream ps = new PrintStream(socket.getOutputStream());
        ps.print(message);

        ps.close();
        socket.close();
    }
}
