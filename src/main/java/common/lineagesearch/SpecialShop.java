package common.lineagesearch;

import java.util.Scanner;

/**
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/special-shop
 * -69904c91/
 */
public class SpecialShop {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    long t = scanner.nextLong();
    for (int i = 0; i < t; i++) {
      long n = scanner.nextLong();
      long a = scanner.nextLong();
      long b = scanner.nextLong();

      long x = n * b / (a + b);
      long y = x + 1;

      long price1 = a * x * x + b * (n - x) * (n - x);
      long price2 = a * y * y + b * (n - y) * (n - y);

      System.out.println(Math.min(price1, price2));
    }
  }
}
