package common.binarysearch;

import java.util.Scanner;

/**
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/c-impresses-everyone/
 * TODO not done
 */
public class CImpressesEveryone {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    long sum = 0;
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
      sum += a[i];
    }

    int q = scanner.nextInt();

    for (int i = 0; i < q; i++) {
      long x = scanner.nextLong();
      long backupSum = sum - x;
      for (int j = 0; j < n; j++) {
        if (backupSum <= a[j]) {
          if (j % 2 == 0) {
            System.out.println("A");
          } else {
            System.out.println("B");
          }
          break;
        }
      }
    }
  }
}
