package common.binarysearch;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/the-furious-five-69521576/
 * TODO not passed all test runs due to time complexity
 */
public class FuriousFive {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    int max = 0;
    Map<Integer, Long> fx = new HashMap<>();
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();

      fx.put(a[i], 0L);
      if (a[i] > max) {
        max = a[i];
      }
    }

    int jump = 0;
    int step = 0;
    long start = 5; // jump step
    do {
      step++;
      if (fx.containsKey(step)) {
        fx.put(step, start);
      }

      long quot = jump * 5;
      while (quot % 5 == 0) {
        step++;
        if (fx.containsKey(step)) {
          fx.put(step, start);
        }
        quot = quot / 5;
      }
      start += 5;
    } while (step < max);
    for (int i = 0; i < n; i++) {
      System.out.println(fx.get(a[i]));
    }
  }
}
