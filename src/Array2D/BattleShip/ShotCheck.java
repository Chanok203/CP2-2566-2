package Array2D.BattleShip;

import java.util.Scanner;

public class ShotCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();

        int K = sc.nextInt();
        int in = 0;
        int out = 0;
        for (int k = 0; k < K; ++k) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;

            boolean isValidR = (0 <= r) && (r < R);
            boolean isValidC = (0 <= c) && (c < C);
            if (isValidC && isValidR) {
                in++;
            } else {
                out++;
            }
        }
        System.out.println(in);
        System.out.println(out);
        sc.close();
    }
}
