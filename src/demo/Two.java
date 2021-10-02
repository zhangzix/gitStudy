package demo;

import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String one = sc.nextLine();
        String two = sc.nextLine();
        char[] arr_one = one.toCharArray();
        char[] arr_two = two.toCharArray();
        int min_len = (arr_one.length > arr_two.length) ? arr_two.length : arr_one.length;
        boolean flag = false;
        for (int i = 0; i < min_len; i++) {
            if (arr_one[i] > arr_two[i]) {
                flag = true;
            }
        }
        if (flag){
            System.out.print(one+" > "+two);
        }else{
            System.out.print(one+" < "+two);
        }
    }
}
