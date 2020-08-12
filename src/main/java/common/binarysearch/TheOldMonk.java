package common.binarysearch;

import java.util.Scanner;

/**
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/the-old-monk/
 * TODO not done
 */
public class TheOldMonk {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int q = scanner.nextInt();
    for (int i = 0; i < q; i++) {
      int n = scanner.nextInt();
      int count = 0;
      long[] a = new long[n];
      for (int j = 0; j < n; j++) {
        a[j] = scanner.nextLong();
      }
      long[] b = new long[n];
      for (int j = 0; j < n; j++) {
        b[j] = scanner.nextLong();
      }

      for (int j = 0; j < n; j++) {
        long pos = binarySearch(a, b[j]);
        if (pos != -1 && j > pos) {
          count++;
        }
      }

      System.out.println(count);
    }
  }

  public static long binarySearch(long[] arr, long x) {
    return binarySearch(arr, x, 0, arr.length - 1);
  }

  public static long binarySearch(long[] arr, long x, int l, int r) {
    if (l <= r) {
      int mid = (l + r) / 2;
      if (arr[mid] <= x && (mid + 1 >= arr.length || arr[mid + 1] < x)) {
        return mid;
      }

      return binarySearch(arr, x, mid + 1, r);
    }
    return -1;
  }
}
