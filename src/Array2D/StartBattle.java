package Array2D;

import java.util.Scanner;

public class StartBattle {
    static void printMap(int[][] map) {
        int R = map.length;
        for (int r = 0; r < R; ++r) {
            int C = map[r].length;
            for (int c = 0; c < C; ++c) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int[][] map = new int[R][C];
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                map[r][c] = sc.nextInt();
            }
        }
        int K = sc.nextInt();
        int shot = 0;
        int miss = 0;
        int dupShot = 0;
        int dupMiss = 0;
        int out = 0;
        /*
         * 0 = ไม่มีเรือ
         * 1 = เรือ
         * 2 = เรือที่ถูกยิง
         * 3 = น้ำที่ถูกยิง
         */
        for (int k = 0; k < K; ++k) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;

            boolean isValidR = (0 <= r) && (r < R);
            boolean isValidC = (0 <= c) && (c < C);
            // ยิงออกนอกแผนที่
            if (!isValidC || !isValidR) {
                out++;
            }

            // ยิงลงน้ำครั้งแรก
            else if (map[r][c] == 0) {
                miss++;
                map[r][c] = 3;
            }

            // ยิงโดนเรือครั้งแรก
            else if (map[r][c] == 1) {
                shot++;
                map[r][c] = 2;
            }

            // ยิงโดนเรือซ้ำ
            else if (map[r][c] == 2) {
                dupShot++;
            }

            // ยิงน้ำซ้ำ
            else if (map[r][c] == 3) {
                dupMiss++;
            }

            // printMap(map);
            // System.out.println(shot);
            // System.out.println(miss);
            // System.out.println(dupShot);
            // System.out.println(dupMiss);
            // System.out.println(out);
        }
        System.out.println(shot);
        System.out.println(miss);
        System.out.println(dupShot);
        System.out.println(dupMiss);
        System.out.println(out);
    }
}
/*
 * 0 = ไม่มีเรือ
 * 1 = เรือ
 * 2 = เรือที่ถูกยิง
 * 3 = น้ำที่ถูกยิง
 * 
 * 0 1 1 0
 * 1 0 0 0
 * 0 1 0 1
 * 
 * input: 1 2
 * 0 2 1 0
 * 1 0 0 0
 * 0 1 0 1
 * 
 */
