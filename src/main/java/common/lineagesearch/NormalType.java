package common.lineagesearch;

import java.util.Scanner;

/**
 * TODO https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/the-normal-type/submissions/
 */
public class NormalType {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    int duplicate = 0;
    int prev = scanner.nextInt();
    for (int i = 1; i < n; i++) {
      int current = scanner.nextInt();
      if (prev == current) {
        duplicate++;
      }
      prev = current;
    }

    long com = n * (n - 1) / 2;
    System.out.println(com - duplicate);
  }
}
