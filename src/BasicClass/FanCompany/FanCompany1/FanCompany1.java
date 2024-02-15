package BasicClass.FanCompany.FanCompany1;

import java.util.Scanner;

class Blade {
    int size, number, angle;
    double hp;
    boolean valid;

    Blade(int size, int number, int angle, double hp) {
        this.size = size;
        this.number = number;
        this.angle = angle;
        this.hp = hp;
        this.valid = true;
        if (size % 2 != 0 || size < 16 || 24 < size) {
            this.valid = false;
            System.out.println("invalid size");
        }
        // if (number < 3 || 5 < number) {
        if (number != 3 && number != 4 && number != 5) {
            this.valid = false;
            System.out.println("invalid number of blades");
        }
        if (angle != 27 && angle != 30 && angle != 33) {
            this.valid = false;
            System.out.println("invalid angle");
        }
        if (hp <= 0) {
            this.valid = false;
            System.out.println("invalid horsepower");
        }
    }

    void printInfo() {
        String line = String.format(
                "%d %d %d %s %s",
                this.size, this.number, this.angle,
                this.hp + "",
                this.valid);
        System.out.println(line);
    }
}

public class FanCompany1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int numb = scan.nextInt();
        int angle = scan.nextInt();
        double hp = scan.nextDouble();
        Blade ablade = new Blade(size, numb, angle, hp);
        ablade.printInfo();
        scan.close();
    }
}
