package Recursion;

import java.util.Scanner;

public class CaesarShift2 {
    String cshift2(String msg, int[] dist, int i) {
        if (msg.length() == 0) {
            return "";
        }
        int d = dist[i % dist.length];
        int code = msg.charAt(0) + d - 'A';
        code = code % 26 + 'A';
        return (char) code + cshift2(msg.substring(1), dist, i + 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String msg = scan.next();
        int n = scan.nextInt();
        int[] dist = new int[n];
        for (int i = 0; i < n; ++i)
            dist[i] = scan.nextInt();
        scan.close();
        CaesarShift2 cs = new CaesarShift2();
        String ans = cs.cshift2(msg, dist, 0);
        System.out.println(ans);
    }
}
