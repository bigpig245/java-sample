package common.lineagesearch;

import java.util.*;

/**
 * TODO https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/holiday-season-ab957deb/
 */
public class HolidaySeason {

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    String raw = scanner.next();
    String s[] = raw.split("");
    Map<String, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < s.length; i++) {
      List<Integer> indices = map.computeIfAbsent(s[i], k -> new ArrayList<>());
      indices.add(i);
    }
    long end = System.currentTimeMillis();
    System.out.println((end - start)/1000);
    int count = 0;
    for (int a = 0; a < s.length; a++) {
      String xa = s[a];
      List<Integer> cs = map.get(xa);
      if (cs.size() < 2) {
        continue;
      }
      cs.remove(0);
      for (int c : cs) {
        for (int b = a + 1; b < c; b++) {
          String xb = s[b];
          List<Integer> ds = map.get(xb);
          if (cs.size() < 2) {
            continue;
          }

          int notCount = 0;
          for (int d : ds) {
            if (d <= c) {
              notCount++;
            } else {
              break;
            }
          }
          count += ds.size() - notCount;
        }
      }
    }
    System.out.println(count);
    System.out.println((System.currentTimeMillis() - end) / 1000);
  }

//  Scanner scanner = new Scanner(System.in);
  //    int n = scanner.nextInt();
  //    String raw = scanner.next();
  //    String s[] = raw.split("");
  //    int count = 0;
  //    for (int a = 0; a < s.length; a++) {
  //      String xa = s[a];
  //      int step1 = a + 1;
  //      int c = raw.indexOf(xa, step1);
  //      do {
  //        if (c > a) {
  //          for (int b = a + 1; b < c; b++) {
  //            String xb = s[b];
  //            int step2 = c + 1;
  //            int d = raw.indexOf(xb, step2);
  //            do {
  //              if (d > c) {
  //                count++;
  //                step2 = d + 1;
  //                d = raw.indexOf(xb, step2);
  //              } else {
  //                break;
  //              }
  //            } while (true);
  //          }
  //          step1 = c + 1;
  //          c = raw.indexOf(xa, step1);
  //        } else {
  //          break;
  //        }
  //      } while (true);
  //    }
  //    System.out.println(count);
}
