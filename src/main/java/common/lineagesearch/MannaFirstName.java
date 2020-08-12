package common.lineagesearch;

import java.util.Scanner;

/**
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/mannas-first
 * -name-4/
 */
public class MannaFirstName {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    for (int i = 0; i < n; i++) {
      String name = scanner.next().toUpperCase();
      int length = name.length();
      name = name.replaceAll("SUVOJIT", "");
      int str2 = (length - name.length()) / 7;
      length = name.length();
      name = name.replaceAll("SUVO", "");
      int str1 = (length - name.length()) / 4;
      System.out.println(String.format("%s = %d, %s = %d", "SUVO", str1, "SUVOJIT", str2));
    }
  }
}
