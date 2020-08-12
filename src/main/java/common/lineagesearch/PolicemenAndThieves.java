package common.lineagesearch;

import java.util.Scanner;

public class PolicemenAndThieves {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    for (int ii = 0; ii < t; ii++) {
      int count = 0;
      int n = scanner.nextInt();
      int k = scanner.nextInt();
      for (int j = 0; j < n; j++) {

        int[] policemen = new int[n];
        int[] thieves = new int[n];
        int pn = 0, tn = 0;
        for (int i = 0; i < n; i++) {
          String value = scanner.next();
          if ("P".equalsIgnoreCase(value)) {
            policemen[pn] = i;
            pn++;
          } else {
            thieves[tn] = i;
            tn++;
          }
        }

        int pi = 0, ti = 0;
        while (pi < pn && ti < tn) {
          int step = policemen[pi] - thieves[ti];
          if (Math.abs(step) <= k) {
            count++;
            pi++;
            ti++;
          } else {
            if (step > 0) {
              ti++;
            } else {
              pi++;
            }
          }
        }
      }
      System.out.println(count);
    }
  }
}
