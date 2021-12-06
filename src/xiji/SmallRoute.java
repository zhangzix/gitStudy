package xiji;

import java.util.Scanner;

/**
 * 【问题描述】
 * 给定一张图，一个起点和一个终点，寻找最短的路径
 * 【输入形式】
 * 先输入一张图，然后输入起点和终点(大写字母表示，字典序)
 * 【输出形式】
 * 最短路径长度
 */
public class SmallRoute {
    public static final String VEX = "ABCDEFG";

    public final static int INFINITY = Integer.MAX_VALUE;

    public static void main(String[] args) {
        boolean[][] P;
        int[] D;
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] lines = line.split(" ");
        int vexNum = lines.length;
        int[][] arr = new int[vexNum][vexNum];
        for (int i = 0; i < vexNum; i++) {
            int x = Integer.parseInt(lines[i]);
            if (x == -1)
                x = INFINITY;
            arr[0][i] = x;
        }
        for (int i = 1; i < arr.length; i++) {
            line = scanner.nextLine();
            lines = line.split(" ");
            for (int j = 0; j < vexNum; j++) {
                int x = Integer.parseInt(lines[j]);
                if (x == -1)
                    x = INFINITY;
                arr[i][j] = x;
            }
        }
        int startIndex = VEX.indexOf(scanner.next());
        int stopIndex = VEX.indexOf(scanner.next());

        P = new boolean[vexNum][vexNum];
        D = new int[vexNum];

        boolean[] finish = new boolean[vexNum];

        for (int v = 0; v < vexNum; v++) {
            finish[v] = false;
            D[v] = arr[startIndex][v];
            for (int w = 0; w < vexNum; w++)
                P[v][w] = false;
            if (D[v] < INFINITY) {
                P[v][startIndex] = true;
                P[v][v] = true;
            }
        }

        D[startIndex] = 0;
        finish[startIndex] = true;
        int v = -1;
        for (int i = 0; i < vexNum; i++) {
            int min = INFINITY;
            for (int w = 0; w < vexNum; w++) {
                if (!finish[w])
                    if (D[w] < min) {
                        v = w;
                        min = D[w];
                    }
            }
            finish[v] = true;
            for (int w = 0; w < vexNum; w++) {
                if (!finish[w] && arr[v][w] < INFINITY && (min + arr[v][w] < D[w])) {
                    D[w] = min + arr[v][w];
                    System.arraycopy(P[v], 0, P[w], 0, P[v].length);
                    P[w][w] = true;
                }
            }

        }

        System.out.println(D[stopIndex]);
    }
}

