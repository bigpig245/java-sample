package common.lineagesearch;

import java.util.Scanner;

public class BreakupApp {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    int weight19 = 0;
    int weight21 = 0;
    scanner.nextLine();
    for (int i = 0; i < n; i++) {
      String s = scanner.nextLine();
      if (s.contains("G:")) {
        if (s.contains("19")) {
          weight19 += 2;
        }
        if (s.contains("21")) {
          weight21 += 2;
        }
      }

      if (s.contains("M:")) {
        if (s.contains("19")) {
          weight19 += 1;
        }
        if (s.contains("21")) {
          weight21 += 1;
        }
      }
    }

    if (weight19 > weight21) {
      System.out.println("Date");
    } else {
      System.out.println("No Date");
    }

  }
}
