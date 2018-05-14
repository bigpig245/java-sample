package common;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] a){
        Scanner scanner = new Scanner(System.in);
        int N;
        N = scanner.nextInt();
        for(int i = 2; i <= N; i++){
            int j = 2;
            do{
                if(i%j == 0){
                    break;
                }
                j++;
            } while (j <= i/2);
            if(j > i/2){
                System.out.print(i + " ");
            }
        }
    }
}
