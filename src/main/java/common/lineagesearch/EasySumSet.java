package common.lineagesearch;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class EasySumSet {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int M = scanner.nextInt();
    int A[] = new int[M];

    for (int i = 0; i < M; i++) {
      A[i] = scanner.nextInt();
    }
    int N = scanner.nextInt();

    int[] C = new int[N];
    for (int i = 0; i < N; i++) {
      C[i] = scanner.nextInt();
    }

    Set<Integer> B = new TreeSet<>();
    for (Integer i : A) {
      Set<Integer> temp = new HashSet<>();
      for (Integer j : C) {
        int k = j - i;
        if (k > 0) {
          temp.add(k);
        }
      }
      if (B.isEmpty()) {
        B.addAll(temp);
      } else {
        B.retainAll(temp);
      }
    }

    for(int i : B){
      System.out.print(i + " ");
    }

  }
}
