package BasicClass.FanCompany.FanCompany3;

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
                this.hp,
                this.valid);
        System.out.println(line);
    }
}

class Motor {
    double V, I, eff;

    Motor(double V, double I, double eff) {
        this.V = V;
        this.I = I;
        this.eff = eff / 100;
    }

    Motor(double I, double eff) {
        this(220, I, eff);
        // this.V = 220;
        // this.I = I;
        // this.eff = eff / 100;
    }

    double horsepower() {
        double hp = this.V * this.I * this.eff / 746;
        return hp;
    }

    void printInfo() {
        String line = String.format(
                "%s %s %s %.2f",
                this.V,
                this.I,
                this.eff,
                this.horsepower());
        System.out.println(line);
    }
}

class ElectricFan {
    static int count = 0;

    int productId;
    Blade blade;
    Motor motor;
    boolean status;

    ElectricFan(Blade blade, Motor motor) {
        ElectricFan.count++;
        this.productId = ElectricFan.count;
        this.blade = blade;
        this.motor = motor;
        this.status = (blade.hp < motor.horsepower());
    }

    boolean changeBlade(Blade blade) {
        this.blade = blade;
        this.status = (blade.hp < this.motor.horsepower());
        return this.status;
    }

    boolean changeMotor(Motor motor) {
        this.motor = motor;
        this.status = (this.blade.hp < motor.horsepower());
        return this.status;
    }

    void printInfo() {
        String line = String.format(
                "%d %d %s %s %.2f %s",
                this.productId,
                this.blade.size,
                this.blade.hp,
                this.motor.I,
                this.motor.horsepower(),
                this.status);
        System.out.println(line);
    }
}

public class FanCompany3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size, numb, angle;
        double hp, v, i, eff;
        Blade ablade = null;
        Motor motor = null;
        ElectricFan eFan = null;
        for (int index = 0; index < n; index++) {
            int cmd = sc.nextInt();
            if (cmd == 0) {
                size = sc.nextInt();
                numb = sc.nextInt();
                angle = sc.nextInt();
                hp = sc.nextDouble();
                ablade = new Blade(size, numb, angle, hp);
                v = sc.nextDouble();
                i = sc.nextDouble();
                eff = sc.nextDouble();
                motor = new Motor(v, i, eff);
                eFan = new ElectricFan(ablade, motor);
            } else if (cmd == 1) {
                size = sc.nextInt();
                numb = sc.nextInt();
                angle = sc.nextInt();
                hp = sc.nextDouble();
                ablade = new Blade(size, numb, angle, hp);
                eFan.changeBlade(ablade);
            } else if (cmd == 2) {
                v = sc.nextDouble();
                i = sc.nextDouble();
                eff = sc.nextDouble();
                motor = new Motor(v, i, eff);
                eFan.changeMotor(motor);
            }
            eFan.printInfo();
        }
        sc.close();
    }
}
