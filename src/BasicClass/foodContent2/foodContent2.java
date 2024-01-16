package BasicClass.foodContent2;

import java.util.Scanner;

class Food {
    private final String foodName;
    private String content1, content2, content3;
    private int w1, w2, w3;
    private int c1, c2, c3;
    Food(String foodName, String content1, int w1, int c1) {
        this.foodName = foodName;
        this.content1 = content1;
        this.w1 = w1;
        this.c1 = c1;
    }
    void addContent(String content, int w, int c) {
        if (this.w2 == 0 || this.content2 == null) {
            this.content2 = content;
            this.w2 = w;
            this.c2 = c;
            return;
        }
        this.content3 = content;
        this.w3 = w;
        this.c3 = c;
    }
    void printStat() {
        System.out.println(this.content1 + " " + this.w1 + " " +this.c1);
        System.out.println(this.content2 + " " + this.w2 + " " +this.c2);
        System.out.println(this.content3 + " " + this.w3 + " " +this.c3);
    }
    void printInfo() {
        int w = this.w1 + this.w2 + this.w3;
        int c = (this.w1 * this.c1) + (this.w2 * this.c2) + (this.w3 * this.c3);
        String content = this.content1;
        if (this.w2 != 0 || this.content2 != null) {
            content += " " + this.content2;
        }
        if (this.w3 !=0 || this.content3 != null) {
            content += " " + this.content3;
        }
        System.out.println(this.foodName);
        System.out.println(w + " " + c);
        System.out.println(content);
    }
}

public class foodContent2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String foodName = sc.next();
        String content1 = sc.next();
        int w1 = sc.nextInt();
        int c1 = sc.nextInt();

        Food fd = new Food(foodName, content1, w1, c1);
        int q = sc.nextInt();
        while (q != 0) {
            if (q == 1) {
                fd.printInfo();
            } else if (q == 2) {
                String content = sc.next();
                int w = sc.nextInt();
                int c = sc.nextInt();
                fd.addContent(content, w, c);
            }
            q = sc.nextInt();
        }
        sc.close();
    }
}
