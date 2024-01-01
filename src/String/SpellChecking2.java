package String;

import java.util.Scanner;

public class SpellChecking2 {
    static int countMatch(String w1, String w2) {
        int L = w1.length();
        if (w2.length() < L) {
            L = w2.length();
        }
        int score = 0;
        for (int i = 0; i < L; ++i) {
            int c1 = w1.charAt(i);
            int c2 = w2.charAt(i);
            if (c1 == c2) {
                score++;
            }
        }
        return score;
    }

    static boolean isInDict(String[] d, String w) {
        for (int j = 0; j < d.length; ++j) {
            if (w.equals(d[j])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] dict = new String[N];
        for (int i = 0; i < N; ++i) {
            dict[i] = sc.next();
        }
        int K = sc.nextInt();
        for (int i = 0; i < K; ++i) {
            String w = sc.next();
            if (isInDict(dict, w)) {
                System.out.println(w);
                continue;
            }

            String ans = dict[0];
            int maxScore = countMatch(w, dict[0]);
            for (int j = 1; j < N; ++j) {
                int score = countMatch(w, dict[j]);
                if (maxScore < score) {
                    ans = dict[j];
                    maxScore = score;
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
