package Recursion;

import java.util.Scanner;

public class RemoveAnyDup {
    String removeAnyDup(String str) {
        int L = str.length();
        if (L <= 1) {
            return str;
        }
        String last = str.substring(L-1, L);
        String str2 = str.substring(0, L-1);

        int idx = str2.indexOf(last);
        String ans = removeAnyDup(str2);
        if (idx == -1) {
            ans += last;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        RemoveAnyDup remover = new RemoveAnyDup();
        String result = remover.removeAnyDup(str);
        System.out.print(result);
    }
}
