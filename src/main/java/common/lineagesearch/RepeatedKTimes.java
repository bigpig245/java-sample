package common.lineagesearch;

import java.util.Scanner;

/**
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/repeated-k-times/
 */
public class RepeatedKTimes {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int a[] = new int[100001];
    for (int i = 0; i < n; i++) {
      int val = scanner.nextInt();
      a[val] += 1;
    }
    int k = scanner.nextInt();
    for (int i = 0; i < 100001; i++) {
      if (a[i] == k) {
        System.out.println(i);
        break;
      }
    }
  }

}
