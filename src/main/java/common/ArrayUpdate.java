package common;

import java.util.Scanner;

/**
 * Micro and Array Update
 * Micro purchased an array A having N integer values.
 * After playing it for a while, he got bored of it and decided to update value of its element.
 * In one second he can increase value of each array element by 1.
 * He wants each array element's value to become greater than or equal to K
 * Please help Micro to find out the minimum amount of time it will take, for him to do so.
 * <p>
 * Input:
 * First line consists of a single integer, T denoting the number of test cases.
 * First line of each test case consists of two space separated integers denoting N and K.
 * Second line of each test case consists of N space separated integers denoting the array A.
 * <p>
 * Output:
 * For each test case, print the minimum time in which all array elements will become greater than or equal to K.
 * Print a new line after each test case.
 */
public class ArrayUpdate {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int min = 0;
            for (int j = 0; j < n; j++) {
                int temp = scanner.nextInt();
                if (j == 0 || temp < min) {
                    min = temp;
                }
            }
            int diff = k - min;
            System.out.println(diff < 0 ? 0 : diff);
        }
    }
}
