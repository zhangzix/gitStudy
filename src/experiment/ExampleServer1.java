package experiment;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  面向对象实验10 第1题Server
 */
public class ExampleServer1 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4001);
        Socket soc = serverSocket.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        String message = "";
        String temp = null;
        do {
            temp = br.readLine();
            if (temp == null) {
                break;
            }
            message = message + temp;
        } while (true);
        br.close();
        PrintStream ps = new PrintStream(new FileOutputStream("message.txt"));
        ps.println(message);
        ps.close();
    }
}
