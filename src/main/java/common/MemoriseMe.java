package common;

import java.util.Scanner;

public class MemoriseMe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, i, value, Q;
        N = scanner.nextInt();
        int a[] = new int[1000];
        for (i = 0; i < N; i++) {
            value = scanner.nextInt();
            a[value] += 1;
        }

        Q = scanner.nextInt();

        for (i = 0; i < Q; i++) {
            value = scanner.nextInt();
            if(value == 0){
                System.out.println("NOT PRESENT");
            }else {
                System.out.println(a[value]);
            }
        }
    }
}
