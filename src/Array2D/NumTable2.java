package Array2D;

import java.util.Scanner;

public class NumTable2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int[][] arr = new int[R][C];
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                arr[r][c] = sc.nextInt();
            }
        }
        int N = sc.nextInt();
        int prev = -1; // -1 = "-"
        for (int n = 0; n < N; ++n) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            boolean isValidR = (0 <= r) && (r < R);
            boolean isValidC = (0 <= c) && (c < C);
            if (isValidR && isValidC) {
                if (prev == arr[r][c]) {
                    System.out.print("*");
                } else {
                    System.out.print(arr[r][c]);
                }
                prev = arr[r][c];
            } else {
                if (prev != -1) {
                    System.out.println();
                }
                prev = -1;
            }
        }
        sc.close();
    }
}
/*
 * 2 2
 * 1 2
 * 3 4
 * 4
 * 1 1
 * 1 1
 * 1 1
 * 1 1
 * 
 * Numtable1: 1111
 * NumTable2: 1***
 */
