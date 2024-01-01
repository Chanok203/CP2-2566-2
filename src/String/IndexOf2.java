package String;

import java.util.Scanner;

public class IndexOf2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();
        String word = sc.next();
        sc.close();

        int idx = msg.indexOf(word);
        if (idx == -1) {
            System.out.println("string not found");
            return;
        }

        while(idx != -1) {
            System.out.print((idx + 1) + " ");
            idx = msg.indexOf(word, idx+1);
        }
    }
}
