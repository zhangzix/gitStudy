package experiment;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Vector;

/**
 * 面向对象实验10 第3题Server
 */
public class ExampleServer03 {
    static Vector<Socket> list = new Vector<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        boolean listening = true;
        int clientNumber = 1;

        try {
            serverSocket = new ServerSocket(4001);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4001.");
            System.exit(-1);
        }

        while (listening) {
            Socket socket;
            socket = serverSocket.accept();
            System.out.println("(Client" + clientNumber + ")链接成功");
            list.add(socket);
            new MultiTalkServerOut(socket, clientNumber).start();
            clientNumber++;
        }
        serverSocket.close();
    }

    static class MultiTalkServerOut extends Thread {
        Socket socket;
        int clientNum;

        public MultiTalkServerOut(Socket socket, int clientNum) {
            super("Client" + clientNum);
            this.socket = socket;
            this.clientNum = clientNum;
        }

        @Override
        public void run() {
            PrintWriter out = null;
            BufferedReader input = null;
            try {
                input = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf8"));
                while (true) {
                    String line = input.readLine();
                    line = "(Client" + clientNum + ") " + line;
                    System.out.println(line);
                    for (Socket tSocket : list) {
                        if (tSocket.isConnected() && socket != tSocket) {
                            out = new PrintWriter(tSocket.getOutputStream(), true);
                            out.println(line);
                            out.flush();
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Client" + clientNum + ":已经下线");
            } finally {
                try {
                    out.close();
                    input.close();
                    socket.close();
                } catch (Exception e) {

                }
            }
        }
    }


}
