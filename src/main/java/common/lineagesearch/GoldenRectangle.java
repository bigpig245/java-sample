package common.lineagesearch;

import java.util.Scanner;

public class GoldenRectangle {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int count = 0;
    for (int i = 0; i < n; i++) {
      int w = scanner.nextInt();
      int h = scanner.nextInt();
      double ratio = (double) w / h;
      double ratio2 = (double) h / w;

      boolean isGolden = (ratio >= 1.6 && ratio <= 1.7)
          || (ratio2 >= 1.6 && ratio2 <= 1.7);
      if (isGolden) {
        count++;
      }
    }

    System.out.println(count);
  }

}
