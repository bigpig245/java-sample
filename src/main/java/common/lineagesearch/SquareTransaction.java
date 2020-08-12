package common.lineagesearch;

import java.util.Scanner;

/**
 * TODO https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/square-transaction-20/
 */
public class SquareTransaction {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    int[] a = new int[t];
    int sum = 0;
    for (int i = 0; i < t; i++) {
      sum += scanner.nextInt();
      a[i] = sum;
    }

    int q = scanner.nextInt();
    for (int i = 0; i < q; i++) {
      System.out.println(binarySearch(a, scanner.nextInt()));
    }
  }

  public static int binarySearch(int[] arr, int x) {
    return binarySearch(arr, x, 0, arr.length - 1);
  }

  public static int binarySearch(int[] arr, int x, int l, int r) {
    if (l <= r) {
      int mid = (l + r) / 2;
      if (arr[mid] >= x && (arr[mid - 1] < x)) {
        return mid + 1;
      }

      // if middle value > x, starting search from left to mid
      if (arr[mid] > x) {
        return binarySearch(arr, x, l, mid - 1);
      } else {
        return binarySearch(arr, x, mid + 1, r);
      }
    }
    return -1;
  }

}
