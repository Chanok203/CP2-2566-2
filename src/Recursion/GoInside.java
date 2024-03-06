package Recursion;

import java.util.Scanner;

public class GoInside {
    String goInside(String str, boolean front) {
        int L = str.length();
        if (L <= 1) {
            return str;
        }

        String first = str.substring(0, 1);
        String middle = str.substring(1, L - 1);
        String last = str.substring(L - 1, L);

        String ans;
        if (front) {
            ans = first + last;
        } else {
            ans = last + first;
        }
        return ans + goInside(middle, !front);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        GoInside gi = new GoInside();
        String answer = gi.goInside(str, true);
        System.out.println(answer);
    }
}
