package common.lineagesearch;

import java.util.Scanner;

public class MaximumSum {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int[] a = new int[N];
    for (int i = 0; i < N; i++) {
      a[i] = scanner.nextInt();
    }

    int max = a[0];
    long sum = 0;
    int count = 0;
    for (int i = 0; i < N; i++) {
      if (a[i] >= 0) {
        sum += a[i];
        count++;
      }
      if (a[i] > max) {
        max = a[i];
      }
    }

    if (count == 0) {
      count = 1;
      sum = max;
    }

    System.out.println(sum + " " + count);
  }
}
