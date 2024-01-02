package Array2D;

import java.util.Scanner;

public class NumTable1 {
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
        for (int n = 0; n < N; ++n) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            boolean isValidR = (0 <= r) && (r < R);
            boolean isValidC = (0 <= c) && (c < C);
            if (isValidR && isValidC) {
                System.out.print(arr[r][c]);
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
        sc.close();
    }
}
/*
 * 3 5
 * 0 5 3 2 1
 * 7 8 3 1 2
 * 9 5 6 8 4
 * 8
 * 1 1
 * 5 3
 * 3 5
 * 0 2
 * 2 -1
 * 2 3
 * 3 2
 * 2 4
 */
