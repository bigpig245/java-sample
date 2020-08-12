package common.binarysearch;

import java.util.Scanner;

public class PicuBank {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    for (int i = 0; i < t; i++) {
      long d = scanner.nextLong();
      long a = scanner.nextLong();
      long m = scanner.nextLong();
      long b = scanner.nextLong();
      long x = scanner.nextLong();

      long sum = a * m + b;
      long net = x - d;
      long am = a * m;

      long month = 0;
      long x1 = net / sum;
      month = x1 * (m + 1);
      long modx1 = net % sum;
      if (modx1 > am) {
        month++;
        modx1 = am;
      }
      long x2 = modx1 / a;
      month += x2;

      long x3 = modx1 % a;
      if (x3 > 0) {
        month++;
      }
      System.out.println(month);
    }
  }
}
