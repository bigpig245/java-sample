package common.binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountingTriangles {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    Map<String, Integer> input = new HashMap<>();
    for (int i = 0; i < n; i++) {
      long[] a = new long[3];
      a[0] = scanner.nextLong();
      a[1] = scanner.nextLong();
      a[2] = scanner.nextLong();
      Arrays.sort(a);
      String key = a[0] + "_" + a[1] + "_" + a[2];
      Integer count = input.get(key);
      if (count == null) {
        input.put(key, 1);
      } else {
        input.put(key, ++count);
      }
    }

    System.out.println(input.values().stream().filter(i -> i == 1).count());
  }
}
