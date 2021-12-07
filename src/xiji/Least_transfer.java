package xiji;

import java.util.Scanner;

/**
 * 图编程作业-专转本与民办通用 编程题 2. 最少转机
 * 【问题描述】
 * 小明坐飞机去旅游，他收集了很多航班信息。城市用整数1、2、3等进行编号，给出小明所在的城市和目标城市，请计算出最少的转机次数。
 * 【输入形式】
 * 第一行，两个整数n和m，用空格分隔，分别表示城市总数和航线条数。
 * 第二行值第m+1行，每行两个用空格分隔的整数，表示一条航线的起点城市和终点城市。
 * 第m+2行，两个用空格分隔的整数，表示小明所在的城市和目标城市
 * 【输出形式】
 * 一个整数，最小转机次数。
 */
public class Least_transfer {
    public final static int INFINITY = Integer.MAX_VALUE;

    public static void main(String[] args) {
        boolean[][] P;
        int[] D;

        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String[] s1 = line1.split(" ");

        int vexNum = Integer.parseInt(s1[0]);
        int lineNums = Integer.parseInt(s1[1]);
        int[][] arr = new int[vexNum][vexNum];
        for (int i = 0; i < vexNum; i++) {
            for (int j = 0; j < vexNum; j++) {
                arr[i][j] = INFINITY;
            }
        }
        for (int i = 0; i < lineNums; i++) {
            String line = scanner.nextLine();
            String[] s = line.split(" ");
            int x, y;
            arr[x = Integer.parseInt(s[0]) - 1][y = Integer.parseInt(s[1]) - 1] = 1;
            arr[y][x] = 1;
        }
        int startIndex = scanner.nextInt() - 1;
        int stopIndex = scanner.nextInt() - 1;
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
