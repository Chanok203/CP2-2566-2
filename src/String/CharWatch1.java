package String;

import java.util.Scanner;

public class CharWatch1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Read inputs as strings of one character
        String s1 = sc.next();
        String s2 = sc.next();
        String s3 = sc.next();
        // Extract the first char to obtain the characters we need.
        char char1 = s1.charAt(0);
        char char2 = s2.charAt(0);
        char char3 = s3.charAt(0);
        // Read the main string
        String major = sc.next();
        int N = sc.nextInt();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int L = major.length();
        for (int i = 0; i < N; ++i) {
            int idx = sc.nextInt();
            if (idx <= 0 || L < idx) {
                count4++;
                continue;
            }

            char c = major.charAt(idx - 1);
            if (c == char1) {
                count1++;
            } else if (c == char2) {
                count2++;
            } else if (c == char3) {
                count3++;
            }
        }
        sc.close();
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);
        System.out.println(count4);
    }
}
