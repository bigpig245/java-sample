package common.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/bishu-and-soldiers/description/
 */
public class BishuAndSoliders {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }

    Arrays.sort(a);
    int q = scanner.nextInt();
    for (int i = 0; i < q; i++) {
      int power = scanner.nextInt();
      int sum = 0;
      int count = 0;
      for (int j = 0; j < n; j++) {
        if (a[j] > power) {
          break;
        }
        sum += a[j];
        count++;
      }
      System.out.println(count + " " + sum);
    }
  }
}
