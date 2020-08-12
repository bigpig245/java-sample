package common.lineagesearch;

import java.util.Scanner;

public class HexaNumber {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    for (int i = 0; i < num; i++) {
      int L = scanner.nextInt();
      int R = scanner.nextInt();
      findHex(L, R);
    }

  }

  public static void findHex(int L, int R) {
    int count = 0;
    for (int i = L; i <= R; i++) {
      String hex = Integer.toHexString(i);
      int sum = 0;
      for (int j = 0; j < hex.length(); j++) {
        Character c = hex.charAt(j);

        if (Character.isAlphabetic(c)) {
          switch (c) {
            case 'a':
              c = 10;
              break;
            case 'b':
              c = 11;
              break;
            case 'c':
              c = 12;
              break;
            case 'd':
              c = 13;
              break;
            case 'e':
              c = 14;
              break;
            case 'f':
              c = 15;
              break;
          }
          sum += c;
        }

        if (Character.isDigit(c)) {
          sum += Integer.valueOf(String.valueOf(c));
        }
      }
      if (GCD(i, sum) > 1) {
        count++;
      }
    }

    System.out.println(count);
  }

  public static int GCD(int num1, int num2) {
    int gcd = 1;
    for (int i = 1; i <= num1 && i <= num2; i++) {
      if (num1 % i == 0 && num2 % i == 0) {
        gcd = i;
      }
    }

    return gcd;
  }
}
