package common.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class DiscoverTheMonk {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int q = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }
    Arrays.sort(a);

    for (int i = 0; i < q; i++) {
      int find = binarySearch(a, scanner.nextInt());
      System.out.println(find > -1 ? "YES" : "NO");
    }
  }

  public static int binarySearch(int[] arr, int x) {
    return binarySearch(arr, x, 0, arr.length - 1);
  }

  public static int binarySearch(int[] arr, int x, int l, int r) {
    if (l <= r) {
      int mid = (l + r) / 2;
      if (arr[mid] == x) {
        return mid;
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
