package common.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/the-soap-mystery/
 */
public class TheSoapMystery {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];

    a[0] = scanner.nextInt();
    for (int i = 1; i < n; i++) {
      a[i] = scanner.nextInt();
    }
    Arrays.sort(a);

    int q = scanner.nextInt();
    for (int i = 0; i < q; i++) {
      int m = scanner.nextInt();
      System.out.println(binarySearch(a, m));
    }

  }

  public static int binarySearch(int[] arr, int x) {
    return binarySearch(arr, x, 0, arr.length - 1);
  }

  public static int binarySearch(int[] arr, int x, int l, int r) {
    if (l <= r) {
      int mid = (l + r) / 2;
      if (arr[mid] < x && (mid == arr.length - 1 || arr[mid + 1] >= x)) {
        return mid + 1;
      }

      // if middle value > x, starting search from left to mid
      if (arr[mid] >= x) {
        return binarySearch(arr, x, l, mid - 1);
      } else {
        return binarySearch(arr, x, mid + 1, r);
      }
    }
    return 0;
  }
}
