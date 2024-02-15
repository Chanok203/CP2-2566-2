package BasicClass.FanCompany.FanCompany2;

import java.util.Scanner;

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

public class FanCompany2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double v = sc.nextDouble();
        double i = sc.nextDouble();
        double eff = sc.nextDouble();
        Motor motor = null;
        if (v == 220) {
            motor = new Motor(i, eff);
        } else {
            motor = new Motor(v, i, eff);
        }
        motor.printInfo();
        sc.close();
    }
}
