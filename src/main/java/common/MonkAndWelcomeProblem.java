package common;

import java.util.Scanner;

public class MonkAndWelcomeProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, i;
        N = scanner.nextInt();
        int a[] = new int[N];
        for (i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
        }
        for (i = 0; i < N; i++) {
            a[i] += scanner.nextInt();
            System.out.println(a[i] + " ");
        }
    }
}
