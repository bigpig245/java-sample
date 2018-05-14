package common;

import java.util.Scanner;

public class BinaryQueries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, Q, i, q, flipIndex, R;
        N = scanner.nextInt();
        Q = scanner.nextInt();
        int a[] = new int[N];
        for (i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
        }

        for (i = 0; i < Q; i++) {
            q = scanner.nextInt();
            if (q == 0) {
                scanner.nextInt();
                R = scanner.nextInt();
                if (a[R - 1] == 1) {
                    System.out.println("ODD");
                } else {
                    System.out.println("EVEN");
                }

            } else {
                flipIndex = scanner.nextInt();
                a[flipIndex - 1] ^= 1;
            }
        }
    }
}
