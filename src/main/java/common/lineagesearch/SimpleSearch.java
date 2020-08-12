package common.lineagesearch;

import java.util.Scanner;

public class SimpleSearch {

  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int[] a = new int[N];
    for(int i = 0; i < N; i++){
      a[i] = scanner.nextInt();
    }

    int k = scanner.nextInt();
    for(int i = 0; i < N; i++){
      if(a[i] == k){
        System.out.println(i);
      }
    }
  }
}
