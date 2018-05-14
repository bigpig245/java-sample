package common;

import java.util.Scanner;

public class ReverseArray {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Please input the size of array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Please input the elements of array: ");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("\nThe reverse array: ");
        for (int i = n - 1; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }
}
