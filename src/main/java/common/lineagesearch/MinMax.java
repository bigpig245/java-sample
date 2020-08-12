package common.lineagesearch;

import java.util.Scanner;

public class MinMax {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }
    int min = a[0];
    int max = a[0];
    long sum = a[0];

    for (int i = 1; i < n; i++) {
      int value = a[i];
      if (value > max) {
        max = value;
      }
      if (value < min) {
        min = value;
      }
      sum += value;
    }

    System.out.println((sum - max) + " " + (sum - min));
  }

}
