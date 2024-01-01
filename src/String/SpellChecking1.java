package String;

import java.util.Scanner;

public class SpellChecking1 {

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
        for (int i = 0; i < 10; ++i) {
            String w = sc.next();
            boolean found = isInDict(dict, w);
            if (found) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }
        }
        System.out.println();
        sc.close();
    }
}
