package BasicClass.foodContent.foodContent1;

import java.util.Scanner;

class Food {
    private final String foodName;
    private String content1, content2, content3;
    private int w1, w2, w3;
    Food(String foodName, String content1, int w1) {
        this.foodName = foodName;
        this.content1 = content1;
        this.w1 = w1;
    }
    void addContent(String content, int w) {
        if (this.w2 == 0 || this.content2 == null) {
            this.content2 = content;
            this.w2 = w;
            return;
        }
        this.content3 = content;
        this.w3 = w;
    }
    void printInfo() {
        int w = this.w1 + this.w2 + this.w3;
        String content = this.content1;
        if (this.w2 != 0 || this.content2 != null) {
            content += " " + this.content2;
        }
        if (this.w3 !=0 || this.content3 != null) {
            content += " " + this.content3;
        }
        System.out.println(this.foodName);
        System.out.println(w);
        System.out.println(content);
    }
}

public class foodContent1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String foodName = sc.next();
        String content1 = sc.next();
        int w1 = sc.nextInt();

        Food fd = new Food(foodName, content1, w1);
        int q = sc.nextInt();
        while (q != 0) {
            if (q == 1) {
                fd.printInfo();
            } else if (q == 2) {
                String content = sc.next();
                int w = sc.nextInt();
                fd.addContent(content, w);
            }
            q = sc.nextInt();
        }
        sc.close();
    }
}
