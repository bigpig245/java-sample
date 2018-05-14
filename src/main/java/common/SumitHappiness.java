package common;

import java.util.Scanner;

/**
 * Sumit is given an array A of size N, where Ai represents the happiness sumit get by eating the i-th dish.
 * Sumit will eat all the dishes in a series of steps.
 * In each step, sumit pick a non empty subset of the remaining dishes and eat them.
 * The happiness sumit get from eating these dishes is the size of the subset multiplied by the sum of the individual happiness from the dishes in the subset.
 * Sumit want to maximize the happiness he get from the entire feast, which is the sum of happiness in each step.
 * <p>
 * Input :
 * test cases , t
 * no. of dishes , N
 * happiness by eating ith dish, Ai
 * <p>
 * Output :
 * Maximum Happiness Sumit can get
 * <p>
 * Constraints:
 * <p>
 * 1<=t<=8
 * 1<=N<=10^5
 * -10^8<=Ai<=10^8
 */
public class SumitHappiness {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t, n, i, j, aj;
        long total;
        t = scanner.nextInt();

        for (i = 0; i < t; i++) {
            total = 0;
            n = scanner.nextInt();
            for (j = 0; j < n; j++) {
                aj = scanner.nextInt();
                total += (aj > 0 ? aj * n : aj);
            }
            System.out.println(total);
        }
    }
}
