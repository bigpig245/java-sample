package common.lineagesearch;

import java.util.Scanner;

public class RestInPeace {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    for (int i = 0; i < n; i++) {
      int num = scanner.nextInt();
      boolean isBlackJack = String.valueOf(num).contains("21") || num % 21 == 0;
      if (isBlackJack) {
        System.out.println("The streak is broken!");
      } else {
        System.out.println("The streak lives still in our heart!");
      }
    }

  }
}
