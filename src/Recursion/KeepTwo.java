package Recursion;

import java.util.Scanner;

public class KeepTwo {
    String keepTwo(String str) {
        int L = str.length();
        if (L <= 2) {
            return str;
        }
        String last = str.substring(L-1);
        String str2 = str.substring(0, L-1);

        int idx1 = str2.indexOf(last);
        int idx2 = str2.lastIndexOf(last);
        String ans = keepTwo(str2);
        if (idx1 == idx2) {
            ans += last;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        KeepTwo kt = new KeepTwo();
        String answer = kt.keepTwo(str);
        System.out.print(answer);
    }
}
