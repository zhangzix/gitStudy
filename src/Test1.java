import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        int size = 0;
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                if (arr[j] == 0 && j != 0) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]);
            if (i!=size-1) System.out.print(" ");
        }
    }
}